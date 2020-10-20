package com.meritamerica.assignment3;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;



//import com.meritamerica.assignment2.AccountHolder;
//import com.meritamerica.assignment2.CDOffering;

public class MeritBank {
	private static AccountHolder[] accountHolderList = null;
	private static CDOffering[] cdOfferingList = null;
	private static int accountNumber = 999;
	static List<Integer> number;
	static List<String> firstWord;
	static List<String> rest;
	private static long nextAccountNumber = 0;
	private static AccountHolder AccountHoldersArray[] = new AccountHolder[0];
	private static CDOffering CDOfferingsArray[] = new CDOffering[0];

	//1. static void addAccountHolder(AccountHolder accountHolder)
	public static void addAccountHolder(AccountHolder accountHolder) {
		if (accountHolderList == null) {
			accountHolderList = new AccountHolder[1];
			accountHolderList[0] = accountHolder;
		} else {
			AccountHolder[] tempAccountHolderList = new AccountHolder[accountHolderList.length + 1];
			for (int i = 0; i < accountHolderList.length; i++) {
				tempAccountHolderList[i] = accountHolderList[i];
			}
			tempAccountHolderList[accountHolderList.length] = accountHolder;
			accountHolderList = tempAccountHolderList;
		}
	}

	//2.static AccountHolder[] getAccountHolders()
	public static AccountHolder[] getAccountHolders() {
		return accountHolderList;
	}
	//3.static CDOffering[] getCDOfferings(){
	public static CDOffering[] getCDOfferings() {
		return cdOfferingList;
	}
	//static CDOffering getBestCDOffering(double depositAmount)
	public static CDOffering getBestCDOffering(double depositAmount) {
		if (cdOfferingList == null){
			return null;
		} else {
		
			int bestOfferingIndex = 0;
		
			for (int i = 1; i < cdOfferingList.length; i++){
				if (Math.pow(1 + cdOfferingList[i].getInterestRate(), cdOfferingList[i].getTerm()) > 
				Math.pow(1 + cdOfferingList[bestOfferingIndex].getInterestRate(), cdOfferingList[bestOfferingIndex].getTerm())) {
					bestOfferingIndex = i;
				}                     
			}
			
			return cdOfferingList[bestOfferingIndex];
		}
	}
	//static CDOffering getSecondBestCDOffering(double depositAmount)
	public static CDOffering getSecondBestCDOffering(double depositAmount) {
		if (cdOfferingList == null){
			return null;
		} else {
			int bestOfferingIndex = 0;
			int secondBestOfferingIndex = 0;
			
			for (int i = 1; i < cdOfferingList.length; i++){
				if (Math.pow(1 + cdOfferingList[i].getInterestRate(), cdOfferingList[i].getTerm()) > 
				Math.pow(1 + cdOfferingList[bestOfferingIndex].getInterestRate(), cdOfferingList[bestOfferingIndex].getTerm())) {
					secondBestOfferingIndex = bestOfferingIndex;
					bestOfferingIndex = i;
				}                     
			}
		
			return cdOfferingList[secondBestOfferingIndex];
	
		}
	}
	//static void clearCDOfferings()
	public static void clearCDOfferings(){
		cdOfferingList = null;
	}
	
	//static void setCDOfferings(CDOffering[] offerings)
	public static void setCDOfferings(CDOffering[] offerings) {
		cdOfferingList = offerings;
	}
	
	//static long getNextAccountNumber()
	public static int getNextAccountNumber(){
		accountNumber++;
		return accountNumber;
	}
	
	//static double totalBalances()
	public static double totalBalances(){
		double balanceTotal = 0;
		for (int i = 0; i < accountHolderList.length; i++) {
			balanceTotal += (accountHolderList[i].getCombinedBalance());
		}
		return balanceTotal;		
	}
	//static double futureValue(double presentValue, double interestRate, int term)
	public static double futureValue(double presentValue, double interestRate, int term){
		return Math.pow(1+interestRate, term)*presentValue;
	}
	public static AccountHolder readFromString(String accountHolderData) {
	    String[] holding = accountHolderData.split(",");
	    String firstName = holding[0];
	    String middleName = holding[1];
	    String lastName = holding[2];
	    String ssn = holding[3];	
	    return new AccountHolder(firstName, middleName, lastName, ssn);
	}
	
