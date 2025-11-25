package com.kmstimes.nexon.client.dto;

import com.kmstimes.nexon.MapleStoryApi;
import com.kmstimes.nexon.TestValue;
import com.kmstimes.nexon.dto.character.ability.AbilityResponse;
import com.kmstimes.nexon.dto.character.achievement.AchievementResponse;
import com.kmstimes.nexon.dto.character.basic.BasicResponse;
import com.kmstimes.nexon.dto.character.dojang.DojangResponse;
import com.kmstimes.nexon.dto.character.equipment.android.AndroidEquipmentResponse;
import com.kmstimes.nexon.dto.character.equipment.beauty.BeautyEquipmentResponse;
import com.kmstimes.nexon.dto.character.equipment.cashitem.CashItemEquipmentResponse;
import com.kmstimes.nexon.dto.character.equipment.item.ItemEquipmentResponse;
import com.kmstimes.nexon.dto.character.equipment.pet.PetEquipmentResponse;
import com.kmstimes.nexon.dto.character.equipment.symbol.SymbolEquipmentResponse;
import com.kmstimes.nexon.dto.character.hyperstat.HyperStatResponse;
import com.kmstimes.nexon.dto.character.list.AccountResponse;
import com.kmstimes.nexon.dto.character.otherstat.OtherStatResponse;
import com.kmstimes.nexon.dto.character.propensity.PropensityResponse;
import com.kmstimes.nexon.dto.character.ringexchange.RingExchangeResponse;
import com.kmstimes.nexon.dto.character.seteffect.SetEffectResponse;
import com.kmstimes.nexon.dto.character.skill.hexamatrix.HexaMatrixResponse;
import com.kmstimes.nexon.dto.character.skill.hexamatrixstat.HexaMatrixStatResponse;
import com.kmstimes.nexon.dto.character.skill.link.LinkSkillResponse;
import com.kmstimes.nexon.dto.character.skill.skill.SkillResponse;
import com.kmstimes.nexon.dto.character.skill.vmatrix.VMatrixResponse;
import com.kmstimes.nexon.dto.character.stat.StatResponse;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CharacterApiTest {
    static final LocalDate date = TestValue.date;
    static String apiKey = TestValue.apiKey;
    static MapleStoryApi api = TestValue.api;
    static String ocid = TestValue.ocid;

    @Test
    void getCharacterList(){
        AccountResponse list = api.Character().getCharacterList(apiKey);
        System.out.println(list);
    }

    @Test
    void getId() {
        ocid = api.Character().getId("아델").ocid();
        System.out.println(ocid);
    }

    @Test
    void characterAchievement() {
        AchievementResponse res = api.Character().getCharacterAchievement(apiKey);
        System.out.println(res);
    }

    @Test
    void characterBasic() {
        BasicResponse res = api.Character().getCharacterBasic(ocid, date);
        assertNotNull(res);
        System.out.println(res);
    }

    @Test
    void characterStat() {
        StatResponse res = api.Character().getCharacterStat(ocid, date);
        assertNotNull(res);
        System.out.println(res);
    }

    @Test
    void characterPopularity() {
        long popularity = api.Character().getCharacterPopularity(ocid, date).popularity();
        assertTrue(popularity >= 0);
        System.out.println(popularity);
    }

    @Test
    void characterAbility() {
        AbilityResponse res = api.Character().getCharacterAbility(ocid, date);
        assertNotNull(res);
        System.out.println(res);
    }

    @Test
    void characterHyperStat() {
        HyperStatResponse res = api.Character().getCharacterHyperStat(ocid, date);
        assertNotNull(res);
        System.out.println(res);
    }

    @Test
    void characterPropensity() {
        PropensityResponse res = api.Character().getCharacterPropensity(ocid, date);
        assertNotNull(res);
        System.out.println(res);
    }

    @Test
    void characterItemEquipment() {
        ItemEquipmentResponse res = api.Character().getCharacterItemEquipment(ocid, date);
        assertNotNull(res);
        System.out.println(res);
    }

    @Test
    void characterCashItemEquipment() {
        CashItemEquipmentResponse res = api.Character().getCharacterCashItemEquipment(ocid, date);
        assertNotNull(res);
        System.out.println(res);
    }

    @Test
    void characterSymbolEquipment() {
        SymbolEquipmentResponse res = api.Character().getCharacterSymbolEquipment(ocid, date);
        assertNotNull(res);
        System.out.println(res);
    }

    @Test
    void characterSetEffect() {
        SetEffectResponse res = api.Character().getCharacterSetEffect(ocid, date);
        assertNotNull(res);
        System.out.println(res);
    }

    @Test
    void characterBeautyEquipment() {
        BeautyEquipmentResponse res = api.Character().getCharacterBeautyEquipment(ocid, date);
        assertNotNull(res);
        System.out.println(res);
    }

    @Test
    void characterAndroidEquipment() {
        AndroidEquipmentResponse res = api.Character().getCharacterAndroidEquipment(ocid, date);
        assertNotNull(res);
        System.out.println(res);
    }

    @Test
    void characterPetEquipment() {
        PetEquipmentResponse res = api.Character().getCharacterPetEquipment(ocid, date);
        assertNotNull(res);
        System.out.println(res);
    }

    @Test
    void characterSkill() {
        SkillResponse res = api.Character().getCharacterSkill(ocid, date, "5");
        assertNotNull(res);
        System.out.println(res);
    }

    @Test
    void characterLinkSkill() {
        LinkSkillResponse res = api.Character().getCharacterLinkSkill(ocid, date);
        assertNotNull(res);
        System.out.println(res);
    }

    @Test
    void characterVMatrix() {
        VMatrixResponse res = api.Character().getCharacterVMatrix(ocid, date);
        assertNotNull(res);
        System.out.println(res);
    }

    @Test
    void characterHexaMatrix() {
        HexaMatrixResponse res = api.Character().getCharacterHexaMatrix(ocid, date);
        assertNotNull(res);
        System.out.println(res);
    }

    @Test
    void characterHexaMatrixStat() {
        HexaMatrixStatResponse res = api.Character().getCharacterHexaMatrixStat(ocid, date);
        assertNotNull(res);
        System.out.println(res);
    }

    @Test
    void characterDojang() {
        DojangResponse res = api.Character().getCharacterDojang(ocid, date);
        assertNotNull(res);
        System.out.println(res);
    }

    @Test
    void characterOtherStat(){
        OtherStatResponse res = api.Character().getCharacterOtherStat(ocid, null);
        assertNotNull(res);
        System.out.println(res);
    }

    @Test
    void characterRingExchange(){
        RingExchangeResponse res = api.Character().getCharacterRingExchange(ocid, null);
        assertNotNull(res);
        System.out.println(res);
    }
}
