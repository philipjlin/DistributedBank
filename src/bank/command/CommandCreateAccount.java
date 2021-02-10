package bank.command;

import bank.Account;
import bank.AccountImpl;
import bank.Bank;
import bank.DuplicateAccountException;

public class CommandCreateAccount extends Command
{
    @Override
    public String execute(Bank bank) throws DuplicateAccountException
    {
        simulateNetworkDelay();
        Account account = new AccountImpl(accountId);
        bank.addAccount(account);
        return "";
    }

    @Override
    public String asString()
    {        
        return NAME + DELIMITER + accountId;
    }

    public CommandCreateAccount(int accountId)
    {
        this.accountId = accountId;
    }

    public static final String NAME = "CREATE_ACCOUNT";
    
    private final int accountId;
}