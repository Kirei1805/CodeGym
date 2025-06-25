package controller;

import entity.Truck;
import service.TruckService;

public class TruckController {
    private TruckService truckService;

    public TruckController() {
        this.truckService = new TruckService();
    }

    public void addTruck(Truck truck) {
        truckService.addTruck(truck);
    }

    public void displayTrucks() {
        truckService.displayTrucks();
    }

    public void removeTruck(String licensePlate) {
        truckService.removeTruck(licensePlate);
    }
}