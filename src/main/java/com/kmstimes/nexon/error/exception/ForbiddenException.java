package com.kmstimes.nexon.error.exception;

/**
 * HTTP 403 Forbidden 오류를 나타내는 예외 클래스입니다.
 *
 * <p>권한이 없거나 접근이 거부된 경우를 처리합니다.</p>
 */
public class ForbiddenException extends NexonApiException {

    /**
     * ForbiddenException을 생성합니다.
     *
     * @param errorCode 넥슨 API 오류 코드
     * @param message 오류 메시지
     */
    public ForbiddenException(String errorCode, String message) {
        super(errorCode, 403, message);
    }
}
