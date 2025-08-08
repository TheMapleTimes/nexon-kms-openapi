package com.kmstimes.nexon.client.json;

import com.kmstimes.nexon.api.json.GuildApiJson;
import com.kmstimes.nexon.dto.guild.GuildBasicResponse;
import com.kmstimes.nexon.dto.guild.GuildIdResponse;
import com.kmstimes.nexon.error.handler.NexonApiExceptionHandler;
import com.kmstimes.nexon.validator.DateValidator;
import com.kmstimes.nexon.validator.WorldValidator;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;

import java.time.LocalDate;

/**
 * 길드 정보 조회 API 호출을 담당하는 클라이언트 클래스입니다.
 * <p>
 * {@link GuildApiJson} 인터페이스를 기반으로, 실제 API 요청을 수행하고,
 * 예외 처리를 일관되게 처리합니다.
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
public class GuildApiJsonClient {
    private final GuildApiJson guildApi;
    private final DateValidator dateValidator = new DateValidator(LocalDate.of(2023, 12, 21));

    /**
     * 생성자: Retrofit 인스턴스를 주입받아 {@link GuildApiJson} 를 초기화합니다.
     *
     * @param retrofit Retrofit 인스턴스
     */
    public GuildApiJsonClient(Retrofit retrofit) {
        this.guildApi = retrofit.create(GuildApiJson.class);
    }

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
    public ResponseBody getGuildId(String guildName, String worldName) {
        validateString(guildName);
        validateString(worldName);
        WorldValidator.validate(worldName);

        return NexonApiExceptionHandler.execute(() ->
                guildApi.getGuildId(guildName, worldName)
        );
    }

    /**
     * 길드 기본 정보를 조회합니다.
     *
     * @param guildId 길드 식별자
     * @param date    조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link GuildBasicResponse} 길드 기본 정보 조회
     */
    public ResponseBody getGuildBasic(String guildId, LocalDate date) {
        validateString(guildId);

        return NexonApiExceptionHandler.execute(() ->
                guildApi.getGuildBasic(guildId, dateValidator.validate(date))
        );
    }

    private void validateString(String string) {
        if (string == null || string.trim().isEmpty()) {
            throw new IllegalArgumentException("null 이거나 비어 있을 수 없습니다.");
        }
    }
}