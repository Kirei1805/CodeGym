import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String name;
    private double price;
    private String manufacturer;
    private String description;

    public Product(String id, String name, double price, String manufacturer, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Mã: %s | Tên: %s | Giá: %.2f | Hãng: %s | Mô tả: %s",
                id, name, price, manufacturer, description);
    }

    public String getName() {
        return name;
    }
}
