package com.kmstimes.nexon.dto.probability.potential.common;

/**
 * 메이플스토리 잠재능력 옵션 정보를 담는 데이터 클래스입니다.
 *
 * @param value 옵션 명
 * @param grade 옵션 등급
 */
public record PotentialOption(
        String value,
        String grade
) {
}
