package controller;

import entity.Motorcycle;
import service.MotorcycleService;

public class MotorcycleController {
    private MotorcycleService motorcycleService;

    public MotorcycleController() {
        this.motorcycleService = new MotorcycleService();
    }

    public void addMotorcycle(Motorcycle motorcycle) {
        motorcycleService.addMotorcycle(motorcycle);
    }

    public void displayMotorcycles() {
        motorcycleService.displayMotorcycles();
    }

    public void removeMotorcycle(String licensePlate) {
        motorcycleService.removeMotorcycle(licensePlate);
    }
}