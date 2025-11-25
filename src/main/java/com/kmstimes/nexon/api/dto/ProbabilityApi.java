package com.kmstimes.nexon.api.dto;

import com.kmstimes.nexon.client.dto.ProbabilityApiClient;
import com.kmstimes.nexon.dto.probability.potential.cube.CubeResponse;
import com.kmstimes.nexon.dto.probability.potential.potential.PotentialResponse;
import com.kmstimes.nexon.dto.probability.starforce.StarforceResponse;
import com.kmstimes.nexon.dto.probability.user.OuidResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

import java.time.LocalDate;

/**
 * 메이플스토리 확률 정보 조회 API 정의 인터페이스입니다.
 * <p>
 * Retrofit을 기반으로 각 확률 관련 API 엔드포인트를 선언하며,
 * {@link ProbabilityApiClient} 에서 사용됩니다.
 */
public interface ProbabilityApi {

    /**
     * 계정 식별자(ouid)를 조회합니다.
     *
     * @param userApiKey 구 개발자센터 API KEY
     * @return {@link OuidResponse} 계정 식별자(ouid) 조회(구 API KEY 사용)
     */
    @GET("legacy/ouid")
    Call<OuidResponse> getLegacyOuid(@Header("x-nxopen-api-key") String userApiKey);

    /**
     * 계정 식별자(ouid)를 조회합니다.
     *
     * @param userApiKey API KEY
     * @return {@link OuidResponse} 계정 식별자(ouid) 조회
     */
    @GET("maplestory/v1/ouid")
    Call<OuidResponse> getOuid(@Header("x-nxopen-api-key") String userApiKey);

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
    @GET("maplestory/v1/history/starforce")
    Call<StarforceResponse> getStarforce(@Header("x-nxopen-api-key") String userApiKey,
                                         @Query("count") int count,
                                         @Query("date") LocalDate date,
                                         @Query("cursor") String cursor);

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
    @GET("maplestory/v1/history/potential")
    Call<PotentialResponse> getPotential(@Header("x-nxopen-api-key") String userApiKey,
                                         @Query("count") int count,
                                         @Query("date") LocalDate date,
                                         @Query("cursor") String cursor);

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
    @GET("maplestory/v1/history/cube")
    Call<CubeResponse> getCube(@Header("x-nxopen-api-key") String userApiKey,
                               @Query("count") int count,
                               @Query("date") LocalDate date,
                               @Query("cursor") String cursor);
}
