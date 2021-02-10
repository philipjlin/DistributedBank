package bank;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BankServer
 * 
 * @author Philip Lin
 */
public class BankServer {
	
	private static Bank bank;
	private static ServerSocket serverSocket;
	private static Socket clientSocket;
	//private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 9090;
	
	public static void main(String[] args) throws IOException{
		
		System.out.println("Creating Bank with no Accounts...");
		bank = new BankImpl();
		System.out.println("Bank Created.\n");
		
		System.out.println("Connecting Server Socket to port...");
		try{
			
			serverSocket = new ServerSocket(SERVER_PORT);
			System.out.println("Server Socket Created.\n");
			
			while( serverSocket != null ){ 
												
				System.out.println("Waiting to accept a client...");
				clientSocket = serverSocket.accept();
				
				System.out.println("Client connected.\n");
				InputStream inputStream = clientSocket.getInputStream();
				OutputStream outputStream = clientSocket.getOutputStream();
				
				CommandExecutionThread cet = new CommandExecutionThread(bank, inputStream, outputStream);
				System.out.println("Running new command execution thread.\n");
				cet.run();
				
				System.out.println("Thread Run, Closing Client Socket.\n");
				clientSocket.close();		
			}
			
		}catch(IOException ioe){
			ioe.printStackTrace();
		}catch(IllegalArgumentException iae){
			iae.printStackTrace();
		}finally{
			
			if( serverSocket != null ){
				
				try{
					System.out.println("Cleaning up, closing sockets");
					serverSocket.close();
					System.out.println("Server Socket closed.");
					if( clientSocket != null )
						clientSocket.close();
					
				}catch(IOException ioe){
					ioe.printStackTrace();
				}
			}
		}
		
	}//end main
	
}