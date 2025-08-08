package com.kmstimes.nexon.dto.character.stat;

import java.util.List;

/**
 * 메이플스토리 종합 능력치 정보 조회 응답을 담는 데이터 클래스입니다.
 *
 * @param date            조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
 *                        <p>
 *                        example: 2023-12-21T00:00+09:00
 * @param character_class 캐릭터 직업
 * @param final_stat      현재 스탯 정보
 * @param remain_ap       잔여 AP
 */
public record StatResponse(
        String date,
        String character_class,
        List<Stat> final_stat,
        Long remain_ap
) {
}
