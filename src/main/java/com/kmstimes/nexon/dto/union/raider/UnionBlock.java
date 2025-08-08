package com.kmstimes.nexon.dto.union.raider;

import java.util.List;

/**
 * 메이플스토리 유니온 블록 정보를 담는 데이터 클래스입니다.
 *
 * @param block_type          블록 모양 (전사, 마법사, 궁수, 도적, 해적, 메이플m, 하이브리드)
 * @param block_class         블록 해당 캐릭터 직업
 * @param block_level         블록 해당 캐릭터 레벨
 * @param block_control_point 블록 기준점 좌표
 * @param block_position      블록이 차지하고 있는 영역 좌표들 (null:미 배치 시)
 */
public record UnionBlock(
        String block_type,
        String block_class,
        String block_level,
        BlockPoint block_control_point,
        List<BlockPoint> block_position
) {
}
