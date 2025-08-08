package com.kmstimes.nexon.client.json;

import com.kmstimes.nexon.api.json.RankingApiJson;
import com.kmstimes.nexon.dto.ranking.achievement.AchievementRankingResponse;
import com.kmstimes.nexon.dto.ranking.dojang.DojangRankingResponse;
import com.kmstimes.nexon.dto.ranking.guild.GuildRankingResponse;
import com.kmstimes.nexon.dto.ranking.overall.OverallRankingResponse;
import com.kmstimes.nexon.dto.ranking.theseed.TheseedRankingResponse;
import com.kmstimes.nexon.dto.ranking.union.UnionRankingResponse;
import com.kmstimes.nexon.error.handler.NexonApiExceptionHandler;
import com.kmstimes.nexon.validator.ClassValidator;
import com.kmstimes.nexon.validator.DateValidator;
import com.kmstimes.nexon.validator.WorldValidator;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;

import java.time.LocalDate;

/**
 * 유니온 정보 조회 API 호출을 담당하는 클라이언트 클래스입니다.
 * <p>
 * {@link RankingApiJson} 인터페이스를 기반으로, 실제 API 요청을 수행하고,
 * 예외 처리를 일관되게 처리합니다.
 * <p>
 * <strong>NEXON OPEN API 안내사항:</strong>
 * <ul>
 * <li>2023년 12월 22일 데이터부터 조회할 수 있습니다.</li>
 * <li>오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.</li>
 * <li>게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</li>
 * <li>해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</li>
 * </ul>
 */
public class RankingApiJsonClient {
    private final RankingApiJson rankingApi;
    private final DateValidator dateValidator = new DateValidator(LocalDate.of(2023, 12, 22));

    /**
     * 생성자: Retrofit 인스턴스를 주입받아 {@link RankingApiJson} 를 초기화합니다.
     *
     * @param retrofit Retrofit 인스턴스
     */
    public RankingApiJsonClient(Retrofit retrofit) {
        this.rankingApi = retrofit.create(RankingApiJson.class);
    }

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
    public ResponseBody getOverall(LocalDate date, String worldName, int worldType, String characterClass, String ocid, int page) {
        WorldValidator.validate(worldName);
        ClassValidator.validate(characterClass);

        return NexonApiExceptionHandler.execute(() ->
                rankingApi.getOverall(dateValidator.validate(date), worldName, worldType, characterClass, ocid, validatePage(page))
        );

    }

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
    public ResponseBody getUnion(LocalDate date, String worldName, String ocid, int page) {
        WorldValidator.validate(worldName);

        return NexonApiExceptionHandler.execute(() ->
                rankingApi.getUnion(dateValidator.validate(date), worldName, ocid, validatePage(page))
        );

    }

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
    public ResponseBody getGuild(LocalDate date, String worldName, int rankingType, String guildName, int page) {
        WorldValidator.validate(worldName);
        if (0 > rankingType || rankingType > 2) {
            rankingType = 0;
        }
        int finalRankingType = rankingType;

        return NexonApiExceptionHandler.execute(() ->
                rankingApi.getGuild(dateValidator.validate(date), worldName, finalRankingType, guildName, validatePage(page))
        );

    }

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
    public ResponseBody getDojang(LocalDate date, String worldName, int difficulty, String characterClass, String ocid, int page) {
        WorldValidator.validate(worldName);
        ClassValidator.validate(characterClass);

        if (0 > difficulty || difficulty > 1) {
            difficulty = 1;
        }

        int finalDifficulty = difficulty;
        return NexonApiExceptionHandler.execute(() ->
                rankingApi.getDojang(dateValidator.validate(date), worldName, finalDifficulty, characterClass, ocid, validatePage(page))
        );
    }

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
    public ResponseBody getTheseed(LocalDate date, String worldName, String ocid, int page) {
        WorldValidator.validate(worldName);

        return NexonApiExceptionHandler.execute(() ->
                rankingApi.getTheseed(dateValidator.validate(date), worldName, ocid, validatePage(page))
        );

    }

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
    public ResponseBody getAchievement(LocalDate date, String ocid, int page) {

        return NexonApiExceptionHandler.execute(() ->
                rankingApi.getAchievement(dateValidator.validate(date), ocid, validatePage(page))
        );
    }

    private int validatePage(int page) {
        if (page <= 0) {
            return 1;
        }
        return page;
    }

}
