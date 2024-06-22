package com.shortthirdman.medihub.domain;

import com.shortthirdman.medihub.common.exception.InsufficientFundsException;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {

    private Long id;
    private BigDecimal balance;
    private BigDecimal adminFee;

    // Constructors, getters, and setters are omitted for brevity.

    public void deposit(BigDecimal amount) {
        validateAmountNonNegative(amount);
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) throws InsufficientFundsException {
        validateAmountNonNegative(amount);
        if (hasSufficientFunds(amount)) {
            this.balance = this.balance.subtract(amount);
        } else {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }
    }

    public void applyAdminFee() throws InsufficientFundsException {
        if (this.balance.compareTo(adminFee) < 0) {
            throw new InsufficientFundsException("Insufficient funds to cover the admin fee.");
        }
        this.balance = this.balance.subtract(adminFee);
    }

    private void validateAmountNonNegative(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
    }

    private boolean hasSufficientFunds(BigDecimal amount) {
        return this.balance.compareTo(amount) >= 0;
    }
}
