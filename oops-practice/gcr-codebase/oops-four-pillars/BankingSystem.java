// Interface
interface Loanable {
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}

// Abstract Class
abstract class BankAccount {

    // Encapsulation: private fields
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        if (balance >= 0) {
            this.balance = balance;
        }
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit (concrete)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Withdraw (concrete)
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    // Abstract method
    abstract double calculateInterest();
}

// Savings Account
class SavingsAccount extends BankAccount implements Loanable {

    public SavingsAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    double calculateInterest() {
        return getBalance() * 0.04; // 4% interest
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Savings Account Loan Applied: " + amount);
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 5; // 5x balance
    }
}

// Current Account
class CurrentAccount extends BankAccount implements Loanable {

    public CurrentAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    double calculateInterest() {
        return getBalance() * 0.02; // 2% interest
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Current Account Loan Applied: " + amount);
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 10; // 10x balance
    }
}

// Main Class
public class BankingSystem {

    public static void main(String[] args) {

        // Polymorphism: BankAccount reference
        BankAccount[] accounts = new BankAccount[2];

        accounts[0] = new SavingsAccount("SB101", "Rahul", 50000);
        accounts[1] = new CurrentAccount("CA201", "Aman", 80000);

        for (BankAccount acc : accounts) {

            System.out.println("Account Number: " + acc.getAccountNumber());
            System.out.println("Holder Name: " + acc.getHolderName());
            System.out.println("Balance: " + acc.getBalance());

            double interest = acc.calculateInterest();
            System.out.println("Interest: " + interest);

            Loanable loanAcc = (Loanable) acc;
            loanAcc.applyForLoan(20000);
            System.out.println("Loan Eligibility: " + loanAcc.calculateLoanEligibility());

            System.out.println();
        }
    }
}
