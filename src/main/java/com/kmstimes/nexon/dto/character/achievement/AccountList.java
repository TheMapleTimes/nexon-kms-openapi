package com.kmstimes.nexon.dto.character.achievement;

import java.util.List;

/**
 * 메이플스토리 계정 업적 정보를 담는 데이터 클래스입니다.
 *
 * @param account_id          메이플스토리 계정 식별자
 * @param achievement_achieve 달성 업적 정보
 */
public record AccountList(
        String account_id,
        List<AchievementAchieve> achievement_achieve
) {
}
