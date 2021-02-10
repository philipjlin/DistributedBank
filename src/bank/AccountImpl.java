package bank;

/**
 * AccountImpl class represents a bank account with an account number and money balance.
 * Deposit and withdraw operations are defined in this class.
 * @author Philip Lin
 */
public class AccountImpl implements Account{
	
	private int id;
	private long balance;
	
	/**
	 * Constructor 
	 * @param id identification number of the account
	 */
	public AccountImpl(int id){
		
		this.id = id;
	}
	
	/**
     * Returns the identifer of this Account. Identifiers should be unique within a Bank.
     * @return the identifer of this Account.
     */
	@Override
	public int id(){
		
		return id;
	}

	/**
     * Returns the balance of this Account.
     * @return the balance of this Account.
     */
	@Override
	public long balance(){

		return balance;
	}

	/**
     * Increase the balance by the given amount.
     * @param amount The amount being deposited.
     */
	@Override
	public void deposit(long amount){
		
		if( amount <= 0 )
			throw new IllegalArgumentException();
			
		balance += amount;
	}

	/**
     * Decrease the balance by the given amount.
     * @param amount The amount being withdrawn.
     * @throws InsufficientFundsException if amount exceeds balance.
     */
	@Override
	public void withdraw(long amount) throws InsufficientFundsException{
		
		if( amount <= 0 )
			throw new IllegalArgumentException();
			
		if( amount > balance )
			throw new InsufficientFundsException(this, amount);
			
		balance -= amount;
	}

}