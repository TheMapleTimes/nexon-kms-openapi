package com.kmstimes.nexon.dto.character.hyperstat;

/**
 * 메이플스토리 하이퍼스탯 정보를 담는 데이터 클래스입니다.
 *
 * @param stat_type     스탯 종류
 * @param stat_point    스탯 투자 포인트
 * @param stat_level    스탯 레벨
 * @param stat_increase 스탯 상승량
 */
public record HyperStat(
        String stat_type,
        Long stat_point,
        Long stat_level,
        String stat_increase
) {
}
