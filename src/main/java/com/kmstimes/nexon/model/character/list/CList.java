package com.kmstimes.nexon.model.character.list;

/**
 * 메이플스토리 캐릭터 목록을 담는 데이터 클래스입니다.
 *
 * @param ocid            캐릭터 식별자
 * @param character_name  캐릭터 명
 * @param world_name      월드 명
 * @param character_class 캐릭터 직업
 * @param character_level 캐릭터 레벨
 */
public record CList(
        String ocid,
        String character_name,
        String world_name,
        String character_class,
        Long character_level
) {
}
