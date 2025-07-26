package com.kmstimes.nexon.error.exception;

/**
 * 넥슨 API 호출 시 발생하는 모든 예외의 기본 클래스입니다.
 *
 * <p>이 클래스는 넥슨 API에서 반환되는 오류 코드, HTTP 상태 코드,
 * 그리고 오류 메시지를 포함하는 RuntimeException입니다.</p>
 */
public class NexonApiException extends RuntimeException {
    /**
     * 넥슨 API에서 제공하는 오류 코드
     */
    private final String errorCode;

    /**
     * HTTP 응답 상태 코드
     */
    private final int httpStatus;

    /**
     * 오류 상세 메시지
     */
    private final String errorMessage;

    /**
     * 기본 NexonApiException을 생성합니다.
     *
     * @param errorCode 넥슨 API 오류 코드
     * @param httpStatus HTTP 상태 코드
     * @param errorMessage 오류 메시지
     */
    public NexonApiException(String errorCode, int httpStatus, String errorMessage) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }

    /**
     * 원인(cause)이 있는 NexonApiException을 생성합니다.
     *
     * @param errorCode 넥슨 API 오류 코드
     * @param httpStatus HTTP 상태 코드
     * @param errorMessage 오류 메시지
     * @param cause 예외의 원인
     */
    public NexonApiException(String errorCode, int httpStatus, String errorMessage, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }

    /**
     * 포맷된 오류 메시지를 반환합니다.
     *
     * @return "[오류코드] 오류메시지 (HTTP 상태코드)" 형식의 문자열
     */
    @Override
    public String getMessage() {
        return String.format("[%s] %s (HTTP %d)", errorCode, errorMessage, httpStatus);
    }

    /**
     * 넥슨 API 오류 코드를 반환합니다.
     *
     * @return 오류 코드
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * HTTP 상태 코드를 반환합니다.
     *
     * @return HTTP 상태 코드
     */
    public int getHttpStatus() {
        return httpStatus;
    }

    /**
     * 오류 메시지를 반환합니다.
     *
     * @return 오류 메시지
     */
    public String getErrorMessage() {
        return errorMessage;
    }
}
