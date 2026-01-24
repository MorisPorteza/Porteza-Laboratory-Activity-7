package com.store.order;

// Abstract class represents a general concept of an Order. This enforces abstraction.
public abstract class Order {

    // Fields are private to enforce encapsulation
    private int orderId;
    private double amount;
    private OrderStatus status;

    // Constructor initializes required data.
    // Status is automatically set to PENDING to enforce a valid starting state.
    public Order(int orderId, double amount) {
        this.orderId = orderId;
        this.amount = amount;
        this.status = OrderStatus.PENDING;
    }

    // Abstract method forces subclasses to define how an order is processed.
    public abstract void processOrder();

    // Concrete method shared by all orders.
    // Getters are used instead of direct field access to preserve encapsulation.
    public String getOrderSummary() {
        return "Order ID: " + orderId +
               ", Amount: ₱" + amount +
               ", Status: " + status;
    }

    // Getters

    public int getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    // Setter with validation.
    // This prevents invalid amounts from corrupting the object.
    public void setAmount(double amount) {
        if (amount >= 0) {
            this.amount = amount;
        } else {
            System.out.println("Amount cannot be negative.");
        }
    }

    // Protected setter for status.
    // Only subclasses can change order status. This maintains controlled access.
    protected void setStatus(OrderStatus status) {
        this.status = status;
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
