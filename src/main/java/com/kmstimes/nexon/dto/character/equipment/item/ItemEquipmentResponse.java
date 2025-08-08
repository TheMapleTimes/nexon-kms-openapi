package com.kmstimes.nexon.dto.character.equipment.item;

import java.util.List;

/**
 * 메이플스토리 장착 장비 (캐시 장비 제외) 정보 조회 응답을 담는 데이터 클래스입니다.
 * <p>
 * 훈장 외형, 칭호 외형 정보는 2025년 1월 16일 메이플스토리 점검 이후 데이터부터 조회 가능합니다.
 *
 * @param date                    조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
 *                                <p>
 *                                example: 2023-12-21T00:00+09:00
 * @param character_gender        캐릭터 성별
 * @param character_class         캐릭터 직업
 * @param preset_no               적용 중인 장비 프리셋 번호(number)
 * @param item_equipment          장비 정보
 * @param item_equipment_preset_1 1번 프리셋 장비 정보
 * @param item_equipment_preset_2 2번 프리셋 장비 정보
 * @param item_equipment_preset_3 3번 프리셋 장비 정보
 * @param title                   칭호 정보
 * @param medal_shape             외형 설정에 등록한 훈장 외형 정보
 * @param dragon_equipment        에반 드래곤 장비 정보 (에반인 경우 응답)
 * @param mechanic_equipment      메카닉 장비 정보 (메카닉인 경우 응답)
 */
public record ItemEquipmentResponse(
        String date,
        String character_gender,
        String character_class,
        Long preset_no,
        List<ItemEquipment> item_equipment,
        List<ItemEquipment> item_equipment_preset_1,
        List<ItemEquipment> item_equipment_preset_2,
        List<ItemEquipment> item_equipment_preset_3,
        Title title,
        MedalShape medal_shape,
        List<EMEquipment> dragon_equipment,
        List<EMEquipment> mechanic_equipment
) {
}
