package com.kmstimes.nexon;

import com.kmstimes.nexon.client.dto.*;
import com.kmstimes.nexon.client.json.*;
import com.kmstimes.nexon.validator.ApiKeyValidator;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.util.concurrent.TimeUnit;

/**
 * 넥슨 메이플스토리 Open API의 클라이언트 진입점 클래스입니다.
 * <p>
 * 이 클래스는 다양한 도메인 API (길드, 캐릭터, 공지, 확률형, 랭킹, 유니온 등)에 대한
 * Retrofit 기반의 클라이언트를 초기화하고 제공합니다.
 * <p>
 * 다양한 생성자 및 빌더를 통해 사용자 설정 (API 키, 타임아웃)을 지원합니다.
 * <p>
 * 예시 사용법:
 * <pre>
 * MapleStoryApi api = MapleStoryApi.create("your-api-key");
 * UnionResponse response = api.unionApiClient().getUnion("ocid", "2024-01-01");
 * </pre>
 */
public class MapleStoryApi {
    private static final String BASE_URL = "https://open.api.nexon.com/";
    private static final String API_KEY_HEADER = "x-nxopen-api-key";
    private static final int DEFAULT_CONNECT_TIMEOUT = 10;
    private static final int DEFAULT_READ_TIMEOUT = 30;
    private final String apiKey;
    private final GuildApiClient guildApiClient;
    private final CharacterApiClient characterApiClient;
    private final NoticeApiClient noticeApiClient;
    private final ProbabilityApiClient probabilityApiClient;
    private final RankingApiClient rankingApiClient;
    private final UnionApiClient unionApiClient;
    private final GuildApiJsonClient guildApiJsonClient;
    private final CharacterApiJsonClient characterApiJsonClient;
    private final NoticeApiJsonClient noticeApiJsonClient;
    private final ProbabilityApiJsonClient probabilityApiJsonClient;
    private final RankingApiJsonClient rankingApiJsonClient;
    private final UnionApiJsonClient unionApiJsonClient;
    private final PlatformApiClient platformApiClient;
    private final PlatformApiJsonClient platformApiJsonClient;

    /**
     * 기본 생성자입니다. 기본 타임아웃 설정을 사용하여 클라이언트를 초기화합니다.
     *
     * @param apiKey Nexon Open API 키
     * @throws IllegalArgumentException API 키가 null 이거나 비어 있을 경우
     */
    public MapleStoryApi(final String apiKey) {
        this(apiKey, DEFAULT_CONNECT_TIMEOUT, DEFAULT_READ_TIMEOUT);
    }

    /**
     * 연결 및 읽기 타임아웃을 포함하여 클라이언트를 초기화합니다.
     *
     * @param apiKey                Nexon Open API 키
     * @param connectTimeoutSeconds 연결 타임아웃 (초)
     * @param readTimeoutSeconds    읽기 타임아웃 (초)
     * @throws IllegalArgumentException 유효하지 않은 파라미터 입력 시
     */
    public MapleStoryApi(String apiKey, int connectTimeoutSeconds, int readTimeoutSeconds) {
        ApiKeyValidator.validate(apiKey);
        if (connectTimeoutSeconds <= 0 || readTimeoutSeconds <= 0) {
            throw new IllegalArgumentException("시간 초과 값은 양수여야 합니다.");
        }

        this.apiKey = apiKey;
        Retrofit retrofit = buildRetrofit(connectTimeoutSeconds, readTimeoutSeconds);
        this.guildApiClient = new GuildApiClient(retrofit);
        this.characterApiClient = new CharacterApiClient(retrofit);
        this.noticeApiClient = new NoticeApiClient(retrofit);
        this.probabilityApiClient = new ProbabilityApiClient(retrofit);
        this.rankingApiClient = new RankingApiClient(retrofit);
        this.unionApiClient = new UnionApiClient(retrofit);
        this.guildApiJsonClient = new GuildApiJsonClient(retrofit);
        this.characterApiJsonClient = new CharacterApiJsonClient(retrofit);
        this.noticeApiJsonClient = new NoticeApiJsonClient(retrofit);
        this.probabilityApiJsonClient = new ProbabilityApiJsonClient(retrofit);
        this.rankingApiJsonClient = new RankingApiJsonClient(retrofit);
        this.unionApiJsonClient = new UnionApiJsonClient(retrofit);
        this.platformApiClient = new PlatformApiClient(retrofit);
        this.platformApiJsonClient = new PlatformApiJsonClient(retrofit);
    }

