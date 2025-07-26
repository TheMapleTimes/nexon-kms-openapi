package com.kmstimes.nexon.model.notice.update;

import com.kmstimes.nexon.model.notice.common.Notice;

import java.util.List;

/**
 * 메이플스토리 업데이트 공지사항 목록 조회 응답을 담는 데이터 클래스입니다.
 * 최근 등록된 업데이트 공지사항 최대 20개를 포함합니다.
 *
 * @param update_notice 업데이트 공지사항 목록
 */
public record UpdateNoticeResponse(List<Notice> update_notice) {
}
