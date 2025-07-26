package com.kmstimes.nexon.error.exception;

/**
 * HTTP 500 Internal Server Error 오류를 나타내는 예외 클래스입니다.
 *
 * <p>서버 내부 오류나 API 서비스 중단 등의 서버 측 오류를 처리합니다.</p>
 */
public class InternalServerErrorException extends NexonApiException {

    /**
     * InternalServerErrorException을 생성합니다.
     *
     * @param errorCode 넥슨 API 오류 코드
     * @param message 오류 메시지
     */
    public InternalServerErrorException(String errorCode, String message) {
        super(errorCode, 500, message);
    }
}
