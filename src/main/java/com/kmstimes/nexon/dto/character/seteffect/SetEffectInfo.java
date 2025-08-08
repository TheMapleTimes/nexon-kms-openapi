package com.kmstimes.nexon.dto.character.seteffect;

/**
 * 메이플스토리 적용 중인 세트 효과 정보를 담는 데이터 클래스입니다.
 *
 * @param set_count  세트 효과 레벨 (장비 수)
 * @param set_option 세트 효과
 */
public record SetEffectInfo(
        Long set_count,
        String set_option
) {
}
