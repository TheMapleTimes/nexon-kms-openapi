package com.kmstimes.nexon.dto.character.equipment.symbol;

/**
 * 메이플스토리 심볼 정보를 담는 데이터 클래스입니다.
 *
 * @param symbol_name                 심볼 명
 * @param symbol_icon                 심볼 아이콘
 * @param symbol_description          심볼 설명
 * @param symbol_force                심볼로 인한 증가 수치
 * @param symbol_level                심볼 레벨
 * @param symbol_str                  심볼로 증가한 힘
 * @param symbol_dex                  심볼로 증가한 민첩
 * @param symbol_int                  심볼로 증가한 지력
 * @param symbol_luk                  심볼로 증가한 운
 * @param symbol_hp                   심볼로 증가한 체력
 * @param symbol_drop_rate            심볼로 증가한 아이템 드롭률
 * @param symbol_meso_rate            심볼로 증가한 메소 획득량
 * @param symbol_exp_rate             심볼로 증가한 경험치 획득량
 * @param symbol_growth_count         현재 보유 성장치
 * @param symbol_require_growth_count 성장 시 필요한 성장치
 */
public record Symbol(
        String symbol_name,
        String symbol_icon,
        String symbol_description,
        String symbol_force,
        Long symbol_level,
        String symbol_str,
        String symbol_dex,
        String symbol_int,
        String symbol_luk,
        String symbol_hp,
        String symbol_drop_rate,
        String symbol_meso_rate,
        String symbol_exp_rate,
        Long symbol_growth_count,
        Long symbol_require_growth_count
) {
}
