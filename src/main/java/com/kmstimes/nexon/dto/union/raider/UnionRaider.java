package com.kmstimes.nexon.dto.union.raider;

import java.util.List;

/**
 * 메이플스토리 유니온 프리셋 정보를 담는 데이터 클래스입니다.
 *
 * @param union_raider_stat   유니온 공격대원 효과
 * @param union_occupied_stat 유니온 공격대 점령 효과
 * @param union_inner_stat    유니온 공격대 배치
 * @param union_block         유니온 블록 정보
 */
public record UnionRaider(
        List<String> union_raider_stat,
        List<String> union_occupied_stat,
        List<UnionInnerStat> union_inner_stat,
        List<UnionBlock> union_block
) {
}
