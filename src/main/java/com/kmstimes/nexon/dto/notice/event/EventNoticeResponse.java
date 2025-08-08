package com.kmstimes.nexon.dto.notice.event;

import java.util.List;

/**
 * 메이플스토리 이벤트 공지사항 목록 조회 응답을 담는 데이터 클래스입니다.
 * 현재 진행 중인 이벤트 공지사항 최대 20개를 포함합니다.
 *
 * @param event_notice 이벤트 공지사항 목록
 */
public record EventNoticeResponse(List<EventNotice> event_notice) {
}
