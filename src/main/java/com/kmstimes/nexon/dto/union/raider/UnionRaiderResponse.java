package com.kmstimes.nexon.dto.union.raider;

import java.util.List;

/**
 * 메이플스토리 유니온 공격대 정보 조회 응답을 담는 데이터 클래스입니다.
 *
 * @param date                  조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
 *                              <p>
 *                              example: 2023-12-21T00:00+09:00
 * @param union_raider_stat     유니온 공격대원 효과
 * @param union_occupied_stat   유니온 공격대 점령 효과
 * @param union_inner_stat      유니온 공격대 배치
 * @param union_block           유니온 블록 정보
 * @param use_preset_no         적용 중인 프리셋 번호
 * @param union_raider_preset_1 유니온 프리셋 1번 정보
 * @param union_raider_preset_2 유니온 프리셋 2번 정보
 * @param union_raider_preset_3 유니온 프리셋 3번 정보
 * @param union_raider_preset_4 유니온 프리셋 4번 정보
 * @param union_raider_preset_5 유니온 프리셋 5번 정보
 */
public record UnionRaiderResponse(
        String date,
        List<String> union_raider_stat,
        List<String> union_occupied_stat,
        List<UnionInnerStat> union_inner_stat,
        List<UnionBlock> union_block,
        Long use_preset_no,
        UnionRaider union_raider_preset_1,
        UnionRaider union_raider_preset_2,
        UnionRaider union_raider_preset_3,
        UnionRaider union_raider_preset_4,
        UnionRaider union_raider_preset_5
) {
}
