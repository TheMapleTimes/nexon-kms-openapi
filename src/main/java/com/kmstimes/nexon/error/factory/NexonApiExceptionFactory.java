package com.kmstimes.nexon.error.factory;

import com.kmstimes.nexon.error.exception.BadRequestException;
import com.kmstimes.nexon.error.exception.ForbiddenException;
import com.kmstimes.nexon.error.exception.InternalServerErrorException;
import com.kmstimes.nexon.error.exception.NexonApiException;
import com.kmstimes.nexon.error.exception.ServiceUnavailableException;
import com.kmstimes.nexon.error.exception.TooManyRequestsException;

/**
 * 넥슨 API 오류 코드에 따라 적절한 예외 인스턴스를 생성하는 팩토리 클래스입니다.
 *
 * <p>이 클래스는 넥슨 API에서 반환되는 표준 오류 코드를 기반으로
 * 타입 안전한 예외 객체를 생성합니다.</p>
 *
 * <strong>지원하는 오류 코드:</strong>
 * <ul>
 *   <li>OPENAPI00001 - 서버 내부 오류</li>
 *   <li>OPENAPI00002 - 권한 없음</li>
 *   <li>OPENAPI00003 - 유효하지 않은 식별자</li>
 *   <li>OPENAPI00004 - 파라미터 누락 또는 유효하지 않음</li>
 *   <li>OPENAPI00005 - 유효하지 않은 API KEY</li>
 *   <li>OPENAPI00006 - 유효하지 않은 게임 또는 API PATH</li>
 *   <li>OPENAPI00007 - API 호출량 초과</li>
 *   <li>OPENAPI00009 - 데이터 준비 중</li>
 *   <li>OPENAPI00010 - 게임 점검 중</li>
 *   <li>OPENAPI00011 - API 서비스 일시 중단</li>
 * </ul>
 */
public class NexonApiExceptionFactory {

    /**
     * 오류 코드에 따라 적절한 NexonApiException 인스턴스를 생성합니다.
     *
     * <p>알려진 오류 코드의 경우 미리 정의된 메시지와 함께 특화된 예외를 반환하고,
     * 알려지지 않은 오류 코드의 경우 기본 NexonApiException을 반환합니다.</p>
     *
     * @param errorCode 넥슨 API 오류 코드
     * @param httpStatus HTTP 상태 코드
     * @param message 원본 오류 메시지 (알려진 오류 코드의 경우 무시됨)
     * @return 오류 코드에 맞는 NexonApiException 인스턴스
     * @throws IllegalArgumentException errorCode가 null인 경우
     */
    public static NexonApiException createException(String errorCode, int httpStatus, String message) {
        return switch (errorCode) {
            case "OPENAPI00001" -> new InternalServerErrorException(errorCode, "서버 내부 오류가 발생했습니다.");
            case "OPENAPI00002" -> new ForbiddenException(errorCode, "권한이 없습니다.");
            case "OPENAPI00003" -> new BadRequestException(errorCode, "유효하지 않은 식별자입니다.");
            case "OPENAPI00004" -> new BadRequestException(errorCode, "파라미터 누락 또는 유효하지 않습니다.");
            case "OPENAPI00005" -> new BadRequestException(errorCode, "유효하지 않은 API KEY 입니다.");
            case "OPENAPI00006" -> new BadRequestException(errorCode, "유효하지 않은 게임 또는 API PATH 입니다.");
            case "OPENAPI00007" -> new TooManyRequestsException(errorCode, "API 호출량이 초과되었습니다.");
            case "OPENAPI00009" -> new BadRequestException(errorCode, "데이터 준비 중입니다.");
            case "OPENAPI00010" -> new BadRequestException(errorCode, "게임 점검 중입니다.");
            case "OPENAPI00011" -> new ServiceUnavailableException(errorCode, "API 서비스가 일시적으로 중단되었습니다.");
            default -> new NexonApiException(errorCode, httpStatus, message);
        };
    }
}
