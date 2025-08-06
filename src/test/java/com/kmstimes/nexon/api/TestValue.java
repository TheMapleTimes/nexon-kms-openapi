package com.kmstimes.nexon.api;

import com.kmstimes.nexon.MapleStoryApi;

import java.time.LocalDate;

public class TestValue {
    static final LocalDate date = LocalDate.of(2025, 6, 29);
    static final LocalDate cubeDate = LocalDate.of(2025, 6, 29);
    static final LocalDate StarDate = LocalDate.of(2025, 7, 20);
    static final String guildName = "전설";
    static final String WorldName = "스카니아";
    static String apiKey = System.getProperty("nexon.api.key",
            System.getenv("NEXON_API_KEY"));
    static String legacyApiKey = System.getProperty("nexon.legacy.api.key",
            System.getenv("NEXON_LEGACY_API_KEY"));
    static MapleStoryApi api = new MapleStoryApi(apiKey);
    static String ocid = "384a48e20cfd97dad5273c2eb380caa8";
    static String ocid2 = "4b5556ad92b3bb4080c1c43d06d6c2d7";

    static int count = 10;

    static {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalStateException("NEXON_API_KEY environment variable is not set");
        }
        if (legacyApiKey == null || legacyApiKey.isEmpty()) {
            throw new IllegalStateException("NEXON_LEGACY_API_KEY environment variable is not set");
        }
    }
}
