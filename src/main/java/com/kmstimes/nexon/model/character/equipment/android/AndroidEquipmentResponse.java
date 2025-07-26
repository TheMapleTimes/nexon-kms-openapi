package com.kmstimes.nexon.model.character.equipment.android;

import com.kmstimes.nexon.model.character.equipment.common.Face;
import com.kmstimes.nexon.model.character.equipment.common.Hair;
import com.kmstimes.nexon.model.character.equipment.common.Skin;

import java.util.List;

/**
 * 메이플스토리 장착 안드로이드 정보 조회 응답을 담는 데이터 클래스입니다.
 *
 * @param date                         조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
 *                                     <p>
 *                                     example: 2023-12-21T00:00+09:00
 * @param android_name                 안드로이드 명
 * @param android_nickname             안드로이드 닉네임
 * @param android_icon                 안드로이드 아이콘
 * @param android_description          안드로이드 아이템 설명
 * @param android_hair                 안드로이드 헤어 정보
 * @param android_face                 안드로이드 성형 정보
 * @param android_skin                 안드로이드 피부 정보
 * @param android_ear_sensor_clip_flag 안드로이드 이어센서 클립 적용 여부
 * @param android_gender               안드로이드 성별
 * @param android_grade                안드로이드 등급
 * @param android_non_humanoid_flag    비인간형 안드로이드 여부
 * @param android_shop_usable_flag     잡화상점 기능 이용 가능 여부
 * @param android_cash_item_equipment  안드로이드 캐시 아이템 장착 정보
 * @param preset_no                    적용 중인 장비 프리셋 번호(number)
 * @param android_preset_1             1번 프리셋 안드로이드 정보
 * @param android_preset_2             2번 프리셋 안드로이드 정보
 * @param android_preset_3             3번 프리셋 안드로이드 정보
 */
public record AndroidEquipmentResponse(
        String date,
        String android_name,
        String android_nickname,
        String android_icon,
        String android_description,
        Hair android_hair,
        Face android_face,
        Skin android_skin,
        String android_ear_sensor_clip_flag,
        String android_gender,
        String android_grade,
        String android_non_humanoid_flag,
        String android_shop_usable_flag,
        List<AndroidCashItemEquipment> android_cash_item_equipment,
        Long preset_no,
        AndroidPreset android_preset_1,
        AndroidPreset android_preset_2,
        AndroidPreset android_preset_3
) {
}
