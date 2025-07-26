package com.kmstimes.nexon.model.notice.event;

/**
 * 메이플스토리 이벤트 공지사항 상세 정보 응답을 담는 데이터 클래스입니다.
 *
 * @param title            이벤트 제목
 * @param url              이벤트 URL
 * @param contents         이벤트 내용 (HTML 형식)
 * @param date             공지사항 등록 날짜 (KST) (example: 2023-12-21T00:00+09:00)
 * @param date_event_start 이벤트 시작 날짜 (KST) (example: 2023-12-21T00:00+09:00)
 * @param date_event_end   이벤트 종료 날짜 (KST) (example: 2023-12-21T00:00+09:00)
 */
public record EventNoticeDetailResponse(
        String title,
        String url,
        String contents,
        String date,
        String date_event_start,
        String date_event_end
) {
}
