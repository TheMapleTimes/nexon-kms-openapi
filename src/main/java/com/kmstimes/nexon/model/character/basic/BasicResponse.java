package com.kmstimes.nexon.model.character.basic;

/**
 * 메이플스토리 기본 정보 조회 응답을 담는 데이터 클래스입니다.
 * <p>
 * 조회된 캐릭터 외형 이미지 URL에 쿼리 파리미터를 사용하여 캐릭터 이미지의 동작이나 감정표현을 변경하실 수 있습니다.
 *
 * @param date                        조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
 *                                    <p>
 *                                    example: 2023-12-21T00:00+09:00
 * @param character_name              캐릭터 명
 * @param world_name                  월드 명
 * @param character_gender            캐릭터 성별
 * @param character_class             캐릭터 직업
 * @param character_class_level       캐릭터 전직 차수
 * @param character_level             캐릭터 레벨
 * @param character_exp               현재 레벨에서 보유한 경험치
 * @param character_exp_rate          현재 레벨에서 경험치 퍼센트
 * @param character_guild_name        캐릭터 소속 길드 명
 * @param character_image             캐릭터 외형 이미지
 *                                    <ul>
 *                                    <li>조회된 캐릭터 외형 이미지 URL에 쿼리 파리미터를 사용하여 캐릭터 이미지의 동작이나 감정표현을 변경하실 수 있습니다.</li>
 *                                    <li>쿼리 파라미터는 API로 조회된 URL 뒤에 물음표(?)와 "Key=value" 쌍을 입력하여 조회합니다.</li>
 *                                    <li>여러 개의 쿼리 파라미터를 전달하려면 파라미터 사이에 앰퍼샌드(&)을 추가하여 하나의 문자열로 입력합니다.</li>
 *                                    <li>액션 및 감정표현에 프레임 값("Key=value.number")을 입력하여 아바타 이미지를 프레임 별로 조회 가능합니다. (20250116 추가)</li>
 *                                    <li>예시: https://open.api.nexon.com/static/maplestory/character/look/ABCDEFG?action=A00.2&emotion=E00&width=200&height=200</li>
 *                                    <li>액션(A00~A41) 쿼리 파라미터: {@link com.kmstimes.nexon.enums.Action}</li>
 *                                    <li>감정표현(E00~E24) 쿼리 파라미터: {@link com.kmstimes.nexon.enums.Emotion}</li>
 *                                    <li>무기 모션(W00~W04) 쿼리 파라미터: {@link com.kmstimes.nexon.enums.WeaponMotion}</li>
 *                                    <li>width: 가로 길이 (배경 크기에 해당함, 96(default)~1000)</li>
 *                                    <li>height: 세로 길이 (배경 크기에 해당함, 96(default)~1000)</li>
 *                                    <li>x: 캐릭터의 가로 좌표 (좌표 범위 0 < x < width, 0은 왼쪽 시작점에 해당)</li>
 *                                    <li>y: 캐릭터의 세로 좌표 (좌표 범위 0 < y < height, 0은 상단 시작점에 해당)</li>
 *                                    </ul>
 * @param character_date_create       캐릭터 생성일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
 *                                    <p>
 *                                    example: 2023-12-21T00:00+09:00
 * @param access_flag                 최근 7일간 접속 여부 (true 접속, false 미접속)
 * @param liberation_quest_clear_flag 해방 퀘스트 완료 여부 (true 완료, false 미완료)
 *                                    <ul>
 *                                    <li>해당 파라미터는 2025년 9월 메이플스토리 OpenAPI 업데이트 이후에 제거될 예정입니다.</li>
 *                                    <li>새로 추가된 {@link #liberation_quest_clear} 파라미터를 사용해주세요.</li>
 *                                    </ul>
 * @param liberation_quest_clear      해방 퀘스트 완료 여부 (0:미완료, 1:제네시스 무기 해방, 2:데스티니 무기 1차 해방)
 */
public record BasicResponse(
        String date,
        String character_name,
        String world_name,
        String character_gender,
        String character_class,
        String character_class_level,
        Long character_level,
        Long character_exp,
        String character_exp_rate,
        String character_guild_name,
        String character_image,
        String character_date_create,
        String access_flag,
        String liberation_quest_clear_flag,
        String liberation_quest_clear
) {
}
