import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import tester.Tester;

class VotingMachine {
	ElectionData voting = new ElectionData(); 
	public LinkedList<String> ballot = new LinkedList<String>();
	
	public void printBallot() {
		    System.out.println("The candidates are: ");
		    for (String s : ballot) {
		      System.out.println(s);
		    }
	  } 
	
	 private Scanner keyboard = new Scanner(System.in); 
	// screen where the user enters in the information
	  public void screen() {
		  
		    System.out.println("\nWelcome, please follow the voting process below: \n");
		   
		    System.out.print("Enter your first choice candidate: ");
		    String firstChoice = keyboard.next();
		    
		    System.out.print("Enter your second choice candidate: ");
		    String secondChoice = keyboard.next();
		    
		    System.out.print("Enter your third choice candidate: ");
		    String thirdChoice = keyboard.next();
		    
		    try {
		    	voting.processVote(firstChoice, secondChoice, thirdChoice);
		    } catch (UnknownCandidateException e) {
		    	 System.out.println("Vote failed - " +e.candidateName +" is not a known candidate. Please try again.\n");
		    	 this.screen();
			} catch (DuplicateVotesException e) {
				 System.out.println("Vote failed - You cannot vote for " +e.candidateName +" multiple times. \n");
				 this.screen();
			}

		  }
	  
	  
	   
}