    /**
     * 정적 팩토리 메서드. 기본 타임아웃 설정을 사용하여 클라이언트를 생성합니다.
     *
     * @param apiKey Nexon Open API 키
     * @return MapleStoryApi 인스턴스
     */
    public static MapleStoryApi create(String apiKey) {
        return new MapleStoryApi(apiKey);
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
     * 길드 정보 조회 API에 접근할 수 있는 클라이언트를 반환합니다.
     * <p>
     * api에 대응하는 DTO 객체로 반환합니다.
     *
     * @return {@link GuildApiClient} 인스턴스
     */
    public GuildApiClient Guild() {
        return guildApiClient;
    }
    
    /**
     * 캐릭터 정보 조회 API에 접근할 수 있는 클라이언트를 반환합니다.
     * <p>
     * api에 대응하는 DTO 객체로 반환합니다.
     *
     * @return {@link CharacterApiClient} 인스턴스
     */
    public CharacterApiClient Character() {
        return characterApiClient;
    }
    
    /**
     * 공지 정보 조회 API에 접근할 수 있는 클라이언트를 반환합니다.
     * <p>
     * api에 대응하는 DTO 객체로 반환합니다.
     *
     * @return {@link NoticeApiClient} 인스턴스
     */
    public NoticeApiClient Notice() {
        return noticeApiClient;
    }
    
    /**
     * 확률 정보 조회 API에 접근할 수 있는 클라이언트를 반환합니다.
     * <p>
     * api에 대응하는 DTO 객체로 반환합니다.
     *
     * @return {@link ProbabilityApiClient} 인스턴스
     */
    public ProbabilityApiClient Probability() {
        return probabilityApiClient;
    }
    
    /**
     * 랭킹 정보 조회 API에 접근할 수 있는 클라이언트를 반환합니다.
     * <p>
     * api에 대응하는 DTO 객체로 반환합니다.
     *
     * @return {@link RankingApiClient} 인스턴스
     */
    public RankingApiClient Ranking() {
        return rankingApiClient;
    }
    
    /**
     * 유니온 정보 조회 API에 접근할 수 있는 클라이언트를 반환합니다.
     * <p>
     * api에 대응하는 DTO 객체로 반환합니다.
     *
     * @return {@link UnionApiClient} 인스턴스
     */
    public UnionApiClient Union() {
        return unionApiClient;
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
     * 길드 정보 조회 API에 접근할 수 있는 클라이언트를 반환합니다.
     * <p>
     * ResponseBody 객체(json)로 반환합니다.
     *
     * @return {@link GuildApiJsonClient} 인스턴스
     */
    public GuildApiJsonClient GuildJson() {
        return guildApiJsonClient;
    }
    
    /**
     * 캐릭터 정보 조회 API에 접근할 수 있는 클라이언트를 반환합니다.
     * <p>
     * ResponseBody 객체(json)로 반환합니다.
     *
     * @return {@link CharacterApiJsonClient} 인스턴스
     */
    public CharacterApiJsonClient CharacterJson() {
        return characterApiJsonClient;
    }
    
    /**
     * 공지 정보 조회 API에 접근할 수 있는 클라이언트를 반환합니다.
     * <p>
     * ResponseBody 객체(json)로 반환합니다.
     *
     * @return {@link NoticeApiJsonClient} 인스턴스
     */
    public NoticeApiJsonClient NoticeJson() {
        return noticeApiJsonClient;
    }
    
    /**
     * 확률 정보 조회 API에 접근할 수 있는 클라이언트를 반환합니다.
     * <p>
     * ResponseBody 객체(json)로 반환합니다.
     *
     * @return {@link ProbabilityApiJsonClient} 인스턴스
     */
    public ProbabilityApiJsonClient ProbabilityJson() {
        return probabilityApiJsonClient;
    }
    
    /**
     * 랭킹 정보 조회 API에 접근할 수 있는 클라이언트를 반환합니다.
     * <p>
     * ResponseBody 객체(json)로 반환합니다.
     *
     * @return {@link RankingApiJsonClient} 인스턴스
     */
    public RankingApiJsonClient RankingJson() {
        return rankingApiJsonClient;
    }
    
    /**
     * 유니온 정보 조회 API에 접근할 수 있는 클라이언트를 반환합니다.
     * <p>
     * ResponseBody 객체(json)로 반환합니다.
     *
     * @return {@link UnionApiJsonClient} 인스턴스
     */
    public UnionApiJsonClient UnionJson() {
        return unionApiJsonClient;
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

    private Retrofit buildRetrofit(int connectTimeoutSeconds, int readTimeoutSeconds) {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(connectTimeoutSeconds, TimeUnit.SECONDS)
                .readTimeout(readTimeoutSeconds, TimeUnit.SECONDS)
                .addInterceptor(chain -> {
                    Request request = chain.request().newBuilder()
                            .header(API_KEY_HEADER, apiKey)
                            .header("Accept", "application/json")
                            .build();
                    return chain.proceed(request);
                })
                .build();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * MapleStoryApi를 구성하기 위한 빌더 클래스입니다.
     * <p>
     * 연결 타임아웃, 읽기 타임아웃, API 키를 설정할 수 있습니다.
     */
    public static class Builder {
        private String apiKey;
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
         * MapleStoryApi 인스턴스를 생성합니다.
         *
         * @return MapleStoryApi 인스턴스
         */
        public MapleStoryApi build() {
            return new MapleStoryApi(apiKey, connectTimeoutSeconds, readTimeoutSeconds);
        }
    }
}
