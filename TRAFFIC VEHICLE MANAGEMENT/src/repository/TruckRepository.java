package repository;

import entity.Truck;
import java.util.ArrayList;
import java.io.*;

public class TruckRepository {
    private ArrayList<Truck> trucks;
    private static final String FILE_NAME = "TRAFFIC VEHICLE MANAGEMENT/src/repository/truck.csv";

    public TruckRepository() {
        this.trucks = new ArrayList<>();
        loadFromFile();
    }

    public ArrayList<Truck> getAll() {
        loadFromFile();
        return trucks;
    }

    public void add(Truck truck) {
        trucks.add(truck);
        saveToFile();
    }

    public void remove(String licensePlate) {
        trucks.removeIf(t -> t.getLicensePlate().equals(licensePlate));
        saveToFile();
    }

    public void update(Truck updatedTruck) {
        for (int i = 0; i < trucks.size(); i++) {
            if (trucks.get(i).getLicensePlate().equals(updatedTruck.getLicensePlate())) {
                trucks.set(i, updatedTruck);
                break;
            }
        }
        saveToFile();
    }

    private void loadFromFile() {
        trucks.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    try {
                        String licensePlate = parts[0].trim();
                        String manufacturer = parts[1].trim();
                        int year = Integer.parseInt(parts[2].trim());
                        String owner = parts[3].trim();
                        double payload = Double.parseDouble(parts[4].trim());
                        Truck truck = new Truck(licensePlate, manufacturer, year, owner, payload);
                        trucks.add(truck);
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
            for (Truck truck : trucks) {
                String line = truck.getLicensePlate() + "," +
                        truck.getManufacturer() + "," +
                        truck.getYear() + "," +
                        truck.getOwner() + "," +
                        truck.getPayload();
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}