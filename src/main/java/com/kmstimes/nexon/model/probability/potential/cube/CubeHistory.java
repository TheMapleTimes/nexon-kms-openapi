package com.kmstimes.nexon.model.probability.potential.cube;


import com.kmstimes.nexon.model.probability.potential.common.PotentialOption;

import java.util.List;

/**
 * 메이플스토리 큐브 사용 결과 정보를 담는 데이터 클래스입니다.
 * 
 * @param cube_type 사용 큐브
 * @param id 큐브 히스토리 식별자
 * @param character_name 캐릭터 명
 * @param date_create 사용 일시 (KST) (example: 2023-12-21T17:28:31.000+09:00)
 * @param item_upgrade_result 사용 결과
 * @param miracle_time_flag 미라클 타임 적용 여부
 * @param item_equipment_part 장비 분류
 * @param item_level 장비 레벨
 * @param target_item 큐브 사용한 장비
 * @param potential_option_grade 잠재능력 등급
 * @param additional_potential_option_grade 에디셔널 잠재능력 등급
 * @param upgrade_guarantee 천장에 도달하여 확정 등급 상승한 여부
 * @param upgrade_guarantee_count 현재까지 쌓은 스택
 * @param before_potential_option 사용 전 잠재능력 옵션
 * @param before_additional_potential_option 사용 전 에디셔널 잠재능력 옵션
 * @param after_potential_option 사용 후 잠재능력 옵션
 * @param after_additional_potential_option 사용 후 에디셔널 잠재능력 옵션
 */
public record CubeHistory(
        String cube_type,
        String id,
        String character_name,
        String date_create,
        String item_upgrade_result,
        String miracle_time_flag,
        String item_equipment_part,
        Long item_level,
        String target_item,
        String potential_option_grade,
        String additional_potential_option_grade,
        boolean upgrade_guarantee,
        Long upgrade_guarantee_count,
        List<PotentialOption> before_potential_option,
        List<PotentialOption> before_additional_potential_option,
        List<PotentialOption> after_potential_option,
        List<PotentialOption> after_additional_potential_option
) {
}
