package com.kmstimes.nexon.dto.character.skill.link;


import com.kmstimes.nexon.dto.character.skill.common.Skill;

import java.util.List;

/**
 * 메이플스토리 장착 링크 스킬 정보 조회 응답을 담는 데이터 클래스입니다.
 *
 * @param date                                조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
 *                                            <p>
 *                                            example: 2023-12-21T00:00+09:00
 * @param character_class                     캐릭터 직업
 * @param character_link_skill                링크 스킬 정보
 * @param character_link_skill_preset_1       링크 스킬 1번 프리셋 정보
 * @param character_link_skill_preset_2       링크 스킬 2번 프리셋 정보
 * @param character_link_skill_preset_3       링크 스킬 3번 프리셋 정보
 * @param character_owned_link_skill          내 링크 스킬 정보
 * @param character_owned_link_skill_preset_1 내 링크 스킬 1번 프리셋 정보
 * @param character_owned_link_skill_preset_2 내 링크 스킬 2번 프리셋 정보
 * @param character_owned_link_skill_preset_3 내 링크 스킬 3번 프리셋 정보
 */
public record LinkSkillResponse(
        String date,
        String character_class,
        List<Skill> character_link_skill,
        List<Skill> character_link_skill_preset_1,
        List<Skill> character_link_skill_preset_2,
        List<Skill> character_link_skill_preset_3,
        Skill character_owned_link_skill,
        Skill character_owned_link_skill_preset_1,
        Skill character_owned_link_skill_preset_2,
        Skill character_owned_link_skill_preset_3
) {
}
