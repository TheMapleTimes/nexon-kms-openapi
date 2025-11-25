package com.kmstimes.nexon.client.json;

import com.kmstimes.nexon.MapleStoryApi;
import com.kmstimes.nexon.TestValue;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UnionApiJsonClientTest {
    static MapleStoryApi api = TestValue.api;
    static String ocid = TestValue.ocid;
    static LocalDate date = TestValue.date;

    @Test
    void getUnion() {
        ResponseBody res = api.UnionJson().getUnion(ocid, date);
        resPrint(res);
    }

    @Test
    void getUnionRaider() {
        ResponseBody res = api.UnionJson().getUnionRaider(ocid, date);
        resPrint(res);
    }

    @Test
    void getUnionArtifact() {
        ResponseBody res = api.UnionJson().getUnionArtifact(ocid, date);
        resPrint(res);
    }

    @Test
    void getUnionChampion() {
        ResponseBody res = api.UnionJson().getUnionChampion(ocid, date);
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