package bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

import bank.command.*;

public class CommandExecutionThread extends Thread{

	private Bank bank;
	private BufferedReader bufferedReader;
	private PrintStream printStream;
	
	public CommandExecutionThread(Bank bank, InputStream inputStream, OutputStream outputStream){
		
		this.bank = bank;
		
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		printStream = new PrintStream(outputStream);
	}
	
	/**
	 * CommandExecutionThread.run() needs to read a command (String) from 
	 * the socket's output stream; parse it, turning it into a Command; execute it; 
	 * and then write any output from the Command to the socket's input stream.
	 */
	@Override
	public void run(){
			
		//System.out.println("Running Command Execution Thread, Executing Commands From Reader.");
		try{
			
			String commandString;

			while( (commandString = bufferedReader.readLine()) != null ){
					
				//System.out.println("Buffered Reader Line (Command To Execute): " + commandString);
				try{
					
					printStream.println( Command.parse(commandString).execute(bank) );
					
				}catch( DuplicateAccountException dae ){
					printStream.println("");
				}catch( InsufficientFundsException ife ){
					printStream.println("");
				}
				//System.out.println("Command Parsed and Executed.");
			}
			
			//System.out.println("No More Commands.\n");
			
		}catch( IOException ioe ){
			ioe.printStackTrace();
		}		
	}
	
}