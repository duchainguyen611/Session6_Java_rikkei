package book;

import java.util.Scanner;

public class Book {
    private String bookID;
    private String bookName;
    private float importPrices;
    private float exportPrices;
    private String bookTitle;
    private String author;
    private String publisher;

    public Book() {
    }

    public Book(String bookID, String bookName, int importPrices, int exportPrices, String bookTitle, String author, String publisher) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.importPrices = importPrices;
        this.exportPrices = exportPrices;
        this.bookTitle = bookTitle;
        this.author = author;
        this.publisher = publisher;
    }

    public String getBookID() {
        return bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public float getImportPrices() {
        return importPrices;
    }

    public float getExportPrices() {
        return exportPrices;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setImportPrices(int importPrices) {
        this.importPrices = importPrices;
    }

    public void setExportPrices(int exportPrices) {
        this.exportPrices = exportPrices;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void inputData(Scanner scanner){
        System.out.print("Nhap ma sach:");
        this.bookID = scanner.nextLine();
        System.out.print("Nhap ten sach:");
        this.bookName = scanner.nextLine();
        System.out.print("Nhap gia nhap:");
        this.importPrices = Float.parseFloat(scanner.nextLine());
        System.out.print("Nhap tieu de:");
        this.bookTitle = scanner.nextLine();
        System.out.print("Nhap tac gia:");
        this.author = scanner.nextLine();
        System.out.print("Nhap nha xuat ban:");
        this.publisher = scanner.nextLine();
    }

    public float calExportPrice(){
        return this.importPrices*1.2F;
    }

    public void displayData(){
        System.out.printf("Ma sach: %s\nTen sach: %s\nGia nhap: %f\n"+
                "Gia xuat: %s\nTieu de: %s\nTac gia: %S\nNha xuat ban: %s",
                this.bookID,this.bookName,this.importPrices,this.exportPrices,this.bookTitle
        ,this.author,this.publisher);
    }
}
