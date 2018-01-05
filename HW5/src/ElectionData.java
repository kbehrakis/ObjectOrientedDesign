import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class ElectionData {
  public LinkedList<String> ballot = new LinkedList<String>();

  private HashMap<String,Integer> firstChoiceVotes = new HashMap<String,Integer>();
  private HashMap<String,Integer> secondChoiceVotes = new HashMap<String,Integer>();
  private HashMap<String,Integer> thirdChoiceVotes = new HashMap<String,Integer>();
  private Scanner keyboard = new Scanner(System.in); 
  
  private HashMap<String,HashMap<String,Integer>> votes = new HashMap<String, HashMap<String,Integer>>();  // stores all votes (first, second, and third choices together)
  
  ElectionData() {
	  
  }
  										// **** ALL GETTERS AND SETTERS IN CASE WE NEED THEM
  public HashMap<String,Integer> getfirstChoiceVotes(){
	return firstChoiceVotes;
  }
  
  public void setfirstChoiceVotes(HashMap<String,Integer> newHash){
	  firstChoiceVotes = newHash;
  }
 
  public HashMap<String,Integer> getsecondChoiceVotes(){
		return secondChoiceVotes;
  }
  
  public void setsecondChoiceVotes(HashMap<String,Integer> newHash){
	  	secondChoiceVotes = newHash;
  }
  
  public HashMap<String,Integer> getthirdChoiceVotes(){
		return thirdChoiceVotes;
  }
  
  public void setthirdChoiceVotes(HashMap<String,Integer> newHash){
	  	thirdChoiceVotes = newHash;
  }
  
  public Scanner getScanner(){
	  return keyboard;
  }
  
  public void setScanner(Scanner newKeyboard){
	  keyboard = newKeyboard;
  }
  
  // stores a voter's choices and accounts for exceptions
  public void processVote(String firstChoice, String secondChoice, String thirdChoice) throws DuplicateVotesException, UnknownCandidateException{
	  try{
		  this.addCandidate("Husky");
	  }catch (CandidateExistsException e){
		  System.out.println(e.existingName + " is already on the ballot. \n");
	  }
	  
	  try{
		  this.addCandidate("Joe");
	  }catch (CandidateExistsException e){
		  System.out.println(e.existingName + " is already on the ballot. \n");
	  }
	  
	  try{
		  this.addCandidate("Gompei");
	  }catch (CandidateExistsException e){
		  System.out.println(e.existingName + " is already on the ballot. \n");
	  }
	  
	  boolean allOnBallot = ballot.contains(firstChoice) && ballot.contains(secondChoice) && ballot.contains(thirdChoice);
	  
	  if(allOnBallot && !(firstChoice.equals(secondChoice)) && !(firstChoice.equals(thirdChoice)) && !(secondChoice.equals(thirdChoice))){ // if ballot contains all entered candidates + none are repeated
	 
		  	getfirstChoiceVotes().put(firstChoice, getfirstChoiceVotes().get(firstChoice)+1);
		  	getsecondChoiceVotes().put(secondChoice, getsecondChoiceVotes().get(secondChoice)+1);
		  	getthirdChoiceVotes().put(thirdChoice, getthirdChoiceVotes().get(thirdChoice)+1);} 
	  
	  else if (ballotDoesntContain(firstChoice)){                    // first not in ballot
	  		throw new UnknownCandidateException(firstChoice);}
	  else if (ballotDoesntContain(secondChoice)){        		     // second not in ballot
	  		throw new UnknownCandidateException(secondChoice);}
	  else if (ballotDoesntContain(thirdChoice)){                    // third not in ballot
			throw new UnknownCandidateException(thirdChoice);}
	  else if (isDuplicate(firstChoice,secondChoice,thirdChoice)){   // first choice is duplicate
		  	throwDuplicateException(firstChoice);}
	  else if (isDuplicate(secondChoice,firstChoice,thirdChoice)){   // second choice is duplicate
		  	throwDuplicateException(secondChoice);}
	  else if (isDuplicate(thirdChoice,secondChoice,thirdChoice)){   // third choice is duplicate
		  	throwDuplicateException(thirdChoice);}
	  
	  	votes.put("First Choice", getfirstChoiceVotes());
	  	votes.put("Second Choice", getsecondChoiceVotes());    // add to votes, which stores everything together (first, second, and third choices) 
	  	votes.put("Third Choice", getthirdChoiceVotes());
	  	
	  }

  // adds a new candidate to the ballot
  public void addCandidate(String candidateName) throws CandidateExistsException {   
	  
    if(ballot.contains(candidateName))
	  {throw new CandidateExistsException(candidateName);}
		  
	  this.ballot.add(candidateName);  // add new candidate to the ballot
	  firstChoiceVotes.put(candidateName, 0);  // add new candidate to the hashmap, initially 0 votes
	  secondChoiceVotes.put(candidateName, 0);  // add new candidate to the hashmap, initially 0 votes
	  thirdChoiceVotes.put(candidateName, 0);  // add new candidate to the hashmap, initially 0 votes
}
  
  
  
  								// ********** WINNER METHODS ********** 
  
  // returns the name of the winner (the candidate who got the most first choice votes
  public String findWinnerMostFirstVotes(){

	int highestVal = Collections.max(firstChoiceVotes.values()); // .values gives just the values (not the keys), and then get max of those
	String winner = "No winner";  // default
	
	 for (String s : firstChoiceVotes.keySet()) {  // looking at just the keys now, which are strings
	      if (firstChoiceVotes.get(s).equals(highestVal)) {   // if the value at given string is equal to the highest value 
	        winner = s;  // if it has the highest value, it becomes the winner
	        break;
	      }
	    }
	return winner;   // with ties, any candidate with the highest score would be a valid answer
  }

  
 // Calculate the winner based on the following point-scaling:
 // 	First place: *3
 // 	Second place *2 
 // 	Third-place: *1 
	public String findWinnerMostPoints()
	{
		String winner = "No winner";
		int highestValue = 0;
		
		 for (String s : ballot) {  // for each name on the ballot 
		      if (getAllPoints(s) >= highestValue) {   
		    	  highestValue = getAllPoints(s);  // store the highest value for comparing
		    	  winner = s;  // store the person who has the highest value as the winner
		      }
		    }
		return winner;		 
	}
	
	
	
  							// **********  HELPERS ********** 
  
  // returns true if "choice" is not found in ballot
  private boolean ballotDoesntContain(String choice){
	  return !(ballot.contains(choice));
  }
  
  // returns true if first entered string is equal to either of the other strings 
  private boolean isDuplicate(String first, String second, String third){   
	  return first.equals(second) || first.equals(third);
  }
  
  // throws DuplicateVotesException with the given "choice"
  private Exception throwDuplicateException(String choice) throws DuplicateVotesException{
	throw new DuplicateVotesException(choice);
	  
  }
	
	// helper function to count up the votes and scale them appropriately  
	private int getAllPoints(String currentName){
		int points = firstChoiceVotes.get(currentName)*3 + secondChoiceVotes.get(currentName)*2 + thirdChoiceVotes.get(currentName);
		return points;
	}
}	



							// ********** EXCEPTIONS ********** 
	// exception for when a user enters the same person's name twice
  class DuplicateVotesException extends Exception{
	    String candidateName;
	  
	    DuplicateVotesException(String name) {
	      this.candidateName = name;
	    }
	  }
 
  	// exception for when the candidate that was entered is not on the ballot
  class UnknownCandidateException extends Exception {
	    String candidateName;
	  
	    UnknownCandidateException(String name) {
	      this.candidateName = name;
	    }
	  }
  