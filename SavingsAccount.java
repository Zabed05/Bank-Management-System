public class SavingsAccount extends Account{

    private static final double MIN_BALANCE = 500;

    // Constructors
    public SavingsAccount(int accountNumber, double balance, Customer customer) {
        super(accountNumber, balance, customer); // calling parent class
    }
    
    // Overriding withdraw()
    @Override
    public void withdraw(double amount){
        if(amount <= 0){
            System.out.println("Invalid amount");
            return;
        }

        if(getBalance() - amount >= MIN_BALANCE){
            setBalance(getBalance() - amount);
            System.out.println(amount + "/- withdrawn successfully");
        }
        else{
            System.out.println("withdrawal failed! Minimum balance is 500/-");
        }
    }
}