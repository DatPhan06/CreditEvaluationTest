package org.example;

/**
 * Lớp CreditEvaluation dùng để đánh giá tín dụng cá nhân dựa trên thu nhập hàng tháng (TNHT)
 * và điểm tín dụng (DTD) của cá nhân.
 */
public class CreditEvaluation {

    // Định nghĩa các hằng số
    private static final double MIN_TNHT = 0;
    private static final double MAX_TNHT = 100000;
    private static final int MIN_DTD = 300;
    private static final int MAX_DTD = 850;

    /**
     * Hàm đánh giá tín dụng cá nhân dựa trên thu nhập hàng tháng (TNHT) và điểm tín dụng (DTD).
     *
     * @param TNHT Thu nhập hàng tháng của cá nhân.
     * @param DTD  Điểm tín dụng của cá nhân.
     * @return Kết quả đánh giá tín dụng dưới dạng chuỗi.
     */
    public static String evaluateCredit(double TNHT, int DTD) {
        // Kiểm tra tính hợp lệ của đầu vào
        if (TNHT < MIN_TNHT || TNHT > MAX_TNHT || DTD < MIN_DTD || DTD > MAX_DTD)
            return "Đầu vào không hợp lệ";


        // Đánh giá mức độ tín dụng
        if (TNHT < 1000 || DTD < 500) {
            return "Không đủ điều kiện vay vốn";
        } else if (TNHT >= 20000 && DTD >= 700) {
            return "Đủ điều kiện vay vốn mức cao";
        } else if (TNHT >= 5000 && DTD >= 600) {
            return "Đủ điều kiện vay vốn mức trung bình";
        } else {
            return "Đủ điều kiện vay vốn mức thấp";
        }
    }

//    /**
//     * Phương thức chính để chạy chương trình và kiểm tra các trường hợp đầu vào.
//     */
//    public static void main(String[] args) {
//        // Ví dụ đầu vào
//        double TNHT1 = 50000;
//        int DTD1 = 575;
//        int TNHT2 = 22000;
//        int DTD2 = 720;
//        int TNHT3 = 8000;
//        int DTD3 = 650;
//        int TNHT4 = 4500;
//        int DTD4 = 550;
//        int TNHT5 = -100;
//        int DTD5 = 750;
//
//        // Đánh giá và in kết quả
//        System.out.println(evaluateCredit(TNHT1, DTD1)); // Không đủ điều kiện vay vốn
//        System.out.println(evaluateCredit(TNHT2, DTD2)); // Đủ điều kiện vay vốn mức cao
//        System.out.println(evaluateCredit(TNHT3, DTD3)); // Đủ điều kiện vay vốn mức trung bình
//        System.out.println(evaluateCredit(TNHT4, DTD4)); // Đủ điều kiện vay vốn mức thấp
//        System.out.println(evaluateCredit(TNHT5, DTD5)); // Đầu vào không hợp lệ
//
//    }
}
