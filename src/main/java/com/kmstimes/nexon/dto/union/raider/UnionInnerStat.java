package com.kmstimes.nexon.dto.union.raider;

/**
 * 메이플스토리 유니온 공격대 배치 정보를 담는 데이터 클래스입니다.
 *
 * @param stat_field_id     공격대 배치 위치 (11시 방향부터 시계 방향 순서대로 0~7)
 * @param stat_field_effect 해당 지역 점령 효과
 */
public record UnionInnerStat(
        String stat_field_id,
        String stat_field_effect
) {
}
