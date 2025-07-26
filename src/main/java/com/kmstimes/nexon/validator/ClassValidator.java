package com.kmstimes.nexon.validator;

import com.kmstimes.nexon.enums.ClassName;

public class ClassValidator {

    /**
     * 클래스 명이 사용 가능한 값인지 확인합니다.
     *
     * @param className 검증할 클래스 명
     * @throws IllegalArgumentException 형식이 잘못된 경우 예외 발생
     */
    public static void validate(String className) {
        if (className == null || className.trim().isEmpty()) {
            return;
        }
        
        for (ClassName name : ClassName.values()) {
            if (name.getClassName().equals(className)) {
                return;
            }
        }
        throw new IllegalArgumentException(className + "은 잘못된 클래스 명 입니다");
    }
}
