package com.kmstimes.nexon.dto.character.equipment.common;

/**
 * 메이플스토리 캐시 장비 컬러링 프리즘 정보를 담는 데이터 클래스입니다.
 *
 * @param color_range 컬러링 프리즘 색상 범위
 * @param hue         컬러링 프리즘 색조
 * @param saturation  컬러링 프리즘 채도
 * @param value       컬러링 프리즘 명도
 */
public record CashItemColoringPrism(
        String color_range,
        Long hue,
        Long saturation,
        Long value
) {
}
