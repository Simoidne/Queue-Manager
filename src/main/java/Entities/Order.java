package Entities;

import java.util.HashMap;
import java.util.List;
import ExceptionsPackage.NoCorrespondingQuantityException;

public class Order {
    public int orderId;
    public Customer customer;
    public List<Product> products;
    public List<Double> productQuant;
    public boolean paid;

    public Order(int orderId, Customer customer, List<Product> products,
                 List<Double> productQuant, boolean paid) throws NoCorrespondingQuantityException {
        this.orderId = orderId;
        this.customer = customer;
        this.products = products;
        this.productQuant = productQuant;
        checkProductHasCorrespondingQuantity();
        this.paid = paid;
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public boolean isPaid() {
        return paid;
    }

    public void paymentReceived() {
        paid = true;
    }

    // Returns a map from the product name to the quantity of products
    public HashMap<String, Double> getProductsAndQuantities() throws NoCorrespondingQuantityException {
        checkProductHasCorrespondingQuantity();

        HashMap<String, Double> productsAndQuantities = new HashMap<>();
        for (int i = 0; i < products.size(); i++) {
            productsAndQuantities.put(products.get(i).getProductName(), productQuant.get(i));
        }
        return productsAndQuantities;
    }

    public void addProduct(Product product, double quantity) throws NoCorrespondingQuantityException {
        products.add(product);
        productQuant.add(quantity);

        checkProductHasCorrespondingQuantity();
    }

    // Returns the Total price of all products in this Order
    public double getTotalPrice() throws NoCorrespondingQuantityException {
        checkProductHasCorrespondingQuantity();

        double totalPrice = 0;
        for (int i = 0; i < products.size(); i++) {
            totalPrice += products.get(i).unitPrice * productQuant.get(1);
        }
        return totalPrice;
    }

    // Throws an exception if the size of the product list and the size of the quantities list is different
    private void checkProductHasCorrespondingQuantity() throws NoCorrespondingQuantityException{
        if (products.size() != productQuant.size()) {
            throw new NoCorrespondingQuantityException();
        }
    }
}
