package com.kmstimes.nexon.validator;

import com.kmstimes.nexon.enums.SkillGrade;

/**
 * 전직 차수가 사용 가능한 값인지 확인합니다.
 */
public class GradeValidator {

    /**
     * 전직 차수가 사용 가능한 값인지 확인합니다.
     *
     * @param skillGrade 전직 차수
     * @throws IllegalArgumentException 형식이 잘못된 경우 예외 발생
     */
    public static void validate(String skillGrade) {
        if (skillGrade == null || skillGrade.trim().isEmpty()) {
            return;
        }

        for (SkillGrade name : SkillGrade.values()) {
            if (name.getGrade().equals(skillGrade)) {
                return;
            }
        }
        throw new IllegalArgumentException(skillGrade + "은 잘못된 전직 차수 입니다");
    }
}
