package com.kmstimes.nexon.model.ranking.achievement;

/**
 * 메이플스토리 업적 랭킹 정보를 담는 데이터 클래스입니다.
 * 
 * @param date           랭킹 업데이트 일자 (KST) (example: 2023-12-21T00:00+09:00)
 * @param ranking        종합 랭킹 순위
 * @param character_name 캐릭터 명
 * @param world_name     월드 명
 * @param class_name     직업 명
 * @param sub_class_name 전직 직업 명
 * @param trophy_grade   업적 등급
 * @param trophy_score   업적 점수
 */
public record AchievementRanking(
        String date,
        Long ranking,
        String character_name,
        String world_name,
        String class_name,
        String sub_class_name,
        String trophy_grade,
        Long trophy_score
) {
}
