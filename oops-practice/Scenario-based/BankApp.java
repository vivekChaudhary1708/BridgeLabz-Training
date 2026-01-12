import java.util.*;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}

interface BankService {
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientBalanceException;
    void transfer(Account toAccount, double amount) throws InsufficientBalanceException;
    double getBalance();
    void printTransactionHistory();
}

abstract class Account implements BankService {
    protected String accountNumber;
    protected String holderName;
    protected double balance;
    protected List<String> transactions = new ArrayList<>();

    public Account(String accNo, String name, double balance) {
        this.accountNumber = accNo;
        this.holderName = name;
        this.balance = balance;
        transactions.add("Account opened with balance: " + balance);
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: " + amount);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Not enough balance");
        }
        balance -= amount;
        transactions.add("Withdrawn: " + amount);
    }

    public void transfer(Account toAccount, double amount) throws InsufficientBalanceException {
        this.withdraw(amount);
        toAccount.deposit(amount);
        transactions.add("Transferred " + amount + " to " + toAccount.holderName);
    }

    public double getBalance() {
        return balance;
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History for " + holderName);
        for (String t : transactions) {
            System.out.println(t);
        }
    }

    public abstract double calculateInterest();
}

class SavingsAccount extends Account {
    public SavingsAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    public double calculateInterest() {
        return balance * 0.04;
    }
}

class CurrentAccount extends Account {
    public CurrentAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    public double calculateInterest() {
        return balance * 0.02;
    }
}

public class BankApp {
    public static void main(String[] args) {
        Account a1 = new SavingsAccount("101", "Vivek", 5000);
        Account a2 = new CurrentAccount("102", "Rahul", 3000);

        try {
            a1.deposit(2000);
            a1.withdraw(1000);
            a1.transfer(a2, 1500);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(a1.getBalance());
        System.out.println(a2.getBalance());

        System.out.println(a1.calculateInterest());
        System.out.println(a2.calculateInterest());

        a1.printTransactionHistory();
        a2.printTransactionHistory();
    }
}
