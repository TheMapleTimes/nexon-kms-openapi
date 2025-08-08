package com.kmstimes.nexon.dto.character.equipment.android;

import com.kmstimes.nexon.dto.character.equipment.common.Face;
import com.kmstimes.nexon.dto.character.equipment.common.Hair;
import com.kmstimes.nexon.dto.character.equipment.common.Skin;

/**
 * 메이플스토리 프리셋 안드로이드 정보를 담는 데이터 클래스입니다.
 *
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
 */
public record AndroidPreset(
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
        String android_shop_usable_flag
) {
}
