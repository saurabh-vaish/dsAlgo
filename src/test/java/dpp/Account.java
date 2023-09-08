package dpp;

/**
 * @Author saurabh vaish
 * @Date 19-08-2023
 */
public class Account {
    private double balance;
    private double overdraftLimit;

    public Account(double overdraftLimit) {
        this.balance = 0.0;
        this.overdraftLimit = overdraftLimit > 0 ? overdraftLimit : 0;
    }

    public Account(double balance, double overdraftLimit) {
        this.balance = balance;
        this.overdraftLimit = overdraftLimit;
    }

    public Account() {
    }

    public static AccountBuilder builder() {
        return new AccountBuilder();
    }

    public boolean deposite(double amount) {
        if (amount >= 0) {
            this.balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (this.balance - amount >= -this.overdraftLimit && amount >= 0) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public static class AccountBuilder {
        private double balance;
        private double overdraftLimit;

        AccountBuilder() {
        }

        public AccountBuilder balance(double balance) {
            this.balance = balance;
            return this;
        }

        public AccountBuilder overdraftLimit(double overdraftLimit) {
            this.overdraftLimit = overdraftLimit;
            return this;
        }

        public Account build() {
            return new Account(this.balance, this.overdraftLimit);
        }

        public String toString() {
            return "Account.AccountBuilder(balance=" + this.balance + ", overdraftLimit=" + this.overdraftLimit + ")";
        }
    }
}
