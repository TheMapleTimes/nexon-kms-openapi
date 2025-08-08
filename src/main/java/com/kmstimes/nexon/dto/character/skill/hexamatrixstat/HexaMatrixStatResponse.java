package com.kmstimes.nexon.dto.character.skill.hexamatrixstat;

import java.util.List;

/**
 * 메이플스토리 HEXA 매트릭스 설정 HEXA 스탯 정보 조회 응답을 담는 데이터 클래스입니다.
 *
 * @param date                       조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
 *                                   <p>
 *                                   example: 2023-12-21T00:00+09:00
 * @param character_class            캐릭터 직업
 * @param character_hexa_stat_core   HEXA 스탯 I 코어 정보
 * @param character_hexa_stat_core_2 HEXA 스탯 II 코어 정보
 * @param character_hexa_stat_core_3 HEXA 스탯 III 코어 정보
 * @param preset_hexa_stat_core      프리셋 HEXA 스탯 I 코어 정보
 * @param preset_hexa_stat_core_2    프리셋 HEXA 스탯 II 코어 정보
 * @param preset_hexa_stat_core_3    프리셋 HEXA 스탯 III 코어 정보
 */
public record HexaMatrixStatResponse(
        String date,
        String character_class,
        List<HexaStat> character_hexa_stat_core,
        List<HexaStat> character_hexa_stat_core_2,
        List<HexaStat> character_hexa_stat_core_3,
        List<HexaStat> preset_hexa_stat_core,
        List<HexaStat> preset_hexa_stat_core_2,
        List<HexaStat> preset_hexa_stat_core_3
) {
}
