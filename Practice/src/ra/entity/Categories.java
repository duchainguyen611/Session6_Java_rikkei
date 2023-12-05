package ra.entity;

import java.util.Scanner;

public class Categories {
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private boolean catalogStatus;

    public Categories() {

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

    public void inputData(Scanner scanner, ra.entity.Categories[] arrCategories, int currentCatalogIndex) {
        //Mã danh mục tự tăng
        //B1. Tìm mã danh mục lớn nhất trong arrCategories

        if (currentCatalogIndex == 0) {
            this.catalogId = 1;
        } else {
            int max = arrCategories[0].getCatalogId();
            for (int i = 0; i < currentCatalogIndex; i++) {
                if (max < arrCategories[i].getCatalogId()) {
                    max = arrCategories[i].getCatalogId();
                }
            }
            this.catalogId = max + 1;
        }

        //Nhập tên danh mục: tối da 50 ký tự và không trùng lặp

        boolean isCheckName = true;
        do {
            System.out.print("Nhập vào tên danh mục:");
            this.catalogName = scanner.nextLine();

            if (this.catalogName.length() > 50) {
                System.out.println("\nTên danh mục phải có ít hơn 50 ký tự!");
            } else {
                boolean isNameDuplicate = false;
                for (int i = 0; i < currentCatalogIndex; i++) {
                    if (this.catalogName.equals(arrCategories[i].getCatalogName())) {
                        isNameDuplicate = true;
                        System.out.println("\nTên danh mục này bị trùng!");
                        break;
                    }
                }

                if (!isNameDuplicate) {
                    isCheckName = false;
                }
            }
        } while (isCheckName);


        //Nhập mô tả danh mục

        System.out.print("Nhập mô tả danh mục:");
        this.descriptions = scanner.nextLine();

        //Nhập trạng thái danh mục

        do{
            System.out.print("Nhập trạng thái danh mục:");
            String stringSttCat = scanner.nextLine();

            if(stringSttCat.equals("true") || stringSttCat.equals("false")){
                this.catalogStatus = Boolean.parseBoolean(stringSttCat);
                break;
            }else {
                System.out.println("\nTrạng thái chỉ nhận true hoặc false!");
            }
        }while (true);
    }


    public void displayData() {
        System.out.printf("Mã danh mục: %d - Tên danh mục: %s - Mô tả: %s - Trạng thái: %s\n", this.catalogId, this.catalogName, this.descriptions, this.catalogStatus ?"Hoạt động":"Không hoạt động");
    }
}