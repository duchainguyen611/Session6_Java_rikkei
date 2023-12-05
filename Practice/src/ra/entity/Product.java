package ra.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private float price;
    private String description;
    private Date created;
    private int catalogId;
    private int productStatus;

    public Product() {
    }

    public Product(String productId, String productName, float price, String description, Date created, int catalogId, int productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.created = created;
        this.catalogId = catalogId;
        this.productStatus = productStatus;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData(Scanner scanner, Product[] arrProduct, int currentIndexProduct, Categories[] arrCategories) {

        // Nhập mã sản phẩm đồ uống
        boolean isCheckId = true;
        do {
            System.out.print("Nhập mã sản phẩm đồ uống:");
            this.productId = scanner.nextLine();
            if (this.productId.length() != 4) {
                System.out.println("Tên sản phẩm phải gồm 4 ký tự!\n");
            } else {
                if (this.productId.charAt(0) != 'C' && this.productId.charAt(0) != 'S' && this.productId.charAt(0) != 'A') {
                    System.out.println("Mã sản phẩm phải bắt đầu bằng ký tự 'C', 'S' hoặc 'A' !\n");
                } else {
                    boolean isNameDuplicate = false;
                    for (int i = 0; i < currentIndexProduct; i++) {
                        if (this.productId.equals(arrProduct[i].getProductId())) {
                            System.out.println("Tên mã sản phẩm này bị trùng!");
                            isNameDuplicate = true;
                            break;
                        }
                    }
                    if (!isNameDuplicate) {
                        isCheckId = false;
                    }
                }
            }
        } while (isCheckId);


        //Nhập tên sản phẩm
        boolean isCheckName = true;
        do {
            System.out.print("Nhập vào tên sản phẩm:");
            this.productName = scanner.nextLine();
            if (this.productName.length() > 50 || this.productName.length() < 10) {
                System.out.println("Tên sản phẩm nhiều hơn 10 ký tự và ít hơn 50 ký tự!\n");
            } else {
                boolean isNameDuplicate = false;
                for (int i = 0; i < currentIndexProduct; i++) {
                    if (this.productName.equals(arrProduct[i].getProductName())) {
                        isNameDuplicate = true;
                        System.out.println("Tên sản phẩm này bị trùng!");
                        break;
                    }
                }
                if (!isNameDuplicate) {
                    isCheckName = false;
                }
            }
        } while (isCheckName);

        //Giá sản phẩm
        do {
            System.out.print("Nhập giá sản phẩm:");
            this.price = Float.parseFloat(scanner.nextLine());
            if (this.price <= 0) {
                System.out.print("Giá sản phẩm phải lớn hơn 0");
            }
        } while (this.price <= 0);

        //Mô tả sản phẩm
        System.out.print("Nhập mô tả sản phẩm:");
        this.description = scanner.nextLine();

        //Nhập ngày nhập sản phẩm
        System.out.print("Nhập ngày nhập sản phẩm:");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.created = sdf.parse(scanner.nextLine());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        //Nhập mã danh mục mà sản phẩm này thuộc về
        boolean isCheckIdProductEqualIdCatalog = false;
        System.out.println("Các danh muc đang có:");
        for (int i = 0; i < arrCategories.length; i++) {
            if (arrCategories[i] != null) {
                arrCategories[i].displayData();
            }
        }
        do {
            System.out.print("Nhập mã danh mục sản phẩm thuộc về:");
            this.catalogId = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < arrCategories.length; i++) {
                if (arrCategories[i] != null) {
                    if (this.catalogId == arrCategories[i].getCatalogId()) {
                        isCheckIdProductEqualIdCatalog = true;
                        break;
                    }
                }
            }
            if (!isCheckIdProductEqualIdCatalog) {
                System.out.println("Không có mã danh mục này!!");
            }
        } while (!isCheckIdProductEqualIdCatalog);


        //Nhập trạng thái sản phẩm
        do {
            System.out.print("Nhập trạng thái sản phẩm: ");
            this.productStatus = Integer.parseInt(scanner.nextLine());
            if (this.productStatus < 0 || this.productStatus > 2) {
                System.out.println("Trạng thái sản phẩm chỉ nhận giá trị từ 0 - 2!");

            } else {
                break;
            }
        } while (true);

    }

    public void displayData() {
        System.out.printf("\nMã sản phẩm: %s - Tên sản phẩm: %s - Giá sản phẩm: %.2f - Mô tả: %s\n" +
                        "Ngày nhập sản phẩm: %s - Mã danh mục: %d - Trạng thái sản phẩm: %s\n",
                this.productId, this.productName, this.price, this.description, this.created, this.catalogId,
                this.productStatus == 0 ? "Đang bán" : this.productStatus == 1 ? "Hết hàng" : "Không bán");
    }
}
