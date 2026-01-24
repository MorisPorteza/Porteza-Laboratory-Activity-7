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
