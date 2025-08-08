package com.kmstimes.nexon.client.json;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kmstimes.nexon.MapleStoryApi;
import com.kmstimes.nexon.TestValue;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

class ProbabilityApiJsonClientTest {
    static MapleStoryApi api = TestValue.api;
    static String userApiKey = TestValue.apiKey;
    static String legacyApiKey = TestValue.legacyApiKey;
    static LocalDate cubeDate = TestValue.cubeDate;
    static int count = TestValue.count;

    @Test
    void getLegacyOuid() {
        try {
            ResponseBody res = api.ProbabilityJson().getLegacyOuid(legacyApiKey);
            resPrint(res);
        } catch (Exception e) {
            System.out.println("Expected error (invalid user API key): " + e.getMessage());
        }
    }

    @Test
    void getOuid() {
        ResponseBody res = api.ProbabilityJson().getOuid(userApiKey);
        resPrint(res);
    }

    @Test
    void getStarforce() {
        LocalDate date = TestValue.StarDate;
        ResponseBody res = api.ProbabilityJson().getStarforce(userApiKey, count, date, null);

        String res2;
        try {
            res2 = res.string();
            System.out.println(res2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JsonObject jsonObject = JsonParser.parseString(res2).getAsJsonObject();
        String cursor = jsonObject.get("next_cursor").getAsString();
        ResponseBody res3 = api.ProbabilityJson().getStarforce(userApiKey, count, date, cursor);
        resPrint(res3);
    }

    @Test
    void getPotential() {
        ResponseBody res = api.ProbabilityJson().getPotential(userApiKey, count, cubeDate, null);
        String res2;
        try {
            res2 = res.string();
            System.out.println(res2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JsonObject jsonObject = JsonParser.parseString(res2).getAsJsonObject();
        String cursor = jsonObject.get("next_cursor").getAsString();
        ResponseBody res3 = api.ProbabilityJson().getPotential(userApiKey, count, cubeDate, cursor);
        resPrint(res3);
    }

    @Test
    void getCube() {
        ResponseBody res = api.ProbabilityJson().getCube(userApiKey, count, cubeDate, null);
        String res2;
        try {
            res2 = res.string();
            System.out.println(res2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JsonObject jsonObject = JsonParser.parseString(res2).getAsJsonObject();
        String cursor = jsonObject.get("next_cursor").getAsString();
        ResponseBody res3 = api.ProbabilityJson().getCube(userApiKey, count, cubeDate, cursor);
        resPrint(res3);
    }

    private void resPrint(ResponseBody res) {
        try {
            System.out.println(res.string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}