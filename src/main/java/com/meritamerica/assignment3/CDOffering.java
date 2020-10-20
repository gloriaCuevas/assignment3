package com.meritamerica.assignment3;

public class CDOffering {
	private int term;
	private double interestRate;
	
	//1. CDOferring (int term, double interestRate)
		public CDOffering(int term, double interestRate) {
			this.term = term;
			this.interestRate = interestRate;
		
		}
		
	//2. int getTerm ()
		public int getTerm() {
			return this.term;
			
		}
	//3. double getInterestRate ()
		public double getInterestRate() {
			return this.interestRate;
		}
		 static CDOffering readFromString(String cdOfferingDataString) 
		 {
		    	String[] holding = cdOfferingDataString.split(",");
		    	int term = Integer.parseInt(holding[0]);
		    	double interestRate = Double.parseDouble(holding[1]);
		    	return new CDOffering(term, interestRate);
		  }

		public String writeToString() 
		{
		    	StringBuilder cdOfferingData = new StringBuilder();
		    	cdOfferingData.append(term).append(",");
		    	cdOfferingData.append(interestRate);
		    	return cdOfferingData.toString(); 
}
}