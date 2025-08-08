package com.kmstimes.nexon.dto.character.propensity;

/**
 * 메이플스토리 성향 정보 조회 응답을 담는 데이터 클래스입니다.
 *
 * @param date              조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
 *                          <p>
 *                          example: 2023-12-21T00:00+09:00
 * @param charisma_level    카리스마 레벨
 * @param sensibility_level 감성 레벨
 * @param insight_level     통찰력 레벨
 * @param willingness_level 의지 레벨
 * @param handicraft_level  손재주 레벨
 * @param charm_level       매력 레벨
 */
public record PropensityResponse(
        String date,
        Long charisma_level,
        Long sensibility_level,
        Long insight_level,
        Long willingness_level,
        Long handicraft_level,
        Long charm_level
) {
}
