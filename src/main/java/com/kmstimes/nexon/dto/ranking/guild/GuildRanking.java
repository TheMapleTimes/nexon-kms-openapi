package com.kmstimes.nexon.dto.ranking.guild;

/**
 * 메이플스토리 길드 랭킹 정보를 담는 데이터 클래스입니다.
 *
 * @param date              랭킹 업데이트 일자 (KST) (example: 2023-12-21T00:00+09:00)
 * @param ranking           종합 랭킹 순위
 * @param guild_name        길드 명
 * @param world_name        월드 명
 * @param guild_level       길드 레벨
 * @param guild_master_name 길드 마스터 캐릭터 명
 * @param guild_mark        길드 마크
 * @param guild_point       길드 포인트
 */
public record GuildRanking(
        String date,
        Long ranking,
        String guild_name,
        String world_name,
        Long guild_level,
        String guild_master_name,
        String guild_mark,
        Long guild_point
) {
}
