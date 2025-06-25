import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductManager.loadFromFile();
        while (true) {
            System.out.println("\n==== MENU ====");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Tìm kiếm theo tên");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    ProductManager.addProduct(sc);
                    break;
                case "2":
                    ProductManager.displayProducts();
                    break;
                case "3":
                    ProductManager.searchProduct(sc);
                    break;
                case "0":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
