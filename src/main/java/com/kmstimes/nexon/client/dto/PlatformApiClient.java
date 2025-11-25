package com.kmstimes.nexon.client.dto;

import com.kmstimes.nexon.api.dto.PlatformApi;
import com.kmstimes.nexon.dto.platform.PlatformNoticeResponse;
import com.kmstimes.nexon.error.handler.NexonApiExceptionHandler;
import retrofit2.Retrofit;

/**
 * NEXON Open API의 공지 사항을 조회 API 호출을 담당하는 클라이언트 클래스입니다.
 * <p>
 * {@link PlatformApi} 인터페이스를 기반으로, 실제 API 요청을 수행하고,
 * 예외 처리를 일관되게 처리합니다.
 */
public class PlatformApiClient {
    
    private final PlatformApi platformApi;
    
    /**
     * 생성자: Retrofit 인스턴스를 주입받아 {@link PlatformApi} 를 초기화합니다.
     *
     * @param retrofit Retrofit 인스턴스
     */
    public PlatformApiClient(Retrofit retrofit) {
        
        this.platformApi = retrofit.create(PlatformApi.class);
    }
    
    /**
     * NEXON Open API에 최근 등록된 공지 사항 10개를 가져옵니다.
     * @param gameName 특정 게임의 NEXON Open API 공지를 조회할 때 입력합니다. 빈 값으로 입력할 경우 전체 공지를 조회합니다.
     *      * @return {@link PlatformNoticeResponse} NEXON OPEN API 공지 사항
     */
    public PlatformNoticeResponse getNotices(String gameName) {
        
        return NexonApiExceptionHandler.execute(() -> platformApi.getNotices(gameName));
    }
    
}
