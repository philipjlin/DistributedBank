package bank.command;

import bank.Bank;
import bank.InsufficientFundsException;

public class CommandTransfer extends Command
{
    @Override
    public String execute(Bank bank) throws InsufficientFundsException
    {
        simulateNetworkDelay();
        bank.transfer(fromAccountId, toAccountId, amount);
        return "";
    }

    @Override
    public String asString()
    {
        return NAME + DELIMITER + fromAccountId + DELIMITER + toAccountId + DELIMITER + amount;
    }

    public CommandTransfer(int fromAccountId, int toAccountId, long amount)
    {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
    }

    public static final String NAME = "TRANSFER";
    private final int fromAccountId;
    private final int toAccountId;
    private final long amount;
}