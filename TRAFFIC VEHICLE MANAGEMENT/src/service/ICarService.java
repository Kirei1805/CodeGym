package service;

import entity.Car;

public interface ICarService {
    void addCar(Car car);
    void displayCars();
    void removeCar(String licensePlate);
    void updateCar(Car car);
}