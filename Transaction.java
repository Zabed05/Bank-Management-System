import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private static int nextTransactionId = 10001;

    private int transactionId;
    private int accountNumber;
    private String transactionType;
    private double amount;
    private LocalDateTime dateTime;

    public Transaction(int accountNumber, String transactionType, double amount){
        this.transactionId = nextTransactionId++;
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    public int getTransactionId() {
        return transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    // Display Transacton
    public void displayTransaction(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Type  : " + transactionType);
        System.out.println("Amount : " + amount);
        System.out.println("Date & Time :" + dateTime.format(formatter));
    }
}