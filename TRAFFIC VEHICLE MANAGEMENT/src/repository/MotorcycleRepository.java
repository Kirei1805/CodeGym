package repository;

import entity.Motorcycle;
import java.util.ArrayList;
import java.io.*;

public class MotorcycleRepository {
    private ArrayList<Motorcycle> motorcycles;
    private static final String FILE_NAME = "TRAFFIC VEHICLE MANAGEMENT/src/repository/motorcycle.csv";

    public MotorcycleRepository() {
        this.motorcycles = new ArrayList<>();
        loadFromFile();
    }

    public ArrayList<Motorcycle> getAll() {
        loadFromFile();
        return motorcycles;
    }

    public void add(Motorcycle motorcycle) {
        motorcycles.add(motorcycle);
        saveToFile();
    }

    public void remove(String licensePlate) {
        motorcycles.removeIf(m -> m.getLicensePlate().equals(licensePlate));
        saveToFile();
    }

    public void update(Motorcycle updatedMotorcycle) {
        for (int i = 0; i < motorcycles.size(); i++) {
            if (motorcycles.get(i).getLicensePlate().equals(updatedMotorcycle.getLicensePlate())) {
                motorcycles.set(i, updatedMotorcycle);
                break;
            }
        }
        saveToFile();
    }

    private void loadFromFile() {
        motorcycles.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // Bỏ qua dòng trống
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    try {
                        String licensePlate = parts[0].trim();
                        String manufacturer = parts[1].trim();
                        int year = Integer.parseInt(parts[2].trim());
                        String owner = parts[3].trim();
                        int horsePower = Integer.parseInt(parts[4].trim());
                        Motorcycle motorcycle = new Motorcycle(licensePlate, manufacturer, year, owner, horsePower);
                        motorcycles.add(motorcycle);
                    } catch (NumberFormatException e) {
                        // Bỏ qua dòng lỗi định dạng số
                        continue;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            // File chưa tồn tại, bỏ qua
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveToFile() {
        try {
            File file = new File(FILE_NAME);
            file.getParentFile().mkdirs(); // Tạo thư mục cha nếu chưa có
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (Motorcycle motorcycle : motorcycles) {
                String line = motorcycle.getLicensePlate() + "," +
                        motorcycle.getManufacturer() + "," +
                        motorcycle.getYear() + "," +
                        motorcycle.getOwner() + "," +
                        motorcycle.getHorsePower();
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}