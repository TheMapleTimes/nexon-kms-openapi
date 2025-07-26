package com.kmstimes.nexon.model.character.list;

import java.util.List;

/**
 * 메이플스토리 계정 목록을 담는 데이터 클래스입니다.
 *
 * @param account_id     메이플스토리 계정 식별자
 * @param character_list 캐릭터 목록
 */
public record Account(
        String account_id,
        List<CList> character_list
) {
}
