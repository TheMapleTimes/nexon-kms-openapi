package com.kmstimes.nexon.dto.character.list;

import java.util.List;

/**
 * 메이플스토리 캐릭터 목록 조회 응답을 담는 데이터 클래스입니다.
 *
 * @param account_list 메이플스토리 계정 목록
 */
public record AccountResponse(List<Account> account_list) {
}
