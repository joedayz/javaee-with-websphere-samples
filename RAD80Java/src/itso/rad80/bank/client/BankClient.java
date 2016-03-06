package itso.rad80.bank.client;


import itso.rad80.bank.exception.ITSOBankException;
import itso.rad80.bank.ifc.Bank;
import itso.rad80.bank.impl.ITSOBank;
import itso.rad80.bank.model.Account;
import itso.rad80.bank.model.Customer;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class BankClient {

	public static void main(String[] args) {
		//Start error handling
		try {
			//Create an empty bank instance with the current object structure 
			Bank oITSOBank = ITSOBank.getBank();
			
			//Invoke logic 
			System.out.println("*****************************************");
			System.out.println("Transactions STARTED");
			System.out.println("*****************************************");		
			
			
			//Here you can switch the logic to be implemented in Java or Scripting
			//executeCustomerTransactions(oITSOBank);
			executeCustomerTransactionsWithScript(oITSOBank);
	
			//List current customers created in the bank
			System.out.println("*****************************************");
			System.out.println("Transactions SUCCESSFULLY FINISHED");
			System.out.println("*****************************************");
			System.out.println("\nITSO Bank is listing all customers detailed status ...");
			System.out.println(oITSOBank.getCustomers() + "\n");
			for (Customer customer:oITSOBank.getCustomers().values()) {
				System.out.println("Customer: "	+ customer	+ "\n" 
					+ oITSOBank.getAccountsForCustomer(customer.getSsn()) + "\n");
			}
		} catch (Exception e) {
			//Catch exceptions and printout stack trace in console
			e.printStackTrace();
		}
	}
	
	// Method to test the Bank application (without scripting) 
	private static void executeCustomerTransactions(Bank oBank) throws ITSOBankException {
		try {
			//Declare local variables
			Customer customer1 = null;
			Account account11 = null;
			Account account12 = null;
			BigDecimal amount = null;

			//Create customer-bank instance with hard coded values
			System.out.println("<<Using PLAIN JAVA to access bank Java objects!>>.\n");
			System.out.println("System is going to add new customer...");
			customer1 = new Customer("xxx-xx-xxxx", "Mr", "Juan","Napoli");
			oBank.addCustomer(customer1);
			System.out.println(customer1 + " has been successfully added.\n");
		
			//Add two accounts to the new created customer 
			System.out.println("ITSO Bank is opening two new accounts for customer" 
					+ customer1 + "...");
			//Create and Add first account to the customer 
			account11 = new Account("11", new BigDecimal(10000.00D)); 	
			oBank.openAccountForCustomer(customer1, account11); 	
			//Create and Add second account to the customer
			account12 = new Account("12", new BigDecimal(11234.23D));
			oBank.openAccountForCustomer(customer1, account12);
			System.out.println("Account " + account11.getAccountNumber()
					+ " and account " + account12.getAccountNumber()
					+ " have been successfully opened for " + customer1
					+ ".\n");
		
			//List all accounts for the created customer in the bank
			System.out.println("ITSO Bank - listing all account information of "
					+ customer1 + "...");				
			System.out.println(oBank.getAccountsForCustomer(customer1.getSsn()));
			
			//Perform an automatic credit operation on both accounts
			//Prepare credit operation on first account
			amount = new BigDecimal(2500.00D);			
			System.out.println("\nITSO Bank is going to make credit of $"
					+ amount.setScale(2, BigDecimal.ROUND_HALF_EVEN)
					+ " to account " + account11.getAccountNumber() + "...");
			//Perform credit operation on first account
			oBank.deposit(account11.getAccountNumber(), amount);
			System.out.println("Account " + account11.getAccountNumber()
					+ " has successfully credited by $"
					+ amount.setScale(2, BigDecimal.ROUND_HALF_EVEN) + ".\n");
			//Prepare debit operation on second account
			amount = new BigDecimal(1234.23D);
			System.out.println("ITSO Bank is going to make debit of $"
					+ amount.setScale(2, BigDecimal.ROUND_HALF_EVEN)
					+ " to account " + account12.getAccountNumber() + "...");
			//Perform the debit operation on second account
			oBank.withdraw(account12.getAccountNumber(), amount);
			System.out.println("Account " + account12.getAccountNumber()
					+ " has successfully debited by $"
					+ amount.setScale(2, BigDecimal.ROUND_HALF_EVEN) + ".\n");

			//List current status in all accounts for the created customer in the bank
			System.out.println("ITSO Bank is listing all account information of "
					+ customer1 + "...");
			System.out.println(oBank.getAccountsForCustomer(customer1.getSsn()));
		
			//Perform automatic close account process on first customer account
			System.out.println("\nITSO Bank is going to close account "
					+ account11.getAccountNumber() + " of customer "
					+ customer1 + "...");
			oBank.closeAccountOfCustomer(customer1, account11);
			System.out.println("Account " + account11.getAccountNumber()
					+ " has been successfully closed for " + customer1 + ".\n");
			//List current status in all accounts for the created customer in the bank
			System.out.println("ITSO Bank is listing all account information of "
					+ customer1 + "...");
			System.out.println(oBank.getAccountsForCustomer(customer1.getSsn()));
		
			//Perform an automatic credit operation on second customer account
			amount = new BigDecimal(5000.00D);
			System.out.println("\nITSO Bank is going to make credit of $"
					+ amount.setScale(2, BigDecimal.ROUND_HALF_EVEN)
					+ " to account " + account12.getAccountNumber() + "...");
			oBank.deposit(account12.getAccountNumber(), amount);
			System.out.println("Account " + account12.getAccountNumber()
					+ " has sucessfully credited by $"
					+ amount.setScale(2, BigDecimal.ROUND_HALF_EVEN) + ".\n");
		
			//List current status in all accounts for the created customer in the bank
			System.out.println("ITSO Bank is listing all account information of "
					+ customer1 + "...");
			System.out.println(oBank.getAccountsForCustomer(customer1.getSsn()));
		} 
		//Catch exceptions and printout stack trace in console
		catch (ITSOBankException e)	{throw e;}
	}

	// Method to test the Bank application (with scripting) 
    private static void executeCustomerTransactionsWithScript(Bank oBank) throws ScriptException {
    	//Lookup for the scripting engine
    	ScriptEngineManager engineMgr = new ScriptEngineManager();
        ScriptEngine engine = engineMgr.getEngineByName("ECMAScript");
        
        //Insert the bank object in the Bindings scope
        engine.put("bank", oBank);
        
        //Execute the script
        try {
       		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("itso/rad80/bank/client/BankClientScript.js");
    	    Reader reader = new InputStreamReader(inputStream);
    	    engine.eval(reader);
        } catch (ScriptException e) {
        	throw e;
        } 
    }
	
	// SCRIPTING OPTIONAL METHOD
    private void listScriptingEngines() throws Exception {
	    try {
	        ScriptEngineManager sem = new ScriptEngineManager();
	        List<ScriptEngineFactory> efs = sem.getEngineFactories();
	        System.out.println("List of available script engines");
	        for ( int i = 0; i < efs.size(); i++ ) {
	        	//Get each factory in the engine
	            ScriptEngineFactory factory = efs.get(i);

	            //Show all details for factory	
	            System.out.println("-------------------------------------------");
	            System.out.println("Language: " + factory.getEngineName());
	            System.out.println("Version: " + factory.getEngineVersion());
	            System.out.println("Engine: " + factory.getLanguageName());
	            System.out.println("-------------------------------------------");
	        }
	    } catch ( Exception e ) {
	        throw e;
	    }
    }
    
}
