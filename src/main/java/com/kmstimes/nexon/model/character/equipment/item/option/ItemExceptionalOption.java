package com.kmstimes.nexon.model.character.equipment.item.option;

import com.google.gson.annotations.SerializedName;

/**
 * 메이플스토리 장비 특별 옵션 정보를 담는 데이터 클래스입니다.
 *
 * @param str                 STR
 * @param dex                 DEX
 * @param inte                INT
 * @param luk                 LUK
 * @param max_hp              최대 HP
 * @param max_mp              최대 MP
 * @param attack_power        공격력
 * @param magic_power         마력
 * @param exceptional_upgrade 익셉셔널 강화 적용 횟수
 */
public record ItemExceptionalOption(
        String str,
        String dex,
        @SerializedName("int") String inte,
        String luk,
        String max_hp,
        String max_mp,
        String attack_power,
        String magic_power,
        Long exceptional_upgrade
) {
}
