package ra.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Book {
    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String author;
    private float interest;
    private int year;

    public Book() {
    }

    public Book(String bookId, String bookName, float importPrice, float exportPrice, String author, float interest, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.author = author;
        this.interest = interest;
        this.year = year;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void inputData(Scanner scanner, int currentIndexBook, Book[] arrBook) {

        //Nhập mã sách
        boolean checkDulicateIdBook = true;
        do {
            System.out.print("Nhập mã sách:");
            this.bookId = scanner.nextLine();
            for (int i = 0; i < currentIndexBook; i++) {
                if (Objects.equals(this.bookId, arrBook[i].getBookId())) {
                    System.out.print("Mã sách này bị trùng!\n");
                    checkDulicateIdBook = false;
                    break;
                }
            }
        } while (!checkDulicateIdBook);


        //Nhập tên sách
        boolean checkNameBook = true;
        do {
            System.out.print("Nhập tên sách:");
            this.bookName = scanner.nextLine();
            if (this.bookName.length() != 4) {
                System.out.println("Tên sách phải có 4 ký tự!\n");
            } else {
                if (this.bookName.charAt(0) != 'B') {
                    System.out.println("Tên sách bắt đầu phải là ký tự B\n");
                } else {
                    boolean checkDulicateNameBook = false;
                    for (int i = 0; i < currentIndexBook; i++) {
                        if (Objects.equals(this.bookName, arrBook[i].getBookName())) {
                            checkDulicateNameBook = true;
                            System.out.println("Tên sách này bị trùng!\n");
                            break;
                        }
                    }
                    if (!checkDulicateNameBook) {
                        checkNameBook = false;
                    }
                }
            }
        } while (checkNameBook);

        //Nhập giá nhập của sách
        do {
            System.out.print("Nhập giá nhập của sách:");
            this.importPrice = Float.parseFloat(scanner.nextLine());
            if (this.importPrice <= 0) {
                System.out.print("Giá nhập của sách phải có giá trị lớn hơn 0\n");
            }
        } while (this.importPrice <= 0);

        //Nhập giá xuất của sách
        do {
            System.out.print("Nhập giá xuất của sách:");
            this.exportPrice = Float.parseFloat(scanner.nextLine());
            if (this.exportPrice < (this.importPrice * 0.3 + this.importPrice)) {
                System.out.print("Giá xuất của sách phải có giá trị lớn hơn ít nhất 30% so với giá nhập\n");
            }
        } while (this.exportPrice < (this.importPrice * 0.3 + this.importPrice));

        //Nhập tác giả
        do {
            System.out.print("Nhập tác giả của sách:");
            this.author = scanner.nextLine();
            if (this.author.length() < 6 || this.author.length() > 50) {
                System.out.print("Tác giả của sách phải có từ 6-50 ký tự\n");
            }
        } while (this.author.length() < 6 || this.author.length() > 50);

        //
        do {
            System.out.print("Nhập năm xuất bản:");
            this.year = Integer.parseInt(scanner.nextLine());
            if (this.year < 2000 || this.year > LocalDate.now().getYear()) {
                System.out.print("Năm xuất bản của sách ít nhất sau năm 2000 đến năm thời điểm hiện tại\n");
            }
        } while (this.year < 2000 || this.year > LocalDate.now().getYear());
    }

    public void displayData(){
        System.out.printf("\nMã sách: %s - Tên sách: %s - Giá nhập: %.2f - Giá xuất: %.2f\nTác giả: %s - Lợi nhuận: %.2f - Năm xuất bản: %d\n"
                ,this.bookId,this.bookName,this.importPrice,this.exportPrice,this.author,this.interest,this.year);
    }

    public float findInterest(){
        return this.exportPrice - this.importPrice;
    }
}
