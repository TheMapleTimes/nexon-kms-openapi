package com.kmstimes.nexon.dto.notice.notice;


import com.kmstimes.nexon.dto.notice.common.Notice;

import java.util.List;

/**
 * 메이플스토리 일반 공지사항 목록 조회 응답을 담는 데이터 클래스입니다.
 * 최근 등록된 공지사항 최대 20개를 포함합니다.
 *
 * @param notice 공지사항 목록
 */
public record NoticeResponse(List<Notice> notice) {
}
