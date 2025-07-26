package com.kmstimes.nexon.error.exception;

/**
 * HTTP 400 Bad Request 오류를 나타내는 예외 클래스입니다.
 *
 * <p>잘못된 요청 파라미터, 유효하지 않은 API 키 등의 클라이언트 측 오류를 처리합니다.</p>
 */
public class BadRequestException extends NexonApiException{

    /**
     * BadRequestException을 생성합니다.
     *
     * @param errorCode 넥슨 API 오류 코드
     * @param message 오류 메시지
     */
    public BadRequestException(String errorCode, String message) {
        super(errorCode, 400, message);
    }
}
