package bank.command;

import bank.Bank;
import bank.InsufficientFundsException;

public class CommandDeposit extends Command
{
    @Override
    public String execute(Bank bank) throws InsufficientFundsException
    {
        simulateNetworkDelay();
        bank.deposit(accountId, amount);
        return "";
    }

    @Override
    public String asString()
    {
        return NAME + DELIMITER + accountId + DELIMITER + amount;
    }

    public CommandDeposit(int accountId, long amount)
    {
        this.accountId = accountId;
        this.amount = amount;
    }

    public static final String NAME = "DEPOSIT";
    private final int accountId;
    private final long amount;
}