// File Name: BankAccountDemo.java

abstract class BankAccount {

    // immutable core data
    private final String accountNumber;
    private final double balance;

    // constructor
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // getters (no setters to maintain immutability)
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // polymorphic method
    public abstract double calculateFee();
}

// ================= SAVINGS ACCOUNT =================
class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    // 0.5% of balance
    @Override
    public double calculateFee() {
        return getBalance() * 0.005;
    }
}

// ================= CHECKING ACCOUNT =================
class CheckingAccount extends BankAccount {

    public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    // Flat 1.0 if balance < 1000 else 0.0
    @Override
    public double calculateFee() {
        return getBalance() < 1000.0 ? 1.0 : 0.0;
    }
}

// ================= MAIN CLASS =================
public class BankAccountDemo {

    public static void main(String[] args) {

        BankAccount savings = new SavingsAccount("12345", 1000.0);
        System.out.printf("%.2f%n", savings.calculateFee()); // 5.00

        BankAccount savings2 = new SavingsAccount("11111", 500.0);
        System.out.printf("%.2f%n", savings2.calculateFee()); // 2.50

        BankAccount checking1 = new CheckingAccount("22222", 1500.0);
        System.out.printf("%.2f%n", checking1.calculateFee()); // 0.00

        BankAccount checking2 = new CheckingAccount("33333", 500.0);
        System.out.printf("%.2f%n", checking2.calculateFee()); // 1.00
    }
}
