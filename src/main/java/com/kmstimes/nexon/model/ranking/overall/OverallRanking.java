package com.kmstimes.nexon.model.ranking.overall;

/**
 * 메이플스토리 종합 랭킹 정보를 담는 데이터 클래스입니다.
 *
 * @param date                 랭킹 업데이트 일자 (KST) (example: 2023-12-21T00:00+09:00)
 * @param ranking              종합 랭킹 순위
 * @param character_name       캐릭터 명
 * @param world_name           월드 명
 * @param class_name           직업 명
 * @param sub_class_name       전직 직업 명
 * @param character_level      캐릭터 레벨
 * @param character_exp        캐릭터 경험치
 * @param character_popularity 캐릭터 인기도
 * @param character_guildname  길드 명
 */
public record OverallRanking(
        String date,
        Long ranking,
        String character_name,
        String world_name,
        String class_name,
        String sub_class_name,
        Long character_level,
        Long character_exp,
        Long character_popularity,
        String character_guildname
) {
}