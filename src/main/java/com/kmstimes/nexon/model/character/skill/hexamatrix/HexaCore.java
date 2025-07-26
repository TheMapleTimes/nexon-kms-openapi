package com.kmstimes.nexon.model.character.skill.hexamatrix;

import java.util.List;

/**
 * 메이플스토리 HEXA 코어 정보를 담는 데이터 클래스입니다.
 *
 * @param hexa_core_name  코어 명
 * @param hexa_core_level 코어 레벨
 * @param hexa_core_type  코어 타입
 * @param linked_skill    연결된 스킬
 */
public record HexaCore(
        String hexa_core_name,
        Long hexa_core_level,
        String hexa_core_type,
        List<HexaSkill> linked_skill
) {
}
