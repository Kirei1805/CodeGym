package service;

import entity.Truck;
import repository.TruckRepository;

public class TruckService implements ITruckService {
    private TruckRepository truckRepository;

    public TruckService() {
        this.truckRepository = new TruckRepository();
    }

    @Override
    public void addTruck(Truck truck) {
        truckRepository.add(truck);
    }

    @Override
    public void displayTrucks() {
        for (Truck truck : truckRepository.getAll()) {
            System.out.println(truck.toString());
        }
    }

    @Override
    public void removeTruck(String licensePlate) {
        truckRepository.remove(licensePlate);
    }

    @Override
    public void updateTruck(Truck truck) {
        truckRepository.update(truck);
    }
}