package com.kmstimes.nexon.dto.character.seteffect;

import java.util.List;

/**
 * 메이플스토리 세트 효과 정보를 담는 데이터 클래스입니다.
 *
 * @param set_name             세트 효과 명
 * @param total_set_count      세트 개수 (럭키 아이템 포함)
 * @param set_effect_info      적용 중인 세트 효과 정보
 * @param set_effect_full_info 모든 세트 효과 정보
 */
public record SetEffect(
        String set_name,
        String total_set_count,
        List<SetEffectInfo> set_effect_info,
        List<SetEffectInfo> set_effect_full_info
) {
}
