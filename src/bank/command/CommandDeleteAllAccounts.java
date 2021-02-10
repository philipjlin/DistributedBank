package bank.command;

import bank.Bank;
import bank.DuplicateAccountException;

public class CommandDeleteAllAccounts extends Command
{
    @Override
    public String execute(Bank bank) throws DuplicateAccountException
    {
        simulateNetworkDelay();
        bank.deleteAllAccounts();
        return "";
    }

    @Override
    public String asString()
    {
        return NAME;
    }

    public CommandDeleteAllAccounts()
    {
    }

    public static final String NAME = "DELETE_ALL_ACCOUNTS";
}