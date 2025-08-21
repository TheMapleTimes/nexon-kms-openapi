package com.kmstimes.nexon.api.json;

import com.kmstimes.nexon.client.json.CharacterApiJsonClient;
import com.kmstimes.nexon.dto.character.ability.AbilityResponse;
import com.kmstimes.nexon.dto.character.achievement.AchievementResponse;
import com.kmstimes.nexon.dto.character.basic.BasicResponse;
import com.kmstimes.nexon.dto.character.dojang.DojangResponse;
import com.kmstimes.nexon.dto.character.equipment.android.AndroidEquipmentResponse;
import com.kmstimes.nexon.dto.character.equipment.beauty.BeautyEquipmentResponse;
import com.kmstimes.nexon.dto.character.equipment.cashitem.CashItemEquipmentResponse;
import com.kmstimes.nexon.dto.character.equipment.item.ItemEquipmentResponse;
import com.kmstimes.nexon.dto.character.equipment.pet.PetEquipmentResponse;
import com.kmstimes.nexon.dto.character.equipment.symbol.SymbolEquipmentResponse;
import com.kmstimes.nexon.dto.character.hyperstat.HyperStatResponse;
import com.kmstimes.nexon.dto.character.list.AccountResponse;
import com.kmstimes.nexon.dto.character.ocid.OcidResponse;
import com.kmstimes.nexon.dto.character.otherstat.OtherStatResponse;
import com.kmstimes.nexon.dto.character.popularity.PopularityResponse;
import com.kmstimes.nexon.dto.character.propensity.PropensityResponse;
import com.kmstimes.nexon.dto.character.ringexchange.RingExchangeResponse;
import com.kmstimes.nexon.dto.character.seteffect.SetEffectResponse;
import com.kmstimes.nexon.dto.character.skill.hexamatrix.HexaMatrixResponse;
import com.kmstimes.nexon.dto.character.skill.hexamatrixstat.HexaMatrixStatResponse;
import com.kmstimes.nexon.dto.character.skill.link.LinkSkillResponse;
import com.kmstimes.nexon.dto.character.skill.skill.SkillResponse;
import com.kmstimes.nexon.dto.character.skill.vmatrix.VMatrixResponse;
import com.kmstimes.nexon.dto.character.stat.StatResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

import java.time.LocalDate;

