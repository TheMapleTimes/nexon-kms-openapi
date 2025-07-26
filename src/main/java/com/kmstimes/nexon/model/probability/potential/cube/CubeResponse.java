package com.kmstimes.nexon.model.probability.potential.cube;

import java.util.List;

/**
 * 메이플스토리 큐브 사용 결과 조회 응답을 담는 데이터 클래스입니다.
 * <p>
 * 큐브 확률 정보는 최대 30분 후 확인 가능합니다.
 * <p>
 * 큐브 사용 결과는 최근 2년 데이터만 조회 가능합니다.
 *
 * @param count        결과 건 수
 * @param next_cursor  페이징 처리를 위한 cursor
 * @param cube_history 큐브 히스토리
 */
public record CubeResponse(
        Long count,
        String next_cursor,
        List<CubeHistory> cube_history
) {
}
