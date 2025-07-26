package com.kmstimes.nexon.model.character.equipment.android;

import com.kmstimes.nexon.model.character.equipment.common.CashItemColoringPrism;
import com.kmstimes.nexon.model.character.equipment.common.ItemOption;

import java.util.List;

/**
 * 메이플스토리 안드로이드 캐시 아이템 장착 정보를 담는 데이터 클래스입니다.
 *
 * @param cash_item_equipment_part 안드로이드 캐시 아이템 부위 명
 * @param cash_item_equipment_slot 안드로이드 캐시 아이템 슬롯 위치
 * @param cash_item_name           안드로이드 캐시 아이템 명
 * @param cash_item_icon           안드로이드 캐시 아이템 아이콘 (컬러링 프리즘 효과 미반영 상태)
 * @param cash_item_description    안드로이드 캐시 아이템 설명
 * @param cash_item_option         안드로이드 캐시 아이템 옵션
 * @param date_expire              안드로이드 캐시 아이템 유효 기간 (expired:만료, null:무제한) (KST)
 *                                 <p>
 *                                 example: 2023-12-21T17:28+09:00
 * @param date_option_expire       안드로이드 캐시 아이템 옵션 유효 기간 (expired:만료, null:무제한)
 *                                 <p>
 *                                 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
 *                                 <p>
 *                                 example: 2023-12-21T17:28+09:00
 * @param cash_item_label          안드로이드 캐시 아이템 라벨 정보 (스페셜라벨, 레드라벨, 블랙라벨, 마스터라벨)
 * @param cash_item_coloring_prism 안드로이드 캐시 아이템 컬러링 프리즘 정보
 * @param android_item_gender      아이템 장착 가능 성별
 * @param freestyle_flag           프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
 */
public record AndroidCashItemEquipment(
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
        String android_item_gender,
        String freestyle_flag
) {
}
