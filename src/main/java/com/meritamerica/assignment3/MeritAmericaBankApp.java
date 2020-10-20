package com.meritamerica.assignment3;

//import com.meritamerica.assignment2.AccountHolder;
//import com.meritamerica.assignment2.CDOffering;
//import com.meritamerica.assignment2.MeritBank;

public class MeritAmericaBankApp {
	public static void main(String[] args) {
	// 1. Add 5 CDOfferings to MeritBank
		CDOffering[] CDOfferingList = new CDOffering[5];
		
		CDOfferingList[0] = new CDOffering(1, .018);
		CDOfferingList[1] = new CDOffering(2, .019);
		CDOfferingList[2] = new CDOffering(3, .020);
		CDOfferingList[3] = new CDOffering(5, .025);
		CDOfferingList[4] = new CDOffering(10, .022);	
	
		MeritBank.setCDOfferings(CDOfferingList);
		
	// 2. Instantiate a new AccountHolder (ah1)
		AccountHolder ah1 = new AccountHolder("Minsun", "", "Kim", "111111111");
		
	// 3. Add a checking account with an opening balance of $1,000 as well as 
	//a savings account with an opening balance of $10,000 to ah1
		ah1.addCheckingAccount(1000);
		ah1.addSavingsAccount(10000);
		
	// 4. Add a checking account with an opening balance of $5,000 as well as
	//a savings account with an opening balance of$50,000 to ah1
		ah1.addCheckingAccount(5000);
		ah1.addSavingsAccount(50000);
		
	// 5. Add a checking account with an opening balance of $50,000 as well as
	//a savings account with an opening balance of$500,000 to ah1
		ah1.addCheckingAccount(50000);
		ah1.addSavingsAccount(500000);
		
	// 6. Add a checking account with an opening balance of $5,000 as well as
	//a savings account with an opening balance of$50,000 to ah1
		ah1.addCheckingAccount(5000);
		ah1.addSavingsAccount(50000);
		
	// 7. Confirm last checking and savings accounts were not created
		System.out.println("Number of Checking Account(s) for ah1: " + ah1.getNumberOfCheckingAccounts());
		System.out.println("Number of Savings Account(s) for ah1: " + ah1.getNumberOfSavingsAccounts());
		System.out.println("Combined Balance for ah1: " + (ah1.getCheckingBalance() + ah1.getSavingsBalance()));
			
	// 8. Add the best CD offering as a CD account on ah1
		ah1.addCDAccount(MeritBank.getBestCDOffering(10000), 10000);
		
	// 9. Add ah1 to Merit Bank's list of account holders
		MeritBank.addAccountHolder(ah1);
		
	// 10. Instantiate a new AccountHolder (ah2)
		AccountHolder ah2 = new AccountHolder("Amber", "", "Sidman", "222222222");
		
	// 11. Add a checking account with an opening balance of $1,000 as well as a 
	// savings account with an opening balance of $10,000 to ah2
		ah2.addCheckingAccount(1000);
		ah2.addSavingsAccount(10000);
		
	// 12. Add the second best CD offering as a CD account on ah2
		ah2.addCDAccount(MeritBank.getSecondBestCDOffering(20000), 20000);
		
	// 13. Add ah2 to Merit Bank's list of account holders
		MeritBank.addAccountHolder(ah2);
		
	// 14. Clear the CDs being offered by MeritBank
		MeritBank.clearCDOfferings();
		
	// 15. Instantiate a new AccountHolder(ah3)
		AccountHolder ah3 = new AccountHolder("Jihan", "", "Joo", "333333333");
		
	// 16. Add the second best CD offering as a CD account on ah3
		ah3.addCDAccount(MeritBank.getSecondBestCDOffering(30000), 30000);
		
	// 17. Confirm a CD account was not created on ah3
		System.out.println("CD Account Balance: " + ah3.getCDBalance());

	// 18. Add a checking account with an opening balance of $1,000 as well as a 
	// savings account with an opening balance of $10,000 to ah3
		ah3.addCheckingAccount(1000);
		ah3.addSavingsAccount(10000);
		
	// 19. Add ah3 to Merit Bank's list of account holders
		MeritBank.addAccountHolder(ah3);
		
	// 20. Get the total balance of all accounts held by Merit Bank's account holders
		/*
		System.out.println("Number of Checking Account(s) for ah1: " + ah1.getNumberOfCheckingAccounts());
		System.out.println("Number of Savings Account(s) for ah1: " + ah1.getNumberOfSavingsAccounts());
		System.out.println("Total Balance for ah1: " + (ah1.getCombinedBalance() + ah1.getCDBalance()));
		System.out.println("Number of Checking Account(s) for ah2: " + ah2.getNumberOfCheckingAccounts());
		System.out.println("Number of Savings Account(s) for ah2: " + ah2.getNumberOfSavingsAccounts());
		System.out.println("Total Balance for ah2: " + (ah2.getCombinedBalance() + ah2.getCDBalance()));
		System.out.println("Number of Checking Account(s) for ah3: " + ah3.getNumberOfCheckingAccounts());
		System.out.println("Number of Savings Account(s) for ah3: " + ah3.getNumberOfSavingsAccounts());
		System.out.println("Total Balance for ah3: " + (ah3.getCombinedBalance() + ah3.getCDBalance()));
		*/
		
		System.out.println("Total balance of all accounts held by Merit Bank's account holders: " + MeritBank.totalBalances());
		
	}
}