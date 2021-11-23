import java.util.LinkedList;
import java.util.List;

public class Bank implements IBank {
    private List<IAccount> account_list;
    public Bank(){
        this.account_list = new LinkedList<IAccount>();


    }
    @Override
    public void OpenAccount(IAccount account) {
        if(account != null) {
            this.account_list.add(account);
        }
    }

    @Override
    public void CloseAccount(int accountNumber) {
        for(int i = 0; i <account_list.size(); i++)
        {
            if(account_list.get(i).GetAccountNumber() == accountNumber)
            {
                if(account_list.get(i).GetCurrentBalance() >= 0)
                {
                    account_list.remove(i);
                } else {
                    System.out.println("Account can't be close due to debt");
                }
            }
        }
    }

    @Override
    public List<IAccount> GetAllAccounts() {
        return this.account_list;
    }

    @Override
    public List<IAccount> GetAllAccountsInDebt() {
        List<IAccount> debt_list = new LinkedList<IAccount>();
        for(int i = 0; i < this.account_list.size(); i++)
        {
            if(account_list.get(i).GetCurrentBalance() < 0)
            {
                debt_list.add(account_list.get(i));
            }
        }
        return debt_list;
    }

    @Override
    public List<IAccount> GetAllAccountsWithBalance(double balanceAbove) {
        List<IAccount> balance_list = new LinkedList<IAccount>();
        for(int i = 0; i < this.account_list.size(); i++)
        {
            if(account_list.get(i).GetCurrentBalance() > balanceAbove)
            {
                balance_list.add(account_list.get(i));
            }
        }
        return balance_list ;
    }
}
