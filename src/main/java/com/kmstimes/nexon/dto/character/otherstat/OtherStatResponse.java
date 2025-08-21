package com.kmstimes.nexon.dto.character.otherstat;

import java.util.List;

/**
 * 메이플스토리 기타 능력치 영향 요소 정보 조회 응답을 담는 데이터 클래스입니다.
 *
 * @param date       조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
 *                   <p>
 *                   example: 2023-12-21T00:00+09:00
 * @param other_stat 능력치에 영향을 주는 요소 및 스탯 정보
 */
public record OtherStatResponse(
        String date,
        List<OtherStat> other_stat
) {
}
