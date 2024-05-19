package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Lớp kiểm thử cho CreditEvaluation.
 */
public class EquivalencePartitioningTest {

    /**
     * Kiểm thử phân hoạch yếu
     */
    @ParameterizedTest
    @CsvSource({
            "13761, 128, Đầu vào không hợp lệ", // DTD không hợp lệ
            "-1452, 450, Đầu vào không hợp lệ"  // TNHT không hợp lệ
    })
    public void testWeakEquivalencePartitioning(double TNHT, int DTD, String expected) {
        Assertions.assertEquals(expected, CreditEvaluation.evaluateCredit(TNHT, DTD));
    }

    /**
     * Kiểm thử phân hoạch mạnh
     */
    @ParameterizedTest
    @CsvSource({
            "13761, 128, Đầu vào không hợp lệ",  // DTD không hợp lệ
            "13761, 450, Không đủ điều kiện vay vốn", // DTD không đủ điều kiện vay vốn
            "-1452, 128, Đầu vào không hợp lệ", // TNHT và DTD không hợp lệ
            "-1452, 450, Đầu vào không hợp lệ"  // TNHT không hợp lệ
    })
    public void testStrongEquivalencePartitioning(double TNHT, int DTD, String expected) {
        Assertions.assertEquals(expected, CreditEvaluation.evaluateCredit(TNHT, DTD));
    }

    /**
     * Kiểm thử phân hoạch truyền thống
     */
    @ParameterizedTest
    @CsvSource({
            "13761, 128, Đầu vào không hợp lệ",  // DTD không hợp lệ
            "13761, 450, Không đủ điều kiện vay vốn", // DTD không đủ điều kiện vay vốn
            "-1452, 450, Đầu vào không hợp lệ"  // TNHT không hợp lệ
    })
    public void testTraditionalEquivalencePartitioning(double TNHT, int DTD, String expected) {
        Assertions.assertEquals(expected, CreditEvaluation.evaluateCredit(TNHT, DTD));
    }

    /**
     * Kiểm thử các trường hợp đầu vào không hợp lệ (Phân hoạch theo đầu ra).
     */
    @ParameterizedTest
    @CsvSource({
            "-100, 500, Đầu vào không hợp lệ",     // TNHT < 0
            "101000, 500, Đầu vào không hợp lệ",   // TNHT > 100000
            "50000, 250, Đầu vào không hợp lệ",    // DTD < 300
            "50000, 900, Đầu vào không hợp lệ"     // DTD > 850
    })
    public void testInvalidInputCases(double TNHT, int DTD, String expected) {
        Assertions.assertEquals(expected, CreditEvaluation.evaluateCredit(TNHT, DTD));
    }

    /**
     * Kiểm thử các trường hợp không đủ điều kiện vay vốn (Phân hoạch theo đầu ra).
     */
    @ParameterizedTest
    @CsvSource({
            "500, 499, Không đủ điều kiện vay vốn",  // TNHT < 1000 và DTD < 500
            "999, 500, Không đủ điều kiện vay vốn",  // TNHT < 1000
            "999, 300, Không đủ điều kiện vay vốn"   // TNHT < 1000 và DTD < 500
    })
    public void testNotEligibleCases(double TNHT, int DTD, String expected) {
        Assertions.assertEquals(expected, CreditEvaluation.evaluateCredit(TNHT, DTD));
    }

    /**
     * Kiểm thử các trường hợp đủ điều kiện vay vốn mức cao (Phân hoạch theo đầu ra).
     */
    @ParameterizedTest
    @CsvSource({
            "20000, 700, Đủ điều kiện vay vốn mức cao", // TNHT >= 20000 và DTD >= 700
            "100000, 850, Đủ điều kiện vay vốn mức cao" // TNHT >= 20000 và DTD >= 700
    })
    public void testHighEligibilityCases(double TNHT, int DTD, String expected) {
        Assertions.assertEquals(expected, CreditEvaluation.evaluateCredit(TNHT, DTD));
    }

    /**
     * Kiểm thử các trường hợp đủ điều kiện vay vốn mức trung bình (Phân hoạch theo đầu ra).
     */
    @ParameterizedTest
    @CsvSource({
            "5000, 600, Đủ điều kiện vay vốn mức trung bình",  // TNHT >= 5000 và DTD >= 600, TNHT < 20000 và DTD < 700
            "19999, 699, Đủ điều kiện vay vốn mức trung bình" // TNHT >= 5000 và DTD >= 600, TNHT < 20000 và DTD < 700
    })
    public void testMediumEligibilityCases(double TNHT, int DTD, String expected) {
        Assertions.assertEquals(expected, CreditEvaluation.evaluateCredit(TNHT, DTD));
    }

    /**
     * Kiểm thử các trường hợp đủ điều kiện vay vốn mức thấp (Phân hoạch theo đầu ra).
     */
    @ParameterizedTest
    @CsvSource({
            "1000, 500, Đủ điều kiện vay vốn mức thấp",  // TNHT >= 1000 và DTD >= 500
            "4999, 599, Đủ điều kiện vay vốn mức thấp"  // TNHT >= 1000 và DTD >= 500
    })
    public void testLowEligibilityCases(double TNHT, int DTD, String expected) {
        Assertions.assertEquals(expected, CreditEvaluation.evaluateCredit(TNHT, DTD));
    }
}
