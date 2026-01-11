package com.kmstimes.nexon.dto.character.equipment.cashitem;

import com.kmstimes.nexon.dto.character.equipment.common.CashItemColoringPrism;
import com.kmstimes.nexon.dto.character.equipment.common.ItemOption;

import java.util.List;

/**
 * 메이플스토리 장착 중인 캐시 장비 정보를 담는 데이터 클래스입니다.
 *
 * @param cash_item_equipment_part 캐시 장비 부위 명
 * @param cash_item_equipment_slot 캐시 장비 슬롯 위치
 * @param cash_item_name           캐시 장비 명
 * @param cash_item_icon           캐시 장비 아이콘 (컬러링 프리즘 효과 미반영 상태)
 * @param cash_item_description    캐시 장비 설명
 * @param cash_item_option         캐시 장비 옵션
 * @param date_expire              캐시 장비 유효 기간 (expired:만료, null:무제한) (KST)
 *                                 <p>
 *                                 example: 2023-12-21T00:00+09:00
 * @param date_option_expire       캐시 장비 옵션 유효 기간 (expired:만료, null:무제한)
 *                                 <p>
 *                                 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
 *                                 <p>
 *                                 example: 2023-12-21T00:00+09:00
 * @param cash_item_label          캐시 장비 라벨 정보
 * @param cash_item_coloring_prism 캐시 장비 컬러링 프리즘 정보
 * @param cash_item_effect_prism   캐시 장비(무기) 이펙트 프리즘 정보
 * @param item_gender              아이템 장착 가능 성별
 * @param skill                    스킬명
 * @param freestyle_flag           프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
 * @param emotion_name             표정 합성 정보
 */
public record CashItemEquipmentBase(
        String cash_item_equipment_part,
        String cash_item_equipment_slot,
        String cash_item_name,
        String cash_item_icon,
        String cash_item_description,
        List<ItemOption> cash_item_option,
        String date_expire,
        String date_option_expire,
        String cash_item_label,
        CashItemColoringPrism cash_item_coloring_prism,
        CashItemColoringPrism cash_item_effect_prism,
        String item_gender,
        List<String> skill,
        String freestyle_flag,
        String emotion_name
) {

}
