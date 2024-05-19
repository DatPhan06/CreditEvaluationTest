package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 * Lớp kiểm thử cho CreditEvaluation.
 */
public class BVATest {

    /**
     * Kiểm thử các trường hợp phân tích giá trị biên đơn giản (Boundary Value Analysis).
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/CSVTest/testBoundaryValueAnalysis.csv", numLinesToSkip = 1)
    public void testBoundaryValueAnalysis(double TNHT, int DTD, String expected) {
        Assertions.assertEquals(expected, CreditEvaluation.evaluateCredit(TNHT, DTD));
    }

    /**
     * Kiểm thử các trường hợp phân tích giá trị biên và cận biên hợp lệ (Boundary and Near-Boundary Value Analysis).
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/CSVTest/testBoundaryAndNearBoundaryValueAnalysis.csv", numLinesToSkip = 1)
    public void testBoundaryAndNearBoundaryValueAnalysis(double TNHT, int DTD, String expected) {
        Assertions.assertEquals(expected, CreditEvaluation.evaluateCredit(TNHT, DTD));
    }

    /**
     * Kiểm thử các trường hợp phân tích biên và cận biên bao gồm cả ngoài miền hợp lệ (Boundary and Near-Boundary Analysis Including Invalid Cases).
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/CSVTest/testBoundaryAndNearBoundaryIncludingInvalidCases.csv", numLinesToSkip = 1)
    public void testBoundaryAndNearBoundaryIncludingInvalidCases(double TNHT, int DTD, String expected) {
        Assertions.assertEquals(expected, CreditEvaluation.evaluateCredit(TNHT, DTD));
    }
}
