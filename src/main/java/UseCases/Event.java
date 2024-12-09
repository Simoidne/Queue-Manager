package UseCases;

import Entities.Order;
import Entities.OrderQueue;

import java.util.List;

public class Event {

    public void finishOrder(Order order, OrderQueue orderQueue, NotifyCustomer notifier) {
        orderQueue.removeOrder(order);
        List<Order> failedToRecieveList = notifier.sendToNotifyPool(orderQueue);
        int numOfComeTOLine = notifier.numOfComeToLine;
        int numOfPlaceInLine = notifier.numOfPlaceInLine;
        failedToRecieveList.addAll(notifier.sendPlaceInLine(
                orderQueue.getOrders().subList(numOfComeTOLine, numOfComeTOLine + numOfPlaceInLine)));
    }
    //Notify the top x people in line
}
