package com.kmstimes.nexon;

import com.kmstimes.nexon.client.dto.PlatformApiClient;
import com.kmstimes.nexon.client.json.PlatformApiJsonClient;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * 넥슨 플랫폼 Open API의 클라이언트 진입점 클래스입니다.
 * <p>
 * 이 클래스는 NEXON Open API의 공지 사항 조회에 대한
 * Retrofit 기반의 클라이언트를 초기화하고 제공합니다.
 * <p>
 * 다양한 생성자 및 빌더를 통해 사용자 설정 (API 키, 타임아웃)을 지원합니다.
 * <p>
 * 예시 사용법:
 * <pre>
 * PlatformApi api = PlatformApi.create("your-api-key");
 * PlatformNoticeResponse response = api.PlatformApiClient().getNotices("메이플스토리");
 * </pre>
 */
public class PlatformApi extends BaseNexonApi {
    
    private static final int DEFAULT_CONNECT_TIMEOUT = 10;
    private static final int DEFAULT_READ_TIMEOUT = 30;
    private final PlatformApiClient platformApiClient;
    private final PlatformApiJsonClient platformApiJsonClient;
    
    public PlatformApi(final String apiKey) {
        
        this(apiKey, null, DEFAULT_CONNECT_TIMEOUT, DEFAULT_READ_TIMEOUT);
    }
    
    public PlatformApi(
            String apiKey,
            OkHttpClient customClient,
            int connectTimeoutSeconds,
            int readTimeoutSeconds
    ) {
        
        Retrofit retrofit = buildRetrofit(
                apiKey,
                customClient,
                connectTimeoutSeconds,
                readTimeoutSeconds
        );
        this.platformApiClient = new PlatformApiClient(retrofit);
        this.platformApiJsonClient = new PlatformApiJsonClient(retrofit);
    }
    
    /**
     * 정적 팩토리 메서드. 기본 타임아웃 설정을 사용하여 클라이언트를 생성합니다.
     *
     * @param apiKey Nexon Open API 키
     * @return PlatformApi 인스턴스
     */
    public static PlatformApi create(String apiKey) {
        
        return new PlatformApi(apiKey);
    }
    
    /**
     * 빌더 인스턴스를 반환합니다.
     *
     * @return {@link Builder} 인스턴스
     */
    public static Builder builder() {
        
        return new Builder();
    }
    
    /**
     * NEXON Open API의 공지 사항을 조회 API에 접근할 수 있는 클라이언트를 반환합니다.
     * <p>
     * api에 대응하는 DTO 객체로 반환합니다.
     *
     * @return {@link PlatformApiClient} 인스턴스
     */
    public PlatformApiClient platform() {
        
        return platformApiClient;
    }
    
    /**
     * NEXON Open API의 공지 사항을 조회 API에 접근할 수 있는 클라이언트를 반환합니다.
     * <p>
     * ResponseBody 객체(json)로 반환합니다.
     *
     * @return {@link PlatformApiJsonClient} 인스턴스
     */
    public PlatformApiJsonClient platformJson() {
        
        return platformApiJsonClient;
    }
    
    /**
     * MapleStoryApi를 구성하기 위한 빌더 클래스입니다.
     * <p>
     * 연결 타임아웃, 읽기 타임아웃, API 키를 설정할 수 있습니다.
     */
    public static class Builder {
        
        private String apiKey;
        private OkHttpClient customClient;
        private int connectTimeoutSeconds = DEFAULT_CONNECT_TIMEOUT;
        private int readTimeoutSeconds = DEFAULT_READ_TIMEOUT;
        
        /**
         * API 키를 설정합니다.
         *
         * @param apiKey Nexon Open API 키
         * @return Builder 인스턴스
         */
        public Builder apiKey(String apiKey) {
            
            this.apiKey = apiKey;
            return this;
        }
        
        /**
         *
         * 외부에서 설정한 OkHttpClient(Dispatcher, ConnectionPool 포함)를 주입합니다.
         */
        public Builder client(OkHttpClient client) {
            
            this.customClient = client;
            return this;
        }
        
        /**
         * 연결 타임아웃(초)을 설정합니다.
         *
         * @param seconds 연결 타임아웃 (초)
         * @return Builder 인스턴스
         */
        public Builder connectTimeout(int seconds) {
            
            this.connectTimeoutSeconds = seconds;
            return this;
        }
        
        /**
         * 읽기 타임아웃(초)을 설정합니다.
         *
         * @param seconds 읽기 타임아웃 (초)
         * @return Builder 인스턴스
         */
        public Builder readTimeout(int seconds) {
            
            this.readTimeoutSeconds = seconds;
            return this;
        }
        
        /**
         * PlatformApi 인스턴스를 생성합니다.
         *
         * @return PlatformApi 인스턴스
         */
        public PlatformApi build() {
            
            return new PlatformApi(
                    apiKey,
                                   customClient,
                                   connectTimeoutSeconds,
                                   readTimeoutSeconds
            );
        }
        
    }
    
}
