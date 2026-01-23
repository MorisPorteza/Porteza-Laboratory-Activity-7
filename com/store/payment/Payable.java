package com.store.payment;

// Interface defines a payment contract.
// Any class that can be paid must implement this method.
// This supports abstraction without forcing inheritance.

public interface Payable {
    void pay();
}
