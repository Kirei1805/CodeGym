package entity;

public class Motorcycle extends Vehicle {
    private int horsePower;

    public Motorcycle() {}

    public Motorcycle(String licensePlate, String manufacturer, int year, String owner, int horsePower) {
        super(licensePlate, manufacturer, year, owner);
        this.horsePower = horsePower;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "horsePower=" + horsePower +
                ", manufacturer='" + manufacturer + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", owner='" + owner + '\'' +
                ", year=" + year +
                '}';
    }
}
