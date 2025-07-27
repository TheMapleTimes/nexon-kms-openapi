package com.kmstimes.nexon.validator;

/**
 * API 키가 "test_" 또는 "live_"로 시작하는지 확인합니다.
 */
public class ApiKeyValidator {

    /**
     * API 키가 "test_" 또는 "live_"로 시작하는지 확인합니다.
     *
     * @param apiKey 검증할 API 키
     * @throws IllegalArgumentException 형식이 잘못된 경우 예외 발생
     */
    public static void validate(String apiKey) {
        if (apiKey == null || apiKey.trim().isEmpty()) {
            throw new IllegalArgumentException("API 키는 null 이거나 비어 있을 수 없습니다.");
        }

        if (!(apiKey.startsWith("test_") || apiKey.startsWith("live_"))) {
            throw new IllegalArgumentException("API 키는 'test_' 또는 'live_'로 시작해야 합니다.");
        }
    }
}
