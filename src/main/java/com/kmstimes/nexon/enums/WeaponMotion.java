package com.kmstimes.nexon.enums;

import com.kmstimes.nexon.api.dto.CharacterApi;
import com.kmstimes.nexon.dto.character.basic.BasicResponse;

import java.time.LocalDate;

/**
 * 메이플스토리에서 사용되는 무기의 모션 타입을 정의하는 열거형입니다.
 * 각 무기 타입에 따른 고유한 모션 코드를 제공합니다.
 * <ul>
 * <li>조회된 캐릭터 외형 이미지 URL에 쿼리 파리미터를 사용하여 캐릭터 이미지의 동작이나 감정표현을 변경하실 수 있습니다.</li>
 * <li>쿼리 파라미터는 API로 조회된 URL 뒤에 물음표(?)와 "Key=value" 쌍을 입력하여 조회합니다.</li>
 * <li>여러 개의 쿼리 파라미터를 전달하려면 파라미터 사이에 앰퍼샌드(&amp;)을 추가하여 하나의 문자열로 입력합니다.</li>
 * <li>액션 및 감정표현에 프레임 값("Key=value.number")을 입력하여 아바타 이미지를 프레임 별로 조회 가능합니다. (20250116 추가)</li>
 * <li>예시: https://open.api.nexon.com/static/maplestory/character/look/ABCDEFG?action=A00.2&amp;emotion=E00</li>
 * </ul>
 * <p>
 * 이 열거형은 {@link CharacterApi#getCharacterBasic(String, LocalDate)} 에서 얻은
 * {@link BasicResponse#character_image} 를 사용하여 동작을 변경합니다.
 */
public enum WeaponMotion {
    /**
     * 기본 무기 모션 (default, 무기 타입에 따른 모션)
     */
    DEFAULT("W00"),
    /**
     * 한손 무기 모션
     */
    ONE_HAND("W01"),
    /**
     * 두손 무기 모션
     */
    TWO_HAND("W02"),
    /**
     * 총 무기 모션
     */
    GUN("W03"),
    /**
     * 무기 제외
     */
    NONE("W04");

    /**
     * 무기 모션 코드
     */
    private final String code;

    /**
     * WeaponMotion 열거형 생성자
     *
     * @param code 무기 모션을 식별하는 고유 코드
     */
    WeaponMotion(String code) {
        this.code = code;
    }

    /**
     * 무기 모션의 고유 코드를 반환합니다.
     *
     * @return 모션 코드 (예: "W00", "W01")
     */
    public String getCode() {
        return code;
    }
}
