public class BankAccount {

    private double balance = 0;

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid deposit amount");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
