package ra.run;

import book.Book;

import java.util.Objects;
import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] arrBook = new Book[100];
        int choice;
        int n = 0;
        do {
            System.out.println("\n*********************MENU*******************\n" +
                    "1. Nhập số lượng sách (n) và nhập thông tin n sách (lưu vào mảng)\n" +
                    "2. Hiển thị tất cả sách đang quản lý\n" +
                    "3. Tính giá xuất của các sách đang quản lý\n" +
                    "4. Sắp xếp sách theo giá nhập tăng dần\n" +
                    "5. Tìm kiếm sách theo tên sách\n" +
                    "6. Thoát");
            System.out.print("Mời nhập lựa chọn:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhap số lượng sách:");
                    n = Integer.parseInt(scanner.nextLine());

                    for (int i = 0; i < n; i++) {
                        System.out.printf("Nhập thông tin sách thứ %d:\n", i + 1);
                        arrBook[i] = new Book();
                        arrBook[i].inputData(scanner);
                    }
                    break;
                case 2:
                    System.out.print("\nHiển thị tất cả sách đang quản lý:");
                    for (int i = 0; i < n; i++) {
                        System.out.printf("\nThông tin sách thứ %d:\n", i + 1);
                        arrBook[i].displayData();
                    }
                    break;
                case 3:
                    System.out.print("Tính giá xuất của các sách đang quản lý:");
                    for (int i = 0; i < n; i++) {
                        System.out.printf("Giá xuất sách thứ %d: %.2f\n", i + 1, arrBook[i].calExportPrice());
                    }
                    break;
                case 4:
                    System.out.print("Sắp xếp sách theo giá nhập tăng dần:");
                    Book temp;
                    for (int i = 0; i < n-1; i++) {
                        for (int j = i + 1; j < n; j++){
                            if(arrBook[i].getImportPrices() > arrBook[j].getImportPrices()){
                                temp = arrBook[i];
                                arrBook[i] = arrBook[j];
                                arrBook[j] = temp;
                            }
                        }
                    }
                    System.out.print("Sắp xếp thành công! Ấn 2 để kiểm tra!");
                    break;
                case 5:
                    System.out.print("Nhập sách theo tên sách muốn tìm kiếm:");
                    String lookForBook = scanner.nextLine();
                    System.out.println();
                    for (int i = 0; i < n; i++) {
                        if (Objects.equals(arrBook[i].getBookName(), lookForBook)){
                            arrBook[i].displayData();
                        }
                    }
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Mời nhập từ 1 đến 6!");
                    break;
            }
        } while (true);
    }
}
