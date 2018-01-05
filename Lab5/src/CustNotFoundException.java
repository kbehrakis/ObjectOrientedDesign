// the banking example with exceptions

import java.util.LinkedList;
import java.util.Scanner;
import tester.*;

// ************** The Exceptions ***********************

class CustNotFoundException extends Exception {
  String unfoundName;
  
  CustNotFoundException(String name) {
    this.unfoundName = name;
  }
}

class LoginFailedException extends Exception {
  LoginFailedException(){}
}

// ************** Encapsulated Customer Sets *************

interface ICustSet {
  Customer findByName(String name) throws CustNotFoundException;
}

class CustSet implements ICustSet {
  LinkedList<Customer> customers = new LinkedList<Customer>();
  
  public void addCust(Customer newC) {
    customers.add(newC);
  }
  
  // find customer with given name, or throw exception if not found
  public Customer findByName(String name) throws CustNotFoundException {
    for (Customer cust:customers) {    
      if (cust.nameMatches(name)) 
        return cust;
    }
    throw new CustNotFoundException(name);
  }
}

// ************** Encapsulated Account Sets **************

interface IAccountSet {
  Account findByNum(int number) throws LoginFailedException;
}

class AcctSet implements IAccountSet {
  LinkedList<Account> accounts = new LinkedList<Account>();
  
  public Account findByNum(int num) throws LoginFailedException{
    for (Account acct:accounts) {                
      if (acct.numMatches(num)) 
        return acct;
    }
    throw new LoginFailedException();
  }
}

// ************** Customer Class *************

class Customer {
  private String name;   
  private int password;  
  private LinkedList<Account> accounts; 
  
  Customer(String name, int password) {
    this.name = name;
    this.password = password;
    this.accounts = new LinkedList<Account>();
  }
  
  // returns the name of this customer
  public boolean nameMatches(String aname) {
    return this.name.equals(aname);
  }
  
  // check whether the given password matches the one for this user
  // in a real system, this method would return some object with
  // info about the customer
  public void tryLogin(int withPwd) throws LoginFailedException {
    if (this.password != withPwd)
      throw new LoginFailedException();
  }
}

// ************** Account Class *************

class Account {
  private int number;      
  private Customer owner;  
  private double balance;  
  
  // returns the identification number for this account
  public boolean numMatches(int anum) {
    return (this.number == anum) ;
  }
  
  // returns the balance in this account
  public double getBalance() {
    return this.balance;
  }
  
  // method to withdraw given amount
  public double withdraw(double amt) {
    this.balance = this.balance - amt;
    return amt;
  }
}

// ************** The Banking Service *************

class BankingService {
  private IAccountSet accounts;   
  private ICustSet customers; 
  
  BankingService(IAccountSet accounts, ICustSet customers) {
    this.accounts = accounts;
    this.customers = customers;
  }
  
  // return balance in the account
  public double getBalance(int forAcctNum) throws LoginFailedException  {  
    Account acct = accounts.findByNum(forAcctNum) ;
    return acct.getBalance();
  }
  
  //withdraws given amount from the account
  public double withdraw(int forAcctNum, double amt) throws LoginFailedException {
    Account acct = accounts.findByNum(forAcctNum) ;
    return acct.withdraw(amt);
  }
  
  // tries to log a customer in
  public Customer login(String custname, int withPwd) 
    throws LoginFailedException {
    try {
      Customer cust = customers.findByName(custname);
      cust.tryLogin(withPwd); 
      return cust;
    } catch (CustNotFoundException e) {
      throw new LoginFailedException();
    }
  }
  
}

class BankingConsole{
  // below this is the login screen for the banking system
  
  private Scanner keyboard = new Scanner(System.in);
  BankingService forService; // take in through constructor
  
  public void loginScreen() {
    System.out.println("Welcome to the Bank.  Please log in.");
    System.out.print("Enter your username: ");
    String username = keyboard.next();
    System.out.print("Enter your password: ");
    int password = keyboard.nextInt();
    try {
      this.login(username,password);
    } catch (LoginFailedException e) {
      System.out.println("Login failed -- please try again\n");
      this.loginScreen();
    }  
  }
}

// ************** Examples *************

class Examples {
  Customer gompeiCust = new Customer("gompei", 1865);
    
  // method to initialize a banking service with Gompei as the customer
  public BankingService setUpGompei() {
    CustSet allCusts = new CustSet();
    allCusts.addCust(gompeiCust);
    return new BankingService(new AcctSet(), allCusts);
  }
  
  // a simple test case that gompei can log in
  boolean testValidLogin(Tester t) {
    try{
    	return t.checkExpect(setUpGompei().login("gompei", 1865), gompeiCust);
    } catch (LoginFailedException e) {
    	return t.checkExpect(false, "testValidLogin failed with exception");
    	}
    }
 
  // wrong name
  boolean testNonValidLogin(Tester t) {
    try{
    	return t.checkExpect(setUpGompei().login("Gompei", 1865), gompeiCust);
    } catch (LoginFailedException e) {
    	return t.checkExpect(false, "testValidLogin failed with exception");
    	}
    }
 
  // throw exception, wrong name and password
  boolean testLoginExceptionOnUnknownUser(Tester t) {
	 // setUpGompei().login("Kathi", 123);

	    return t.checkException(new LoginFailedException(),
	    		setUpGompei(), "login", "Kathi", 123);
	  }
	   
  // throw exception, wrong password
  boolean testLoginExceptionOnUnknownUser2(Tester t) {
	    return t.checkException(new LoginFailedException(),
	    									 setUpGompei(), "login", "gompei", 1223);
	  }
	   
}