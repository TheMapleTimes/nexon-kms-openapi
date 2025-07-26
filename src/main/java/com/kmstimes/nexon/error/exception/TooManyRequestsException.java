package com.kmstimes.nexon.error.exception;

/**
 * HTTP 429 Too Many Requests 오류를 나타내는 예외 클래스입니다.
 *
 * <p>API 호출 한도를 초과한 경우를 처리합니다.</p>
 *
 */
public class TooManyRequestsException extends NexonApiException {

    /**
     * TooManyRequestsException을 생성합니다.
     *
     * @param errorCode 넥슨 API 오류 코드
     * @param message 오류 메시지
     */
    public TooManyRequestsException(String errorCode, String message) {
        super(errorCode, 429, message);
    }
}
