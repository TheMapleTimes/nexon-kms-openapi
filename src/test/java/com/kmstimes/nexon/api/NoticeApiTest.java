package com.kmstimes.nexon.api;

import com.kmstimes.nexon.MapleStoryApi;
import com.kmstimes.nexon.model.notice.cashshop.CashshopNoticeDetailResponse;
import com.kmstimes.nexon.model.notice.cashshop.CashshopNoticeResponse;
import com.kmstimes.nexon.model.notice.common.NoticeDetail;
import com.kmstimes.nexon.model.notice.event.EventNoticeDetailResponse;
import com.kmstimes.nexon.model.notice.event.EventNoticeResponse;
import com.kmstimes.nexon.model.notice.notice.NoticeResponse;
import com.kmstimes.nexon.model.notice.update.UpdateNoticeResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NoticeApiTest {
    static MapleStoryApi api = TestValue.api;


    @Test
    void getNotices() {
        NoticeResponse res = api.Notice().getNotices();
        assertNotNull(res.notice());

        System.out.println(res);
    }

    @Test
    void getNoticeDetail() {
        NoticeResponse notices = api.Notice().getNotices();
        if (!notices.notice().isEmpty()) {
            Long noticeId = notices.notice().get(0).notice_id();

            NoticeDetail res = api.Notice().getNoticeDetail(noticeId);
            assertNotNull(res);
            System.out.println(res);
        }
    }

    @Test
    void getUpdateNotices() {
        UpdateNoticeResponse res = api.Notice().getUpdateNotices();
        assertNotNull(res);
        assertNotNull(res.update_notice());

        System.out.println("Update notice count: " + res.update_notice().size());
        System.out.println(res);
    }

    @Test
    void getUpdateNoticeDetail() {
        UpdateNoticeResponse notices = api.Notice().getUpdateNotices();
        if (!notices.update_notice().isEmpty()) {
            Long noticeId = notices.update_notice().get(0).notice_id();

            NoticeDetail res = api.Notice().getUpdateNoticeDetail(noticeId);
            assertNotNull(res);
            System.out.println(res);
        }
    }

    @Test
    void getEventNotices() {
        EventNoticeResponse res = api.Notice().getEventNotices();
        assertNotNull(res);
        assertNotNull(res.event_notice());

        System.out.println("Event notice count: " + res.event_notice().size());
        System.out.println(res);
    }

    @Test
    void getEventNoticeDetail() {
        EventNoticeResponse notices = api.Notice().getEventNotices();
        if (!notices.event_notice().isEmpty()) {
            Long noticeId = notices.event_notice().get(0).notice_id();

            EventNoticeDetailResponse res = api.Notice().getEventNoticeDetail(noticeId);
            assertNotNull(res);
            System.out.println(res);
        }
    }

    @Test
    void getCashshopNotices() {
        CashshopNoticeResponse res = api.Notice().getCashshopNotices();
        assertNotNull(res);
        assertNotNull(res.cashshop_notice());

        System.out.println("Cashshop notice count: " + res.cashshop_notice().size());
        System.out.println(res);
    }

    @Test
    void getCashshopNoticeDetail() {
        CashshopNoticeResponse notices = api.Notice().getCashshopNotices();
        if (!notices.cashshop_notice().isEmpty()) {
            Long noticeId = notices.cashshop_notice().get(0).notice_id();

            CashshopNoticeDetailResponse res = api.Notice().getCashshopNoticeDetail(noticeId);
            assertNotNull(res);
            System.out.println(res);
        }
    }
}
