package com.kmstimes.nexon.client;

import com.kmstimes.nexon.api.ProbabilityApi;
import com.kmstimes.nexon.error.handler.NexonApiExceptionHandler;
import com.kmstimes.nexon.model.probability.potential.cube.CubeResponse;
import com.kmstimes.nexon.model.probability.potential.potential.PotentialResponse;
import com.kmstimes.nexon.model.probability.starforce.StarforceResponse;
import com.kmstimes.nexon.model.probability.user.OuidResponse;
import com.kmstimes.nexon.validator.ApiKeyValidator;
import com.kmstimes.nexon.validator.DateValidator;
import retrofit2.Retrofit;

import java.time.LocalDate;

/**
 * 확률 정보 조회 API 호출을 담당하는 클라이언트 클래스입니다.
 * <p>
 * {@link ProbabilityApi} 인터페이스를 기반으로, 실제 API 요청을 수행하고,
 * 예외 처리를 일관되게 처리합니다.
 */
public class ProbabilityApiClient {
    private final ProbabilityApi probabilityApi;
    private final DateValidator starforceValidator = new DateValidator(LocalDate.of(2023, 12, 27));
    private final DateValidator potentialValidator = new DateValidator(LocalDate.of(2024, 1, 25));
    private final DateValidator cubeValidator = new DateValidator(LocalDate.of(2023, 1, 1));

    /**
     * 생성자: Retrofit 인스턴스를 주입받아 {@link ProbabilityApi} 를 초기화합니다.
     *
     * @param retrofit Retrofit 인스턴스
     */
    public ProbabilityApiClient(Retrofit retrofit) {
        this.probabilityApi = retrofit.create(ProbabilityApi.class);
    }

    /**
     * 계정 식별자(ouid)를 조회합니다.
     *
     * @param userApiKey 구 개발자센터 API KEY
     * @return {@link OuidResponse} 계정 식별자(ouid) 조회(구 API KEY 사용)
     */
    public OuidResponse getLegacyOuid(String userApiKey) {
        ApiKeyValidator.validate(userApiKey);

        return NexonApiExceptionHandler.execute(() ->
                probabilityApi.getLegacyOuid(userApiKey)
        );

    }

    /**
     * 계정 식별자(ouid)를 조회합니다.
     *
     * @param userApiKey API KEY
     * @return {@link OuidResponse} 계정 식별자(ouid) 조회
     */
    public OuidResponse getOuid(String userApiKey) {
        ApiKeyValidator.validate(userApiKey);

        return NexonApiExceptionHandler.execute(() ->
                probabilityApi.getOuid(userApiKey)
        );

    }

    /**
     * 스타포스 강화 결과를 조회합니다.
     * <ul>
     * <li>스타포스 확률 정보는 최대 5분 후 확인 가능합니다.</li>
     * <li>스타포스 강화 결과는 2023년 12월 27일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.</li>
     * </ul>
     *
     * @param userApiKey API KEY
     * @param count      한번에 가져오려는 결과의 갯수(최소 10, 최대 1000)
     * @param date       조회 기준일 (KST, YYYY-MM-DD)
     *                   <p>
     *                   (date와 cursor 파라미터 중 1개 이상은 필수 입력)
     * @param cursor     페이징 처리를 위한 cursor.
     *                   <p>
     *                   응답 값으로 받은 next_cursor를 사용하여 다음 데이터 리스트를 조회합니다.
     *                   <p>
     *                   (date와 cursor 파라미터 중 1개 이상은 필수 입력)
     * @return {@link StarforceResponse} 스타포스 강화 결과 조회
     */
    public StarforceResponse getStarforce(String userApiKey, int count, LocalDate date, String cursor) {
        ApiKeyValidator.validate(userApiKey);

        return NexonApiExceptionHandler.execute(() ->
                probabilityApi.getStarforce(userApiKey, validateCount(count), starforceValidator.validate(validateDate(date, cursor)), cursor)
        );

    }

    /**
     * 잠재능력 재설정 이용 결과를 조회합니다.
     * <ul>
     * <li>잠재능력 재설정 정보는 최대 30분 후 확인 가능합니다.</li>
     * <li>잠재능력 재설정 이용 결과는 2024년 01월 25일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.</li>
     * </ul>
     *
     * @param userApiKey API KEY
     * @param count      한번에 가져오려는 결과의 갯수(최소 10, 최대 1000)
     *                   <ul>
     *                   <li>옵션 재설정을 3회 진행한 결과가 포함될 경우 입력한 count보다 적은 수로 조회될 수 있습니다.</li>
     *                   </ul>
     * @param date       조회 기준일 (KST, YYYY-MM-DD)
     *                   <p>
     *                   (date와 cursor 파라미터 중 1개 이상은 필수 입력)
     * @param cursor     페이징 처리를 위한 cursor.
     *                   <p>
     *                   응답 값으로 받은 next_cursor를 사용하여 다음 데이터 리스트를 조회합니다.
     *                   <p>
     *                   (date와 cursor 파라미터 중 1개 이상은 필수 입력)
     * @return {@link PotentialResponse} 잠재능력 재설정 이용 결과 조회
     */
    public PotentialResponse getPotential(String userApiKey, int count, LocalDate date, String cursor) {
        ApiKeyValidator.validate(userApiKey);

        return NexonApiExceptionHandler.execute(() ->
                probabilityApi.getPotential(userApiKey, validateCount(count), potentialValidator.validate(validateDate(date, cursor)), cursor)
        );

    }

    /**
     * 큐브 사용 결과를 조회합니다.
     * <ul>
     * <li>큐브 확률 정보는 최대 30분 후 확인 가능합니다.</li>
     * <li>큐브 사용 결과는 최근 2년 데이터만 조회 가능합니다.</li>
     * </ul>
     *
     * @param userApiKey API KEY
     * @param count      한번에 가져오려는 결과의 갯수(최소 10, 최대 1000)
     *                   <ul>
     *                   <li>옵션 재설정을 3회 진행한 결과가 포함될 경우 입력한 count보다 적은 수로 조회될 수 있습니다.</li>
     *                   </ul>
     * @param date       조회 기준일 (KST, YYYY-MM-DD)
     *                   <p>
     *                   (date와 cursor 파라미터 중 1개 이상은 필수 입력)
     * @param cursor     페이징 처리를 위한 cursor.
     *                   <p>
     *                   응답 값으로 받은 next_cursor를 사용하여 다음 데이터 리스트를 조회합니다.
     *                   <p>
     *                   (date와 cursor 파라미터 중 1개 이상은 필수 입력)
     * @return {@link CubeResponse} 큐브 사용 결과 조회
     */
    public CubeResponse getCube(String userApiKey, int count, LocalDate date, String cursor) {
        ApiKeyValidator.validate(userApiKey);

        return NexonApiExceptionHandler.execute(() ->
                probabilityApi.getCube(userApiKey, validateCount(count), cubeValidator.validate(validateDate(date, cursor)), cursor)
        );

    }

    private int validateCount(int count) {
        if (count < 10 || count > 1000) {
            return 10;
        }
        return count;
    }

    private LocalDate validateDate(LocalDate date, String cursor) {
        if ((date == null) && (cursor == null || cursor.trim().isEmpty())) {
            throw new IllegalArgumentException("\n" +
                    "At least one of the date and cursor parameters is required");
        }

        if (date != null && cursor != null) {
            return null;
        }

        return date;
    }
}
