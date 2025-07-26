package com.kmstimes.nexon.api;

import com.kmstimes.nexon.model.character.ability.AbilityResponse;
import com.kmstimes.nexon.model.character.achievement.AchievementResponse;
import com.kmstimes.nexon.model.character.basic.BasicResponse;
import com.kmstimes.nexon.model.character.dojang.DojangResponse;
import com.kmstimes.nexon.model.character.equipment.android.AndroidEquipmentResponse;
import com.kmstimes.nexon.model.character.equipment.beauty.BeautyEquipmentResponse;
import com.kmstimes.nexon.model.character.equipment.cashitem.CashItemEquipmentResponse;
import com.kmstimes.nexon.model.character.equipment.item.ItemEquipmentResponse;
import com.kmstimes.nexon.model.character.equipment.pet.PetEquipmentResponse;
import com.kmstimes.nexon.model.character.equipment.symbol.SymbolEquipmentResponse;
import com.kmstimes.nexon.model.character.hyperstat.HyperStatResponse;
import com.kmstimes.nexon.model.character.list.AccountResponse;
import com.kmstimes.nexon.model.character.ocid.OcidResponse;
import com.kmstimes.nexon.model.character.popularity.PopularityResponse;
import com.kmstimes.nexon.model.character.propensity.PropensityResponse;
import com.kmstimes.nexon.model.character.seteffect.SetEffectResponse;
import com.kmstimes.nexon.model.character.skill.hexamatrix.HexaMatrixResponse;
import com.kmstimes.nexon.model.character.skill.hexamatrixstat.HexaMatrixStatResponse;
import com.kmstimes.nexon.model.character.skill.link.LinkSkillResponse;
import com.kmstimes.nexon.model.character.skill.skill.SkillResponse;
import com.kmstimes.nexon.model.character.skill.vmatrix.VMatrixResponse;
import com.kmstimes.nexon.model.character.stat.StatResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

import java.time.LocalDate;

/**
 * 메이플스토리 캐릭터 정보 조회 API 정의 인터페이스입니다.
 * <p>
 * Retrofit을 기반으로 각 캐릭터 관련 API 엔드포인트를 선언하며,
 * {@link com.kmstimes.nexon.client.CharacterApiClient} 에서 사용됩니다.
 * <p>
 * <strong>NEXON OPEN API 안내사항:</strong>
 * <ul>
 * <li>메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</li>
 * <li>2023년 12월 21일 데이터부터 조회할 수 있습니다.</li>
 * <li>과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다.
 * (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</li>
 * <li>게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</li>
 * <li>해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</li>
 * </ul>
 */
public interface CharacterApi {

    /**
     * 계정의 보유 캐릭터 목록을 조회합니다.
     *
     * @param userApiKey API KEY
     * @return {@link AccountResponse} 캐릭터 목록 조회
     */
    @GET("v1/character/list")
    Call<AccountResponse> getCharacterList(@Header("x-nxopen-api-key") String userApiKey);

    /**
     * 계정의 업적 정보를 조회합니다.
     *
     * @param userApiKey API KEY
     * @return {@link AchievementResponse} 업적 정보 조회
     */
    @GET("v1/user/achievement")
    Call<AchievementResponse> getCharacterAchievement(@Header("x-nxopen-api-key") String userApiKey);

    /**
     * 캐릭터 식별자(ocid)를 조회합니다.
     *
     * @param characterName 캐릭터 명
     * @return {@link OcidResponse} 캐릭터 식별자(ocid) 조회
     */
    @GET("v1/id")
    Call<OcidResponse> getId(@Query("character_name") String characterName);

