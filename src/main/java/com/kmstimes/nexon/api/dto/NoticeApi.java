package com.kmstimes.nexon.api.dto;

import com.kmstimes.nexon.client.dto.NoticeApiClient;
import com.kmstimes.nexon.dto.notice.cashshop.CashshopNoticeDetailResponse;
import com.kmstimes.nexon.dto.notice.cashshop.CashshopNoticeResponse;
import com.kmstimes.nexon.dto.notice.common.NoticeDetail;
import com.kmstimes.nexon.dto.notice.event.EventNoticeDetailResponse;
import com.kmstimes.nexon.dto.notice.event.EventNoticeResponse;
import com.kmstimes.nexon.dto.notice.notice.NoticeResponse;
import com.kmstimes.nexon.dto.notice.update.UpdateNoticeResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 메이플스토리 공지 정보 조회 API 정의 인터페이스입니다.
 * <p>
 * Retrofit을 기반으로 각 공지 관련 API 엔드포인트를 선언하며,
 * {@link NoticeApiClient} 에서 사용됩니다.
 * <p>
 * <strong>NEXON OPEN API 안내사항:</strong>
 * <ul>
 * <li>공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.</li>
 * <li>실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니
 * 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.</li>
 * </ul>
 */
public interface NoticeApi {

    /**
     * 메이플스토리 공지사항에 최근 등록된 게시글 20개를 조회합니다.
     *
     * @return {@link NoticeResponse} 공지사항 목록 조회
     */
    @GET("maplestory/v1/notice")
    Call<NoticeResponse> getNotices();

    /**
     * 메이플스토리 공지사항 게시글 세부 사항을 조회합니다.
     *
     * @param noticeId 공지 식별자
     * @return {@link NoticeDetail} 공지사항 상세 조회
     */
    @GET("maplestory/v1/notice/detail")
    Call<NoticeDetail> getNoticeDetail(@Query("notice_id") Long noticeId);

    /**
     * 메이플스토리 업데이트에 최근 등록된 게시글 20개를 조회합니다.
     *
     * @return {@link UpdateNoticeResponse} 업데이트 목록 조회
     */
    @GET("maplestory/v1/notice-update")
    Call<UpdateNoticeResponse> getUpdateNotices();

    /**
     * 메이플스토리 업데이트 게시글 세부 사항을 조회합니다.
     *
     * @param noticeId 공지 식별자
     * @return {@link NoticeDetail} 업데이트 상세 조회
     */
    @GET("maplestory/v1/notice-update/detail")
    Call<NoticeDetail> getUpdateNoticeDetail(@Query("notice_id") Long noticeId);

    /**
     * 메이플스토리 진행 중 이벤트에 최근 등록된 공지사항 20개를 조회합니다.
     *
     * @return {@link EventNoticeResponse} 진행 중 이벤트 목록 조회
     */
    @GET("maplestory/v1/notice-event")
    Call<EventNoticeResponse> getEventNotices();

    /**
     * 메이플스토리 진행 중 이벤트 게시글 세부 사항을 조회합니다.
     *
     * @param noticeId 공지 식별자
     * @return {@link EventNoticeDetailResponse} 진행 중 이벤트 상세 조회
     */
    @GET("maplestory/v1/notice-event/detail")
    Call<EventNoticeDetailResponse> getEventNoticeDetail(@Query("notice_id") Long noticeId);

    /**
     * 메이플스토리 캐시샵 공지에 최근 등록된 공지사항 20개를 조회합니다.
     *
     * @return {@link CashshopNoticeResponse} 캐시샵 공지 목록 조회
     */
    @GET("maplestory/v1/notice-cashshop")
    Call<CashshopNoticeResponse> getCashshopNotices();

    /**
     * 메이플스토리 캐시샵 공지 게시글 세부 사항을 조회합니다.
     *
     * @param noticeId 공지 식별자
     * @return {@link CashshopNoticeDetailResponse} 캐시샵 공지 상세 조회
     */
    @GET("maplestory/v1/notice-cashshop/detail")
    Call<CashshopNoticeDetailResponse> getCashshopNoticeDetail(@Query("notice_id") Long noticeId);
}
