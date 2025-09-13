package com.kmstimes.nexon.enums;

/**
 * 메이플스토리의 모든 직업군을 정의하는 열거형입니다.
 * 각 직업은 한국어 이름으로 식별됩니다.
 */
public enum ClassName {
    /**
     * 전사-히어로
     */
    HERO("전사-히어로", "히어로"),
    /**
     * 전사-팔라딘
     */
    PALADIN("전사-팔라딘", "팔라딘"),
    /**
     * 전사-다크나이트
     */
    DARK_KNIGHT("전사-다크나이트", "다크나이트"),
    /**
     * 마법사-아크메이지(불,독)
     */
    ARCHMAGE_FP("마법사-아크메이지(불,독)", "아크메이지(불,독)"),
    /**
     * 마법사-아크메이지(썬,콜)
     */
    ARCHMAGE_IL("마법사-아크메이지(썬,콜)", "아크메이지(썬,콜)"),
    /**
     * 마법사-비숍
     */
    BISHOP("마법사-비숍", "비숍"),
    /**
     * 궁수-보우마스터
     */
    BOWMASTER("궁수-보우마스터", "보우마스터"),
    /**
     * 궁수-신궁
     */
    MARKSMAN("궁수-신궁", "신궁"),
    /**
     * 궁수-패스파인더
     */
    PATHFINDER("궁수-패스파인더", "패스파인더"),
    /**
     * 도적-나이트로드
     */
    NIGHTLORD("도적-나이트로드", "나이트로드"),
    /**
     * 도적-섀도어
     */
    SHADOWER("도적-섀도어", "섀도어"),
    /**
     * 도적-듀얼블레이더
     */
    DUALBLADER("도적-듀얼블레이더", "듀얼블레이더"),
    /**
     * 해적-바이퍼
     */
    VIPER("해적-바이퍼", "바이퍼"),
    /**
     * 해적-캡틴
     */
    CAPTAIN("해적-캡틴", "캡틴"),
    /**
     * 해적-캐논마스터
     */
    CANNON_MASTER("해적-캐논마스터", "캐논마스터"),
    /**
     * 기사단-소울마스터
     */
    SOULMASTER("기사단-소울마스터", "소울마스터"),
    /**
     * 기사단-플레임위자드
     */
    FLAMEWIZARD("기사단-플레임위자드", "플레임위자드"),
    /**
     * 기사단-윈드브레이커
     */
    WINDBREAKER("기사단-윈드브레이커", "윈드브레이커"),
    /**
     * 기사단-나이트워커
     */
    NIGHTWALKER("기사단-나이트워커", "나이트워커"),
    /**
     * 기사단-스트라이커
     */
    STRIKER("기사단-스트라이커", "스트라이커"),
    /**
     * 기사단-미하일
     */
    MIKHAIL("기사단-미하일", "미하일"),
    /**
     * 레지스탕스-블래스터
     */
    BLASTER("레지스탕스-블래스터", "블래스터"),
    /**
     * 레지스탕스-배틀메이지
     */
    BATTLEMAGE("레지스탕스-배틀메이지", "배틀메이지"),
    /**
     * 레지스탕스-와일드헌터
     */
    WILDHUNTER("레지스탕스-와일드헌터", "와일드헌터"),
    /**
     * 레지스탕스-메카닉
     */
    MECHANIC("레지스탕스-메카닉", "메카닉"),
    /**
     * 레지스탕스-데몬슬레이어
     */
    DEMON_SLAYER("레지스탕스-데몬슬레이어", "데몬슬레이어"),
    /**
     * 레지스탕스-데몬어벤져
     */
    DEMON_AVENGER("레지스탕스-데몬어벤져", "데몬어벤져"),
    /**
     * 레지스탕스-제논
     */
    XENON("레지스탕스-제논", "제논"),
    /**
     * 아란-전체 전직
     */
    ARAN("아란-전체 전직", "아란"),
    /**
     * 에반-전체 전직
     */
    EVAN("에반-전체 전직", "에반"),
    /**
     * 메르세데스-전체 전직
     */
    MERCEDES("메르세데스-전체 전직", "메르세데스"),
    /**
     * 팬텀-전체 전직
     */
    PHANTOM("팬텀-전체 전직", "팬텀"),
    /**
     * 은월-전체 전직
     */
    EUNWOL("은월-전체 전직", "은월"),
    /**
     * 루미너스-전체 전직
     */
    LUMINOUS("루미너스-전체 전직", "루미너스"),
    /**
     * 카이저-전체 전직
     */
    KAISER("카이저-전체 전직", "카이저"),
    /**
     * 엔젤릭버스터-전체 전직
     */
    ANGELICBUSTER("엔젤릭버스터-전체 전직", "엔젤릭버스터"),
    /**
     * 초월자-제로
     */
    ZERO("초월자-제로", "제로"),
    /**
     * 프렌즈 월드-키네시스
     */
    KINESIS("프렌즈 월드-키네시스", "키네시스"),
    /**
     * 카인-전체 전직
     */
    KAIN("카인-전체 전직", "카인"),
    /**
     * 카데나-전체 전직
     */
    CADENA("카데나-전체 전직", "카데나"),
    /**
     * 아델-전체 전직
     */
    ADELE("아델-전체 전직", "아델"),
    /**
     * 일리움-전체 전직
     */
    ILLIUM("일리움-전체 전직", "일리움"),
    /**
     * 칼리-전체 전직
     */
    KHALI("칼리-전체 전직", "칼리"),
    /**
     * 아크-전체 전직
     */
    ARK("아크-전체 전직", "아크"),
    /**
     * 렌-전체 전직
     */
    LEN("렌-전체 전직", "렌"),
    /**
     * 라라-전체 전직
     */
    LARA("라라-전체 전직", "라라"),
    /**
     * 호영-전체 전직
     */
    HOYOUNG("호영-전체 전직", "호영");

    /**
     * 직업의 한국어 이름
     */
    final private String className;
    final private String classValue;

    /**
     * ClassName 열거형 생성자
     *
     * @param className 직업의 한국어 이름
     */
    ClassName(String className, String classValue) {
        this.className = className;
        this.classValue = classValue;
    }


    /**
     * 직업의 api 조회용 이름을 반환합니다.
     *
     * @return 직업명 (예: "전사-히어로", "마법사-아크메이지(불,독)")
     */
    public String getClassName() {
        return className;
    }

    /**
     * 직업의 이름을 반환합니다.
     *
     * @return 직업명 (예: "히어로", "아크메이지(불,독)")
     */
    public String getClassValue() {
        return classValue;
    }

    /**
     * api의 조회 형식인 '라라-전체 전직' 를 단일 String으로 사용할 때 단일 직업 명을 조회합니다.
     *
     * @param className 조회할 직업 명(enum의 className 값)
     * @return classValue 값
     */
    public static String getClassValueByClassName(String className) {
        for (ClassName c : ClassName.values()) {
            if (c.getClassName().equals(className)) {
                return c.getClassValue();
            }
        }
        throw new IllegalArgumentException("해당하는 클래스를 찾을 수 없습니다: " + className);
    }
}
