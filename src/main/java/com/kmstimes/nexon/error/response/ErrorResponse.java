package com.kmstimes.nexon.error.response;

/**
 * 넥슨 API 오류 응답의 최상위 구조를 나타내는 레코드 클래스입니다.
 *
 * <p>이 레코드는 넥슨 API에서 HTTP 오류 상태 코드와 함께 반환되는
 * JSON 응답 본문을 Java 객체로 매핑할 때 사용됩니다.</p>
 *
 * <strong>JSON 구조 예시:</strong>
 * <pre>{@code
 * {
 *   "error": {
 *     "name": "OPENAPI00007",
 *     "message": "API 호출량이 초과되었습니다."
 *   }
 * }
 * }</pre>
 *
 * <p>이 클래스는 주로 {@link com.kmstimes.nexon.error.handler.NexonApiExceptionHandler}에서
 * Gson을 사용하여 오류 응답을 파싱할 때 사용됩니다.</p>
 *
 * @param error 오류 정보를 담고 있는 Error 객체
 *
 * @see Error
 * @see com.kmstimes.nexon.error.handler.NexonApiExceptionHandler#handleResponse(retrofit2.Response)
 */
public record ErrorResponse(
        Error error
) {
}