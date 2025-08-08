package com.kmstimes.nexon.dto.ranking.theseed;

/**
 * @param date                랭킹 업데이트 일자 (KST) (example: 2023-12-21T00:00+09:00)
 * @param ranking             종합 랭킹 순위
 * @param character_name      캐릭터 명
 * @param world_name          월드 명
 * @param class_name          직업 명
 * @param sub_class_name      전직 직업 명
 * @param character_level     캐릭터 레벨
 * @param theseed_floor       더 시드 도달 층
 * @param theseed_time_record 더 시드 클리어 시간 기록 (초 단위)
 */
public record TheseedRanking(
        String date,
        Long ranking,
        String character_name,
        String world_name,
        String class_name,
        String sub_class_name,
        Long character_level,
        Long theseed_floor,
        Long theseed_time_record
) {
}
