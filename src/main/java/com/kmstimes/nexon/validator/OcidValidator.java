package com.kmstimes.nexon.validator;

public class OcidValidator {

    /**
     * 캐릭터 식별자가 유효한 값인지 확인합니다.
     *
     * @param ocid 캐릭터 식별자
     * @throws IllegalArgumentException 형식이 잘못된 경우 예외 발생
     */
    public static void validate(String ocid) {
        if (ocid == null || ocid.trim().isEmpty()) {
            throw new IllegalArgumentException("Ocid는 null 이거나 비어 있을 수 없습니다.");
        }
    }
}
