import exception.InsufficientBalanceException;
import exception.InvalidAmountException;

public class CurrentAccount extends Account{

    private static final double LIMIT = 10000;

    public CurrentAccount(int accountNumber, double balance, Customer customer) {
        super(accountNumber, balance, customer);
    }

    @Override
    public void withdraw(double amount)
            throws InvalidAmountException, InsufficientBalanceException {
                
        if(amount <= 0){
            throw new InvalidAmountException("Withdrawal amount must be greater than 0.");
        }

        if(getBalance() - amount < -LIMIT){
            throw new InsufficientBalanceException("Overdraft limit exceed");
        }

        setBalance(getBalance() - amount);
        addTransaction("WITHDRAW", amount);
        
        System.out.println(amount + "/- withdrawn successfully");
    }
}
