package org.coffee.order;

public class Order {

    private int orderNumber;
    private String clientName;

    public Order(int orderNumber, String clientName) {
        this.orderNumber = orderNumber;
        this.clientName = clientName;
    }

    public int getOrderNumber() {
        return orderNumber;
    }


    public String getClientName() {
        return clientName;
    }

}
