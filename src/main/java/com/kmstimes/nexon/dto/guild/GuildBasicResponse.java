package com.kmstimes.nexon.dto.guild;

import java.util.List;

/**
 * 메이플스토리 길드 기본 정보 조회 응답을 담는 데이터 클래스입니다.
 *
 * @param date                 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
 *                             <p>
 *                             (example: 2023-12-21T00:00+09:00)
 * @param world_name           월드 명
 * @param guild_name           길드 명
 * @param guild_level          길드 레벨
 * @param guild_fame           길드 명성치
 * @param guild_point          길드 포인트(GP)
 * @param guild_master_name    길드 마스터 캐릭터 명
 * @param guild_member_count   길드원 수
 * @param guild_member         길드원 목록
 * @param guild_skill          길드 스킬 목록
 * @param guild_noblesse_skill 노블레스 스킬 목록
 */
public record GuildBasicResponse(
        String date,
        String world_name,
        String guild_name,
        Long guild_level,
        Long guild_fame,
        Long guild_point,
        String guild_master_name,
        Long guild_member_count,
        List<String> guild_member,
        List<GuildSkill> guild_skill,
        List<GuildSkill> guild_noblesse_skill
) {
}
