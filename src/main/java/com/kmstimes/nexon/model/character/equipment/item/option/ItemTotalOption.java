package com.kmstimes.nexon.model.character.equipment.item.option;

import com.google.gson.annotations.SerializedName;

/**
 * 메이플스토리 장비 최종 옵션 정보를 담는 데이터 클래스입니다.
 *
 * @param str                      STR
 * @param dex                      DEX
 * @param inte                     INT
 * @param luk                      LUK
 * @param max_hp                   최대 HP
 * @param max_mp                   최대 MP
 * @param attack_power             공격력
 * @param magic_power              마력
 * @param armor                    방어력
 * @param speed                    이동속도
 * @param jump                     점프력
 * @param boss_damage              보스 몬스터 데미지 증가(%)
 * @param ignore_monster_armor     몬스터 방어율 무시(%)
 * @param all_stat                 올스탯(%)
 * @param damage                   데미지(%)
 * @param equipment_level_decrease 착용 레벨 감소
 * @param max_hp_rate              최대 HP(%)
 * @param max_mp_rate              최대 MP(%)
 */
public record ItemTotalOption(
        String str,
        String dex,
        @SerializedName("int") String inte,
        String luk,
        String max_hp,
        String max_mp,
        String attack_power,
        String magic_power,
        String armor,
        String speed,
        String jump,
        String boss_damage,
        String ignore_monster_armor,
        String all_stat,
        String damage,
        Long equipment_level_decrease,
        String max_hp_rate,
        String max_mp_rate
) {
}
