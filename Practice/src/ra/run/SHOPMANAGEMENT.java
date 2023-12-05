package ra.run;

import ra.entity.Categories;
import ra.entity.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class SHOPMANAGEMENT {
    //Khởi tạo mảng danh mục chứa thông tin các danh mục
    Categories[] arrCategories = new Categories[100];
    Product[] arrProduct = new Product[100];

    //Khai báo biến chỉ số cao nhất đang quản lý trong mảng
    int currentIndexCatalog = 0;
    int currentIndexProduct = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Khởi tạo đối tượng Main
        SHOPMANAGEMENT objShop = new SHOPMANAGEMENT();

        do {
            System.out.println("\n******************SHOP MENU*******************\n" +
                    "1. Quản lý danh mục sản phẩm\n" +
                    "2. Quản lý sản phẩm\n" +
                    "3. Thoát");
            System.out.print("Lựa chọn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    objShop.displayMenuCategories(scanner, objShop);
                    break;
                case 2:
                    objShop.displayMenuProduct(scanner, objShop);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Vui long nhap tu 1 den 3");
                    break;
            }
        } while (true);
    }

    public void displayMenuCategories(Scanner scanner, SHOPMANAGEMENT objShop) {
        boolean isExit = true;
        do {
            System.out.println("\n********************CATEGORIES MENU***********\n" +
                    "1. Nhập thông tin các danh mục\n" +
                    "2. Hiển thị thông tin các danh mục\n" +
                    "3. Cập nhật thông tin danh mục\n" +
                    "4. Xóa danh mục\n" +
                    "5. Cập nhật trạng thái danh mục\n" +
                    "6. Thoát");
            System.out.print("Lựa chọn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    objShop.inputCategories(scanner);
                    break;
                case 2:
                    objShop.displayCategories();
                    break;
                case 3:
                    objShop.updateInForCategaroies(scanner, objShop);
                    break;
                case 4:
                    objShop.deleteCategaroies(scanner, objShop);
                    break;
                case 5:
                    objShop.updateStatusCategaroies(scanner, objShop);
                    break;
                case 6:
                    isExit = false;
                    break;
                default:
                    System.out.println("Vui long nhap tu 1 den 3");
                    break;

            }
        } while (isExit);
    }

    public void displayMenuProduct(Scanner scanner, SHOPMANAGEMENT objShop) {

        boolean isExit = true;
        do {
            System.out.println("\n*******************PRODUCT MANAGEMENT*****************\n" +
                    "1. Nhập thông tin các sản phẩm\n" +
                    "2. Hiển thị thông tin các sản phẩm\n" +
                    "3. Sắp xếp các sản phẩm theo giá\n" +
                    "4. Cập nhật thông tin sản phẩm theo mã sản phẩm\n" +
                    "5. Xóa sản phẩm theo mã sản phẩm\n" +
                    "6. Tìm kiếm các sản phẩm theo tên sản phẩm\n" +
                    "7. Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn phím)\n" +
                    "8. Thoát");
            System.out.print("Lựa chọn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    objShop.inputProduct(scanner);
                    break;
                case 2:
                    objShop.displayProduct();
                    break;
                case 3:
                    objShop.sortProduct();
                    break;
                case 4:
                    objShop.updateProduct(scanner, objShop);
                    break;
                case 5:
                    objShop.deleteProduct(scanner, objShop);
                    break;
                case 6:
                    objShop.lookForProductByName(scanner);
                    break;
                case 7:
                    objShop.lookForProductByMoney(scanner);
                    break;
                case 8:
                    isExit = false;
                    break;
                default:
                    System.out.println("Vui long nhap tu 1 den 8");
                    break;
            }
        } while (isExit);
    }

    public void inputCategories(Scanner scanner) {
        System.out.print("Nhập vào số lượng danh mục cần nhập thông tin:");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.printf("Danh mục thứ %d:\n", i + 1);
            arrCategories[currentIndexCatalog] = new Categories();
            arrCategories[currentIndexCatalog].inputData(scanner, arrCategories, currentIndexCatalog);
            currentIndexCatalog++;
        }
    }

    public void displayCategories() {
        System.out.println("Hiển thị thông tin tất cả danh mục:");
        for (int i = 0; i < currentIndexCatalog; i++) {
            arrCategories[i].displayData();
        }
    }

    public void updateInForCategaroies(Scanner scanner, SHOPMANAGEMENT objShop) {
        int catalogIdUpdate;
        do {
            System.out.print("Nhập mã danh mục muốn cập nhật thông tin:");
            catalogIdUpdate = Integer.parseInt(scanner.nextLine());
            if (objShop.checkCatalogId(catalogIdUpdate) == -1) {
                System.out.println("Danh mục không tồn tại!");
            }
        } while (objShop.checkCatalogId(catalogIdUpdate) == -1);

        boolean isCheckName = true;
        do {
            System.out.print("Nhập tên danh mục muốn cập nhật: ");
            String catalogNameUpdate = scanner.nextLine();
            if (!Objects.equals(catalogNameUpdate, "")) {
                if (catalogNameUpdate.length() > 50) {
                    System.out.println("\nTên danh mục phải có ít hơn 50 ký tự!");
                } else {
                    boolean isNameDuplicate = false;
                    for (int i = 0; i < currentIndexCatalog; i++) {
                        if (catalogNameUpdate.equals(arrCategories[i].getCatalogName())) {
                            isNameDuplicate = true;
                            System.out.println("\nTên danh mục này bị trùng!");
                            break;
                        }
                    }

                    if (!isNameDuplicate) {
                        isCheckName = false;
                    }
                    arrCategories[catalogIdUpdate - 1].setCatalogName(catalogNameUpdate);
                    System.out.println("Cập nhật thành công");
                }
            }
        } while (isCheckName);

        System.out.print("Nhập mô tả danh mục muốn cập nhật: ");
        String descriptionsUpdate = scanner.nextLine();
        if (!Objects.equals(descriptionsUpdate, "")) {
            arrCategories[catalogIdUpdate - 1].setDescriptions(descriptionsUpdate);
            System.out.println("Cập nhật thành công");
        }
    }

    public void deleteCategaroies(Scanner scanner, SHOPMANAGEMENT objShop) {
        int catelogIdDelete;
        do {
            System.out.print("Nhập mã danh mục muốn xóa:");
            catelogIdDelete = Integer.parseInt(scanner.nextLine());
            if (objShop.checkCatalogId(catelogIdDelete) == -1) {
                System.out.println("Danh mục không tồn tại!");
            }
        } while (objShop.checkCatalogId(catelogIdDelete) == -1);

        boolean checkDelete = false;
        for (int i = 0; i < currentIndexProduct; i++) {
            if (catelogIdDelete == arrProduct[i].getCatalogId()) {
                checkDelete = true;
                System.out.println("Không thể xóa danh mục do có sản phẩm!");
                break;
            }
        }
        if (!checkDelete) {
            Categories[] newArrCategories = new Categories[currentIndexCatalog - 1];
            int pos = 0;
            for (int i = 0; i < currentIndexCatalog; i++) {
                if (catelogIdDelete != arrCategories[i].getCatalogId()) {
                    newArrCategories[pos] = arrCategories[i];
                    pos++;
                }
            }
            arrCategories = new Categories[100];
            for (int i = 0; i < currentIndexCatalog - 1; i++) {
                arrCategories[i] = newArrCategories[i];
            }
            currentIndexCatalog--;
            System.out.print("Xóa thành công");

        }
    }

    public void updateStatusCategaroies(Scanner scanner, SHOPMANAGEMENT objShop) {
        int catalogIdUpdate;
        do {
            System.out.print("Nhập mã danh mục muốn cập nhật trạng thái:");
            catalogIdUpdate = Integer.parseInt(scanner.nextLine());
            if (objShop.checkCatalogId(catalogIdUpdate) == -1) {
                System.out.println("Danh mục không tồn tại!");
            }
        } while (objShop.checkCatalogId(catalogIdUpdate) == -1);

        String catalogStatusUpdate;
        do {
            System.out.print("Nhập trạng thái danh mục muốn cập nhật:");
            catalogStatusUpdate = scanner.nextLine();
            if (!Objects.equals(catalogStatusUpdate, "")) {
                if (catalogStatusUpdate.equals("true") || catalogStatusUpdate.equals("false")) {
                    arrCategories[catalogIdUpdate - 1].setCatalogStatus(Boolean.parseBoolean(catalogStatusUpdate));
                    System.out.print("Cập nhật thành công");
                    break;
                } else {
                    System.out.print("Trạng thái chỉ nhận true hoặc false!");
                }
            }
        } while (catalogStatusUpdate.equals("true") || catalogStatusUpdate.equals("false"));
    }

    public int checkCatalogId(int idCheck) {
        for (int i = 1; i <= currentIndexCatalog; i++) {
            if (idCheck == i) {
                return idCheck;
            }
        }
        return -1;
    }

    public void inputProduct(Scanner scanner) {
        System.out.print("Nhập vào số lượng sản phẩm:");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.printf("Sản phẩm thứ %d:\n", i + 1);
            arrProduct[currentIndexProduct] = new Product();
            arrProduct[currentIndexProduct].inputData(scanner, arrProduct, currentIndexProduct, arrCategories);
            currentIndexProduct++;
        }
    }

    public void displayProduct() {
        System.out.println("Hiển thị thông tin tất cả sản phẩm:");
        for (int i = 0; i < currentIndexProduct; i++) {
            this.arrProduct[i].displayData();
        }
    }

    public void sortProduct() {
        Product temp;
        System.out.println("Sắp xếp các sản phẩm theo giá:");
        for (int i = 0; i < currentIndexProduct - 1; i++) {
            for (int j = i + 1; j < currentIndexProduct; j++) {
                if (arrProduct[i].getPrice() > arrProduct[j].getPrice()) {
                    temp = arrProduct[i];
                    arrProduct[i] = arrProduct[j];
                    arrProduct[j] = temp;
                }
            }
        }
        System.out.println("Sắp xếp thành công! Ấn 2 để kiểm tra kết quả.");
    }

    public void updateProduct(Scanner scanner, SHOPMANAGEMENT objShop) {
        //Lấy mã sản phẩm để cập nhật
        String productIdUpdate;
        do {
            System.out.print("Nhập mã sản phẩm của sản phẩm cần cập nhật thông tin:");
            productIdUpdate = scanner.nextLine();
            if (Objects.equals(objShop.checkProductId(productIdUpdate), "")) {
                System.out.print("Sản phẩm không tồn tại!");
            } else {
                break;
            }
        } while (true);

        //Lấy chỉ số sản phẩm để cập nhật
        int productIndexUpdate = objShop.checkIndexProduct(productIdUpdate);

        //Cập nhật tên sản phẩm
        boolean isCheckName = true;
        do {
            System.out.print("Nhập vào tên sản phẩm muốn cập nhật:");
            String productNameUpdate = scanner.nextLine();
            if (!Objects.equals(productNameUpdate, "")) {
                if (productNameUpdate.length() > 50 || productNameUpdate.length() < 10) {
                    System.out.println("Tên sản phẩm nhiều hơn 10 ký tự và ít hơn 50 ký tự!\n");
                } else {
                    boolean isNameDuplicate = false;
                    for (int i = 0; i < currentIndexProduct; i++) {
                        if (productNameUpdate.equals(arrProduct[i].getProductName())) {
                            isNameDuplicate = true;
                            System.out.println("Tên sản phẩm này bị trùng!");
                            break;
                        }
                    }
                    if (!isNameDuplicate) {
                        isCheckName = false;
                    }
                    arrProduct[productIndexUpdate].setProductName(productNameUpdate);
                    System.out.println("Cập nhật thành công");
                }
            } else {
                break;
            }
        } while (isCheckName);

        //Cập nhật giá sản phẩm
        boolean isCheckPrice = true;
        do {
            System.out.print("Nhập giá sản phẩm muốn cập nhật: ");
            String priceProductUpdate = scanner.nextLine();
            if (!Objects.equals(priceProductUpdate, "")) {
                if (Float.parseFloat(priceProductUpdate) <= 0) {
                    isCheckPrice = false;
                    System.out.print("Giá sản phẩm phải lớn hơn 0");
                } else {
                    arrProduct[productIndexUpdate].setPrice(Float.parseFloat(priceProductUpdate));
                    System.out.println("Cập nhật thành công");
                    break;
                }
            } else {
                break;
            }
        } while (isCheckPrice);

        //Cập nhật mô tả sản phẩm
        System.out.print("Nhập mô tả sản phẩm muốn cập nhật: ");
        String descriptionsProductUpdate = scanner.nextLine();
        if (!Objects.equals(descriptionsProductUpdate, "")) {
            arrProduct[productIndexUpdate].setDescription(descriptionsProductUpdate);
            System.out.println("Cập nhật thành công");
        }

        //Cập nhật ngày nhập sản phẩm
        System.out.print("Nhập ngày nhập sản phẩm muốn cập nhật: ");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date productCreatedUpdate;
        try {
            String dateInput = scanner.nextLine();

            if (!Objects.equals(dateInput, "")) {
                productCreatedUpdate = sdf.parse(dateInput);
                arrProduct[productIndexUpdate].setCreated(productCreatedUpdate);
                System.out.println("Cập nhật thành công");
            } else {
                System.out.println("Giá trị ngày không hợp lệ");
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        //Cập nhật mã danh mục mà sản phẩm thuộc về
        boolean isCheckIdProductEqualIdCatalog = false;
        System.out.println("Các danh muc đang có:");
        for (int i = 0; i < currentIndexCatalog; i++) {
            arrCategories[i].displayData();
        }
        do {
            System.out.print("Nhập mã danh mục sản phẩm thuộc về:");
            String idCatalogProduct = scanner.nextLine();
            if (!Objects.equals(idCatalogProduct, "")) {
                for (int i = 0; i < currentIndexCatalog; i++) {
                    if (Integer.parseInt(idCatalogProduct) == arrCategories[i].getCatalogId()) {
                        isCheckIdProductEqualIdCatalog = true;
                        break;
                    }
                }
                if (!isCheckIdProductEqualIdCatalog) {
                    System.out.println("Không có mã danh mục này!!");
                }
                arrProduct[productIndexUpdate].setCatalogId(Integer.parseInt(idCatalogProduct));
                System.out.println("Cập nhật thành công");
            } else {
                break;
            }
        } while (!isCheckIdProductEqualIdCatalog);

        //Cập nhật trạng thái sản phẩm
        do {
            System.out.print("Nhập trạng thái sản phẩm muốn cập nhật: ");
            String productStatusUpdate = scanner.nextLine();
            if (!Objects.equals(productStatusUpdate, "")) {
                if (Integer.parseInt(productStatusUpdate) < 0 || Integer.parseInt(productStatusUpdate) > 2) {
                    System.out.println("Trạng thái sản phẩm chỉ nhận giá trị từ 0 - 2!");
                } else {
                    break;
                }
                arrProduct[productIndexUpdate].setCatalogId(Integer.parseInt(productStatusUpdate));
                System.out.println("Cập nhật thành công");
            } else {
                break;
            }
        } while (true);
    }

    public void deleteProduct(Scanner scanner, SHOPMANAGEMENT objShop) {
        String productIdDelete;
        do {
            System.out.print("Nhập mã sản phẩm muốn xóa:");
            productIdDelete = scanner.nextLine();
            if (Objects.equals(objShop.checkProductId(productIdDelete), "")) {
                System.out.println("Sản phẩm không tồn tại!");
            } else {
                break;
            }
        } while (true);


        Product[] newArrProduct = new Product[currentIndexProduct - 1];

        int pos = 0;
        for (int i = 0; i < currentIndexProduct; i++) {
            if (!Objects.equals(productIdDelete, arrProduct[i].getProductId())) {
                newArrProduct[pos] = arrProduct[i];
                pos++;
            }
        }

        arrProduct = new Product[100];
        for (int i = 0; i < currentIndexProduct - 1; i++) {
            arrProduct[i] = newArrProduct[i];
        }
        currentIndexProduct--;
        System.out.print("Xóa thành công");
    }

    public void lookForProductByName(Scanner scanner) {
        System.out.print("Nhập sản phẩm bạn muốn tìm theo tên: ");
        String nameProductLookFor = scanner.nextLine();
        System.out.println("Sản phẩm theo tên bạn tìm:");
        boolean checkLookForProduct = false;
        for (int i = 0; i < currentIndexProduct; i++) {
            if (arrProduct[i].getProductName().contains(nameProductLookFor)) {
                checkLookForProduct = true;
                arrProduct[i].displayData();
            }
        }
        if (!checkLookForProduct) {
            System.out.print("Không có sản phẩm theo tên bạn tìm!");
        }
    }

    public void lookForProductByMoney(Scanner scanner) {
        System.out.println("Nhập khoảng giá tiền (a - b) để tìm kiếm sản phẩm: ");
        System.out.print("Giá tiền a:");
        float moneyA = Float.parseFloat(scanner.nextLine());
        System.out.print("Giá tiền b:");
        float moneyB = Float.parseFloat(scanner.nextLine());
        boolean checkLookForProduct = false;
        for (int i = 0; i < currentIndexProduct; i++) {
            if (arrProduct[i].getPrice() >= moneyA && arrProduct[i].getPrice() <= moneyB) {
                checkLookForProduct = true;
                arrProduct[i].displayData();
            }
        }
        if (!checkLookForProduct) {
            System.out.print("Không có sản phẩm theo giá tiền bạn tìm!");
        }
    }

    public String checkProductId(String idCheckProduct) {
        for (int i = 0; i < currentIndexProduct; i++) {
            if (Objects.equals(idCheckProduct, arrProduct[i].getProductId())) {
                return idCheckProduct;
            }
        }
        return "";
    }

    public int checkIndexProduct(String idCheckProduct) {
        for (int i = 0; i < currentIndexProduct; i++) {
            if (Objects.equals(idCheckProduct, arrProduct[i].getProductId())) {
                return i;
            }
        }
        return -1;
    }
}
