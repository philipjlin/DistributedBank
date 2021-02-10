package bank;

import java.util.HashMap;
import java.util.Map;

/**
 * BankImpl class represents a bank with a map of accounts.
 * Transfer and deposit operations are defined in this class.
 * @author Philip Lin
 */
public class BankImpl implements Bank{
	
	private HashMap<Integer, Account> accountsMap = new HashMap<Integer, Account>();
	
	/**
     * Add the Account to those managed by this Bank. The Account's id must be unique.
     * @param account The Account being added.
     * @throws DuplicateAccountException if this Bank already manages an Account with identifier account.id().
     */
	@Override
	public void addAccount(Account account) throws DuplicateAccountException{
		
		if( accountsMap.containsKey(account.id()) )
			throw new DuplicateAccountException(account.id());
		
		accountsMap.put(account.id(), account);
	}

	/**
     * Transfer the given amount from one account to another.
     * @param fromAccountId The identifier of the Account from which funds will be withdrawn.
     * @param toAccountId The identifer of the Account to which funds will be deposited.
     * @param amount The amount to be transferred.
     * @throws InsufficientFundsException The account identifed by fromAccountId has a balance less than amount.
     */
	@Override
	public void transfer(int fromAccountId, int toAccountId, long amount) throws InsufficientFundsException{
		
		synchronized( accountsMap.get(fromAccountId) ){
			
			accountsMap.get(fromAccountId).withdraw(amount);
		}
		
		synchronized( accountsMap.get(toAccountId) ){
			
			accountsMap.get(toAccountId).deposit(amount);
		}
	}
	
	/**
     * Deposit the given amount to the Account identified by accountId.
     * @param toAccountId Identifies the Account to which funds will be deposited.
     * @param amount The amount to be deposited.
     */
	public void deposit(int toAccountId, long amount) {
		
		synchronized( accountsMap.get(toAccountId) ){
			
			accountsMap.get(toAccountId).deposit(amount);	
		}
	}

	/**
     * Compute the total of all the Account balances for the Accounts managed by this Bank. The caller
     * is responsible for guaranteeing that no other Bank methods (addAccount, transfer, deposit) are executing
     * while this method is being executed.
     * @return the total of all the Account balances for the Accounts managed by this Bank.
     */
	@Override
	public long totalBalances(){
		
		int totalBalances = 0;
		
		for( Account account : accountsMap.values() )
			totalBalances += account.balance();
		
		return totalBalances;
	}
	
	/**
	 * Test Method.
     * Delete all of the Bank's Accounts.
     */
	@Override
	public void deleteAllAccounts(){
		
			accountsMap.clear();
	}
	
	/*
	 * Getter
	 */
	public Map<Integer, Account> getAccountsMap(){
		return accountsMap;
	}

}