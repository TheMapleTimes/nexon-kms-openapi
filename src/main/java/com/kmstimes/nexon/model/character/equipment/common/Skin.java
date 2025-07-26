package com.kmstimes.nexon.model.character.equipment.common;

/**
 * 메이플스토리 피부 정보를 담는 데이터 클래스입니다.
 *
 * @param skin_name   피부 명
 * @param color_style 색상 계열
 * @param hue         피부 색조
 * @param saturation  피부 채도
 * @param brightness  피부 명도
 */
public record Skin(
        String skin_name,
        String color_style,
        Long hue,
        Long saturation,
        Long brightness
) {
}
