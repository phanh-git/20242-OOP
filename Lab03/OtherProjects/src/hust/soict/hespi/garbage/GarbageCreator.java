package hust.soict.hespi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        // Nếu không truyền filename qua args thì mặc định dùng "test.exe"
        String filename = args.length > 0 ? args[0] : "test.exe";

        // Đọc toàn bộ bytes từ tệp
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));

        // Bắt đầu tính thời gian
        long startTime = System.currentTimeMillis();

        // Phần “tạo rác”: nối chuỗi bằng toán tử +
//        String outputString = "";
//        for (byte b : inputBytes) {
//            outputString += (char) b;
//        }

        // Thay vì String outputString = "";
        StringBuilder outputStringBuilder = new StringBuilder();

        // Nối từng ký tự vào StringBuilder
        for (byte b : inputBytes) {
            outputStringBuilder.append((char)b);
        }

        // Nếu cần biến về String, gọi:
        String outputString = outputStringBuilder.toString();


        // Kết thúc và in ra thời gian thực thi
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed (using +): " + (endTime - startTime) + " ms");
    }
}
