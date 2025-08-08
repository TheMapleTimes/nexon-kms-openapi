package com.kmstimes.nexon.dto.notice.cashshop;

/**
 * 메이플스토리 캐시샵 공지사항 정보를 담는 데이터 클래스입니다.
 *
 * @param title           공지사항 제목
 * @param url             공지사항 URL
 * @param notice_id       공지사항 식별자
 * @param date            공지사항 등록 날짜 (KST) (example: 2023-12-21T00:00+09:00)
 * @param date_sale_start 판매 시작 날짜 (KST) (example: 2023-12-21T00:00+09:00)
 * @param date_sale_end   판매 종료 날짜 (KST) (example: 2023-12-21T00:00+09:00)
 * @param ongoing_flag    상시 판매 여부 ("true": 상시)
 */
public record CashshopNotice(
        String title,
        String url,
        Long notice_id,
        String date,
        String date_sale_start,
        String date_sale_end,
        String ongoing_flag
) {
}
