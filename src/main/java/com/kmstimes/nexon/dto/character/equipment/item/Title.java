package com.kmstimes.nexon.dto.character.equipment.item;

/**
 * 메이플스토리 칭호 정보를 담는 데이터 클래스입니다.
 *
 * @param title_name              칭호 장비 명
 * @param title_icon              칭호 아이콘
 * @param title_description       칭호 설명
 * @param date_expire             칭호 유효 기간 (expired:만료, null:무제한) (KST)
 *                                <p>
 *                                example: 2023-12-21T17:28+09:00
 * @param date_option_expire      칭호 옵션 유효 기간 (expired:만료, null:무제한) (KST)
 *                                <p>
 *                                example: 2023-12-21T17:28+09:00
 * @param title_shape_name        외형 설정에 등록한 칭호 장비 명
 * @param title_shape_icon        외형 설정에 등록한 칭호 아이콘
 * @param title_shape_description 외형 설정에 등록한 칭호 설명
 */
public record Title(
        String title_name,
        String title_icon,
        String title_description,
        String date_expire,
        String date_option_expire,
        String title_shape_name,
        String title_shape_icon,
        String title_shape_description
) {
}
