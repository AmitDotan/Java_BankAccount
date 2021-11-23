public class StandardAccount implements IAccount {
    protected int accountNumber;
    protected double creditLimit;
    protected double balance;
    public StandardAccount(int accountNumber, double creditLimit)
    {
        this.accountNumber = accountNumber;
        this.creditLimit = creditLimit;
        this.balance = 0;
        if(creditLimit > 0)
        {
            this.creditLimit = 0;
        }
    }
    @Override
    public void Deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        double max_withdraw = this.balance-this.creditLimit;
        if(max_withdraw > amount)
        {
            this.balance -= amount;
            return amount;
        } else {
            this.balance = this.creditLimit;
            return max_withdraw;
        }
    }

    @Override
    public double GetCurrentBalance() {
        return this.balance;
    }

    @Override
    public int GetAccountNumber() {
        return this.accountNumber;
    }
}
