public class CurrentAccount extends Account{

    private static final double LIMIT = 10000;

    public CurrentAccount(int accountNumber, double balance, Customer customer) {
        super(accountNumber, balance, customer);
    }

    @Override
    public void withdraw(double amount){
        if(amount <= 0){
            System.out.println("Invalid amount");
            return;
        }

        if(getBalance() + LIMIT >= amount){
            setBalance(getBalance() - amount);
            System.out.println(amount + "/- withdrawn successfull");
        }
        else{
            System.out.println("Withdrawal faild! Limit Exceed");
        }
    }
}
