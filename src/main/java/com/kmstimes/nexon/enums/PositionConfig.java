package com.kmstimes.nexon.enums;

import com.kmstimes.nexon.model.character.basic.BasicResponse;

import java.time.LocalDate;

/**
 * 캐릭터나 오브젝트의 위치와 크기를 설정하기 위한 불변 레코드입니다.
 * 모든 값은 생성 시 유효성 검사를 통과해야 합니다.
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
 *
 * @param width  가로 크기 (96-1000 사이)
 * @param height 세로 크기 (96-1000 사이)
 * @param x      X 좌표 (0 초과, width 미만)
 * @param y      Y 좌표 (0 초과, height 미만)
 */
public record PositionConfig(int width, int height, int x, int y) {

    /**
     * 캐릭터나 오브젝트의 위치와 크기를 설정하기 위한 불변 레코드입니다.
     * 모든 값은 생성 시 유효성 검사를 통과해야 합니다.
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
     *
     * @param width  가로 크기 (96-1000 사이)
     * @param height 세로 크기 (96-1000 사이)
     * @param x      X 좌표 (0 초과, width 미만)
     * @param y      Y 좌표 (0 초과, height 미만)
     * @throws IllegalArgumentException 가로 혹은 세로의 크기가 96-1000 사이가 아닌 경우
     *                                  <p>
     *                                  또는 Y X 좌표가 0초과, 크기 미만이 아닌 경우
     */
    public PositionConfig {
        if (width < 96 || width > 1000) {
            throw new IllegalArgumentException("가로 크기 (96-1000 사이)");
        }
        if (height < 96 || height > 1000) {
            throw new IllegalArgumentException("세로 크기 (96-1000 사이)");
        }
        if (x <= 0 || x >= width) {
            throw new IllegalArgumentException("X 좌표 (0 초과, width 미만)");
        }
        if (y <= 0 || y >= height) {
            throw new IllegalArgumentException("Y 좌표 (0 초과, height 미만)");
        }
    }
}