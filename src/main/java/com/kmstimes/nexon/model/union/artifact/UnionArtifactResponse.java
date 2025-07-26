package com.kmstimes.nexon.model.union.artifact;

import java.util.List;

/**
 * 메이플스토리 유니온 아티팩트 정보 조회 응답을 담는 데이터 클래스입니다.
 *
 * @param date                     조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
 *                                 <p>
 *                                 example: 2023-12-21T00:00+09:00
 * @param union_artifact_effect    아티팩트 효과 정보
 * @param union_artifact_crystal   아티팩트 크리스탈 정보
 * @param union_artifact_remain_ap 잔여 아티팩트 AP
 */
public record UnionArtifactResponse(
        String date,
        List<UnionArtifactEffect> union_artifact_effect,
        List<UnionArtifactCrystal> union_artifact_crystal,
        Long union_artifact_remain_ap
) {
}
