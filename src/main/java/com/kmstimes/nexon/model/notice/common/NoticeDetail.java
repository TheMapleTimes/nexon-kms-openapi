package com.kmstimes.nexon.model.notice.common;

/**
 * 메이플스토리 공지사항의 상세 정보를 담는 공통 데이터 클래스입니다.
 *
 * @param title    공지사항 제목
 * @param url      공지사항 URL
 * @param contents 공지사항 내용 (HTML 형식)
 * @param date     공지사항 등록 날짜 (KST) (example: 2023-12-21T00:00+09:00)
 */
public record NoticeDetail(
        String title,
        String url,
        String contents,
        String date
) {
}
