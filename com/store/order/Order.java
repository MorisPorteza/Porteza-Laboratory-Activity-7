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
               ", Amount: $" + amount +
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
