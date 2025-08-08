package com.kmstimes.nexon.dto.probability.potential.potential;

import java.util.List;

/**
 * 메이플스토리 잠재능력 재설정 이용 결과 조회 응답을 담는 데이터 클래스입니다.
 * <p>
 * 잠재능력 재설정 정보는 최대 30분 후 확인 가능합니다.
 * <p>
 * 잠재능력 재설정 이용 결과는 2024년 01월 25일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.
 * 
 * @param count 결과 건 수
 * @param next_cursor 페이징 처리를 위한 cursor
 * @param potential_history 잠재능력 재설정 히스토리
 */
public record PotentialResponse(
        Long count,
        String next_cursor,
        List<PotentialHistory> potential_history
) {
}
