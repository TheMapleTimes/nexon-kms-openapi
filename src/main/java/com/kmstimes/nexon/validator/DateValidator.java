package com.kmstimes.nexon.validator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

/**
 * API의 조회 가능 시작일을 확인합니다.
 */
public class DateValidator {
    private final LocalDate afterDate;
    private static final ZoneId KST = ZoneId.of("Asia/Seoul");

    /**
     * API의 조회 가능 시작일을 확인합니다.
     * 
     * @param afterDate 조회 가능 시작일
     */
    public DateValidator(LocalDate afterDate) {
        this.afterDate = afterDate;
    }

    /**
     * API의 조회 가능 시작일을 확인합니다.
     *
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @throws IllegalArgumentException 형식이 잘못된 경우 예외 발생
     * @return 조건에 부합한 경우 기존 값을, 비어 있거나 오늘 날짜와 같을 경우 null
     */
    public LocalDate validate(LocalDate date) {
        LocalDate today = LocalDate.now(KST);
        LocalDate earliest = today.minusYears(2);

        if (date == null || date.equals(today)) {
            return null;
        }

        if (date.isBefore(earliest)) {
            throw new IllegalArgumentException("2년 이내의 날짜만 조회 가능합니다.");
        }

        if (date.isBefore(afterDate)) {
            throw new IllegalArgumentException(afterDate + " 이후의 날짜만 조회 가능합니다.");
        }

        return date;
    }

    /**
     * API의 조회 가능 시작일을 확인합니다.(랭킹 전용)
     * <p>
     * 오전 9시 00분부터 오늘의 랭킹 정보를 조회할 수 있습니다.(9시 00분 이전 조회 시 하루 전의 랭킹 정보를 조회)
     *
     * @param date 조회 기준일 (KST, YYYY-MM-DD)
     * @throws IllegalArgumentException 형식이 잘못된 경우 예외 발생
     * @return 조건에 부합한 경우 기존 값을, 비어 있거나 오늘 날짜와 같을 경우 null
     */
    public LocalDate validateOnlyRanking(LocalDate date) {
        LocalDate today = LocalDate.now(KST);
        LocalDate earliest = today.minusYears(2);

        if (date == null || date.equals(today)) {
            LocalTime currentTime = LocalTime.now(KST);
            LocalTime cutoffTime = LocalTime.of(9, 0);

            if(currentTime.isBefore(cutoffTime)) {
                return today.minusDays(1);
            }
            else {
                return today;
            }
        }

        if (date.isBefore(earliest)) {
            throw new IllegalArgumentException("2년 이내의 날짜만 조회 가능합니다.");
        }

        if (date.isBefore(afterDate)) {
            throw new IllegalArgumentException(afterDate + " 이후의 날짜만 조회 가능합니다.");
        }

        return date;
    }
}
