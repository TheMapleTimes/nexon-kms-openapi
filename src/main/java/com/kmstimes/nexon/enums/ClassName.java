package com.kmstimes.nexon.enums;

/**
 * 메이플스토리의 모든 직업군을 정의하는 열거형입니다.
 * 각 직업은 한국어 이름으로 식별됩니다.
 */
public enum ClassName {
    HERO("전사-히어로"),
    PALADIN("전사-팔라딘"),
    DARK_KNIGHT("전사-다크나이트"),
    ARCHMAGE_FP("마법사-아크메이지(불,독)"),
    ARCHMAGE_IL("마법사-아크메이지(썬,콜"),
    BISHOP("마법사-비숍"),
    BOWMASTER("궁수-보우마스터"),
    MARKSMAN("궁수-신궁"),
    PATHFINDER("궁수-패스파인더"),
    NIGHTLORD("도적-나이트로드"),
    SHADOWER("도적-섀도어"),
    DUALBLADER("도적-듀얼블레이더"),
    VIPER("해적-바이퍼"),
    CAPTAIN("해적-캡틴"),
    CANNON_MASTER("해적-캐논마스터"),
    SOULMASTER("기사단-소울마스터"),
    FLAMEWIZARD("기사단-플레임위자드"),
    WINDBREAKER("기사단-윈드브레이커"),
    NIGHTWALKER("기사단-나이트워커"),
    STRIKER("기사단-스트라이커"),
    MIKHAIL("기사단-미하일"),
    BLASTER("레지스탕스-블래스터"),
    BATTLEMAGE("레지스탕스-배틀메이지"),
    WILDHUNTER("레지스탕스-와일드헌터"),
    MECHANIC("레지스탕스-메카닉"),
    DEMON_SLAYER("레지스탕스-데몬슬레이어"),
    DEMON_AVENGER("레지스탕스-데몬어벤져"),
    XENON("레지스탕스-제논"),
    ARAN("아란-전체 전직"),
    EVAN("에반-전체 전직"),
    MERCEDES("메르세데스-전체 전직"),
    PHANTOM("팬텀-전체 전직"),
    EUNWOL("은월-전체 전직"),
    LUMINOUS("루미너스-전체 전직"),
    KAISER("카이저-전체 전직"),
    ANGELICBUSTER("엔젤릭버스터-전체 전직"),
    ZERO("초월자-제로"),
    KINESIS("프렌즈 월드-키네시스"),
    KAIN("카인-전체 전직"),
    CADENA("카데나-전체 전직"),
    ADELE("아델-전체 전직"),
    ILLIUM("일리움-전체 전직"),
    KHALI("칼리-전체 전직"),
    ARK("아크-전체 전직"),
    LEN("렌-전체 전직"),
    LARA("라라-전체 전직"),
    HOYOUNG("호영-전체 전직");

    /**
     * 직업의 한국어 이름
     */
    final private String className;

    /**
     * ClassName 열거형 생성자
     *
     * @param className 직업의 한국어 이름
     */
    ClassName(String className) {
        this.className = className;
    }

    /**
     * 직업의 한국어 이름을 반환합니다.
     *
     * @return 직업명 (예: "전사-히어로", "마법사-아크메이지(불,독)")
     */
    public String getClassName() {
        return className;
    }
}
