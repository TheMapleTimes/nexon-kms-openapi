package com.kmstimes.nexon.model.character.equipment.common;

/**
 * 메이플스토리 헤어 정보를 담는 데이터 클래스입니다.
 *
 * @param hair_name      헤어 명
 * @param base_color     헤어 베이스 컬러
 * @param mix_color      헤어 믹스 컬러
 * @param mix_rate       헤어 믹스 컬러의 염색 비율
 * @param freestyle_flag 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
 */
public record Hair(
        String hair_name,
        String base_color,
        String mix_color,
        String mix_rate,
        String freestyle_flag
) {
}
