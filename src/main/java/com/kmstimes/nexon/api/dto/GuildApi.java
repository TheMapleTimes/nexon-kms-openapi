package com.kmstimes.nexon.api.dto;

import com.kmstimes.nexon.client.dto.GuildApiClient;
import com.kmstimes.nexon.dto.guild.GuildBasicResponse;
import com.kmstimes.nexon.dto.guild.GuildIdResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.time.LocalDate;

/**
 * 메이플스토리 길드 정보 조회 API 정의 인터페이스입니다.
 * <p>
 * Retrofit을 기반으로 각 길드 관련 API 엔드포인트를 선언하며,
 * {@link GuildApiClient} 에서 사용됩니다.
 * <p>
 * <strong>NEXON OPEN API 안내사항:</strong>
 * <ul>
 * <li>메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</li>
 * <li>2023년 12월 21일 데이터부터 조회할 수 있습니다.</li>
 * <li>과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다.
 * (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</li>
 * <li>게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</li>
 * </ul>
 */
public interface GuildApi {

    /**
     * 길드 식별자(oguild_id) 정보를 조회합니다.
     *
     * @param guildName 길드 명
     * @param worldName 월드 명
     *                  <p>
     *                  2024년 12월 19일 이후 30일간 리부트, 리부트2 입력 시 에오스, 핼리오스로 연결됩니다.
     *                  <p>
     *                  리부트, 리부트2로 조회하시던 부분은 30일 이내 에오스, 헬리오스로 갱신 부탁드립니다.
     *                  <p>
     *                  <strong>Available values :</strong> {@link com.kmstimes.nexon.enums.WorldName}
     * @return {@link GuildIdResponse} 길드 식별자(oguild_id) 정보 조회
     */
    @GET("maplestory/v1/guild/id")
    Call<GuildIdResponse> getGuildId(
            @Query("guild_name") String guildName,
            @Query("world_name") String worldName
    );

    /**
     * 길드 기본 정보를 조회합니다.
     *
     * @param guildId 길드 식별자
     * @param date    조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link GuildBasicResponse} 길드 기본 정보 조회
     */
    @GET("maplestory/v1/guild/basic")
    Call<GuildBasicResponse> getGuildBasic(
            @Query("oguild_id") String guildId,
            @Query("date") LocalDate date
    );
}
