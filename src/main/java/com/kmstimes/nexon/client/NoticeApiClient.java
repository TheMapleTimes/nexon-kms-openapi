package com.kmstimes.nexon.client;

import com.kmstimes.nexon.api.NoticeApi;
import com.kmstimes.nexon.error.handler.NexonApiExceptionHandler;
import com.kmstimes.nexon.model.notice.cashshop.CashshopNoticeDetailResponse;
import com.kmstimes.nexon.model.notice.cashshop.CashshopNoticeResponse;
import com.kmstimes.nexon.model.notice.common.NoticeDetail;
import com.kmstimes.nexon.model.notice.event.EventNoticeDetailResponse;
import com.kmstimes.nexon.model.notice.event.EventNoticeResponse;
import com.kmstimes.nexon.model.notice.notice.NoticeResponse;
import com.kmstimes.nexon.model.notice.update.UpdateNoticeResponse;
import retrofit2.Retrofit;

/**
 * 공지 정보 조회 API 호출을 담당하는 클라이언트 클래스입니다.
 * <p>
 * {@link NoticeApi} 인터페이스를 기반으로, 실제 API 요청을 수행하고,
 * 예외 처리를 일관되게 처리합니다.
 * <p>
 * <strong>NEXON OPEN API 안내사항:</strong>
 * <ul>
 * <li>공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.</li>
 * <li>실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니
 * 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.</li>
 * </ul>
 */
public class NoticeApiClient {
    private final NoticeApi noticeApi;

    /**
     * 생성자: Retrofit 인스턴스를 주입받아 {@link NoticeApi} 를 초기화합니다.
     *
     * @param retrofit Retrofit 인스턴스
     */
    public NoticeApiClient(Retrofit retrofit) {
        this.noticeApi = retrofit.create(NoticeApi.class);
    }

    /**
     * 메이플스토리 공지사항에 최근 등록된 게시글 20개를 조회합니다.
     *
     * @return {@link NoticeResponse} 공지사항 목록 조회
     */
    public NoticeResponse getNotices() {
        return NexonApiExceptionHandler.execute(() ->
                noticeApi.getNotices()
        );

    }

    /**
     * 메이플스토리 공지사항 게시글 세부 사항을 조회합니다.
     *
     * @param noticeId 공지 식별자
     * @return {@link NoticeDetail} 공지사항 상세 조회
     */
    public NoticeDetail getNoticeDetail(Long noticeId) {
        validateId(noticeId);

        return NexonApiExceptionHandler.execute(() ->
                noticeApi.getNoticeDetail(noticeId)
        );

    }

    /**
     * 메이플스토리 업데이트에 최근 등록된 게시글 20개를 조회합니다.
     *
     * @return {@link UpdateNoticeResponse} 업데이트 목록 조회
     */
    public UpdateNoticeResponse getUpdateNotices() {
        return NexonApiExceptionHandler.execute(() ->
                noticeApi.getUpdateNotices()
        );

    }

    /**
     * 메이플스토리 업데이트 게시글 세부 사항을 조회합니다.
     *
     * @param noticeId 공지 식별자
     * @return {@link NoticeDetail} 업데이트 상세 조회
     */
    public NoticeDetail getUpdateNoticeDetail(Long noticeId) {
        validateId(noticeId);

        return NexonApiExceptionHandler.execute(() ->
                noticeApi.getUpdateNoticeDetail(noticeId)
        );

    }

    /**
     * 메이플스토리 진행 중 이벤트에 최근 등록된 공지사항 20개를 조회합니다.
     *
     * @return {@link EventNoticeResponse} 진행 중 이벤트 목록 조회
     */
    public EventNoticeResponse getEventNotices() {
        return NexonApiExceptionHandler.execute(() ->
                noticeApi.getEventNotices()
        );

    }

    /**
     * 메이플스토리 진행 중 이벤트 게시글 세부 사항을 조회합니다.
     *
     * @param noticeId 공지 식별자
     * @return {@link EventNoticeDetailResponse} 진행 중 이벤트 상세 조회
     */
    public EventNoticeDetailResponse getEventNoticeDetail(Long noticeId) {
        validateId(noticeId);

        return NexonApiExceptionHandler.execute(() ->
                noticeApi.getEventNoticeDetail(noticeId)
        );

    }

    /**
     * 메이플스토리 캐시샵 공지에 최근 등록된 공지사항 20개를 조회합니다.
     *
     * @return {@link CashshopNoticeResponse} 캐시샵 공지 목록 조회
     */
    public CashshopNoticeResponse getCashshopNotices() {
        return NexonApiExceptionHandler.execute(() ->
                noticeApi.getCashshopNotices()
        );

    }

    /**
     * 메이플스토리 캐시샵 공지 게시글 세부 사항을 조회합니다.
     *
     * @param noticeId 공지 식별자
     * @return {@link CashshopNoticeDetailResponse} 캐시샵 공지 상세 조회
     */
    public CashshopNoticeDetailResponse getCashshopNoticeDetail(Long noticeId) {
        validateId(noticeId);

        return NexonApiExceptionHandler.execute(() ->
                noticeApi.getCashshopNoticeDetail(noticeId)
        );

    }

    private void validateId(Long noticeId){
        if (noticeId == null) {
            throw new IllegalArgumentException("Notice Id 는 null 이거나 비어 있을 수 없습니다.");
        }
    }
}
