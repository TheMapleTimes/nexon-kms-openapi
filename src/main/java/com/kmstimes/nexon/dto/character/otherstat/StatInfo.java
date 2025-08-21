package com.kmstimes.nexon.dto.character.otherstat;

/**
 * 메이플스토리 스탯 정보를 담는 데이터 클래스입니다.
 *
 * @param stat_name  스탯 명
 * @param stat_value 스탯 값
 */
public record StatInfo(
        String stat_name,
        String stat_value
) {
}
