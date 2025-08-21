package com.kmstimes.nexon.dto.character.otherstat;

import java.util.List;

/**
 * 메이플스토리 능력치에 영향을 주는 요소 및 스탯 정보를 담는 데이터 클래스입니다.
 *
 * @param other_stat_type 스텟 타입
 * @param stat_info       스탯 정보
 */
public record OtherStat(
        String other_stat_type,
        List<StatInfo> stat_info
) {
}
