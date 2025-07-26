package com.kmstimes.nexon.model.character.achievement;

import java.util.List;

/**
 * 메이플스토리 업적 정보 조회 응답을 담는 데이터 클래스입니다.
 *
 * @param account_list 메이플스토리 계정 목록
 */
public record AchievementResponse(
        List<AccountList> account_list
) {
}
