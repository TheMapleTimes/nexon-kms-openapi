package com.kmstimes.nexon.dto.character.equipment.common;

/**
 * 메이플스토리 아이템 표기상 옵션 정보를 담는 데이터 클래스입니다.
 *
 * @param option_type  옵션 타입
 * @param option_value 옵션 값
 */
public record ItemOption(
        String option_type,
        String option_value
) {
}
