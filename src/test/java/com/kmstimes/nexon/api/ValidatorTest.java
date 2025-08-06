package com.kmstimes.nexon.api;

import com.kmstimes.nexon.validator.ClassValidator;
import com.kmstimes.nexon.validator.WorldValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {
    @Test
    void world() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> WorldValidator.validate("틀린월드명"));
        assertTrue(e.getMessage().contains("잘못된 월드 명"), "예외 메시지가 기대와 다릅니다.");
    }

    @Test
    void className() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> ClassValidator.validate("틀린클래스명"));
        assertTrue(e.getMessage().contains("잘못된 클래스 명"), "예외 메시지가 기대와 다릅니다.");
    }
}
