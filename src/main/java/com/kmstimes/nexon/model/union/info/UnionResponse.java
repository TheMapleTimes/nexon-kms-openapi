package com.kmstimes.nexon.model.union.info;

/**
 * 메이플스토리 유니온 정보 조회 응답을 담는 데이터 클래스입니다.
 *
 * @param date                 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
 *                             <p>
 *                             example: 2023-12-21T00:00+09:00
 * @param union_level          유니온 레벨
 * @param union_grade          유니온 등급
 * @param union_artifact_level 아티팩트 레벨
 * @param union_artifact_exp   보유 아티팩트 경험치
 * @param union_artifact_point 보유 아티팩트 포인트
 */
public record UnionResponse(
        String date,
        Long union_level,
        String union_grade,
        Long union_artifact_level,
        Long union_artifact_exp,
        Long union_artifact_point
) {
}
