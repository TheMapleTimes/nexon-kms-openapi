package com.kmstimes.nexon.model.character.equipment.beauty;

import com.kmstimes.nexon.model.character.equipment.common.Face;
import com.kmstimes.nexon.model.character.equipment.common.Hair;
import com.kmstimes.nexon.model.character.equipment.common.Skin;

/**
 * 메이플스토리 장착 헤어, 성형, 피부 정보 조회 응답을 담는 데이터 클래스입니다.
 *
 * @param date                      조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
 *                                  <p>
 *                                  example: 2023-12-21T00:00+09:00
 * @param character_gender          캐릭터 성별
 * @param character_class           캐릭터 직업
 * @param character_hair            캐릭터 헤어 정보 (제로인 경우 알파, 엔젤릭버스터인 경우 일반 모드)
 * @param character_face            캐릭터 성형 정보 (제로인 경우 알파, 엔젤릭버스터인 경우 일반 모드)
 * @param character_skin            캐릭터 피부 정보 (제로인 경우 알파, 엔젤릭버스터인 경우 일반 모드)
 * @param additional_character_hair 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드에 적용 중인 헤어 정보
 * @param additional_character_face 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드에 적용 중인 성형 정보
 * @param additional_character_skin 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드에 적용 중인 피부 정보
 */
public record BeautyEquipmentResponse(
        String date,
        String character_gender,
        String character_class,
        Hair character_hair,
        Face character_face,
        Skin character_skin,
        Hair additional_character_hair,
        Face additional_character_face,
        Skin additional_character_skin
) {
}
