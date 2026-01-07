import java.util.*;

// Bank service interface
interface BankService {
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientBalanceException;
    double getBalance();
    double calculateInterest();
}

// Custom exception
class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String msg) {
        super(msg);
    }
}

// Account class
abstract class Account implements BankService {
    int accountNumber;
    double balance;

    Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public synchronized void withdraw(double amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

// Savings account
class SavingsAccount extends Account {

    SavingsAccount(int accNo, double balance) {
        super(accNo, balance);
    }

    public double calculateInterest() {
        return balance * 0.04;
    }
}

// Current account
class CurrentAccount extends Account {

    CurrentAccount(int accNo, double balance) {
        super(accNo, balance);
    }

    public double calculateInterest() {
        return balance * 0.02;
    }
}

// Transaction thread
class Transaction extends Thread {
    Account from;
    Account to;
    double amount;

    Transaction(Account from, Account to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public void run() {
        try {
            synchronized (from) {
                from.withdraw(amount);
            }
            to.deposit(amount);
            System.out.println("Transferred " + amount +
                    " from " + from.accountNumber +
                    " to " + to.accountNumber);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}

// Main class
public class OnlineBankingSystem {

    static List<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {

        Account acc1 = new SavingsAccount(101, 5000);
        Account acc2 = new CurrentAccount(102, 3000);

        System.out.println("Account created");
        System.out.println("Account 101 balance: " + acc1.getBalance());
        System.out.println("Account 102 balance: " + acc2.getBalance());

        // Multithreaded fund transfer
        Thread t1 = new Transaction(acc1, acc2, 2000);
        Thread t2 = new Transaction(acc1, acc2, 1500);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Balance check
        System.out.println("\nFinal balance:");
        System.out.println("Account 101: " + acc1.getBalance());
        System.out.println("Account 102: " + acc2.getBalance());

        // Interest calculation (Polymorphism)
        System.out.println("\nInterest:");
        System.out.println("Savings account interest: " + acc1.calculateInterest());
        System.out.println("Current account interest: " + acc2.calculateInterest());
    }
}
