package com.kmstimes.nexon.dto.character.equipment.pet;

/**
 * 메이플스토리 펫 버프 자동스킬 정보를 담는 데이터 클래스입니다.
 *
 * @param skill_1      첫 번째 슬롯에 등록된 자동 스킬
 * @param skill_1_icon 첫 번째 슬롯에 등록된 자동 스킬 아이콘
 * @param skill_2      두 번째 슬롯에 등록된 자동 스킬
 * @param skill_2_icon 두 번째 슬롯에 등록된 자동 스킬 아이콘
 */
public record PetAutoSkill(
        String skill_1,
        String skill_1_icon,
        String skill_2,
        String skill_2_icon
) {
}
