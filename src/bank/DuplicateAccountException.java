package bank;

@SuppressWarnings("serial")
public class DuplicateAccountException extends BankException
{
    public DuplicateAccountException(int accountId)
    {
        super(String.format("ERROR: Attempt to add a second account with id %d", accountId));
    }
}
