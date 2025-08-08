package com.kmstimes.nexon.client.json;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kmstimes.nexon.MapleStoryApi;
import com.kmstimes.nexon.TestValue;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GuildApiJsonClientTest {
    static MapleStoryApi api = TestValue.api;

    static final LocalDate date = TestValue.date;

    static final String guildName = TestValue.guildName;
    static final String worldName = TestValue.WorldName;

    @Test
    void getGuildId() {
        ResponseBody res = api.GuildJson().getGuildId(guildName, worldName);
        try {
            System.out.println(res.string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getGuildBasic() {
        ResponseBody id = api.GuildJson().getGuildId(guildName, worldName);
        try {
            JsonObject jsonObject = JsonParser.parseString(id.string()).getAsJsonObject();
            String oid = jsonObject.get("oguild_id").getAsString();
            ResponseBody res = api.GuildJson().getGuildBasic(oid, date);
            System.out.println(res.string());
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}