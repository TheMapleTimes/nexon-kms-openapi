package com.kmstimes.nexon.model.character.equipment.item;

import com.kmstimes.nexon.model.character.equipment.item.option.ItemAddOption;
import com.kmstimes.nexon.model.character.equipment.item.option.ItemBaseOption;
import com.kmstimes.nexon.model.character.equipment.item.option.ItemEtcOption;
import com.kmstimes.nexon.model.character.equipment.item.option.ItemExceptionalOption;
import com.kmstimes.nexon.model.character.equipment.item.option.ItemTotalOption;

/**
 * 메이플스토리 에반 드래곤 &amp; 매카닉 장비 정보를 담는 데이터 클래스입니다.
 *
 * @param item_equipment_part      장비 부위 명
 * @param equipment_slot           장비 슬롯 위치
 * @param item_name                장비 명
 * @param item_icon                장비 아이콘
 * @param item_description         장비 설명
 * @param item_shape_name          장비 외형
 * @param item_shape_icon          장비 외형 아이콘
 * @param item_gender              전용 성별
 * @param item_total_option        장비 최종 옵션 정보
 * @param item_base_option         장비 기본 옵션 정보
 * @param equipment_level_increase 착용 레벨 증가
 * @param item_exceptional_option  장비 특별 옵션 정보
 * @param item_add_option          장비 추가 옵션
 * @param growth_exp               성장 경험치
 * @param growth_level             성장 레벨
 * @param scroll_upgrade           주문서 횟수
 * @param cuttable_count           가위 사용 가능 횟수 (교환 불가 장비, 가위 횟수가 없는 교환 가능 장비는 255)
 * @param golden_hammer_flag       황금 망치 재련 적용 (1:적용, 이외 미 적용)
 * @param scroll_resilience_count  복구 가능 횟수
 * @param scroll_upgradable_count  주문서 잔여 횟수
 * @param soul_name                소울 명
 * @param soul_option              소울 옵션
 * @param item_etc_option          장비 기타 옵션 정보
 * @param starforce                강화 단계
 * @param starforce_scroll_flag    놀라운 장비 강화 주문서 사용 여부 (0:미사용, 1:사용)
 * @param item_starforce_option    장비 스타포스 옵션 정보
 * @param special_ring_level       특수 반지 레벨
 * @param date_expire              장비 유효 기간 (expired:만료, null:무제한) (KST)
 *                                 <p>
 *                                 example: 2023-12-21T17:28+09:00
 * @param freestyle_flag           프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
 */
public record EMEquipment(
        String item_equipment_part,
        String equipment_slot,
        String item_name,
        String item_icon,
        String item_description,
        String item_shape_name,
        String item_shape_icon,
        String item_gender,
        ItemTotalOption item_total_option,
        ItemBaseOption item_base_option,
        Long equipment_level_increase,
        ItemExceptionalOption item_exceptional_option,
        ItemAddOption item_add_option,
        Long growth_exp,
        Long growth_level,
        String scroll_upgrade,
        String cuttable_count,
        String golden_hammer_flag,
        String scroll_resilience_count,
        String scroll_upgradable_count,
        String soul_name,
        String soul_option,
        ItemEtcOption item_etc_option,
        String starforce,
        String starforce_scroll_flag,
        ItemEtcOption item_starforce_option,
        Long special_ring_level,
        String date_expire,
        String freestyle_flag

) {
}
