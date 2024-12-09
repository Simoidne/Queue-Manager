package Entities.MessagePackage;

import Entities.Order;

public class ComeToLineMsg implements TextMsg{

    @Override
    public String toString(Order order) {
        return "Please make your way to the line if you haven't done so already. We will be ready to serve you soon";
    }
}
