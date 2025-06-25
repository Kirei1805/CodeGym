package repository;

import entity.Car;
import java.util.ArrayList;
import java.io.*;

public class CarRepository {
    private ArrayList<Car> cars;
    private static final String FILE_NAME = "TRAFFIC VEHICLE MANAGEMENT/src/repository/car.csv";

    public CarRepository() {
        this.cars = new ArrayList<>();
        loadFromFile();
    }

    public ArrayList<Car> getAll() {
        loadFromFile();
        return cars;
    }

    public void add(Car car) {
        cars.add(car);
        saveToFile();
    }

    public void remove(String licensePlate) {
        cars.removeIf(car -> car.getLicensePlate().equals(licensePlate));
        saveToFile();
    }

    public void update(Car updatedCar) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getLicensePlate().equals(updatedCar.getLicensePlate())) {
                cars.set(i, updatedCar);
                break;
            }
        }
        saveToFile();
    }

    private void loadFromFile() {
        cars.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    try {
                        String licensePlate = parts[0].trim();
                        String manufacturer = parts[1].trim();
                        int year = Integer.parseInt(parts[2].trim());
                        String owner = parts[3].trim();
                        int seats = Integer.parseInt(parts[4].trim());
                        String type = parts[5].trim();
                        Car car = new Car(licensePlate, manufacturer, year, owner, seats, type);
                        cars.add(car);
                    } catch (NumberFormatException e) {
                        continue;
                    }
                }
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveToFile() {
        try {
            File file = new File(FILE_NAME);
            file.getParentFile().mkdirs(); // Tạo thư mục cha nếu chưa có
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (Car car : cars) {
                String line = car.getLicensePlate() + "," +
                        car.getManufacturer() + "," +
                        car.getYear() + "," +
                        car.getOwner() + "," +
                        car.getSeats() + "," +
                        car.getType();
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}