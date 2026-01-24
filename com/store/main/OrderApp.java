package com.store.main;

import com.store.order.*;
import java.util.ArrayList;
import java.util.Iterator;

// This is the main application class that's responsible only for running the program.
public class OrderApp {

    public static void main(String[] args) {

        // Abstract type Order is used to demonstrate abstraction and allow different order types in the same collection.
        ArrayList<Order> orders = new ArrayList<>();

        // Create OnlineOrder objects
        OnlineOrder order1 = new OnlineOrder(101, 342.40);
        OnlineOrder order2 = new OnlineOrder(102, 111.50);
        OnlineOrder order3 = new OnlineOrder(103, 637.89);

        // Add orders to the collection
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        
        System.out.println("𝐏𝐨𝐫𝐭𝐞𝐳𝐚'𝐬 𝐎𝐫𝐝𝐞𝐫 𝐌𝐚𝐧𝐚𝐠𝐞𝐦𝐞𝐧𝐭 𝐒𝐲𝐬𝐭𝐞𝐦");
        
        System.out.println();
        
        // Added for demonstration only.
        // Shows that the method processOrder works.
        order1.processOrder();
        order2.processOrder();
        order3.processOrder();
        
        // Cancel one order using a controlled public method.
        // This properly changes the order state while preserving encapsulation.
        order2.cancelOrder();
        
        // Register one order as paid.
        order3.pay();
        
        // Iterator is used to allow safe traversal and removal of elements.
        Iterator<Order> iterator = orders.iterator();

        while (iterator.hasNext()) {
            Order order = iterator.next();

            // Display order summary
            System.out.println(order.getOrderSummary());

            // Remove orders that are cancelled.
            // iterator.remove() prevents ConcurrentModificationException.
            if (order.getStatus() == OrderStatus.CANCELLED) {
                iterator.remove();
        
            }
        }
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

// Text style generated using: https://boldtext.online/
