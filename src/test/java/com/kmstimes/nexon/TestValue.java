package com.kmstimes.nexon;

import java.time.LocalDate;

public class TestValue {
    public static final LocalDate date = LocalDate.of(2025, 6, 29);
    public static final LocalDate cubeDate = LocalDate.of(2025, 6, 29);
    public static final LocalDate StarDate = LocalDate.of(2025, 7, 20);
    public static final String guildName = "전설";
    public static final String WorldName = "스카니아";
    public static String apiKey = System.getProperty("nexon.api.key",
            System.getenv("NEXON_API_KEY"));
    public static String legacyApiKey = System.getProperty("nexon.legacy.api.key",
            System.getenv("NEXON_LEGACY_API_KEY"));
    public static MapleStoryApi api = new MapleStoryApi(apiKey);
    public static String ocid = "384a48e20cfd97dad5273c2eb380caa8";
    public static String ocid2 = "4b5556ad92b3bb4080c1c43d06d6c2d7";

    public static int count = 10;

    static {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalStateException("NEXON_API_KEY environment variable is not set");
        }
        if (legacyApiKey == null || legacyApiKey.isEmpty()) {
            throw new IllegalStateException("NEXON_LEGACY_API_KEY environment variable is not set");
        }
    }
}
