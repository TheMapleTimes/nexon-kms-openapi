package com.kmstimes.nexon.dto.character.skill.hexamatrixstat;

/**
 * 메이플스토리 HEXA 스탯 코어 정보를 담는 데이터 클래스입니다.
 *
 * @param slot_id           슬롯 인덱스
 * @param main_stat_name    메인 스탯 명
 * @param sub_stat_name_1   첫 번째 서브 명
 * @param sub_stat_name_2   두 번째 서브 명
 * @param main_stat_level   메인 스탯 레벨
 * @param main_stat_level_1 첫 번째 서브 레벨
 * @param main_stat_level_2 두 번째 서브 레벨
 * @param stat_grade        스탯 코어 등급
 */
public record HexaStat(
        String slot_id,
        String main_stat_name,
        String sub_stat_name_1,
        String sub_stat_name_2,
        Long main_stat_level,
        Long main_stat_level_1,
        Long main_stat_level_2,
        Long stat_grade
) {
}
