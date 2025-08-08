package com.kmstimes.nexon.dto.probability.starforce;

import java.util.List;

/**
 * 메이플스토리 스타포스 강화 결과 조회 응답을 담는 데이터 클래스입니다.
 * <p>
 * 스타포스 확률 정보는 최대 5분 후 확인 가능합니다.
 * <p>
 * 스타포스 강화 결과는 2023년 12월 27일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.
 *
 * @param count             결과 건 수
 * @param next_cursor       페이징 처리를 위한 cursor
 * @param starforce_history 스타포스 히스토리
 */
public record StarforceResponse(
        Long count,
        String next_cursor,
        List<StarforceHistory> starforce_history
) {
}
