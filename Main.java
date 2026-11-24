// Main class connects all the classes 

import java.util.Scanner;

import exception.InsufficientBalanceException;
import exception.InvalidAmountException;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while(true){
            System.out.println("\n ---BANK MANAGEMENT SYSTEM---");
            System.out.println("1.Create Savings Account");
            System.out.println("2.Create Current Account");
            System.out.println("3.Deposite");
            System.out.println("4.Withdraw");
            System.out.println("5.Check Balance");
            System.out.println("6.Display specific account");
            System.out.println("7.Display all accounts");
            System.out.println("8.Delete Account");
            System.out.println("9.View Transaction History");
            System.out.println("10.Transfer Money");
            System.out.println("11.Exit");

            System.out.println("Enter Your Choice:");
            int choice = sc.nextInt();

            switch(choice){

                // 1 & 2 are same(Creating an account) so doing it in one
                case 1:
                case 2:
                    sc.nextLine();
                    System.out.println("Enter Customer Id:");
                    String customerId = sc.nextLine();

                    System.out.println("Enter Customer Name:");
                    String name = sc.nextLine();

                    System.out.println("Enter Age:");
                    int age = sc.nextInt();

                    sc.nextLine();

                    System.out.println("Enter Phone Number:");
                    String phone = sc.nextLine();

                    System.out.println("Enter Email:");
                    String email = sc.nextLine();

                    System.out.println("Enter Address:");
                    String address = sc.nextLine();

                    int accountNumber = bank.generateAccountNumber();

                    System.out.println("Enter Initial Balance:");
                    double balnce = sc.nextDouble();

                    Customer customer = new Customer(
                        customerId,
                        name,
                        age,
                        phone,
                        email,
                        address
                    );

                    Account account;
                    if(choice == 1){
                        account = new SavingsAccount(accountNumber, balnce, customer);
                    }
                    else{
                        account = new CurrentAccount(accountNumber, balnce, customer);
                    }

                    bank.createAccount(account);

                    System.out.println("Your Account Number: " + accountNumber);
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    accountNumber = sc.nextInt();

                    System.out.print("Enter Amount: ");
                    double depositAmount = sc.nextDouble();

                    try {
                        bank.deposit(accountNumber, depositAmount);
                    } catch (InvalidAmountException e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    accountNumber = sc.nextInt();

                    System.out.print("Enter Amount: ");
                    double withdrawAmount = sc.nextDouble();

                    try {
                        bank.withdraw(accountNumber, withdrawAmount);
                    } catch (InvalidAmountException | InsufficientBalanceException e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;

                case 5:
                    System.out.println("Enter Acccount Number:");
                    accountNumber = sc.nextInt();

                    bank.checkBalance(accountNumber);
                    break;

                case 6:
                    System.out.println("Enter Account Number:");
                    accountNumber = sc.nextInt();

                    bank.displayAccount(accountNumber);
                    break;

                case 7:
                    bank.displayAllAccount();
                    break;

                case 8:
                    System.out.println("Enter Account Number:");
                    accountNumber = sc.nextInt();

                    bank.deleteAccount(accountNumber);
                    break;
                
                case 9:
                    System.out.println("Enter Account Number:");
                    accountNumber = sc.nextInt();

                    bank.showTransactionHistory(accountNumber);
                    break;
                
                case 10:
                    System.out.println("Enter Sender account number:");
                    int senderAcc = sc.nextInt();
                    
                    System.out.println("Enter Recever account number:");
                    int receverAcc = sc.nextInt();

                    System.out.println("Enter transfer amount:");
                    double amount = sc.nextDouble();

                    bank.transferMoney(senderAcc, receverAcc, amount);
                    break;

                case 11:
                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!!");
            }
        }
    }
}