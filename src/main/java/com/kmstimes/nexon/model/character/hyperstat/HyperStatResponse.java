package com.kmstimes.nexon.model.character.hyperstat;

import java.util.List;

/**
 * 메이플스토리 하이퍼스탯 정보 조회 응답을 담는 데이터 클래스입니다.
 *
 * @param date                             조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
 *                                         <p>
 *                                         example: 2023-12-21T00:00+09:00
 * @param character_class                  캐릭터 직업
 * @param use_preset_no                    적용 중인 프리셋 번호
 * @param use_available_hyper_stat         사용 가능한 최대 하이퍼스탯 포인트
 * @param hyper_stat_preset_1              1번 프리셋 하이퍼 스탯 정보
 * @param hyper_stat_preset_1_remain_point 1번 프리셋 하이퍼 스탯 잔여 포인트
 * @param hyper_stat_preset_2              2번 프리셋 하이퍼 스탯 정보
 * @param hyper_stat_preset_2_remain_point 2번 프리셋 하이퍼 스탯 잔여 포인트
 * @param hyper_stat_preset_3              3번 프리셋 하이퍼 스탯 정보
 * @param hyper_stat_preset_3_remain_point 3번 프리셋 하이퍼 스탯 잔여 포인트
 */
public record HyperStatResponse(
        String date,
        String character_class,
        String use_preset_no,
        Long use_available_hyper_stat,
        List<HyperStat> hyper_stat_preset_1,
        Long hyper_stat_preset_1_remain_point,
        List<HyperStat> hyper_stat_preset_2,
        Long hyper_stat_preset_2_remain_point,
        List<HyperStat> hyper_stat_preset_3,
        Long hyper_stat_preset_3_remain_point
) {
}
