package com.kmstimes.nexon.enums;

/**
 * 메이플스토리 스킬의 등급과 차수를 정의하는 열거형입니다.
 * 각 스킬 등급은 고유한 등급 코드와 설명을 가지고 있습니다.
 */
public enum SkillGrade {
    /**
     * 0차 스킬 및 제로 공용스킬
     */
    SKILL_0("0", "0차 스킬 및 제로 공용스킬"),
    /**
     * 1차 스킬
     */
    SKILL_1("1", "1차 스킬"),
    /**
     * 1.5차 스킬
     */
    SKILL_1_5("1.5", "1.5차 스킬"),
    /**
     * 2차 스킬
     */
    SKILL_2("2", "2차 스킬"),
    /**
     * 2.5차 스킬
     */
    SKILL_2_5("2.5", "2.5차 스킬"),
    /**
     * 3차 스킬
     */
    SKILL_3("3", "3차 스킬"),
    /**
     * 4차 스킬
     */
    SKILL_4("4", "4차 스킬"),
    /**
     * 하이퍼 패시브 스킬
     */
    SKILL_HYPERPASSIVE("hyperpassive", "하이퍼 패시브 스킬"),
    /**
     * 하이퍼 액티브 스킬
     */
    SKILL_HYPERACTIVE("hyperactive", "하이퍼 액티브 스킬"),
    /**
     * 5차 스킬
     */
    SKILL_5("5", "5차 스킬"),
    /**
     * 6차 스킬
     */
    SKILL_6("6", "6차 스킬");

    /**
     * 스킬 등급 코드
     */
    final private String grade;

    /**
     * 스킬 등급 설명
     */
    final private String description;

    /**
     * SkillGrade 열거형 생성자
     *
     * @param grade       스킬 등급을 나타내는 코드
     * @param description 스킬 등급에 대한 설명
     */
    SkillGrade(String grade, String description) {
        this.grade = grade;
        this.description = description;
    }

    /**
     * 스킬 등급 코드를 반환합니다.
     *
     * @return 등급 코드 (예: "0", "1", "hyperpassive")
     */
    public String getGrade() {
        return grade;
    }

    /**
     * 스킬 등급에 대한 설명을 반환합니다.
     *
     * @return 등급 설명 (예: "0차 스킬 및 제로 공용스킬")
     */
    public String getDescription() {
        return description;
    }
}
