import exception.InsufficientBalanceException;
import exception.InvalidAmountException;

public class SavingsAccount extends Account{

    private static final double MIN_BALANCE = 500;

    // Constructors
    public SavingsAccount(int accountNumber, double balance, Customer customer) {
        super(accountNumber, balance, customer); // calling parent class
    }
    
    // Overriding withdraw()
    @Override
    public void withdraw(double amount)
            throws InvalidAmountException, InsufficientBalanceException {

        if (amount <= 0){
            throw new InvalidAmountException(
                "Withdrawal amount must be greater than 0."
            );
        }

        if (getBalance() - amount < MIN_BALANCE){
            throw new InsufficientBalanceException(
                "Minimum balance of 500 must be maintained."
            );
        }

        setBalance(getBalance() - amount);
        addTransaction("WITHDRAW", amount);
        
        System.out.println(amount + "/- withdrawn successfully.");
    }
}