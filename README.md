# Giới thiệu
Dự án này triển khai một hệ thống đánh giá tín dụng cá nhân, giúp xác định mức độ tín dụng của các cá nhân dựa trên thu nhập hàng tháng (TNHT) và điểm tín dụng (DTD).

# Yêu Cầu Hệ Thống
## Đầu vào
- TNHT: Thu nhập hàng tháng (0 - 100,000 USD).
- DTD: Điểm tín dụng (300 - 850).
## Đầu ra
- "Đầu vào không hợp lệ"
- "Không đủ điều kiện vay vốn"
- "Đủ điều kiện vay vốn mức thấp"
- "Đủ điều kiện vay vốn mức trung bình"
- "Đủ điều kiện vay vốn mức cao"

# Kiểm Thử
Chạy các bài kiểm thử JUnit trong thư mục test để đảm bảo mã nguồn hoạt động đúng.

# Lỗi Đã Cấy
- Lỗi 1: Điều kiện TNHT < 1000 && DTD < 500
- Lỗi 2: Điều kiện TNHT >= 20000 && DTD >= 750
- Lỗi 3: Điều kiện TNHT >= 5000 && DTD > 600
