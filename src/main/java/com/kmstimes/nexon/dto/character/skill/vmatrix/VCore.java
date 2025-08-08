package com.kmstimes.nexon.dto.character.skill.vmatrix;

/**
 * 메이플스토리 V코어 정보를 담는 데이터 클래스입니다.
 *
 * @param slot_id        슬롯 인덱스
 * @param slot_level     슬롯 레벨
 * @param v_core_name    코어 명
 * @param v_core_type    코어 타입
 * @param v_core_level   코어 레벨
 * @param v_core_skill_1 코어에 해당하는 스킬 명
 * @param v_core_skill_2 (강화 코어인 경우) 코어에 해당하는 두 번째 스킬 명
 * @param v_core_skill_3 (강화 코어인 경우) 코어에 해당하는 세 번째 스킬 명
 */
public record VCore(
        String slot_id,
        Long slot_level,
        String v_core_name,
        String v_core_type,
        Long v_core_level,
        String v_core_skill_1,
        String v_core_skill_2,
        String v_core_skill_3
) {
}
