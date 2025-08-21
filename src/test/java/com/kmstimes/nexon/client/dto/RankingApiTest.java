package com.kmstimes.nexon.client.dto;

import com.kmstimes.nexon.MapleStoryApi;
import com.kmstimes.nexon.TestValue;
import com.kmstimes.nexon.dto.ranking.achievement.AchievementRankingResponse;
import com.kmstimes.nexon.dto.ranking.dojang.DojangRankingResponse;
import com.kmstimes.nexon.dto.ranking.guild.GuildRankingResponse;
import com.kmstimes.nexon.dto.ranking.overall.OverallRankingResponse;
import com.kmstimes.nexon.dto.ranking.theseed.TheseedRankingResponse;
import com.kmstimes.nexon.dto.ranking.union.UnionRankingResponse;
import com.kmstimes.nexon.enums.ClassName;
import com.kmstimes.nexon.enums.WorldName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RankingApiTest {
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
        OverallRankingResponse response = api.Ranking().getOverall(LocalDate.now(ZoneId.of("Asia/Seoul")), worldName, worldType, characterClass, ocid, page);
        assertNotNull(response);
        assertNotNull(response.ranking());
        assertFalse(response.ranking().isEmpty());

        System.out.println("Overall ranking count: " + response.ranking().size());
        System.out.println(response);
    }

    @Test
    void getUnion() {
        UnionRankingResponse response = api.Ranking().getUnion(date, worldName, ocid, page);
        assertNotNull(response);
        assertNotNull(response.ranking());
        assertFalse(response.ranking().isEmpty());

        System.out.println("Union ranking count: " + response.ranking().size());
        System.out.println(response);
    }

    @Test
    void getGuild() {
        GuildRankingResponse response = api.Ranking().getGuild(date, worldName, rankingType, guildName, page);
        assertNotNull(response);
        assertNotNull(response.ranking());
        assertFalse(response.ranking().isEmpty());

        System.out.println("Guild ranking count: " + response.ranking().size());
        System.out.println(response);
    }

    @Test
    void getDojang() {
        DojangRankingResponse response = api.Ranking().getDojang(date, worldName, difficulty, characterClass, ocid, page);
        assertNotNull(response);
        assertNotNull(response.ranking());
        assertFalse(response.ranking().isEmpty());

        System.out.println("Dojang ranking count: " + response.ranking().size());
        System.out.println(response);
    }

    @Test
    void getTheseed() {
        TheseedRankingResponse response = api.Ranking().getTheseed(date, worldName, ocid, page);
        assertNotNull(response);
        assertNotNull(response.ranking());
        assertFalse(response.ranking().isEmpty());

        System.out.println("Theseed ranking count: " + response.ranking().size());
        System.out.println(response);
    }

    @Test
    void getAchievement() {
        AchievementRankingResponse response = api.Ranking().getAchievement(date, ocid, page);
        assertNotNull(response);
        assertNotNull(response.ranking());
        assertFalse(response.ranking().isEmpty());

        System.out.println("Achievement ranking count: " + response.ranking().size());
        System.out.println(response);
    }
}
