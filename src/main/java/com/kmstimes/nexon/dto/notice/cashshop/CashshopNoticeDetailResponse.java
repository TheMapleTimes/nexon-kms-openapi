package com.kmstimes.nexon.dto.notice.cashshop;

/**
 * 메이플스토리 캐시샵 공지사항 상세 정보 응답을 담는 데이터 클래스입니다.
 *
 * @param title           공지사항 제목
 * @param url             공지사항 URL
 * @param contents        공지사항 내용 (HTML 형식)
 * @param date            공지사항 등록 날짜 (yyyy-MM-dd HH:mm 형식)
 * @param date_sale_start 판매 시작 날짜 (yyyy-MM-dd HH:mm 형식, 판매 기간이 없는 경우 null)
 * @param date_sale_end   판매 종료 날짜 (yyyy-MM-dd HH:mm 형식, 판매 기간이 없는 경우 null)
 * @param ongoing_flag    진행 상태 ("true": 진행중, "false": 종료)
 */
public record CashshopNoticeDetailResponse(
        String title,
        String url,
        String contents,
        String date,
        String date_sale_start,
        String date_sale_end,
        String ongoing_flag
) {
}
