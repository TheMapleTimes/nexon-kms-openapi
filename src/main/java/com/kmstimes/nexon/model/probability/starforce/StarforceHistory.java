package com.kmstimes.nexon.model.probability.starforce;

import java.util.List;

/**
 * 메이플스토리 스타포스 강화 결과 정보를 담는 데이터 클래스입니다.
 *
 * @param id                     스타포스 히스토리 식별자
 * @param item_upgrade_result    강화 시도 결과
 * @param before_starforce_count 강화 시도 전 스타포스 수치
 * @param after_starforce_count  강화 시도 후 스타포스 수치
 * @param starcatch_result       스타 캐치
 * @param superior_item_flag     슈페리얼 장비
 * @param destroy_defence        파괴 방지
 * @param chance_time            찬스 타임
 * @param event_field_flag       파괴 방지 필드 이벤트
 * @param upgrade_item           사용 주문서 명
 * @param protect_shield         프로텍트 실드
 * @param bonus_stat_upgrade     보너스 스탯 부여 아이템 여부
 * @param character_name         캐릭터 명
 * @param world_name             월드 명
 * @param target_item            대상 장비 아이템 명
 * @param date_create            강화 일시 (KST) (example: 2023-12-21T17:28:31.000+09:00)
 * @param starforce_event_list   진행 중인 스타포스 강화 이벤트 정보
 */
public record StarforceHistory(
        String id,
        String item_upgrade_result,
        Long before_starforce_count,
        Long after_starforce_count,
        String starcatch_result,
        String superior_item_flag,
        String destroy_defence,
        String chance_time,
        String event_field_flag,
        String upgrade_item,
        String protect_shield,
        String bonus_stat_upgrade,
        String character_name,
        String world_name,
        String target_item,
        String date_create,
        List<StarforceEventList> starforce_event_list
) {
}