    /**
     * 기본 정보를 조회합니다.
     * <p>
     * <strong>캐릭터 외형 이미지:</strong>
     * <ul>
     * <li>조회된 캐릭터 외형 이미지 URL에 쿼리 파리미터를 사용하여 캐릭터 이미지의 동작이나 감정표현을 변경하실 수 있습니다.</li>
     * <li>쿼리 파라미터는 API로 조회된 URL 뒤에 물음표(?)와 "Key=value" 쌍을 입력하여 조회합니다.</li>
     * <li>여러 개의 쿼리 파라미터를 전달하려면 파라미터 사이에 앰퍼샌드(&)을 추가하여 하나의 문자열로 입력합니다.</li>
     * <li>액션 및 감정표현에 프레임 값("Key=value.number")을 입력하여 아바타 이미지를 프레임 별로 조회 가능합니다. (20250116 추가)</li>
     * <li>예시: https://open.api.nexon.com/static/maplestory/character/look/ABCDEFG?action=A00.2&emotion=E00&width=200&height=200</li>
     * <li>액션(A00~A41) 쿼리 파라미터: {@link com.kmstimes.nexon.enums.Action}</li>
     * <li>감정표현(E00~E24) 쿼리 파라미터: {@link com.kmstimes.nexon.enums.Emotion}</li>
     * <li>무기 모션(W00~W04) 쿼리 파라미터: {@link com.kmstimes.nexon.enums.WeaponMotion}</li>
     * <li>width: 가로 길이 (배경 크기에 해당함, 96(default)~1000)</li>
     * <li>height: 세로 길이 (배경 크기에 해당함, 96(default)~1000)</li>
     * <li>x: 캐릭터의 가로 좌표 (좌표 범위 0 < x < width, 0은 왼쪽 시작점에 해당)</li>
     * <li>y: 캐릭터의 세로 좌표 (좌표 범위 0 < y < height, 0은 상단 시작점에 해당)</li>
     * </ul>
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link BasicResponse} 기본 정보 조회
     */
    @GET("v1/character/basic")
    Call<BasicResponse> getCharacterBasic(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 인기도 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link PopularityResponse} 인기도 정보 조회
     */
    @GET("v1/character/popularity")
    Call<PopularityResponse> getCharacterPopularity(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 종합 능력치 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link StatResponse} 종합 능력치 정보 조회
     */
    @GET("v1/character/stat")
    Call<StatResponse> getCharacterStat(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 하이퍼스탯 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link HyperStatResponse} 하이퍼스탯 정보 조회
     */
    @GET("v1/character/hyper-stat")
    Call<HyperStatResponse> getCharacterHyperStat(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 성향 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link PropensityResponse} 성향 정보 조회
     */
    @GET("v1/character/propensity")
    Call<PropensityResponse> getCharacterPropensity(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 어빌리티 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link AbilityResponse} 어빌리티 정보 조회
     */
    @GET("v1/character/ability")
    Call<AbilityResponse> getCharacterAbility(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 장착한 장비 중 캐시 장비를 제외한 나머지 장비 정보를 조회합니다.
     * <p>
     * 훈장 외형, 칭호 외형 정보는 2025년 1월 16일 메이플스토리 점검 이후 데이터부터 조회 가능합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link ItemEquipmentResponse} 장착 장비 정보 조회(캐시 장비 제외)
     */
    @GET("v1/character/item-equipment")
    Call<ItemEquipmentResponse> getCharacterItemEquipment(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 장착한 캐시 장비 정보를 조회합니다.
     * <p>
     * 장착 중인 캐시 장비의 스킬 정보는 2025년 1월 16일 메이플스토리 점검 이후 데이터부터 조회 가능합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link CashItemEquipmentResponse} 장착 캐시 장비 정보 조회
     */
    @GET("v1/character/cashitem-equipment")
    Call<CashItemEquipmentResponse> getCharacterCashItemEquipment(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 장착한 심볼 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link SymbolEquipmentResponse} 장착 심볼 정보 조회
     */
    @GET("v1/character/symbol-equipment")
    Call<SymbolEquipmentResponse> getCharacterSymbolEquipment(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 적용받고 있는 세트 효과 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link SetEffectResponse} 적용 세트 효과 정보 조회
     */
    @GET("v1/character/set-effect")
    Call<SetEffectResponse> getCharacterSetEffect(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 장착 중인 헤어, 성형, 피부 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link BeautyEquipmentResponse} 장착 헤어, 성형, 피부 정보 조회
     */
    @GET("v1/character/beauty-equipment")
    Call<BeautyEquipmentResponse> getCharacterBeautyEquipment(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 장착한 안드로이드 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link AndroidEquipmentResponse} 장착 안드로이드 정보 조회
     */
    @GET("v1/character/android-equipment")
    Call<AndroidEquipmentResponse> getCharacterAndroidEquipment(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 장착한 펫 및 펫 스킬, 장비 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link PetEquipmentResponse} 장착 펫 정보 조회
     */
    @GET("v1/character/pet-equipment")
    Call<PetEquipmentResponse> getCharacterPetEquipment(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 캐릭터 스킬과 하이퍼 스킬 정보를 조회합니다.
     *
     * @param ocid  캐릭터 식별자
     * @param date  조회 기준일 (KST, YYYY-MM-DD)
     * @param grade 조회하고자 하는 전직 차수
     *              <p>
     *              <ul>
     *              <li>0: 0차 스킬 및 제로 공용스킬</li>
     *              <li>1: 1차 스킬</li>
     *              <li>1.5: 1.5차 스킬</li>
     *              <li>2: 2차 스킬</li>
     *              <li>2.5: 2.5차 스킬</li>
     *              <li>3: 3차 스킬</li>
     *              <li>4: 4차 스킬 및 제로 알파/베타 스킬</li>
     *              <li>hyperpassive: 하이퍼 패시브 스킬</li>
     *              <li>hyperactive: 하이퍼 액티브 스킬</li>
     *              <li>5: 5차 스킬</li>
     *              <li>6: 6차 스킬</li>
     *              </ul>
     *              <strong>Available values :</strong> 0, 1, 1.5, 2, 2.5, 3, 4, hyperpassive, hyperactive, 5, 6
     * @return {@link SkillResponse} 스킬 정보 조회
     */
    @GET("v1/character/skill")
    Call<SkillResponse> getCharacterSkill(@Query("ocid") String ocid, @Query("date") LocalDate date, @Query("character_skill_grade") String grade);

    /**
     * 장착 링크 스킬 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link LinkSkillResponse} 장착 링크 스킬 정보 조회
     */
    @GET("v1/character/link-skill")
    Call<LinkSkillResponse> getCharacterLinkSkill(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * V매트릭스 슬롯 정보와 장착한 V코어 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link VMatrixResponse} V매트릭스 정보 조회
     */
    @GET("v1/character/vmatrix")
    Call<VMatrixResponse> getCharacterVMatrix(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * HEXA 매트릭스에 장착한 HEXA 코어 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link HexaMatrixResponse} HEXA 코어 정보 조회
     */
    @GET("v1/character/hexamatrix")
    Call<HexaMatrixResponse> getCharacterHexaMatrix(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * HEXA 매트릭스에 설정한 HEXA 스탯 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link HexaMatrixStatResponse} HEXA 매트릭스 설정 HEXA 스탯 정보 조회
     */
    @GET("v1/character/hexamatrix-stat")
    Call<HexaMatrixStatResponse> getCharacterHexaMatrixStat(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 캐릭터 무릉도장 최고 기록 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link DojangResponse} 무릉도장 최고 기록 정보 조회
     */
    @GET("v1/character/dojang")
    Call<DojangResponse> getCharacterDojang(@Query("ocid") String ocid, @Query("date") LocalDate date);
}
