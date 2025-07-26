package com.kmstimes.nexon.model.union.champion;

import java.util.List;

/**
 * 메이플스토리 유니온 챔피언 정보를 담는 데이터 클래스입니다.
 *
 * @param champion_name       유니온 챔피언 캐릭터 명
 * @param champion_slot       유니온 챔피언 슬롯
 * @param champion_grade      유니온 챔피언 등급
 * @param champion_class      유니온 챔피언 캐릭터의 직업
 * @param champion_badge_info 유니온 챔피언 휘장 정보
 */
public record UnionChampion(
        String champion_name,
        Long champion_slot,
        String champion_grade,
        String champion_class,
        List<ChampionBadgeInfo> champion_badge_info
) {
}
