import tester.* ;
  
class Main {
  static Examples E = new Examples () ;
  
  public static void main(String[] args) {
 //   Tester.runReport (E, false, false) ;
	  
	  CustSet allCusts = new CustSet();
	  Customer gompeiCust = new Customer("gompei", 1865);
	  allCusts.addCust(gompeiCust);
	  
	  BankingService bank = new BankingService(new AcctSet(), allCusts); 

	  bank.loginScreen();	  
  }

}