// Bank class manages all the accounts

import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accounts;
    private int nextAccountNumber = 1001;

    // Constructor
    public Bank(){
        accounts = new ArrayList<>();
    }

    // Create Account
    public void createAccount(Account account){
        accounts.add(account);
        System.out.println("Account created successfully");
    }

    // Generate Account Number
    public int generateAccountNumber(){
        return nextAccountNumber++;
    }

    // Find Account
    public Account findAccount(int accountNumber){
        for (Account account : accounts) {
            if(account.getAccountNumber() == accountNumber){
                return account;
            }
        }
        return null;
    }

    // Deposit
    public void deposit(int accountNumber, double amount) throws InvalidAmountException {
        Account account = findAccount(accountNumber);

        if(account != null){
            account.deposit(amount);
        }
        else{
            System.out.println("Account not found!");
        }
    }

    // Withdraw
    public void withdraw(int accountNumber, double amount)  throws InvalidAmountException, InsufficientBalanceException{
        Account account = findAccount(accountNumber);

        if(account != null){
            account.withdraw(amount);
        }
        else{
            System.out.println("Account not found!");
        }
    }

    // Check Balance
    public void checkBalance(int accountNumber){
        Account account = findAccount(accountNumber);

        if(account != null){
            account.checkBalance();
        }
        else{
            System.out.println("Account not found!");
        }
    }

    // Display account
    public void displayAccount(int accountNumber){
        Account account = findAccount(accountNumber);
        if(account == null){
            System.out.println("Account not found!");
            return;
        }
        account.displayAccountDetails();
    }

    // Display all Accounts
    public void displayAllAccount(){
        if(accounts.isEmpty()){
            System.out.println("No Accounts avialable");
            return;
        }
        for (Account account : accounts) {
            account.displayAccountDetails();
            System.out.println("-----------------------------------");
        }
    }

    // Delete Account
    public void deleteAccount(int accountNumber){
        Account account = findAccount(accountNumber);

        if(account != null){
            accounts.remove(account);
            System.out.println("Account deleted successfully");
        }
        else{
            System.out.println("Account not found!");
        }
    }
}