	static boolean readFromFile( String fileName) {
		CDOffering offering[] = new CDOffering[0];
		try {
			FileReader reader = new FileReader (fileName);
			BufferedReader bufferedReader = new BufferedReader(reader);
			Long nextAccountNumber = Long.valueOf(bufferedReader.readLine());
			int holdOfferNum = Integer.valueOf(bufferedReader.readLine());
				for(int i = 0; i < holdOfferNum; i++) {
					offering = Arrays.copyOf(offering, offering.length + 1);
					offering [offering.length-1] = CDOffering.readFromString(bufferedReader.readLine());
				}
			int numOfAcctHld = Integer.valueOf(bufferedReader.readLine());
			AccountHolder [] newAccountHolders = new AccountHolder[numOfAcctHld];
			for(int i = 0; i<numOfAcctHld; i++) {				
				AccountHolder acctH = AccountHolder.readFromString(bufferedReader.readLine());
				int numOfChecking = Integer.valueOf(bufferedReader.readLine());
					for(int j = 0; j<numOfChecking; j++) {
						acctH.addCheckingAccount(CheckingAccount.readFromString(bufferedReader.readLine()));				
					}
				int numOfSavings = Integer.valueOf(bufferedReader.readLine());
					for(int k = 0; k<numOfSavings; k++) {
						acctH.addSavingsAccount(SavingsAccount.readFromString(bufferedReader.readLine()));				
					}
				int numOfCD = Integer.valueOf(bufferedReader.readLine());
					for(int m = 0; m<numOfCD; m++) {
						acctH.addCDAccount(CDAccount.readFromString(bufferedReader.readLine()));				
					}
				newAccountHolders[i] = acctH;	
			}
			setNextAccountNumber(nextAccountNumber);
			CDOfferingsArray = offering;
			AccountHoldersArray = newAccountHolders;
			reader.close();
			return true;
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	static boolean writeToFile( String fileName)  {
		try {
		FileWriter writer = new FileWriter(fileName);
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		bufferedWriter.write(String.valueOf(nextAccountNumber));
		bufferedWriter.newLine();
		bufferedWriter.write(String.valueOf(CDOfferingsArray.length));
		bufferedWriter.newLine();
			for(int i = 0; i<CDOfferingsArray.length;i++) {
				bufferedWriter.write(CDOfferingsArray[i].writeToString());
				bufferedWriter.newLine();
			}
			
		bufferedWriter.write(String.valueOf(AccountHoldersArray.length));
		bufferedWriter.newLine();
			for(int j = 0; j <AccountHoldersArray.length;j++) {
				bufferedWriter.write(AccountHoldersArray[j].toString());
				bufferedWriter.newLine();
				bufferedWriter.write(String.valueOf(AccountHoldersArray[j].getCheckingAccounts().length));
				bufferedWriter.newLine();
					for(int k = 0; k < AccountHoldersArray[j].getCheckingAccounts().length;k++) {
							bufferedWriter.write(AccountHoldersArray[j].getCheckingAccounts()[k].toString());
							bufferedWriter.newLine();
					}
				bufferedWriter.write(String.valueOf(AccountHoldersArray[j].getSavingsAccounts().length));
				bufferedWriter.newLine();
					for(int m = 0; m < AccountHoldersArray[j].getSavingsAccounts().length;m++) {
							bufferedWriter.write(AccountHoldersArray[j].getSavingsAccounts()[m].toString());
							bufferedWriter.newLine();
					}
				bufferedWriter.write(String.valueOf(AccountHoldersArray[j].getCDAccounts().length));
				bufferedWriter.newLine();
					for(int n = 0; n < AccountHoldersArray[j].getCDAccounts().length;n++) {
							bufferedWriter.write(AccountHoldersArray[j].getCDAccounts()[n].toString());
							bufferedWriter.newLine();
					}			
			}
			writer.close();
			return true;
		}
		catch (Exception e) {
			return false;
		}
	
	}
	
	static AccountHolder[] sortAccountHolders() {
		Arrays.sort(AccountHoldersArray, Collections.reverseOrder());
			for(AccountHolder a : AccountHoldersArray) {
				System.out.println(a);
			}
		return AccountHoldersArray;
	}
	
	static void setNextAccountNumber( long accountNumber) {
		nextAccountNumber = accountNumber;
		
	}
		}