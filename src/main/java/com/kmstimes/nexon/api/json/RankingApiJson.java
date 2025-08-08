package com.kmstimes.nexon.api.json;

import com.kmstimes.nexon.client.json.RankingApiJsonClient;
import com.kmstimes.nexon.dto.ranking.achievement.AchievementRankingResponse;
import com.kmstimes.nexon.dto.ranking.dojang.DojangRankingResponse;
import com.kmstimes.nexon.dto.ranking.guild.GuildRankingResponse;
import com.kmstimes.nexon.dto.ranking.overall.OverallRankingResponse;
import com.kmstimes.nexon.dto.ranking.theseed.TheseedRankingResponse;
import com.kmstimes.nexon.dto.ranking.union.UnionRankingResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.time.LocalDate;

/**
 * 메이플스토리 랭킹 정보 조회 API 정의 인터페이스입니다.
 * <p>
 * Retrofit을 기반으로 각 랭킹 관련 API 엔드포인트를 선언하며,
 * {@link RankingApiJsonClient} 에서 사용됩니다.
 * <p>
 * <strong>NEXON OPEN API 안내사항:</strong>
 * <ul>
 * <li>2023년 12월 22일 데이터부터 조회할 수 있습니다.</li>
 * <li>오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.</li>
 * <li>게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</li>
 * <li>해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</li>
 * </ul>
 */
public interface RankingApiJson {

    /**
     * 종합 랭킹 정보를 조회합니다.
     * <p>
     * - 종합 랭킹 정보는 최근 2년 데이터만 조회 가능합니다.
     *
     * @param date           조회 기준일 (KST, YYYY-MM-DD)
     * @param worldName      월드 명
     *                       <p>
     *                       2024년 12월 19일 이후 30일간 리부트, 리부트2 입력 시 에오스, 핼리오스로 연결됩니다.
     *                       <p>
     *                       리부트, 리부트2로 조회하시던 부분은 30일 이내 에오스, 헬리오스로 갱신 부탁드립니다.
     *                       <p>
     *                       <strong>Available values :</strong> {@link com.kmstimes.nexon.enums.WorldName}
     * @param worldType      월드 타입 (0:일반, 1:에오스,핼리오스) (기본 값은 0이며, world_name 입력 시 미 반영)
     * @param characterClass 직업 및 전직
     *                       <p>
     *                       <strong>Available values :</strong> {@link com.kmstimes.nexon.enums.ClassName}
     * @param ocid           캐릭터 식별자
     * @param page           페이지 번호
     * @return {@link OverallRankingResponse} 종합 랭킹 정보 조회
     */
    @GET("v1/ranking/overall")
    Call<ResponseBody> getOverall(
            @Query("date") LocalDate date,
            @Query("world_name") String worldName,
            @Query("world_type") int worldType,
            @Query("class") String characterClass,
            @Query("ocid") String ocid,
            @Query("page") int page
    );

    /**
     * 유니온 랭킹 정보를 조회합니다.
     * <p>
     * - 유니온 랭킹 정보는 최근 2년 데이터만 조회 가능합니다.
     *
     * @param date      조회 기준일 (KST, YYYY-MM-DD)
     * @param worldName 월드 명
     *                  <p>
     *                  2024년 12월 19일 이후 30일간 리부트, 리부트2 입력 시 에오스, 핼리오스로 연결됩니다.
     *                  <p>
     *                  리부트, 리부트2로 조회하시던 부분은 30일 이내 에오스, 헬리오스로 갱신 부탁드립니다.
     *                  <p>
     *                  <strong>Available values :</strong> {@link com.kmstimes.nexon.enums.WorldName}
     * @param ocid      캐릭터 식별자
     * @param page      페이지 번호
     * @return {@link UnionRankingResponse} 유니온 랭킹 정보 조회
     */
    @GET("v1/ranking/union")
    Call<ResponseBody> getUnion(
            @Query("date") LocalDate date,
            @Query("world_name") String worldName,
            @Query("ocid") String ocid,
            @Query("page") int page
    );

