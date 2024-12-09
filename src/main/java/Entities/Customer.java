package Entities;

public class Customer {
    public String name;
    public String phoneNum;

    public Customer(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }
}
