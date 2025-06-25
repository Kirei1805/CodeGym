package entity;

public class Truck extends Vehicle {
    private double payload;
    public Truck() {
    }
    public Truck(String licensePlate, String manufacturer, int year, String owner, double payload) {
        super(licensePlate, manufacturer, year, owner);
        this.payload = payload;
    }

    public double getPayload() {
        return payload;
    }

    public void setPayload(double payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "payload=" + payload +
                ", owner='" + owner + '\'' +
                ", year=" + year +
                ", licensePlate='" + licensePlate + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
