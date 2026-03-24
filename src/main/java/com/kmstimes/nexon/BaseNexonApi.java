package com.kmstimes.nexon;

import com.kmstimes.nexon.validator.ApiKeyValidator;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.util.concurrent.TimeUnit;

public abstract class BaseNexonApi {
    private static final String BASE_URL = "https://open.api.nexon.com/";
    private static final String API_KEY_HEADER = "x-nxopen-api-key";
    
    protected Retrofit buildRetrofit(String apiKey, OkHttpClient customClient, int connectTimeoutSeconds, int readTimeoutSeconds) {
        
        ApiKeyValidator.validate(apiKey);
        if (connectTimeoutSeconds <= 0 || readTimeoutSeconds <= 0) {
            throw new IllegalArgumentException("시간 초과 값은 양수여야 합니다.");
        }
        
        OkHttpClient.Builder clientBuilder;
        
        if (customClient != null) {
            clientBuilder = customClient.newBuilder();
        } else {
            clientBuilder = new OkHttpClient.Builder();
            clientBuilder.connectTimeout(connectTimeoutSeconds, TimeUnit.SECONDS);
            clientBuilder.readTimeout(readTimeoutSeconds, TimeUnit.SECONDS);
        }
        
        clientBuilder.addInterceptor(chain -> {
            Request request = chain.request().newBuilder()
                                   .header(API_KEY_HEADER, apiKey)
                                   .header("Accept", "application/json")
                                   .build();
            return chain.proceed(request);
        });
        
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(clientBuilder.build())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
