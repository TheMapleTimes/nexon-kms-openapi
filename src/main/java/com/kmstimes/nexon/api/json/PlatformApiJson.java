package com.kmstimes.nexon.api.json;

import com.kmstimes.nexon.client.json.PlatformApiJsonClient;
import com.kmstimes.nexon.dto.platform.PlatformNoticeResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * NEXON Open API의 공지 사항을 조회할 수 있는 API입니다.
 * <p>
 * Retrofit을 기반으로 NEXON Open API 엔드포인트를 선언하며,
 * {@link PlatformApiJsonClient} 에서 사용됩니다.
 */
public interface PlatformApiJson {
    
    /**
     * NEXON Open API에 최근 등록된 공지 사항 10개를 가져옵니다.
     * @param gameName 특정 게임의 NEXON Open API 공지를 조회할 때 입력합니다. 빈 값으로 입력할 경우 전체 공지를 조회합니다.
     * @return {@link PlatformNoticeResponse} NEXON OPEN API 공지 사항
     */
    @GET("platform/openapi/v1/notice")
    Call<ResponseBody> getNotices(@Query("game_name") String gameName);
}
