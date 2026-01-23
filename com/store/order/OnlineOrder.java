package com.store.order;

import com.store.payment.Payable;

// OnlineOrder is a specific type of Order.
// It extends Order to reuse common behavior and implements Payable to guarantee payment capability.
public class OnlineOrder extends Order implements Payable {

    public OnlineOrder(int orderId, double amount) {
        super(orderId, amount);
    }

    // Concrete implementation of abstract method.
    // This is required because Order declares processOrder() as abstract.
    @Override
    public void processOrder() {
        System.out.println("Processing online order ID: " + getOrderId());
    }

    // Implements Payable interface.
    // This updates status safely using protected setter.
    @Override
    public void pay() {
        setStatus(OrderStatus.PAID);
        System.out.println("Order ID " + getOrderId() + " has been paid.");
    }
}
