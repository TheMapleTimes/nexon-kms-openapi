package com.kmstimes.nexon.model.character.achievement;

/**
 * 메이플스토리 달성 업적 정보를 담는 데이터 클래스입니다.
 *
 * @param achievement_name        업적 명
 * @param achievement_description 업적 설명
 */
public record AchievementAchieve(
        String achievement_name,
        String achievement_description
) {
}
