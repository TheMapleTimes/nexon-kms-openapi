package com.kmstimes.nexon.enums;

import com.kmstimes.nexon.model.character.basic.BasicResponse;

import java.time.LocalDate;

/**
 * 메이플스토리 캐릭터의 다양한 액션 상태를 정의하는 열거형입니다.
 * 각 액션은 고유한 코드와 프레임 범위를 가지고 있습니다.
 * <ul>
 * <li>조회된 캐릭터 외형 이미지 URL에 쿼리 파리미터를 사용하여 캐릭터 이미지의 동작이나 감정표현을 변경하실 수 있습니다.</li>
 * <li>쿼리 파라미터는 API로 조회된 URL 뒤에 물음표(?)와 "Key=value" 쌍을 입력하여 조회합니다.</li>
 * <li>여러 개의 쿼리 파라미터를 전달하려면 파라미터 사이에 앰퍼샌드(&amp;)을 추가하여 하나의 문자열로 입력합니다.</li>
 * <li>액션 및 감정표현에 프레임 값("Key=value.number")을 입력하여 아바타 이미지를 프레임 별로 조회 가능합니다. (20250116 추가)</li>
 * <li>예시: https://open.api.nexon.com/static/maplestory/character/look/ABCDEFG?action=A00.2&amp;emotion=E00&amp;width=200&amp;height=200</li>
 * </ul>
 * <p>
 * 이 열거형은 {@link com.kmstimes.nexon.api.CharacterApi#getCharacterBasic(String, LocalDate)} 에서 얻은
 * {@link BasicResponse#character_image} 를 사용하여 동작을 변경합니다.
 */
public enum Action {
    /**
     * STAND1 frame: 0~2
     */
    STAND1("A00", 0, 2),
    /**
     * STAND2 frame: 0~2
     */
    STAND2("A01", 0, 2),
    /**
     * WALK1 frame: 0~3
     */
    WALK1("A02", 0, 3),
    /**
     * WALK2 frame: 0~3
     */
    WALK2("A03", 0, 3),
    /**
     * PRONE frame: 0~0
     */
    PRONE("A04", 0, 0),
    /**
     * FLY frame: 0~1
     */
    FLY("A05", 0, 1),
    /**
     * JUMP frame: 0~0
     */
    JUMP("A06", 0, 0),
    /**
     * SIT frame: 0~0
     */
    SIT("A07", 0, 0),
    /**
     * LADDER frame: 0~1
     */
    LADDER("A08", 0, 1),
    /**
     * ROPE frame: 0~1
     */
    ROPE("A09", 0, 1),
    /**
     * HEAL frame: 0~2
     */
    HEAL("A10", 0, 2),
    /**
     * ALERT frame: 0~2
     */
    ALERT("A11", 0, 2),
    /**
     * PRONE_STAB frame: 0~1
     */
    PRONE_STAB("A12", 0, 1),
    /**
     * SWING_O1 frame: 0~2
     */
    SWING_O1("A13", 0, 2),
    /**
     * SWING_O2 frame: 0~2
     */
    SWING_O2("A14", 0, 2),
    /**
     * SWING_O3 frame: 0~2
     */
    SWING_O3("A15", 0, 2),
    /**
     * SWING_OF frame: 0~3
     */
    SWING_OF("A16", 0, 3),
    /**
     * SWING_P1 frame: 0~2
     */
    SWING_P1("A17", 0, 2),
    /**
     * SWING_P2 frame: 0~2
     */
    SWING_P2("A18", 0, 2),
    /**
     * SWING_PF frame: 0~3
     */
    SWING_PF("A19", 0, 3),
    /**
     * SWING_T1 frame: 0~2
     */
    SWING_T1("A20", 0, 2),
    /**
     * SWING_T2 frame: 0~2
     */
    SWING_T2("A21", 0, 2),
    /**
     * SWING_T3 frame: 0~2
     */
    SWING_T3("A22", 0, 2),
    /**
     * SWING_TF frame: 0~3
     */
    SWING_TF("A23", 0, 3),
    /**
     * STAB_O1 frame: 0~1
     */
    STAB_O1("A24", 0, 1),
    /**
     * STAB_O2 frame: 0~1
     */
    STAB_O2("A25", 0, 1),
    /**
     * STAB_OF frame: 0~2
     */
    STAB_OF("A26", 0, 2),
    /**
     * STAB_T1 frame: 0~2
     */
    STAB_T1("A27", 0, 2),
    /**
     * STAB_T2 frame: 0~2
     */
    STAB_T2("A28", 0, 2),
    /**
     * STAB_TF frame: 0~3
     */
    STAB_TF("A29", 0, 3),
    /**
     * SHOOT1 frame: 0~2
     */
    SHOOT1("A30", 0, 2),
    /**
     * SHOOT2 frame: 0~4
     */
    SHOOT2("A31", 0, 4),
    /**
     * SHOOT_F frame: 0~2
     */
    SHOOT_F("A32", 0, 2),
    /**
     * DEAD frame: 0~0
     */
    DEAD("A33", 0, 0),
    /**
     * GHOSTWALK frame: 0~3
     */
    GHOSTWALK("A34", 0, 3),
    /**
     * GHOSTSTAND frame: 0~2
     */
    GHOSTSTAND("A35", 0, 2),
    /**
     * GHOSTJUMP frame: 0~0
     */
    GHOSTJUMP("A36", 0, 0),
    /**
     * GHOSTPRONE_STAB frame: 0~1
     */
    GHOSTPRONE_STAB("A37", 0, 1),
    /**
     * GHOSTLADDER frame: 0~1
     */
    GHOSTLADDER("A38", 0, 1),
    /**
     * GHOSTROPE frame: 0~1
     */
    GHOSTROPE("A39", 0, 1),
    /**
     * GHOSTFLY frame: 0~1
     */
    GHOSTFLY("A40", 0, 1),
    /**
     * GHOSTSIT frame: 0~0
     */
    GHOSTSIT("A41", 0, 0);

    /**
     * 액션 코드
     */
    private final String code;

    /**
     * 애니메이션 시작 프레임
     */
    private final int frameStart;

    /**
     * 애니메이션 종료 프레임
     */
    private final int frameEnd;

    /**
     * Action 열거형 생성자
     *
     * @param code       액션을 식별하는 고유 코드
     * @param frameStart 애니메이션 시작 프레임 번호
     * @param frameEnd   애니메이션 종료 프레임 번호
     */
    Action(String code, int frameStart, int frameEnd) {
        this.code = code;
        this.frameStart = frameStart;
        this.frameEnd = frameEnd;
    }

    /**
     * 액션의 고유 코드를 반환합니다.
     *
     * @return 액션 코드 (예: "A00", "A01")
     */
    public String getCode() {
        return code;
    }

    /**
     * 애니메이션 시작 프레임 번호를 반환합니다.
     *
     * @return 시작 프레임 번호
     */
    public int getFrameStart() {
        return frameStart;
    }

    /**
     * 애니메이션 종료 프레임 번호를 반환합니다.
     *
     * @return 종료 프레임 번호
     */
    public int getFrameEnd() {
        return frameEnd;
    }
}
