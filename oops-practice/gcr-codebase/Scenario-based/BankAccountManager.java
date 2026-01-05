class BankAccount {

    private String accountNumber;
    private double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
        }
    }

    double checkBalance() {
        return balance;
    }
}

public class BankAccountManager {

    public static void main(String[] args) {

        BankAccount account = new BankAccount("ACC101", 5000);

        account.deposit(2000);
        account.withdraw(3000);
        account.withdraw(6000);   // overdraft not allowed

        System.out.println(account.checkBalance());
    }
}
