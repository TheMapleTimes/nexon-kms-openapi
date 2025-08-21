package com.kmstimes.nexon.client.json;

import com.kmstimes.nexon.MapleStoryApi;
import com.kmstimes.nexon.TestValue;
import com.kmstimes.nexon.enums.SkillGrade;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

class CharacterApiJsonClientTest {
    static final LocalDate date = TestValue.date;
    static String apiKey = TestValue.apiKey;
    static MapleStoryApi api = TestValue.api;
    static String ocid = TestValue.ocid;

    @Test
    void getCharacterList() {
        ResponseBody res = api.CharacterJson().getCharacterList(apiKey);
        resPrint(res);
    }

    @Test
    void getCharacterAchievement() {
        ResponseBody res = api.CharacterJson().getCharacterAchievement(apiKey);
        resPrint(res);
    }

    @Test
    void getId() {
        ResponseBody res = api.CharacterJson().getId("닉네임");
        resPrint(res);
    }

    @Test
    void getCharacterBasic() {
        ResponseBody res = api.CharacterJson().getCharacterBasic(ocid, date);
        resPrint(res);
    }

    @Test
    void getCharacterPopularity() {
        ResponseBody res = api.CharacterJson().getCharacterPopularity(ocid, date);
        resPrint(res);
    }

    @Test
    void getCharacterStat() {
        ResponseBody res =  api.CharacterJson().getCharacterStat(ocid, date);
        resPrint(res);
    }

    @Test
    void getCharacterHyperStat() {
        ResponseBody res =  api.CharacterJson().getCharacterHyperStat(ocid, date);
        resPrint(res);
    }

    @Test
    void getCharacterPropensity() {
        ResponseBody res =  api.CharacterJson().getCharacterPropensity(ocid, date);
        resPrint(res);
    }

    @Test
    void getCharacterAbility() {
        ResponseBody res =  api.CharacterJson().getCharacterAbility(ocid, date);
        resPrint(res);
    }

    @Test
    void getCharacterItemEquipment() {
        ResponseBody res =  api.CharacterJson().getCharacterItemEquipment(ocid, date);
        resPrint(res);
    }

    @Test
    void getCharacterCashItemEquipment() {
        ResponseBody res =  api.CharacterJson().getCharacterCashItemEquipment(ocid, date);
        resPrint(res);
    }

    @Test
    void getCharacterSymbolEquipment() {
        ResponseBody res =  api.CharacterJson().getCharacterSymbolEquipment(ocid, date);
        resPrint(res);
    }

    @Test
    void getCharacterSetEffect() {
        ResponseBody res =  api.CharacterJson().getCharacterSetEffect(ocid, date);
        resPrint(res);
    }

    @Test
    void getCharacterBeautyEquipment() {
        ResponseBody res =  api.CharacterJson().getCharacterBeautyEquipment(ocid, date);
        resPrint(res);
    }

    @Test
    void getCharacterAndroidEquipment() {
        ResponseBody res =  api.CharacterJson().getCharacterAndroidEquipment(ocid, date);
        resPrint(res);
    }

    @Test
    void getCharacterPetEquipment() {
        ResponseBody res =  api.CharacterJson().getCharacterPetEquipment(ocid, date);
        resPrint(res);
    }

    @Test
    void getCharacterSkill() {
        for(SkillGrade grade : SkillGrade.values()) {
            ResponseBody res = api.CharacterJson().getCharacterSkill(ocid, date, grade.getGrade());
            resPrint(res);
        }
    }

    @Test
    void getCharacterLinkSkill() {
        ResponseBody res =  api.CharacterJson().getCharacterLinkSkill(ocid, date);
        resPrint(res);
    }

    @Test
    void getCharacterVMatrix() {
        ResponseBody res =  api.CharacterJson().getCharacterVMatrix(ocid, date);
        resPrint(res);
    }

    @Test
    void getCharacterHexaMatrix() {
        ResponseBody res =  api.CharacterJson().getCharacterHexaMatrix(ocid, date);
        resPrint(res);
    }

    @Test
    void getCharacterHexaMatrixStat() {
        ResponseBody res =  api.CharacterJson().getCharacterHexaMatrixStat(ocid, date);
        resPrint(res);
    }

    @Test
    void getCharacterDojang() {
        ResponseBody res =  api.CharacterJson().getCharacterDojang(ocid, date);
        resPrint(res);
    }

    @Test
    void getCharacterOtherStat(){
        ResponseBody res =  api.CharacterJson().getCharacterOtherStat(ocid, date);
        resPrint(res);
    }

    @Test
    void getCharacterRingExchange(){
        ResponseBody res =  api.CharacterJson().getCharacterRingExchange(ocid, date);
        resPrint(res);
    }

    private void resPrint(ResponseBody res) {
        try {
            System.out.println(res.string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}