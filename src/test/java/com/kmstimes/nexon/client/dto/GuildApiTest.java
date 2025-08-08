package com.kmstimes.nexon.client.dto;

import com.kmstimes.nexon.MapleStoryApi;
import com.kmstimes.nexon.TestValue;
import com.kmstimes.nexon.dto.guild.GuildBasicResponse;
import com.kmstimes.nexon.dto.guild.GuildIdResponse;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GuildApiTest {
    static MapleStoryApi api = TestValue.api;

    static final LocalDate date = TestValue.date;

    static final String guildName = TestValue.guildName;
    static final String worldName = TestValue.WorldName;

    @Test
    void getGuildId() {
        GuildIdResponse res = api.Guild().getGuildId(guildName, worldName);
        assertNotNull(res.oguild_id());
        System.out.println(res);
    }

    @Test
    void getGuildBasic() {
        GuildIdResponse guildIdRes = api.Guild().getGuildId(guildName, worldName);
        if(!guildIdRes.oguild_id().isEmpty()){
            GuildBasicResponse res = api.Guild().getGuildBasic(guildIdRes.oguild_id(), date);
            assertNotNull(res);
            System.out.println(res);
        }
    }
}
