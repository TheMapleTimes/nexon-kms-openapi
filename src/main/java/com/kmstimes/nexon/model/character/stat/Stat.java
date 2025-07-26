package com.kmstimes.nexon.model.character.stat;

/**
 * 메이플스토리 현재 스탯 정보를 담는 데이터 클래스입니다.
 *
 * @param stat_name  스탯 명 (example: 최소 스탯 공격력)
 * @param stat_value 스탯 값 (example: 43.75)
 */
public record Stat(
        String stat_name,
        String stat_value
) {
}