/**
 * 메이플스토리 캐릭터 정보 조회 API 정의 인터페이스입니다.
 * <p>
 * Retrofit을 기반으로 각 캐릭터 관련 API 엔드포인트를 선언하며,
 * {@link CharacterApiJsonClient} 에서 사용됩니다.
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
public interface CharacterApiJson {

    /**
     * 계정의 보유 캐릭터 목록을 조회합니다.
     *
     * @param userApiKey API KEY
     * @return {@link AccountResponse} 캐릭터 목록 조회
     */
    @GET("v1/character/list")
    Call<ResponseBody> getCharacterList(@Header("x-nxopen-api-key") String userApiKey);

    /**
     * 계정의 업적 정보를 조회합니다.
     *
     * @param userApiKey API KEY
     * @return {@link AchievementResponse} 업적 정보 조회
     */
    @GET("v1/user/achievement")
    Call<ResponseBody> getCharacterAchievement(@Header("x-nxopen-api-key") String userApiKey);

    /**
     * 캐릭터 식별자(ocid)를 조회합니다.
     *
     * @param characterName 캐릭터 명
     * @return {@link OcidResponse} 캐릭터 식별자(ocid) 조회
     */
    @GET("v1/id")
    Call<ResponseBody> getId(@Query("character_name") String characterName);

    /**
     * 기본 정보를 조회합니다.
     * <p>
     * <strong>캐릭터 외형 이미지:</strong>
     * <ul>
     * <li>조회된 캐릭터 외형 이미지 URL에 쿼리 파리미터를 사용하여 캐릭터 이미지의 동작이나 감정표현을 변경하실 수 있습니다.</li>
     * <li>쿼리 파라미터는 API로 조회된 URL 뒤에 물음표(?)와 "Key=value" 쌍을 입력하여 조회합니다.</li>
     * <li>여러 개의 쿼리 파라미터를 전달하려면 파라미터 사이에 앰퍼샌드(&amp;)을 추가하여 하나의 문자열로 입력합니다.</li>
     * <li>액션 및 감정표현에 프레임 값("Key=value.number")을 입력하여 아바타 이미지를 프레임 별로 조회 가능합니다. (20250116 추가)</li>
     * <li>예시: https://open.api.nexon.com/static/maplestory/character/look/ABCDEFG?action=A00.2&amp;emotion=E00</li>
     * <li>액션(A00~A41) 쿼리 파라미터: {@link com.kmstimes.nexon.enums.Action}</li>
     * <li>감정표현(E00~E24) 쿼리 파라미터: {@link com.kmstimes.nexon.enums.Emotion}</li>
     * <li>무기 모션(W00~W04) 쿼리 파라미터: {@link com.kmstimes.nexon.enums.WeaponMotion}</li>
     * </ul>
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link BasicResponse} 기본 정보 조회
     */
    @GET("v1/character/basic")
    Call<ResponseBody> getCharacterBasic(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 인기도 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link PopularityResponse} 인기도 정보 조회
     */
    @GET("v1/character/popularity")
    Call<ResponseBody> getCharacterPopularity(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 종합 능력치 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link StatResponse} 종합 능력치 정보 조회
     */
    @GET("v1/character/stat")
    Call<ResponseBody> getCharacterStat(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 하이퍼스탯 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link HyperStatResponse} 하이퍼스탯 정보 조회
     */
    @GET("v1/character/hyper-stat")
    Call<ResponseBody> getCharacterHyperStat(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 성향 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link PropensityResponse} 성향 정보 조회
     */
    @GET("v1/character/propensity")
    Call<ResponseBody> getCharacterPropensity(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 어빌리티 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link AbilityResponse} 어빌리티 정보 조회
     */
    @GET("v1/character/ability")
    Call<ResponseBody> getCharacterAbility(@Query("ocid") String ocid, @Query("date") LocalDate date);

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
    Call<ResponseBody> getCharacterItemEquipment(@Query("ocid") String ocid, @Query("date") LocalDate date);

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
    Call<ResponseBody> getCharacterCashItemEquipment(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 장착한 심볼 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link SymbolEquipmentResponse} 장착 심볼 정보 조회
     */
    @GET("v1/character/symbol-equipment")
    Call<ResponseBody> getCharacterSymbolEquipment(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 적용받고 있는 세트 효과 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link SetEffectResponse} 적용 세트 효과 정보 조회
     */
    @GET("v1/character/set-effect")
    Call<ResponseBody> getCharacterSetEffect(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 장착 중인 헤어, 성형, 피부 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link BeautyEquipmentResponse} 장착 헤어, 성형, 피부 정보 조회
     */
    @GET("v1/character/beauty-equipment")
    Call<ResponseBody> getCharacterBeautyEquipment(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 장착한 안드로이드 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link AndroidEquipmentResponse} 장착 안드로이드 정보 조회
     */
    @GET("v1/character/android-equipment")
    Call<ResponseBody> getCharacterAndroidEquipment(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 장착한 펫 및 펫 스킬, 장비 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link PetEquipmentResponse} 장착 펫 정보 조회
     */
    @GET("v1/character/pet-equipment")
    Call<ResponseBody> getCharacterPetEquipment(@Query("ocid") String ocid, @Query("date") LocalDate date);

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
    Call<ResponseBody> getCharacterSkill(@Query("ocid") String ocid, @Query("date") LocalDate date, @Query("character_skill_grade") String grade);

    /**
     * 장착 링크 스킬 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link LinkSkillResponse} 장착 링크 스킬 정보 조회
     */
    @GET("v1/character/link-skill")
    Call<ResponseBody> getCharacterLinkSkill(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * V매트릭스 슬롯 정보와 장착한 V코어 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link VMatrixResponse} V매트릭스 정보 조회
     */
    @GET("v1/character/vmatrix")
    Call<ResponseBody> getCharacterVMatrix(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * HEXA 매트릭스에 장착한 HEXA 코어 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link HexaMatrixResponse} HEXA 코어 정보 조회
     */
    @GET("v1/character/hexamatrix")
    Call<ResponseBody> getCharacterHexaMatrix(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * HEXA 매트릭스에 설정한 HEXA 스탯 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link HexaMatrixStatResponse} HEXA 매트릭스 설정 HEXA 스탯 정보 조회
     */
    @GET("v1/character/hexamatrix-stat")
    Call<ResponseBody> getCharacterHexaMatrixStat(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 캐릭터 무릉도장 최고 기록 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link DojangResponse} 무릉도장 최고 기록 정보 조회
     */
    @GET("v1/character/dojang")
    Call<ResponseBody> getCharacterDojang(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 능력치에 영향을 주는 요소 중 다른 조회에서 능력치 확인이 어려운 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link OtherStatResponse} 기타 능력치 영향 요소 정보 조회
     */
    @GET("v1/character/other-stat")
    Call<ResponseBody> getCharacterOtherStat(@Query("ocid") String ocid, @Query("date") LocalDate date);

    /**
     * 링 익스체인지 스킬 등록 장비를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @return {@link RingExchangeResponse} 링 익스체인지 스킬 등록 장비 조회
     */
    @GET("v1/character/ring-exchange-skill-equipment")
    Call<ResponseBody> getCharacterRingExchange(@Query("ocid") String ocid, @Query("date") LocalDate date);
}
