package com.kmstimes.nexon.model.union.champion;

import java.util.List;

/**
 * 메이플스토리 유니온 챔피언 정보 조회 응답을 담는 데이터 클래스입니다.
 * <p>
 * 유니온 챔피언 정보는 2025년 2월 20일 메이플스토리 점검 이후 데이터부터 조회 가능합니다.
 *
 * @param date                      조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
 *                                  <p>
 *                                  example: 2023-12-21T00:00+09:00
 * @param union_champion            유니온 챔피언 정보
 * @param champion_badge_total_info 챔피언 휘장 효과
 */
public record UnionChampionResponse(
        String date,
        List<UnionChampion> union_champion,
        List<ChampionBadgeInfo> champion_badge_total_info
) {
}
