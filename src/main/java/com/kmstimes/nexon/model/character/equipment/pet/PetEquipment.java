package com.kmstimes.nexon.model.character.equipment.pet;


import com.kmstimes.nexon.model.character.equipment.common.ItemOption;

import java.util.List;

/**
 * 메이플스토리 펫 장착 정보를 담는 데이터 클래스입니다.
 *
 * @param item_name         아이템 명
 * @param item_icon         아이템 아이콘
 * @param item_description  아이템 설명
 * @param item_option       아이템 표기상 옵션
 * @param scroll_upgrade    주문서 횟수
 * @param scroll_upgradable 주문서 잔여 횟수
 * @param item_shape        아이템 외형
 * @param item_shape_icon   아이템 외형 아이콘
 */
public record PetEquipment(
        String item_name,
        String item_icon,
        String item_description,
        List<ItemOption> item_option,
        Long scroll_upgrade,
        Long scroll_upgradable,
        String item_shape,
        String item_shape_icon

) {
}
