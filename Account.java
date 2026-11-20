// Account class contains account related informations
// abstract bcz every account supports withdrawal, but rules are differnt(Savings/Current)

import java.util.ArrayList;
import java.util.List;

import exception.InsufficientBalanceException;
import exception.InvalidAmountException;

public abstract class Account {
    
    private int accountNumber;
    private double balance;
    private Customer customer;

    private List<Transaction> transactions;

    // Constructors
    public Account(int accountNumber, double balance, Customer customer) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
        this.transactions = new ArrayList<>();
    }

    // Getters
    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    // Setters
    protected void setBalance(double balance){
        this.balance = balance;
    }
    

    // Deposit method
    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0){
            throw new InvalidAmountException(
                "Deposit amount must be greater than 0."
            );
        }

        balance += amount;

        addTransaction("DEPOSIT", amount);
        System.out.println(amount + " deposited successfully.");
        System.out.println("New Balance: " + balance);
    }

    // Balance check
    public void checkBalance(){
        System.out.println("Current Balance: " + balance);
    }

    // Display Account Details
    public void displayAccountDetails(){
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        customer.displayCustomerDetails();
    }

    //Abstract method
    public abstract void withdraw(double amount)
        throws InvalidAmountException, InsufficientBalanceException;
    
        
    // Add Transaction
    protected void addTransaction(String type, double amount){
        Transaction transaction = new Transaction(getAccountNumber(), type, amount);

        transactions.add(transaction);
    }

    // Display transaction history
    public void showTransactionHistory(){
        if(transactions.isEmpty()){
            System.out.println("No transaction found");
            return;
        }

        System.out.println("----Transaction History----");
        for(Transaction transaction : transactions){
            transaction.displayTransaction();
        }
    }
}
