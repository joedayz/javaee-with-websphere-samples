println('<<Using JAVASCRIPT to access bank Java objects!>>.\n');

//Import java packages
importPackage(Packages.itso.rad80.bank.impl);
importPackage(Packages.itso.rad80.bank.model);
importPackage(Packages.itso.rad80.bank.exception);
importClass(java.math.BigDecimal);

//Start error handling
try 
{
	//Get bank variable from javax.script.Bindings scope
	var oBank = bank;
		
	//Create customer-bank instance with hard coded values
	println('System is going to add new customer...');
	var oCustomer = new Customer('xxx-xx-xxxx', 'Mr', 'Juan','Napoli');
	oBank.addCustomer(oCustomer);
	println(oCustomer + ' has been successfully added.');
	
	//Add two accounts to the new created customer 
	println('Opening two new accounts for the customer ' + oCustomer + '...');
	
	//Create and Add first account to the customer 
	oAccountI = new Account('1', BigDecimal('10000.00')); 	
	oBank.openAccountForCustomer(oCustomer, oAccountI);
	
	//Create and Add second account to the customer
	oAccountII = new Account("2", BigDecimal('11234.23'));
	oBank.openAccountForCustomer(oCustomer, oAccountII);
	println('Account ' + oAccountI.getAccountNumber()
				+ ' and account ' + oAccountII.getAccountNumber()
				+ ' have been successfully opened for ' + oCustomer);
	
	//List all accounts for the created customer in the bank
	println('ITSO Bank is listing all account information of ' + oCustomer);				
	println(oBank.getAccountsForCustomer(oCustomer.getSsn()));
	
	//Perform an automatic credit operation on both accounts
	//Prepare credit operation on first account
	bgAmount = new BigDecimal('2500.00');			
	println('\nITSO Bank is going to make credit of $'
			+ bgAmount.setScale(2, BigDecimal.ROUND_HALF_EVEN)
			+ ' to account ' + oAccountI.getAccountNumber() + '...');
	//Perform credit operation on first account
	oBank.deposit(oAccountI.getAccountNumber(), bgAmount);
	println('Account ' + oAccountI.getAccountNumber()
			+ ' has sucessfully credited by $'
			+ bgAmount.setScale(2, BigDecimal.ROUND_HALF_EVEN) + '.\n');
	//Prepare credit operation on second account
	bgAmount = new BigDecimal('1234.23');
	println('ITSO Bank is going to make debit of $'
			+ bgAmount.setScale(2, BigDecimal.ROUND_HALF_EVEN)
			+ ' to account ' + oAccountII.getAccountNumber() + '...');
	//Perform the credit operation in second account
	oBank.withdraw(oAccountII.getAccountNumber(), bgAmount);
	println('Account ' + oAccountII.getAccountNumber()
			+ ' has sucessfully debited by $'
			+ bgAmount.setScale(2, BigDecimal.ROUND_HALF_EVEN) + '.\n');

	//List current status in all accounts for the created customer in the oBank
	println('ITSO Bank is listing all account information of '
			+ oCustomer + '...');
	println(oBank.getAccountsForCustomer(oCustomer.getSsn()));

	//Perform automatic close account process on first customer account
	println('\nITSO Bank is going to close account '
			+ oAccountI.getAccountNumber() + ' of customer '
			+ oCustomer + '...');
	oBank.closeAccountOfCustomer(oCustomer, oAccountI);
	println('Account ' + oAccountI.getAccountNumber()
			+ ' has been successfully closed for ' + oCustomer + '.\n');
	//List current status in all accounts for the created customer in the oBank
	println('ITSO Bank is listing all account information of '
			+ oCustomer + '...');
	println(oBank.getAccountsForCustomer(oCustomer.getSsn()));

	//Perform an automatic credit operation on second customer account
	bgAmount = new BigDecimal('5000.00');
	println('\nITSO Bank is going to make credit of $'
			+ bgAmount.setScale(2, BigDecimal.ROUND_HALF_EVEN)
			+ ' to account ' + oAccountII.getAccountNumber() + '...');
	oBank.deposit(oAccountII.getAccountNumber(), bgAmount);
	println('Account ' + oAccountII.getAccountNumber()
			+ ' has sucessfully credited by $'
			+ bgAmount.setScale(2, BigDecimal.ROUND_HALF_EVEN) + '.\n');

	//List current status in all accounts for the created customer in the oBank
	println('ITSO Bank is listing all account information of '
			+ oCustomer + '...');
	println(oBank.getAccountsForCustomer(oCustomer.getSsn()));
}
catch (itsoexce if itsoexce.javaException instanceof ITSOBankException)
{
		println('the following application exception occurred ... ');
		itsoexce.javaException.printStackTrace();
}
		
		