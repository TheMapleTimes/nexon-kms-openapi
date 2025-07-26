package com.kmstimes.nexon.model.character.equipment.cashitem;

import java.util.List;

/**
 * 메이플스토리 장착한 캐시 장비 정보 조회 응답을 담는 데이터 클래스입니다.
 * <p>
 * 장착 중인 캐시 장비의 스킬 정보는 2025년 1월 16일 메이플스토리 점검 이후 데이터부터 조회 가능합니다.
 *
 * @param date                                    조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
 *                                                <p>
 *                                                example: 2023-12-21T00:00+09:00
 * @param character_gender                        캐릭터 성별
 * @param character_class                         캐릭터 직업
 * @param character_look_mode                     캐릭터 외형 모드(0:일반 모드, 1:제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드)
 * @param preset_no                               적용 중인 캐시 장비 프리셋 번호
 * @param cash_item_equipment_base                장착 중인 캐시 장비
 * @param cash_item_equipment_preset_1            1번 코디 프리셋
 * @param cash_item_equipment_preset_2            2번 코디 프리셋
 * @param cash_item_equipment_preset_3            3번 코디 프리셋
 * @param additional_cash_item_equipment_base     제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드에서 장착 중인 캐시 장비
 * @param additional_cash_item_equipment_preset_1 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드의 1번 코디 프리셋
 * @param additional_cash_item_equipment_preset_2 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드의 2번 코디 프리셋
 * @param additional_cash_item_equipment_preset_3 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드의 3번 코디 프리셋
 */
public record CashItemEquipmentResponse(
        String date,
        String character_gender,
        String character_class,
        String character_look_mode,
        Long preset_no,
        List<CashItemEquipmentBase> cash_item_equipment_base,
        List<CashItemEquipmentBase> cash_item_equipment_preset_1,
        List<CashItemEquipmentBase> cash_item_equipment_preset_2,
        List<CashItemEquipmentBase> cash_item_equipment_preset_3,
        List<CashItemEquipmentBase> additional_cash_item_equipment_base,
        List<CashItemEquipmentBase> additional_cash_item_equipment_preset_1,
        List<CashItemEquipmentBase> additional_cash_item_equipment_preset_2,
        List<CashItemEquipmentBase> additional_cash_item_equipment_preset_3
) {
}
