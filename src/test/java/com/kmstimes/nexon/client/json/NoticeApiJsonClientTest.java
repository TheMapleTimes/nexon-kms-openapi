package com.kmstimes.nexon.client.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kmstimes.nexon.MapleStoryApi;
import com.kmstimes.nexon.TestValue;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class NoticeApiJsonClientTest {
    static MapleStoryApi api = TestValue.api;

    @Test
    void getNotices() {
        ResponseBody res = api.NoticeJson().getNotices();
        resPrint(res);
    }

    @Test
    void getNoticeDetail() {
        ResponseBody res = api.NoticeJson().getNotices();
        ResponseBody res2 = api.NoticeJson().getNoticeDetail(resLong(res, "notice"));
        resPrint(res2);
    }

    @Test
    void getUpdateNotices() {
        ResponseBody res = api.NoticeJson().getUpdateNotices();
        resPrint(res);
    }

    @Test
    void getUpdateNoticeDetail() {
        ResponseBody res = api.NoticeJson().getUpdateNotices();
        ResponseBody res2 = api.NoticeJson().getUpdateNoticeDetail(resLong(res, "update_notice"));
        resPrint(res2);
    }

    @Test
    void getEventNotices() {
        ResponseBody res = api.NoticeJson().getEventNotices();
        resPrint(res);
    }

    @Test
    void getEventNoticeDetail() {
        ResponseBody res = api.NoticeJson().getEventNotices();
        ResponseBody res2 = api.NoticeJson().getEventNoticeDetail(resLong(res, "event_notice"));
        resPrint(res2);
    }

    @Test
    void getCashshopNotices() {
        ResponseBody res = api.NoticeJson().getCashshopNotices();
        resPrint(res);
    }

    @Test
    void getCashshopNoticeDetail() {
        ResponseBody res = api.NoticeJson().getCashshopNotices();
        ResponseBody res2 = api.NoticeJson().getCashshopNoticeDetail(resLong(res, "cashshop_notice"));
        resPrint(res2);
    }

    private void resPrint(ResponseBody res) {
        try {
            System.out.println(res.string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Long resLong(ResponseBody res, String name) {
        try{
            JsonObject jsonObject = JsonParser.parseString(res.string()).getAsJsonObject();
            JsonArray notices = jsonObject.getAsJsonArray(name);
            JsonObject firstNotice = notices.get(0).getAsJsonObject();
            return firstNotice.get("notice_id").getAsLong();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}