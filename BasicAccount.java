public class BasicAccount extends StandardAccount{
    private int accountNumber;
    private double withdrawalLimit;
    public BasicAccount(int accountNumber, double withdrawalLimit) {
        super(accountNumber, 0);
        this.withdrawalLimit = withdrawalLimit;
        if (withdrawalLimit < 0) {
            this.withdrawalLimit = 0;
        }
    }

    @Override
    public double Withdraw(double amount) {
        if(amount >= withdrawalLimit)
        {
            amount = withdrawalLimit;
        }
        double total = 0;
        if(this.balance < amount)
        {
            total = balance;
            this.balance = 0;
        } else {
            total = amount;
        }
        return  total;

    }
}
