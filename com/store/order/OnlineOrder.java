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
        System.out.println("Order ID " + getOrderId() + " has been successfully paid.");
    }
    
    // Used to cancel order.
    public void cancelOrder() {
        setStatus(OrderStatus.CANCELLED);
        System.out.println("Order ID " + getOrderId() + " has been cancelled.");
    }
}

// Submitted by: Porteza, Moris L. (BSCS-2D)

// AI Model: GPT-5 (ChatGPT)

// AI Prompt:
// You are tasked with developing a simple Order Management System for a small online store.
// The system should allow the creation of different types of orders while ensuring that order data
// is protected and accessed safely.
// Build the project using three packages: com.store.order, com.store.payment, and com.store.main,
// with each package containing only the classes relevant to its purpose.
// In the com.store.order package, create an OrderStatus enum with values PENDING, PAID, SHIPPED,
// and CANCELLED to represent the current state of an order.
// Create an abstract Order class in com.store.order with private fields orderId, amount, and status,
// a constructor that initializes orderId and amount and sets status to PENDING, an abstract processOrder()
// method, and a concrete getOrderSummary() method that returns a summary string.
// Implement getters for all private fields and a setter for amount that prevents negative values.
// Also include a protected setter for status so only subclasses can change it.
// In the com.store.payment package, define a Payable interface with a single method void pay()
// to represent payment behavior.
// Implement a concrete OnlineOrder class in com.store.order that extends Order and implements Payable,
// overrides processOrder() to print a processing message, implements pay() to set the status to PAID,
// and includes a cancelOrder() method that sets the status to CANCELLED, all while keeping fields private
// and using methods for access.
// In the com.store.main package create an OrderApp class with a main method that stores multiple
// OnlineOrder objects in an ArrayList<Order>, cancels at least one order using the cancelOrder() method,
// and then traverses the list using an Iterator<Order> to print each order’s summary and remove any cancelled
// orders using iterator.remove() without using index-based access.
// After everything, explain to me all the OOP concepts used in the program.

// Transaction ID: https://chatgpt.com/share/697412f9-a020-8003-8226-5ee932d85942
