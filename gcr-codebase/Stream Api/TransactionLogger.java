import java.time.LocalDateTime;
import java.util.*;

public class TransactionLogger {

    public static void main(String[] args) {

        List<String> transactionIds = List.of(
                "TXN101",
                "TXN102",
                "TXN103"
        );

        System.out.println("Transaction Logs:");

        // Log each transaction with timestamp
        transactionIds.forEach(id ->
                System.out.println(
                        LocalDateTime.now() + " - Transaction ID: " + id
                )
        );
    }
}
