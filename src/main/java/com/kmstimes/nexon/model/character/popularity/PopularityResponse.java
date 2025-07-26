package com.kmstimes.nexon.model.character.popularity;

/**
 * 메이플스토리 인기도 정보 조회 응답을 담는 데이터 클래스입니다.
 *
 * @param date       조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
 *                   <p>
 *                   example: 2023-12-21T00:00+09:00
 * @param popularity 캐릭터 인기도
 */
public record PopularityResponse(
        String date,
        Long popularity
) {
}
