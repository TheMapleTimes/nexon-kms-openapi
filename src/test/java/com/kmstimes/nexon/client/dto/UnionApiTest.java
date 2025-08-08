package com.kmstimes.nexon.client.dto;

import com.kmstimes.nexon.MapleStoryApi;
import com.kmstimes.nexon.TestValue;
import com.kmstimes.nexon.dto.union.artifact.UnionArtifactResponse;
import com.kmstimes.nexon.dto.union.champion.UnionChampionResponse;
import com.kmstimes.nexon.dto.union.info.UnionResponse;
import com.kmstimes.nexon.dto.union.raider.UnionRaiderResponse;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UnionApiTest {
    static MapleStoryApi api = TestValue.api;
    static String ocid = TestValue.ocid2;
    static LocalDate date = TestValue.date;

    @Test
    void getUnion() {
            UnionResponse response = api.Union().getUnion(ocid, date);
            assertNotNull(response);

            System.out.println(response);
    }

    @Test
    void getUnionRaider() {
        UnionRaiderResponse response = api.Union().getUnionRaider(ocid, date);
        assertNotNull(response);

        System.out.println(response);
    }

    @Test
    void getUnionArtifact() {
        UnionArtifactResponse response = api.Union().getUnionArtifact(ocid, date);
        assertNotNull(response);

        System.out.println(response);
    }

    @Test
    void getUnionChampion() {
        UnionChampionResponse response = api.Union().getUnionChampion(ocid, date);
        assertNotNull(response);

        System.out.println(response);
    }
}
