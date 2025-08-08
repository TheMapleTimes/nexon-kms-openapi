package com.kmstimes.nexon.dto.character.equipment.item;

/**
 * 메이플스토리 외형 설정에 등록한 훈장 외형 정보를 담는 데이터 클래스입니다.
 *
 * @param medal_shape_name                외형 설정에 등록한 훈장 장비 명
 * @param medal_shape_icon                외형 설정에 등록한 훈장 아이콘
 * @param medal_shape_description         외형 설정에 등록한 훈장 설명
 * @param medal_shape_changed_name        외형 설정에 등록한 훈장의 모루 적용 장비 명
 * @param medal_shape_changed_icon        외형 설정에 등록한 훈장의 모루 적용 아이콘
 * @param medal_shape_changed_description 외형 설정에 등록한 훈장의 모루 적용 훈장 설명
 */
public record MedalShape(
        String medal_shape_name,
        String medal_shape_icon,
        String medal_shape_description,
        String medal_shape_changed_name,
        String medal_shape_changed_icon,
        String medal_shape_changed_description
) {
}
