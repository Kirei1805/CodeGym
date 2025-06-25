package service;

import entity.Motorcycle;

public interface IMotorcycleService {
    void addMotorcycle(Motorcycle motorcycle);
    void displayMotorcycles();
    void removeMotorcycle(String licensePlate);
    void updateMotorcycle(Motorcycle motorcycle);
}