package controller;

import entity.Car;
import service.CarService;

public class CarController {
    private CarService carService;

    public CarController() {
        this.carService = new CarService();
    }

    public void addCar(Car car) {
        carService.addCar(car);
    }

    public void displayCars() {
        carService.displayCars();
    }

    public void removeCar(String licensePlate) {
        carService.removeCar(licensePlate);
    }
}