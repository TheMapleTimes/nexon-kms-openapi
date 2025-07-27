package com.kmstimes.nexon.enums;

/**
 * 메이플스토리의 모든 서버(월드) 이름을 정의하는 열거형입니다.
 * 각 월드는 한국어 이름으로 식별됩니다.
 */
public enum WorldName {
    /**
     * 스카니아
     */
    SCANIA("스카니아"),
    /**
     * 베라
     */
    BERA("베라"),
    /**
     * 루나
     */
    LUNA("루나"),
    /**
     * 제니스
     */
    ZENITH("제니스"),
    /**
     * 크로아
     */
    CROA("크로아"),
    /**
     * 유니온
     */
    UNION("유니온"),
    /**
     * 엘리시움
     */
    ELYSIUM("엘리시움"),
    /**
     * 이노시스
     */
    ENOSIS("이노시스"),
    /**
     * 레드
     */
    RED("레드"),
    /**
     * 오로라
     */
    AURORA("오로라"),
    /**
     * 아케인
     */
    ARCANE("아케인"),
    /**
     * 노바
     */
    NOVA("노바"),
    /**
     * 에오스
     */
    EOS("에오스"),
    /**
     * 핼리오스
     */
    HELIOS("핼리오스"),
    /**
     * 챌린저스
     */
    CHALLENGERS("챌린저스"),
    /**
     * 챌린저스2
     */
    CHALLENGERS2("챌린저스2"),
    /**
     * 챌린저스3
     */
    CHALLENGERS3("챌린저스3"),
    /**
     * 챌린저스4
     */
    CHALLENGERS4("챌린저스4");

    /**
     * 월드의 한국어 이름
     */
    final private String worldName;

    /**
     * WorldName 열거형 생성자
     *
     * @param worldName 월드의 한국어 이름
     */
    WorldName(String worldName) {
        this.worldName = worldName;
    }

    /**
     * 월드의 한국어 이름을 반환합니다.
     *
     * @return 월드명 (예: "스카니아", "베라")
     */
    public String getWorldName() {
        return worldName;
    }
}
