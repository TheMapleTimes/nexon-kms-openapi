# Nexon MapleStory OpenAPI Java Client

[![Maven Central](https://img.shields.io/maven-central/v/com.kmstimes/nexon-kms-openapi.svg)](https://search.maven.org/artifact/com.kmstimes/nexon-kms-openapi)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Java Version](https://img.shields.io/badge/Java-17%2B-blue)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

넥슨 메이플스토리 OpenAPI를 위한 Java 클라이언트 라이브러리입니다. 이 라이브러리를 사용하면 메이플스토리의 캐릭터, 길드, 랭킹 등 다양한 게임 데이터에 쉽게 접근할 수 있습니다.

## 특징

- 메이플스토리 OpenAPI의 모든 엔드포인트 지원
- 사용하기 쉬운 인터페이스
- 자동 예외 처리
- 타입 안전성 보장
- 유연한 설정 옵션

## 시작하기

### 의존성 추가

#### Maven

```xml
<dependency>
    <groupId>com.kmstimes</groupId>
    <artifactId>nexon-kms-openapi</artifactId>
    <version>1.2.2</version>
</dependency>
```

#### Gradle

```groovy
implementation 'com.kmstimes:nexon-kms-openapi:1.2.2'
```

### API 키 발급받기

이 라이브러리를 사용하기 위해서는 넥슨 개발자 센터에서 API 키를 발급받아야 합니다.
1. [넥슨 개발자 센터](https://openapi.nexon.com/)에 방문하여 계정을 생성합니다.
2. 새 애플리케이션을 등록하고 메이플스토리 OpenAPI 접근 권한을 요청합니다.
3. 발급받은 API 키를 안전하게 보관하세요.

## 사용 예제

### 기본 사용법

```java
// API 클라이언트 초기화
MapleStoryApi api = MapleStoryApi.create("your-api-key");

// 캐릭터 OCID 조회
String ocid = api.Character().getId("캐릭터명").ocid();

// 캐릭터 기본 정보 조회
LocalDate date = LocalDate.now();
BasicResponse basicInfo = api.Character().getCharacterBasic(ocid, date);
System.out.println("캐릭터 이름: " + basicInfo.character_name());
System.out.println("레벨: " + basicInfo.character_level());
System.out.println("직업: " + basicInfo.character_class());
```

### 빌더 패턴 사용

```java
// 빌더를 사용한 커스텀 설정
MapleStoryApi api = MapleStoryApi.builder()
    .apiKey("your-api-key")
    .connectTimeout(15) // 연결 타임아웃 15초
    .readTimeout(30)    // 읽기 타임아웃 30초
    .build();

// 길드 정보 조회
GuildBasicResponse guildInfo = api.Guild().getGuildBasic("길드명", "월드명", LocalDate.now());
```

## 라이선스

이 프로젝트는 MIT 라이선스 하에 배포됩니다. 자세한 내용은 [LICENSE](LICENSE) 파일을 참조하세요.

## 연락처

- 개발자: Jinhyeok Ko
- 조직: The Maple Times
- GitHub: [https://github.com/TheMapleTimes](https://github.com/TheMapleTimes)