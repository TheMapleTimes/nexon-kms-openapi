package com.kmstimes.nexon.dto.character.ringexchange;

/**
 * 메이플스토리 링 익스체인지 스킬 등록 장비 조회 응답을 담는 데이터 클래스입니다.
 *
 * @param date                        조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
 *                                    <p>
 *                                    example: 2023-12-21T00:00+09:00
 * @param character_class             캐릭터 직업
 * @param special_ring_exchange_name  링 익스체인지에 등록된 특수 반지
 * @param special_ring_exchange_level 링 익스체인지에 등록된 특수 반지 레벨
 */
public record RingExchangeResponse(
        String date,
        String character_class,
        String special_ring_exchange_name,
        Long special_ring_exchange_level
) {
}
