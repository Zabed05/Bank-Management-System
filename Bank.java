// Bank class manages all the accounts

import java.util.ArrayList;

import exception.InsufficientBalanceException;
import exception.InvalidAmountException;

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

    // Transaction History
    public void showTransactionHistory(int accountNumber){
        Account account = findAccount(accountNumber);
        if(account == null){
            System.out.println("Account not found");
            return;
        }
        account.showTransactionHistory();
    }

    // Transfer Money
    public void transferMoney(int senderAcc, int receverAcc, double amount){
        Account sender = findAccount(senderAcc);
        Account recever = findAccount(receverAcc);

        // validation check
        if(sender == null){
            System.out.println("Sender Account not found!");
            return;
        }
        if(recever == null){
            System.out.println("Recever account not found!");
            return;
        }

        // prevent self transfer
        if(sender == recever){
            System.out.println("Money transfer cannot procced in same account");
            return;
        }

        try{
            sender.withdraw(amount);
            recever.deposit(amount);

            System.out.println("Money transferred successfully!");
        }
        catch(InvalidAmountException | InsufficientBalanceException e){
            System.out.println("Transfer failed:" + e.getMessage());
        }
    }
}