package UseCases;

import Entities.Customer;
import Entities.MessagePackage.ComeToLineMsg;
import Entities.MessagePackage.PlaceInLineMsg;
import Entities.Order;
import Entities.OrderQueue;
import Entities.MessagePackage.TextMsg;
import MessageSenderPackage.SmsSender;

import java.util.ArrayList;
import java.util.List;

public class NotifyCustomer {
    public int numOfComeToLine;
    public int numOfPlaceInLine;

    public NotifyCustomer(int numOfComeToLine, int numOfPlaceInLine) {
        this.numOfComeToLine = numOfComeToLine;
        this.numOfPlaceInLine = numOfPlaceInLine;
    }

    //notifies customers and then return list of Orders that didn't receive the text
    public List<Order> sendToNotifyPool(OrderQueue orderQueue) {
        ComeToLineMsg comeToLineMsg = new ComeToLineMsg();
        List<Order> notifyPool = orderQueue.getTop(numOfComeToLine);

        //Try two times
        List<Order> failToNotifyPool = sendTo(notifyPool, comeToLineMsg);
        failToNotifyPool = sendTo(failToNotifyPool, comeToLineMsg);

        return failToNotifyPool;
    }

    public List<Order> sendPlaceInLine(List<Order> orders) {
        PlaceInLineMsg placeInLineMsg = new PlaceInLineMsg();
        List<Order> failToNotifyPool = sendTo(orders, placeInLineMsg);
        failToNotifyPool = sendTo(failToNotifyPool, placeInLineMsg);
        return failToNotifyPool;
    }

    //Sends notifications to the list of orders and returns list of failed messages
    private List<Order> sendTo(List<Order> notifyPool, TextMsg msg) {
        List<Order> failToNotifyPool = new ArrayList<>();
        for (Order order : notifyPool) {
            Customer customer = order.getCustomer();
            if (!SmsSender.sendMessage(customer.getPhoneNum(), msg.toString(order))) {
                failToNotifyPool.add(order);
            }
        }
        return failToNotifyPool;
    }
}
