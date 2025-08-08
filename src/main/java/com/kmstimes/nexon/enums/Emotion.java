package com.kmstimes.nexon.enums;

import com.kmstimes.nexon.api.dto.CharacterApi;
import com.kmstimes.nexon.dto.character.basic.BasicResponse;

import java.time.LocalDate;

/**
 * 메이플스토리 캐릭터의 다양한 감정 표현을 정의하는 열거형입니다.
 * 각 감정은 고유한 코드와 애니메이션 프레임 범위를 가지고 있습니다.
 * <ul>
 * <li>조회된 캐릭터 외형 이미지 URL에 쿼리 파리미터를 사용하여 캐릭터 이미지의 동작이나 감정표현을 변경하실 수 있습니다.</li>
 * <li>쿼리 파라미터는 API로 조회된 URL 뒤에 물음표(?)와 "Key=value" 쌍을 입력하여 조회합니다.</li>
 * <li>여러 개의 쿼리 파라미터를 전달하려면 파라미터 사이에 앰퍼샌드(&amp;)을 추가하여 하나의 문자열로 입력합니다.</li>
 * <li>액션 및 감정표현에 프레임 값("Key=value.number")을 입력하여 아바타 이미지를 프레임 별로 조회 가능합니다. (20250116 추가)</li>
 * <li>예시: https://open.api.nexon.com/static/maplestory/character/look/ABCDEFG?action=A00.2&amp;emotion=E00&amp;width=200&amp;height=200</li>
 * </ul>
 * <p>
 * 이 열거형은 {@link CharacterApi#getCharacterBasic(String, LocalDate)} 에서 얻은
 * {@link BasicResponse#character_image} 를 사용하여 동작을 변경합니다.
 */
public enum Emotion {
    /**
     * DEFAULT frame: 0~0
     */
    DEFAULT("E00", 0, 0),
    /**
     * WINK frame: 0~0
     */
    WINK("E01", 0, 0),
    /**
     * SMILE frame: 0~0
     */
    SMILE("E02", 0, 0),
    /**
     * CRY frame: 0~0
     */
    CRY("E03", 0, 0),
    /**
     * ANGRY frame: 0~0
     */
    ANGRY("E04", 0, 0),
    /**
     * BEWILDERED frame: 0~0
     */
    BEWILDERED("E05", 0, 0),
    /**
     * BLINK frame: 0~2
     */
    BLINK("E06", 0, 2),
    /**
     * BLAZE frame: 0~1
     */
    BLAZE("E07", 0, 1),
    /**
     * BOWING frame: 0~1
     */
    BOWING("E08", 0, 1),
    /**
     * CHEERS frame: 0~0
     */
    CHEERS("E09", 0, 0),
    /**
     * CHU frame: 0~0
     */
    CHU("E10", 0, 0),
    /**
     * DAM frame: 0~1
     */
    DAM("E11", 0, 1),
    /**
     * DESPAIR frame: 0~1
     */
    DESPAIR("E12", 0, 1),
    /**
     * GLITTER frame: 0~1
     */
    GLITTER("E13", 0, 1),
    /**
     * HIT frame: 0~0
     */
    HIT("E14", 0, 0),
    /**
     * HOT frame: 0~1
     */
    HOT("E15", 0, 1),
    /**
     * HUM frame: 0~1
     */
    HUM("E16", 0, 1),
    /**
     * LOVE frame: 0~1
     */
    LOVE("E17", 0, 1),
    /**
     * OOPS frame: 0~0
     */
    OOPS("E18", 0, 0),
    /**
     * PAIN frame: 0~0
     */
    PAIN("E19", 0, 0),
    /**
     * TROUBLED frame: 0~0
     */
    TROUBLED("E20", 0, 0),
    /**
     * Q_BLUE frame: 0~0
     */
    Q_BLUE("E21", 0, 0),
    /**
     * SHINE frame: 0~0
     */
    SHINE("E22", 0, 0),
    /**
     * STUNNED frame: 0~0
     */
    STUNNED("E23", 0, 0),
    /**
     * VOMIT frame: 0~1
     */
    VOMIT("E24", 0, 1);

    /**
     * 감정 표현 코드
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
     * Emotion 열거형 생성자
     *
     * @param code       감정을 식별하는 고유 코드
     * @param frameStart 애니메이션 시작 프레임 번호
     * @param frameEnd   애니메이션 종료 프레임 번호
     */
    Emotion(String code, int frameStart, int frameEnd) {
        this.code = code;
        this.frameStart = frameStart;
        this.frameEnd = frameEnd;
    }

    /**
     * 감정 표현의 고유 코드를 반환합니다.
     *
     * @return 감정 코드 (예: "E00", "E01")
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
