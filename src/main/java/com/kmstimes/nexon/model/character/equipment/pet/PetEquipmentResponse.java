package com.kmstimes.nexon.model.character.equipment.pet;

import java.util.List;

/**
 * 메이플스토리 장착 펫 정보 조회 응답을 담는 데이터 클래스입니다.
 *
 * @param date                  조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
 *                              <p>
 *                              example: 2023-12-21T00:00+09:00
 * @param pet_1_name            펫1 명
 * @param pet_1_nickname        펫1 닉네임
 * @param pet_1_icon            펫1 아이콘
 * @param pet_1_description     펫1 설명
 * @param pet_1_equipment       펫1 장착 정보
 * @param pet_1_auto_skill      펫1 펫 버프 자동스킬 정보
 * @param pet_1_pet_type        펫1 원더 펫 종류
 * @param pet_1_skill           펫1 펫 보유 스킬
 * @param pet_1_date_expire     펫1 마법의 시간 (expired:만료, null:무제한)
 *                              <p>
 *                              (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
 *                              <p>
 *                              example: 2023-12-21T00:00+09:00
 * @param pet_1_appearance      펫1 외형
 * @param pet_1_appearance_icon 펫1 외형 아이콘
 * @param pet_2_name            펫2 명
 * @param pet_2_nickname        펫2 닉네임
 * @param pet_2_icon            펫2 아이콘
 * @param pet_2_description     펫2 설명
 * @param pet_2_equipment       펫2 장착 정보
 * @param pet_2_auto_skill      펫2 펫 버프 자동 스킬 정보
 * @param pet_2_pet_type        펫2 원더 펫 종류
 * @param pet_2_skill           펫2 펫 보유 스킬
 * @param pet_2_date_expire     펫2 마법의 시간 (expired:만료, null:무제한)
 *                              <p>
 *                              (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
 *                              <p>
 *                              example: 2023-12-21T00:00+09:00
 * @param pet_2_appearance      펫2 외형
 * @param pet_2_appearance_icon 펫2 외형 아이콘
 * @param pet_3_name            펫3 명
 * @param pet_3_nickname        펫3 닉네임
 * @param pet_3_icon            펫3 아이콘
 * @param pet_3_description     펫3 설명
 * @param pet_3_equipment       펫3 장착 정보
 * @param pet_3_auto_skill      펫3 펫 버프 자동 스킬 정보
 * @param pet_3_pet_type        펫3 원더 펫 종류
 * @param pet_3_skill           펫3 펫 보유 스킬
 * @param pet_3_date_expire     펫3 마법의 시간 (expired:만료, null:무제한)
 *                              <p>
 *                              (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
 *                              <p>
 *                              example: 2023-12-21T00:00+09:00
 * @param pet_3_appearance      펫3 외형
 * @param pet_3_appearance_icon 펫3 외형 아이콘
 */
public record PetEquipmentResponse(
        String date,
        String pet_1_name,
        String pet_1_nickname,
        String pet_1_icon,
        String pet_1_description,
        PetEquipment pet_1_equipment,
        PetAutoSkill pet_1_auto_skill,
        String pet_1_pet_type,
        List<String> pet_1_skill,
        String pet_1_date_expire,
        String pet_1_appearance,
        String pet_1_appearance_icon,
        String pet_2_name,
        String pet_2_nickname,
        String pet_2_icon,
        String pet_2_description,
        PetEquipment pet_2_equipment,
        PetAutoSkill pet_2_auto_skill,
        String pet_2_pet_type,
        List<String> pet_2_skill,
        String pet_2_date_expire,
        String pet_2_appearance,
        String pet_2_appearance_icon,
        String pet_3_name,
        String pet_3_nickname,
        String pet_3_icon,
        String pet_3_description,
        PetEquipment pet_3_equipment,
        PetAutoSkill pet_3_auto_skill,
        String pet_3_pet_type,
        List<String> pet_3_skill,
        String pet_3_date_expire,
        String pet_3_appearance,
        String pet_3_appearance_icon
) {
}
