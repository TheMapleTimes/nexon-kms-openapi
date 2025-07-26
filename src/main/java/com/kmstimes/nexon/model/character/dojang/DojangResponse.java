package com.kmstimes.nexon.model.character.dojang;

/**
 * 메이플스토리 무릉도장 최고 기록 정보 조회 응답을 담는 데이터 클래스입니다.
 *
 * @param date               조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
 *                           <p>
 *                           example: 2023-12-21T00:00+09:00
 * @param character_class    캐릭터 직업
 * @param world_name         월드 명
 * @param dojang_best_floor  무릉도장 최고 기록 층수
 * @param date_dojang_record 무릉도장 최고 기록 달성 일
 *                           <p>
 *                           (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
 *                           <p>
 *                           example: 2023-12-21T00:00+09:00
 * @param dojang_best_time   무릉도장 최고 층수 클리어에 걸린 시간 (초)
 */
public record DojangResponse(
        String date,
        String character_class,
        String world_name,
        Long dojang_best_floor,
        String date_dojang_record,
        Long dojang_best_time
) {
}
