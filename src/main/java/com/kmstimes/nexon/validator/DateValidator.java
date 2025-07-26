package com.kmstimes.nexon.validator;

import java.time.LocalDate;
import java.time.ZoneId;

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
}
