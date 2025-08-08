package com.kmstimes.nexon.dto.character.equipment.common;

/**
 * 메이플스토리 성형 정보를 담는 데이터 클래스입니다.
 *
 * @param face_name      성형 명
 * @param base_color     성형 베이스 컬러
 * @param mix_color      성형 믹스 컬러
 * @param mix_rate       성형 믹스 컬러의 염색 비율
 * @param freestyle_flag 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
 */
public record Face(
        String face_name,
        String base_color,
        String mix_color,
        String mix_rate,
        String freestyle_flag
) {
}
