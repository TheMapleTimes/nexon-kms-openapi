package com.kmstimes.nexon.model.probability.starforce;

/**
 * 메이플스토리 진행 중인 스타포스 강화 이벤트 정보를 담는 데이터 클래스입니다.
 *
 * @param success_rate          이벤트 성공 확률
 * @param destroy_decrease_rate 이벤트 파괴 확률 감소율
 * @param cost_discount_rate    이벤트 비용 할인율
 * @param plus_value            이벤트 강화 수치 가중값
 * @param starforce_event_range 이벤트 적용 강화 시도 가능한 n성 범위
 */
public record StarforceEventList(
        String success_rate,
        String destroy_decrease_rate,
        String cost_discount_rate,
        String plus_value,
        String starforce_event_range
) {
}
