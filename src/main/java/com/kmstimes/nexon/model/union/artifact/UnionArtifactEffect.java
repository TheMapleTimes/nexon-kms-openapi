package com.kmstimes.nexon.model.union.artifact;

/**
 * 메이플스토리 아티팩트 효과 정보를 담는 데이터 클래스입니다.
 *
 * @param name  아티팩트 효과 명
 * @param level 아티팩트 효과 레벨
 */
public record UnionArtifactEffect(
        String name,
        Long level
) {
}
