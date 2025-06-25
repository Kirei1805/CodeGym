package service;

import entity.Truck;

public interface ITruckService {
    void addTruck(Truck truck);
    void displayTrucks();
    void removeTruck(String licensePlate);
    void updateTruck(Truck truck);
}