package com.kmstimes.nexon.error.exception;

/**
 * HTTP 503 Service Unavailable 오류를 나타내는 예외 클래스입니다.
 *
 * <p>서비스가 일시적으로 사용할 수 없는 상태를 처리합니다.</p>
 *
 */
public class ServiceUnavailableException extends NexonApiException {

    /**
     * ServiceUnavailableException을 생성합니다.
     *
     * @param errorCode 넥슨 API 오류 코드
     * @param message 오류 메시지
     */
    public ServiceUnavailableException(String errorCode, String message) {
        super(errorCode, 503, message);
    }
}