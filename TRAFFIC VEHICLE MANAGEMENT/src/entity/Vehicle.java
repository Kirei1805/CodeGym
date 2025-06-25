package entity;

abstract class Vehicle {
    protected String licensePlate;
    protected String manufacturer;
    protected int year;
    protected String owner;

    public Vehicle() {
    }

    public Vehicle(String licensePlate, String manufacturer, int year, String owner) {
        this.licensePlate = licensePlate;
        this.manufacturer = manufacturer;
        this.year = year;
        this.owner = owner;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

}
