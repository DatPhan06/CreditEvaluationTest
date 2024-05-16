package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Lớp kiểm thử cho CreditEvaluation.
 */
public class CreditEvaluationTest {

    @Test
    @DisplayName("1 + 1 = 2")
    void addsTwoNumbers() {
        Assertions.assertEquals(2, 2, "1 + 1 should equal 2");
    }

    /**
     * Kiểm thử các trường hợp đầu vào không hợp lệ.
     */
    @ParameterizedTest
    @CsvSource({
            "-100, 750, Đầu vào không hợp lệ",
            "1200, 290, Đầu vào không hợp lệ"
    })
    public void testInvalidInput(double TNHT, int DTD, String expected) {
        Assertions.assertEquals(expected, CreditEvaluation.evaluateCredit(TNHT, DTD));
    }

    /**
     * Kiểm thử các trường hợp không đủ điều kiện vay vốn.
     */
    @ParameterizedTest
    @CsvSource({
            "1200, 480, Không đủ điều kiện vay vốn",
            "900, 600, Không đủ điều kiện vay vốn"
    })
    public void testNotEligibleForLoan(double TNHT, int DTD, String expected) {
        Assertions.assertEquals(expected, CreditEvaluation.evaluateCredit(TNHT, DTD));
    }

    /**
     * Kiểm thử các trường hợp đủ điều kiện vay vốn mức cao.
     */
    @ParameterizedTest
    @CsvSource({
            "22000, 720, Đủ điều kiện vay vốn mức cao",
            "30000, 800, Đủ điều kiện vay vốn mức cao"
    })
    public void testHighEligibility(double TNHT, int DTD, String expected) {
        Assertions.assertEquals(expected, CreditEvaluation.evaluateCredit(TNHT, DTD));
    }

    /**
     * Kiểm thử các trường hợp đủ điều kiện vay vốn mức trung bình.
     */
    @ParameterizedTest
    @CsvSource({
            "8000, 650, Đủ điều kiện vay vốn mức trung bình",
            "15000, 650, Đủ điều kiện vay vốn mức trung bình"
    })
    public void testMediumEligibility(double TNHT, int DTD, String expected) {
        Assertions.assertEquals(expected, CreditEvaluation.evaluateCredit(TNHT, DTD));
    }

    /**
     * Kiểm thử các trường hợp đủ điều kiện vay vốn mức thấp.
     */
    @ParameterizedTest
    @CsvSource({
            "4500, 550, Đủ điều kiện vay vốn mức thấp",
            "3000, 700, Đủ điều kiện vay vốn mức thấp"
    })
    public void testLowEligibility(double TNHT, int DTD, String expected) {
        Assertions.assertEquals(expected, CreditEvaluation.evaluateCredit(TNHT, DTD));
    }
}
