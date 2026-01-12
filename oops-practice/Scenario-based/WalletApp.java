import java.util.*;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}

interface TransferService {
    void transfer(Wallet from, Wallet to, double amount) throws InsufficientBalanceException;
}

class WalletTransfer implements TransferService {
    public void transfer(Wallet from, Wallet to, double amount) throws InsufficientBalanceException {
        if (from.balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        from.balance -= amount;
        to.balance += amount;
        from.transactions.add(new Transaction("Sent " + amount));
        to.transactions.add(new Transaction("Received " + amount));
    }
}

class BankTransfer implements TransferService {
    public void transfer(Wallet from, Wallet to, double amount) throws InsufficientBalanceException {
        double fee = 50;
        if (from.balance < amount + fee) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        from.balance -= (amount + fee);
        to.balance += amount;
        from.transactions.add(new Transaction("Sent " + amount + " via Bank"));
        to.transactions.add(new Transaction("Received " + amount + " via Bank"));
    }
}

class User {
    String name;

    public User(String name) {
        this.name = name;
    }
}

class Wallet {
    User user;
    double balance;
    List<Transaction> transactions = new ArrayList<>();

    public Wallet(User user) {
        this.user = user;
    }

    public void addMoney(double amount) {
        balance += amount;
        transactions.add(new Transaction("Added " + amount));
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance -= amount;
        transactions.add(new Transaction("Withdrawn " + amount));
    }

    public void showHistory() {
        for (Transaction t : transactions) {
            System.out.println(t.detail);
        }
    }
}

class Transaction {
    String detail;

    public Transaction(String detail) {
        this.detail = detail;
    }
}

public class WalletApp {
    public static void main(String[] args) {
        User u1 = new User("Vivek");
        User u2 = new User("Rahul");

        Wallet w1 = new Wallet(u1);
        Wallet w2 = new Wallet(u2);

        w1.addMoney(5000);

        try {
            TransferService walletTransfer = new WalletTransfer();
            walletTransfer.transfer(w1, w2, 1000);

            TransferService bankTransfer = new BankTransfer();
            bankTransfer.transfer(w1, w2, 2000);

        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(w1.balance);
        System.out.println(w2.balance);

        w1.showHistory();
        w2.showHistory();
    }
}
