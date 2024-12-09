package Entities;
import java.util.List;

public class OrderQueue {
    public List<Order> orders;

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void removeOrder(Order order) {
        orders.remove(placeInQueue(order));
    }

    public int placeInQueue(Order order) {
        return orders.indexOf(order);
    }

    public int queueSize() {
        return orders.size();
    }

    public List<Order> getTop(int num) {
        return orders.subList(0, num);
    }
}
