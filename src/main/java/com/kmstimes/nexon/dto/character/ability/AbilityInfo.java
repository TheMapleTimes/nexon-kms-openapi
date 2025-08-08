package com.kmstimes.nexon.dto.character.ability;

import java.util.List;

/**
 * 메이플스토리 어빌리티 프리셋 전체 정보를 담는 데이터 클래스입니다.
 *
 * @param ability_preset_grade 어빌리티 프리셋의 어빌리티 등급
 * @param ability_info         어빌리티 프리셋 정보
 */
public record AbilityInfo(
        String ability_preset_grade,
        List<Ability> ability_info
) {
}
