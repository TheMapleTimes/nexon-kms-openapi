package com.kmstimes.nexon.dto.character.ability;

import java.util.List;

/**
 * 메이플스토리 어빌리티 정보 조회 응답을 담는 데이터 클래스입니다.
 *
 * @param date             조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
 *                         <p>
 *                         example: 2023-12-21T00:00+09:00
 * @param ability_grade    어빌리티 등급
 * @param ability_info     어빌리티 정보
 * @param remain_fame      보유 명성치
 * @param preset_no        적용 중인 어빌리티 프리셋 번호(number)
 * @param ability_preset_1 어빌리티 1번 프리셋 전체 정보
 * @param ability_preset_2 어빌리티 2번 프리셋 전체 정보
 * @param ability_preset_3 어빌리티 3번 프리셋 전체 정보
 */
public record AbilityResponse(
        String date,
        String ability_grade,
        List<Ability> ability_info,
        Long remain_fame,
        Long preset_no,
        AbilityInfo ability_preset_1,
        AbilityInfo ability_preset_2,
        AbilityInfo ability_preset_3
) {
}
