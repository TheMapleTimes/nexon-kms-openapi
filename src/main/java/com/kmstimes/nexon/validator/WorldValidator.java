package com.kmstimes.nexon.validator;

import com.kmstimes.nexon.enums.WorldName;

public class WorldValidator {

    /**
     * 월드 명이 사용 가능한 값인지 확인합니다.
     *
     * @param worldName 월드 명
     * @throws IllegalArgumentException 형식이 잘못된 경우 예외 발생
     */
    public static void validate(String worldName) {
        if (worldName == null || worldName.trim().isEmpty()) {
            return;
        }

        for (WorldName world : WorldName.values()) {
            if (world.getWorldName().equals(worldName)) {
                return;
            }
        }
        throw new IllegalArgumentException(worldName + "은 잘못된 월드 명 입니다");
    }
}
