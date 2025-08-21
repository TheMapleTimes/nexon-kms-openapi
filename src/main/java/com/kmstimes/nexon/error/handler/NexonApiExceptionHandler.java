package com.kmstimes.nexon.error.handler;

import com.google.gson.Gson;
import com.kmstimes.nexon.error.exception.NexonApiException;
import com.kmstimes.nexon.error.factory.NexonApiExceptionFactory;
import com.kmstimes.nexon.error.response.ErrorResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.function.Supplier;

/**
 * 넥슨 API 호출을 처리하고 예외를 관리하는 핸들러 클래스입니다.
 *
 * <p>이 클래스는 Retrofit2 Call 객체를 실행하고, 응답을 처리하며,
 * 오류 발생 시 적절한 NexonApiException을 던지는 역할을 합니다.</p>
 *
 * <strong>주요 기능:</strong>
 * <ul>
 *   <li>API 호출 실행 및 응답 처리</li>
 *   <li>HTTP 오류 응답을 NexonApiException으로 변환</li>
 *   <li>네트워크 오류 및 파싱 오류 처리</li>
 *   <li>API 호출 URL 로깅</li>
 * </ul>
 *
 * <strong>사용 예시:</strong>
 * <pre>{@code
 * // API 호출 예시
 * String result = NexonApiExceptionHandler.execute(() ->
 *     apiService.getUserInfo(userId));
 * }</pre>
 */
public class NexonApiExceptionHandler {

    /**
     * JSON 직렬화/역직렬화를 위한 Gson 인스턴스
     */
    private static final Gson GSON = new Gson();

    /**
     * Retrofit2 Call을 실행하고 결과를 반환합니다.
     *
     * <p>이 메서드는 API 호출을 실행하고, 성공 시 응답 본문을 반환하며,
     * 실패 시 적절한 NexonApiException을 던집니다.</p>
     *
     * <p>호출되는 API의 URL이 콘솔에 출력되어 디버깅에 도움을 줍니다.</p>
     *
     * @param <T>          응답 타입
     * @param callSupplier Retrofit2 Call 객체를 제공하는 Supplier
     * @return API 호출 성공 시 응답 본문
     * @throws NexonApiException        API 호출 실패, 네트워크 오류, 또는 파싱 오류 시
     * @throws IllegalArgumentException callSupplier가 null인 경우
     * @see NexonApiExceptionFactory#createException(String, int, String)
     */
    public static <T> T execute(Supplier<Call<T>> callSupplier) throws NexonApiException {
        try {
            Call<T> call = callSupplier.get();
            System.out.println(call.request().url());
            Response<T> response = call.execute();
            return handleResponse(response);
        } catch (IOException e) {
            throw new NexonApiException("NETWORK_ERROR", 0, "네트워크 오류가 발생했습니다.", e);
        } catch (NexonApiException e) {
            throw e;
        } catch (Exception e) {
            throw new NexonApiException("CALL_CREATION_ERROR", 0, "API 호출 생성 중 오류가 발생했습니다.", e);
        }
    }

    /**
     * HTTP 응답을 처리하고 성공/실패에 따라 적절한 동작을 수행합니다.
     *
     * <p>성공 응답의 경우 응답 본문을 반환하고, 실패 응답의 경우
     * 오류 응답을 파싱하여 적절한 NexonApiException을 던집니다.</p>
     *
     * @param <T>      응답 타입
     * @param response Retrofit2 Response 객체
     * @return 성공 시 응답 본문
     * @throws NexonApiException HTTP 오류 응답 또는 파싱 오류 시
     */
    private static <T> T handleResponse(Response<T> response) throws NexonApiException {
        if (response.isSuccessful()) {
            return response.body();
        }

        try (ResponseBody errorBody = response.errorBody()) {
            String errorBodyString = errorBody != null ? errorBody.string() : null;
            if (errorBodyString == null || errorBodyString.isBlank()) {
                throw new NexonApiException(
                        "EMPTY_ERROR_BODY",
                        response.code(),
                        "에러 응답 본문이 비어있습니다."
                );
            }

            ErrorResponse errorResponse = GSON.fromJson(errorBodyString, ErrorResponse.class);

            String errorCode = errorResponse.error().name();
            String errorMessage = errorResponse.error().message();
            int httpStatus = response.code();

            throw NexonApiExceptionFactory.createException(errorCode, httpStatus, errorMessage);

        } catch (IOException e) {
            throw new NexonApiException("PARSE_ERROR", response.code(), "에러 응답을 파싱할 수 없습니다.", e);
        } catch (NexonApiException e) {
            throw e;
        } catch (Exception e) {
            throw new NexonApiException("UNKNOWN_ERROR", response.code(),
                    "알 수 없는 에러가 발생했습니다: HTTP " + response.code(), e);
        }
    }
}