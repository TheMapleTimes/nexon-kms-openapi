package com.kmstimes.nexon.dto.character.skill.common;

/**
 * 메이플스토리 스킬 정보를 담는 데이터 클래스입니다.
 *
 * @param skill_name        스킬 명
 * @param skill_description 스킬 설명
 * @param skill_level       스킬 레벨
 * @param skill_effect      스킬 레벨 별 효과 설명
 * @param skill_effect_next 다음 스킬 레벨 효과 설명
 * @param skill_icon        스킬 아이콘
 */
public record Skill(
        String skill_name,
        String skill_description,
        Long skill_level,
        String skill_effect,
        String skill_effect_next,
        String skill_icon
) {
}
