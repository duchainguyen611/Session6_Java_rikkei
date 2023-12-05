package ra.entity;

import java.util.Scanner;

public class Categories {
    private static int currentCatalogId = 1; // Mã danh mục tự tăng, bắt đầu từ 1
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private boolean catalogStatus;

    public Categories() {
        this.catalogId = currentCatalogId++;
    }

    public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public void inputData(Scanner scanner,Categories[] arrCategories, int index){
        System.out.println("Nhập thông tin cho danh mục:");

        // Nhập tên danh mục
        System.out.print("Nhập tên danh mục (độ dài tối đa 50 ký tự): ");
        String name = scanner.nextLine();
        while (name.length() > 50) {
            System.out.println("Tên danh mục quá dài. Vui lòng nhập lại.");
            System.out.print("Nhập tên danh mục (độ dài tối đa 50 ký tự): ");
            name = scanner.nextLine();
        }
        this.setCatalogName(name);

        // Nhập mô tả danh mục
        System.out.print("Nhập mô tả danh mục: ");
        String description = scanner.nextLine();
        this.setDescriptions(description);

        // Nhập trạng thái danh mục
        System.out.print("Nhập trạng thái danh mục (true - hoạt động, false - không hoạt động): ");
        boolean status = scanner.nextBoolean();
        this.setCatalogStatus(status);

        // Lưu thông tin vào mảng
        arrCategories[index] = this;
    }


    public void displayData(){
        System.out.printf("Ma danh muc: %d\nTen danh muc: %s\nMo ta: %s\nTrang thai: %b",this.catalogId,this.catalogName,this.descriptions,this.catalogStatus);

    }
}
