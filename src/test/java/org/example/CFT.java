package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CFT {

    @ParameterizedTest
    @CsvSource({
            // Ca kiểm thử 1: Đầu vào không hợp lệ - TNHT < MIN_TNHT
            "-357000, 500, Đầu vào không hợp lệ",  // tc1: 1c1; 2

            // Ca kiểm thử 2: Đầu vào không hợp lệ - TNHT > MAX_TNHT
            "134000, 657, Đầu vào không hợp lệ",   // tc2: 1c1; 1c2; 2

            // Ca kiểm thử 3: Đầu vào không hợp lệ - DTD < MIN_DTD
            "50000, 299, Đầu vào không hợp lệ",    // tc3: 1c1; 1c2; 1c3; 2

            // Ca kiểm thử 4: Đầu vào không hợp lệ - DTD > MAX_DTD
            "50000, 900, Đầu vào không hợp lệ",    // tc4: 1c1; 1c2; 1c3; 1c4; 2

            // Ca kiểm thử 5: Không đủ điều kiện vay vốn - TNHT < 1000
            "500, 600, Không đủ điều kiện vay vốn",  // tc5: 1c1; 1c2; 1c3; 1c4; 3c1; 4

            // Ca kiểm thử 6: Không đủ điều kiện vay vốn - DTD < 500
            "1500, 400, Không đủ điều kiện vay vốn", // tc6: 1c1; 1c2; 1c3; 1c4; 3c1; 3c2; 4

            // Ca kiểm thử 7: Đủ điều kiện vay vốn mức cao - TNHT >= 20000 và DTD >= 700
            "25000, 750, Đủ điều kiện vay vốn mức cao", // tc7: 1c1; 1c2; 1c3; 1c4; 3c1; 3c2; 5; 6; 7

            // Ca kiểm thử 8: Đủ điều kiện vay vốn mức trung bình - TNHT >= 5000 và DTD >= 600
            "10000, 650, Đủ điều kiện vay vốn mức trung bình", // tc8: 1c1; 1c2; 1c3; 1c4; 3c1; 3c2; 5; 8; 9; 10

            // Ca kiểm thử 9: Đủ điều kiện vay vốn mức thấp - TNHT >= 1000 và DTD >= 500
            "3000, 550, Đủ điều kiện vay vốn mức thấp", // tc9: 1c1; 1c2; 1c3; 1c4; 3c1; 3c2; 5; 8; 11

            // Ca kiểm thử 10: Đủ điều kiện vay vốn mức thấp - TNHT >= 5000 nhưng DTD < 600
            "7000, 590, Đủ điều kiện vay vốn mức thấp", // tc10: 1c1; 1c2; 1c3; 1c4; 3c1; 3c2; 5; 8; 9; 11

            // Ca kiểm thử 11: Đủ điều kiện vay vốn mức trung bình - TNHT = 25000 và DTD = 620
            "25000, 620, Đủ điều kiện vay vốn mức trung bình", // tc11: 1c1; 1c2; 1c3; 1c4; 3c1; 3c2; 5; 6; 8; 9; 10

            // Ca kiểm thử 12: Không hợp lệ - Không thể thỏa mãn 5 và không thỏa mãn 8
            // tc12: 1c1; 1c2; 1c3; 1c4; 3c1; 3c2; 5; 6; 8; 11

            // Ca kiểm thử 13: Không hợp lệ - Không thể thỏa mãn 5 và không thỏa mãn 8
            // tc13: 1c1; 1c2; 1c3; 1c4; 3c1; 3c2; 5; 6; 8; 9; 11
    })
    public void testEvaluateCredit(double TNHT, int DTD, String expected) {
        Assertions.assertEquals(expected, CreditEvaluation.evaluateCredit(TNHT, DTD));
    }
}
