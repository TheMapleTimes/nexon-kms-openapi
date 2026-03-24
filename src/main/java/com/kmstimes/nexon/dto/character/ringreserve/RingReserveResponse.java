package com.kmstimes.nexon.dto.character.ringreserve;

/**
 * 메이플스토리 예비 특수 반지 장착 정보 조회 응답을 담는 데이터 클래스입니다.
 *
 * @param date                             조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
 *                                         <p>
 *                                         example: 2023-12-21T00:00+09:00
 * @param character_class                  캐릭터 직업
 * @param special_ring_reserve_name        예비 특수 반지 슬롯에 장착한 특수 반지
 * @param special_ring_reserve_level       예비 특수 반지 슬롯에 장착한 특수 반지 레벨
 * @param special_ring_reserve_icon        예비 특수 반지 슬롯에 장착한 특수 반지 아이콘
 * @param special_ring_reserve_description 예비 특수 반지 슬롯에 장착한 특수 반지 설명
 */
public record RingReserveResponse(
        String date,
        String character_class,
        String special_ring_reserve_name,
        Long special_ring_reserve_level,
        String special_ring_reserve_icon,
        String special_ring_reserve_description
) {

}
