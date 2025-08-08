package com.kmstimes.nexon.client.json;

import com.kmstimes.nexon.MapleStoryApi;
import com.kmstimes.nexon.TestValue;
import com.kmstimes.nexon.enums.ClassName;
import com.kmstimes.nexon.enums.WorldName;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RankingApiJsonClientTest {
    static MapleStoryApi api = TestValue.api;
    static String worldName = WorldName.SCANIA.getWorldName();
    static LocalDate date = TestValue.date;
    static String ocid = null;
    static int page = 1;
    static int worldType = 0;
    static String characterClass = ClassName.ADELE.getClassName();
    static int rankingType = 1;
    static String guildName = TestValue.guildName;
    static int difficulty = 1;

    @Test
    void getOverall() {
        ResponseBody res = api.RankingJson().getOverall(date, worldName, worldType, characterClass, ocid, page);
        resPrint(res);
    }

    @Test
    void getUnion() {
        ResponseBody res = api.RankingJson().getUnion(date, worldName, ocid, page);
        resPrint(res);
    }

    @Test
    void getGuild() {
        ResponseBody res = api.RankingJson().getGuild(date, worldName, rankingType, guildName, page);
        resPrint(res);
    }

    @Test
    void getDojang() {
        ResponseBody res = api.RankingJson().getDojang(date, worldName, difficulty, characterClass, ocid, page);
        resPrint(res);
    }

    @Test
    void getTheseed() {
        ResponseBody res = api.RankingJson().getTheseed(date, worldName, ocid, page);
        resPrint(res);
    }

    @Test
    void getAchievement() {
        ResponseBody res = api.RankingJson().getAchievement(date, ocid, page);
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