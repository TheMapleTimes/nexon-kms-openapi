package com.kmstimes.nexon.dto.character.skill.vmatrix;

import java.util.List;

/**
 * 메이플스토리 V매트릭스 정보 조회 응답을 담는 데이터 클래스입니다.
 *
 * @param date                                         조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
 *                                                     <p>
 *                                                     example: 2023-12-21T00:00+09:00
 * @param character_class                              캐릭터 직업
 * @param character_v_core_equipment                   V코어 정보
 * @param character_v_matrix_remain_slot_upgrade_point 캐릭터 잔여 매트릭스 강화 포인트
 */
public record VMatrixResponse(
        String date,
        String character_class,
        List<VCore> character_v_core_equipment,
        Long character_v_matrix_remain_slot_upgrade_point
) {
}
