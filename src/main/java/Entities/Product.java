package Entities;

public class Product {
    public String name;
    public String description;
    public double unitPrice;

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.unitPrice = price;
    }

    public String getProductName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
