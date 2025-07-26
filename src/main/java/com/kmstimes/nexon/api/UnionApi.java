package com.kmstimes.nexon.api;

import com.kmstimes.nexon.model.union.artifact.UnionArtifactResponse;
import com.kmstimes.nexon.model.union.champion.UnionChampionResponse;
import com.kmstimes.nexon.model.union.info.UnionResponse;
import com.kmstimes.nexon.model.union.raider.UnionRaiderResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.time.LocalDate;

/**
 * 메이플스토리 유니온 정보 조회 API 정의 인터페이스입니다.
 * <p>
 * Retrofit을 기반으로 각 유니온 관련 API 엔드포인트를 선언하며,
 * {@link com.kmstimes.nexon.client.UnionApiClient} 에서 사용됩니다.
 * <p>
 * <strong>NEXON OPEN API 안내사항:</strong>
 * <ul>
 * <li>메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</li>
 * <li>2023년 12월 21일 데이터부터 조회할 수 있습니다.</li>
 * <li>과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다.
 * (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</li>
 * <li>게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</li>
 * <li>해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</li>
 * </ul>
 */
public interface UnionApi {

    /**
     * 유니온 레벨 및 유니온 등급 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link UnionResponse} 유니온 정보 조회
     */
    @GET("v1/user/union")
    Call<UnionResponse> getUnion(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 유니온에 배치된 공격대원 효과 및 공격대 점령 효과 등 상세 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link UnionRaiderResponse} 유니온 공격대 정보 조회
     */
    @GET("v1/user/union-raider")
    Call<UnionRaiderResponse> getUnionRaider(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 유니온 아티팩트 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link UnionArtifactResponse} 유니온 아티팩트 정보 조회
     */
    @GET("v1/user/union-artifact")
    Call<UnionArtifactResponse> getUnionArtifact(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 유니온 챔피언 정보를 조회합니다.
     * <p>
     * 유니온 챔피언 정보는 2025년 2월 20일 메이플스토리 점검 이후 데이터부터 조회 가능합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link UnionChampionResponse} 유니온 챔피언 정보 조회
     */
    @GET("v1/user/union-champion")
    Call<UnionChampionResponse> getUnionChampion(@Query("ocid") String ocid, @Query("date") LocalDate date);
}
