package com.kmstimes.nexon.model.character.skill.skill;

import com.kmstimes.nexon.model.character.skill.common.Skill;

import java.util.List;

/**
 * 메이플스토리 스킬 정보 조회 응답을 담는 데이터 클래스입니다.
 *
 * @param date                  조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
 *                              <p>
 *                              example: 2023-12-21T00:00+09:00
 * @param character_class       캐릭터 직업
 * @param character_skill_grade 스킬 전직 차수
 * @param character_skill       스킬 정보
 */
public record SkillResponse(
        String date,
        String character_class,
        String character_skill_grade,
        List<Skill> character_skill
) {
}
