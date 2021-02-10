package bank;

@SuppressWarnings("serial")
public abstract class BankException extends Exception
{
    protected BankException(String message)
    {
        super(message);
    }
}
