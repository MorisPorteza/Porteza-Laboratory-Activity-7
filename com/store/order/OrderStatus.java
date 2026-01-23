package com.store.order;

// Enum is used because order status is a fixed set of values.
// This prevents invalid states from being assigned.

public enum OrderStatus {
    PENDING,
    PAID,
    SHIPPED,
    CANCELLED
}
