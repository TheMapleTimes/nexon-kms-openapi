package com.kmstimes.nexon.error.response;

/**
 * 넥슨 API 오류 응답의 세부 정보를 담는 레코드 클래스입니다.
 *
 * <p>이 레코드는 넥슨 API에서 반환되는 오류 응답의 error 객체 내부 구조를 나타냅니다.
 * JSON 역직렬화를 통해 API 오류 정보를 Java 객체로 변환할 때 사용됩니다.</p>
 *
 * <strong>JSON 구조 예시:</strong>
 * <pre>{@code
 * {
 *   "name": "OPENAPI00001",
 *   "message": "서버 내부 오류가 발생했습니다."
 * }
 * }</pre>
 *
 * @param name 넥슨 API 오류 코드 (예: OPENAPI00001, OPENAPI00002 등)
 * @param message 오류에 대한 상세 설명 메시지
 *
 * @see ErrorResponse
 * @see com.kmstimes.nexon.error.factory.NexonApiExceptionFactory
 */
public record Error(
        String name,
        String message
) {
}

