// Account class contains account related informations
// abstract bcz every account supports withdrawal, but rules are differnt(Savings/Current)

import exception.InsufficientBalanceException;
import exception.InvalidAmountException;

public abstract class Account {
    
    private int accountNumber;
    private double balance;
    private Customer customer;

    // Constructors
    public Account(int accountNumber, double balance, Customer customer) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
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

        System.out.println("₹" + amount + " deposited successfully.");
        System.out.println("New Balance: ₹" + balance);
    }

    // Balance check
    public void checkBalance(){
        System.out.println("Current Balance: ₹" + balance);
    }

    // Display Account Details
    public void displayAccountDetails(){
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
        customer.displayCustomerDetails();
    }

    //Abstract method
    public abstract void withdraw(double amount)
        throws InvalidAmountException, InsufficientBalanceException;
    
}