    /**
     * 길드 랭킹 정보를 조회합니다.
     * <p>
     * - 길드 랭킹 정보는 최근 2년 데이터만 조회 가능합니다.
     *
     * @param date        조회 기준일 (KST, YYYY-MM-DD)
     * @param worldName   월드 명
     *                    <p>
     *                    2024년 12월 19일 이후 30일간 리부트, 리부트2 입력 시 에오스, 핼리오스로 연결됩니다.
     *                    <p>
     *                    리부트, 리부트2로 조회하시던 부분은 30일 이내 에오스, 헬리오스로 갱신 부탁드립니다.
     *                    <p>
     *                    <strong>Available values :</strong> {@link com.kmstimes.nexon.enums.WorldName}
     * @param rankingType 랭킹 타입 (0:주간 명성치, 1:플래그 레이스, 2:지하 수로)
     * @param guildName   길드 명
     * @param page        페이지 번호
     * @return {@link GuildRankingResponse} 길드 랭킹 정보 조회
     */
    @GET("v1/ranking/guild")
    Call<ResponseBody> getGuild(
            @Query("date") LocalDate date,
            @Query("world_name") String worldName,
            @Query("ranking_type") int rankingType,
            @Query("guild_name") String guildName,
            @Query("page") int page
    );

    /**
     * 무릉도장 랭킹 정보를 조회합니다.
     * <p>
     * - 무릉도장 랭킹 정보는 최근 2년 데이터만 조회 가능합니다.
     *
     * @param date           조회 기준일 (KST, YYYY-MM-DD)
     * @param worldName      월드 명
     *                       <p>
     *                       2024년 12월 19일 이후 30일간 리부트, 리부트2 입력 시 에오스, 핼리오스로 연결됩니다.
     *                       <p>
     *                       리부트, 리부트2로 조회하시던 부분은 30일 이내 에오스, 헬리오스로 갱신 부탁드립니다.
     *                       <p>
     *                       <strong>Available values :</strong> {@link com.kmstimes.nexon.enums.WorldName}
     * @param difficulty     구간 (0:일반, 1:통달)
     * @param characterClass 직업 및 전직
     *                       <p>
     *                       <strong>Available values :</strong> {@link com.kmstimes.nexon.enums.ClassName}
     * @param ocid           캐릭터 식별자
     * @param page           페이지 번호
     * @return {@link DojangRankingResponse} 무릉도장 랭킹 정보 조회
     */
    @GET("v1/ranking/dojang")
    Call<ResponseBody> getDojang(
            @Query("date") LocalDate date,
            @Query("world_name") String worldName,
            @Query("difficulty") int difficulty,
            @Query("class") String characterClass,
            @Query("ocid") String ocid,
            @Query("page") int page
    );

    /**
     * 더 시드 랭킹 정보를 조회합니다.
     * <p>
     * - 더 시드 랭킹 정보는 최근 2년 데이터만 조회 가능합니다.
     *
     * @param date      조회 기준일 (KST, YYYY-MM-DD)
     * @param worldName 월드 명
     *                  <p>
     *                  2024년 12월 19일 이후 30일간 리부트, 리부트2 입력 시 에오스, 핼리오스로 연결됩니다.
     *                  <p>
     *                  리부트, 리부트2로 조회하시던 부분은 30일 이내 에오스, 헬리오스로 갱신 부탁드립니다.
     *                  <p>
     *                  <strong>Available values :</strong> {@link com.kmstimes.nexon.enums.WorldName}
     * @param ocid      캐릭터 식별자
     * @param page      페이지 번호
     * @return {@link TheseedRankingResponse} 더 시드 랭킹 정보 조회
     */
    @GET("v1/ranking/theseed")
    Call<ResponseBody> getTheseed(
            @Query("date") LocalDate date,
            @Query("world_name") String worldName,
            @Query("ocid") String ocid,
            @Query("page") int page
    );

    /**
     * 업적 랭킹 정보를 조회합니다.
     * <p>
     * - 업적 랭킹 정보는 최근 2년 데이터만 조회 가능합니다.
     *
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @param ocid 캐릭터 식별자
     * @param page 페이지 번호
     * @return {@link AchievementRankingResponse} 업적 랭킹 정보 조회
     */
    @GET("v1/ranking/achievement")
    Call<ResponseBody> getAchievement(
            @Query("date") LocalDate date,
            @Query("ocid") String ocid,
            @Query("page") int page
    );
}
