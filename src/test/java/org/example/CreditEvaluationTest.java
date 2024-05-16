package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.testng.annotations.Test;

/**
 * Lớp kiểm thử cho CreditEvaluation.
 */
public class CreditEvaluationTest {

    /**
     * Kiểm thử các trường hợp đầu vào không hợp lệ.
     */
    @Test
    public void testInvalidInput() {
        assertEquals("Đầu vào không hợp lệ", CreditEvaluation.evaluateCredit(-100, 750));
        assertEquals("Đầu vào không hợp lệ", CreditEvaluation.evaluateCredit(1200, 290));
    }

    /**
     * Kiểm thử các trường hợp không đủ điều kiện vay vốn.
     */
    @Test
    public void testNotEligibleForLoan() {
        assertEquals("Không đủ điều kiện vay vốn", CreditEvaluation.evaluateCredit(1200, 480));
        assertEquals("Không đủ điều kiện vay vốn", CreditEvaluation.evaluateCredit(900, 600));
    }

    /**
     * Kiểm thử các trường hợp đủ điều kiện vay vốn mức cao.
     */
    @Test
    public void testHighEligibility() {
        assertEquals("Đủ điều kiện vay vốn mức cao", CreditEvaluation.evaluateCredit(22000, 720));
        assertEquals("Đủ điều kiện vay vốn mức cao", CreditEvaluation.evaluateCredit(30000, 800));
    }

    /**
     * Kiểm thử các trường hợp đủ điều kiện vay vốn mức trung bình.
     */
    @Test
    public void testMediumEligibility() {
        assertEquals("Đủ điều kiện vay vốn mức trung bình", CreditEvaluation.evaluateCredit(8000, 650));
        assertEquals("Đủ điều kiện vay vốn mức trung bình", CreditEvaluation.evaluateCredit(15000, 650));
    }

    /**
     * Kiểm thử các trường hợp đủ điều kiện vay vốn mức thấp.
     */
    @Test
    public void testLowEligibility() {
        assertEquals("Đủ điều kiện vay vốn mức thấp", CreditEvaluation.evaluateCredit(4500, 550));
        assertEquals("Đủ điều kiện vay vốn mức thấp", CreditEvaluation.evaluateCredit(3000, 700));
    }
}
