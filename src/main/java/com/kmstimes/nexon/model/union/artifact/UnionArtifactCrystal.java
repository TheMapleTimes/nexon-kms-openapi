package com.kmstimes.nexon.model.union.artifact;

/**
 * 메이플스토리 아티팩트 크리스탈 정보를 담는 데이터 클래스입니다.
 *
 * @param name                  아티팩트 크리스탈 명
 * @param validity_flag         능력치 유효 여부 (0:유효, 1:유효하지 않음)
 * @param date_expire           능력치 유효 기간 (expired:만료, null:무제한) (KST)
 *                              <p>
 *                              example: 2023-12-21T17:28+09:00
 * @param level                 아티팩트 크리스탈 등급
 * @param crystal_option_name_1 아티팩트 크리스탈 첫 번째 옵션 명
 * @param crystal_option_name_2 아티팩트 크리스탈 두 번째 옵션 명
 * @param crystal_option_name_3 아티팩트 크리스탈 세 번째 옵션 명
 */
public record UnionArtifactCrystal(
        String name,
        String validity_flag,
        String date_expire,
        Long level,
        String crystal_option_name_1,
        String crystal_option_name_2,
        String crystal_option_name_3
) {
}
