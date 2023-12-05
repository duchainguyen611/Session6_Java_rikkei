package ra.run;

import ra.entity.Book;

import java.util.Objects;
import java.util.Scanner;

public class BookImp {

    int currentIndexBook = 0;

    Book[] arrBook = new Book[100];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookImp bookImp = new BookImp();

        do {
            System.out.println("\n*********************MENU******************\n" +
                    "1. Nhập thông tin n sách (n nhập từ bàn phím)\n" +
                    "2. Tính lợi nhuận các sách\n" +
                    "3. Hiển thị thông tin sách\n" +
                    "4. Sắp xếp sách theo giá bán tăng dần\n" +
                    "5. Sắp xếp sách theo lợi nhuận giảm dần\n" +
                    "6. Tìm sách theo tên sách (tên sách nhập từ bàn phím)\n" +
                    "7. Thống kê số lượng sách theo năm xuất bản\n" +
                    "8. Thống kê số lượng sách theo tác giả\n" +
                    "9. Thoát");
            System.out.print("Nhập lựa chọn:");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    bookImp.inputBook(scanner);
                    break;
                case 2:
                    bookImp.findInterest();
                    break;
                case 3:
                    bookImp.outputBook();
                    break;
                case 4:
                    bookImp.sortBookByExportPrice();
                    break;
                case 5:
                    bookImp.sortBookByInterest();
                    break;
                case 6:
                    bookImp.lookForBookByName(scanner);
                    break;
                case 7:
                    bookImp.statisticsByYear();
                    break;
                case 8:
                    bookImp.statisticsByAuthor();
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.print("Nhập từ 1 đến 9!");
                    break;
            }
        } while (true);
    }

    public void inputBook(Scanner scanner) {
        System.out.print("Nhập số sách cần nhập:");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.printf("Sách thứ %d:\n", i + 1);
            arrBook[currentIndexBook] = new Book();
            arrBook[currentIndexBook].inputData(scanner, currentIndexBook, arrBook);
            currentIndexBook++;
        }
    }

    public void findInterest() {
        for (int i = 0; i < currentIndexBook; i++) {
            arrBook[i].setInterest(arrBook[i].findInterest());
        }
        System.out.println("Tính lợi nhuận thành công");
    }

    public void outputBook() {
        for (int i = 0; i < currentIndexBook; i++) {
            arrBook[i].displayData();
        }
    }

    public void sortBookByExportPrice() {
        for (int i = 0; i < currentIndexBook - 1; i++) {
            for (int j = i + 1; j < currentIndexBook; j++) {
                if (arrBook[i].getExportPrice() > arrBook[j].getExportPrice()) {
                    Book temp = arrBook[i];
                    arrBook[i] = arrBook[j];
                    arrBook[j] = temp;
                }
            }
        }
        System.out.print("Sắp xếp thành công! Ấn 3 để xem kết quả");
    }

    public void sortBookByInterest() {
        for (int i = 0; i < currentIndexBook - 1; i++) {
            for (int j = i + 1; j < currentIndexBook; j++) {
                if (arrBook[i].getInterest() < arrBook[j].getInterest()) {
                    Book temp = arrBook[i];
                    arrBook[i] = arrBook[j];
                    arrBook[j] = temp;
                }
            }
        }
        System.out.print("Sắp xếp thành công! Ấn 3 để xem kết quả");
    }

    public void lookForBookByName(Scanner scanner) {
        System.out.print("Nhập tên sách muốn tìm:");
        String lookForBook = scanner.nextLine();
        boolean checkLookFor = false;

        for (int i = 0; i < currentIndexBook; i++) {
            if (Objects.equals(lookForBook, arrBook[i].getBookName())) {
                checkLookFor = true;
                arrBook[i].displayData();
                break;
            }
        }
        if (!checkLookFor) {
            System.out.println("Không tìm thấy sách theo tên bạn muốn tìm!");
        }
    }

    public void statisticsByYear() {
        System.out.println("Thống kê số lượng sách theo năm xuất bản");
        for (int i = 0; i < currentIndexBook; i++) {

            boolean processed = false;
            for (int j = 0; j < i; j++) {
                if (arrBook[i].getYear() == arrBook[j].getYear()) {
                    processed = true;
                    break;
                }
            }

            if (!processed) {
                int count = countElementYear(arrBook[i].getYear());
                System.out.printf("Năm %d có %d sách\n", arrBook[i].getYear(), count);
            }
        }
    }

    public void statisticsByAuthor() {
        System.out.println("Thống kê số lượng sách theo tác giả");
        for (int i = 0; i < currentIndexBook; i++) {
            boolean processed = false;
            for (int j = 0; j < i; j++) {
                if (Objects.equals(arrBook[i].getAuthor(), arrBook[j].getAuthor())) {
                    processed = true;
                    break;
                }
            }

            if (!processed) {
                int count = countElementAuthor(arrBook[i].getAuthor());
                System.out.printf("Tác giả %sư có %d sách\n", arrBook[i].getAuthor(), count);
            }
        }
    }

    public int countElementYear(int year) {
        int count = 0;
        for (int i = 0; i < currentIndexBook; i++) {
            if (arrBook[i].getYear() == year) {
                count++;
            }
        }
        return count;
    }

    public int countElementAuthor(String author) {
        int count = 0;
        for (int i = 0; i < currentIndexBook; i++) {
            if (Objects.equals(arrBook[i].getAuthor(), author)) {
                count++;
            }
        }
        return count;
    }
}
