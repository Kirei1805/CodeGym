import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private static final String FILE_NAME = "products.dat";
    private static List<Product> productList = new ArrayList<>();

    // Load danh sách từ file
    public static void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            productList = (List<Product>) ois.readObject();
        } catch (Exception e) {
            productList = new ArrayList<>(); // File chưa có thì tạo mới
        }
    }

    // Lưu danh sách xuống file
    public static void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(productList);
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    // Thêm sản phẩm mới
    public static void addProduct(Scanner sc) {
        System.out.print("Nhập mã sản phẩm: ");
        String id = sc.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String name = sc.nextLine();
        System.out.print("Nhập giá: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập hãng sản xuất: ");
        String manufacturer = sc.nextLine();
        System.out.print("Nhập mô tả: ");
        String description = sc.nextLine();

        Product product = new Product(id, name, price, manufacturer, description);
        productList.add(product);
        saveToFile();
        System.out.println("Đã thêm sản phẩm.");
    }

    // Hiển thị danh sách
    public static void displayProducts() {
        if (productList.isEmpty()) {
            System.out.println("Danh sách rỗng.");
        } else {
            System.out.println("== Danh sách sản phẩm ==");
            for (Product p : productList) {
                System.out.println(p);
            }
        }
    }

    // Tìm kiếm theo tên
    public static void searchProduct(Scanner sc) {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String keyword = sc.nextLine().toLowerCase();
        boolean found = false;
        for (Product p : productList) {
            if (p.getName().toLowerCase().contains(keyword)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm.");
        }
    }
}
