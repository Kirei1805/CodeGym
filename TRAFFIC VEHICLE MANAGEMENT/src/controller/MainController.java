package controller;

import entity.Car;
import entity.Truck;
import entity.Motorcycle;
import java.util.ArrayList;
import java.util.Scanner;

public class MainController {
    private controller.CarController carController;
    private controller.TruckController truckController;
    private controller.MotorcycleController motorcycleController;
    private ArrayList<String> hangSanXuat;

    public MainController() {
        this.carController = new controller.CarController();
        this.truckController = new controller.TruckController();
        this.motorcycleController = new controller.MotorcycleController();
        this.hangSanXuat = new ArrayList<>();
        initializeManufacturerData();
    }

    private void initializeManufacturerData() {
        hangSanXuat.add("Yamaha");
        hangSanXuat.add("Honda");
        hangSanXuat.add("Dongfeng");
        hangSanXuat.add("Huyndai");
        hangSanXuat.add("Ford");
        hangSanXuat.add("Toyota");
        hangSanXuat.add("Hino");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addVehicle(scanner);
                    break;
                case 2:
                    displayVehicles(scanner);
                    break;
                case 3:
                    deleteVehicle(scanner);
                    break;
                case 4:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG");
        System.out.println("Chọn chức năng:");
        System.out.println("1. Thêm mới phương tiện.");
        System.out.println("2. Hiện thị phương tiện.");
        System.out.println("3. Xóa phương tiện.");
        System.out.println("4. Thoát.");
    }

    private void addVehicle(Scanner scanner) {
        System.out.println("1. Thêm xe tải, 2. Thêm ôtô, 3. Thêm xe máy");
        int type = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Biển kiểm soát: ");
        String license = scanner.nextLine();
        System.out.println("Chọn hãng sản xuất (1-Yamaha, 2-Honda, 3-Dongfeng, 4-Huyndai, 5-Ford, 6-Toyota, 7-Hino):");
        int manIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        System.out.print("Năm sản xuất: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Chủ sở hữu: ");
        String owner = scanner.nextLine();

        switch (type) {
            case 1:
                System.out.print("Trọng tải: ");
                double payload = scanner.nextDouble();
                truckController.addTruck(new Truck(license, hangSanXuat.get(manIndex), year, owner, payload));
                break;
            case 2:
                System.out.print("Số chỗ ngồi: ");
                int seats = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Kiểu xe (Du lịch/Xe khách): ");
                String carType = scanner.nextLine();
                carController.addCar(new Car(license, hangSanXuat.get(manIndex), year, owner, seats, carType));
                break;
            case 3:
                System.out.print("Công suất: ");
                int hp = scanner.nextInt();
                motorcycleController.addMotorcycle(new Motorcycle(license, hangSanXuat.get(manIndex), year, owner, hp));
                break;
        }
        System.out.println("Thêm mới thành công!");
    }

    private void displayVehicles(Scanner scanner) {
        System.out.println("1. Hiện thị xe tải, 2. Hiện thị ôtô, 3. Hiện xe máy");
        int type = scanner.nextInt();
        scanner.nextLine();
        switch (type) {
            case 1:
                truckController.displayTrucks();
                break;
            case 2:
                carController.displayCars();
                break;
            case 3:
                motorcycleController.displayMotorcycles();
                break;
        }
        scanner.nextLine();
    }

    private void deleteVehicle(Scanner scanner) {
        System.out.print("Nhập biển kiểm soát để xóa: ");
        String license = scanner.nextLine();
        boolean found = false;
        System.out.print("Xác nhận xóa (Yes/No): ");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("Yes")) {
            truckController.removeTruck(license);
            carController.removeCar(license);
            motorcycleController.removeMotorcycle(license);
            System.out.println("Đã xóa thành công");
        }
        scanner.nextLine();
    }
}