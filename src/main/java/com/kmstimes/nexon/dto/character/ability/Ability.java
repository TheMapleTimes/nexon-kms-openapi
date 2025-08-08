package com.kmstimes.nexon.dto.character.ability;

/**
 * 메이플스토리 어빌리티 정보를 담는 데이터 클래스입니다.
 *
 * @param ability_no    어빌리티 번호
 * @param ability_grade 어빌리티 등급
 * @param ability_value 어빌리티 옵션 및 수치
 */
public record Ability(
        String ability_no,
        String ability_grade,
        String ability_value
) {
}
