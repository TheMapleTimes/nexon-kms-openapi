package com.kmstimes.nexon.dto.ranking.overall;


import java.util.List;

/**
 * 메이플스토리 종합 랭킹 정보 조회 응답을 담는 데이터 클래스입니다.
 * <p>
 * 종합 랭킹 정보는 최근 2년 데이터만 조회 가능합니다.
 *
 * @param ranking 종합 랭킹 정보
 */
public record OverallRankingResponse(List<OverallRanking> ranking) {}