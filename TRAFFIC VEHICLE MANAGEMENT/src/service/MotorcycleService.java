package service;

import entity.Motorcycle;
import repository.MotorcycleRepository;

public class MotorcycleService implements IMotorcycleService {
    private MotorcycleRepository motorcycleRepository;

    public MotorcycleService() {
        this.motorcycleRepository = new MotorcycleRepository();
    }

    @Override
    public void addMotorcycle(Motorcycle motorcycle) {
        motorcycleRepository.add(motorcycle);
    }

    @Override
    public void displayMotorcycles() {
        for (Motorcycle motorcycle : motorcycleRepository.getAll()) {
            System.out.println(motorcycle.toString());
        }
    }

    @Override
    public void removeMotorcycle(String licensePlate) {
        motorcycleRepository.remove(licensePlate);
    }

    @Override
    public void updateMotorcycle(Motorcycle motorcycle) {
        motorcycleRepository.update(motorcycle);
    }
}