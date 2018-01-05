// Kristen Behrakis

import java.util.LinkedList;

import tester.*;

class Examples {
    	Examples () {} ;
    	
    	// method to set up a ballot and cast votes
    	  	ElectionData Setup1 () throws CandidateExistsException {
    	    ElectionData ED = new ElectionData();
    	  
    	    // put candidates on the ballot
    	    ED.addCandidate("Gompei");
    	    ED.addCandidate("Husky");
    	    ED.addCandidate("Joe");
    	    
    	    // cast votes
    	    try {
    	  	  ED.processVote("Gompei", "Husky", "Joe");  // Number of points for each candidate: 
    		  ED.processVote("Gompei", "Husky", "Joe");  // Gompei = 14, Husky = 10, Joe = 12
    		  ED.processVote("Joe", "Gompei", "Husky");  // Joe occurs the most in 1st (3 times)
    		  ED.processVote("Husky", "Gompei", "Joe");
    		  ED.processVote("Joe", "Gompei", "Husky");
    		  ED.processVote("Joe", "Gompei", "Husky");
    	    } catch (Exception e) {}
    	    return(ED);
    	  }
    	  
       	  	ElectionData Setup2 () throws CandidateExistsException {
        	    ElectionData ED = new ElectionData();
        	  
        	    // put candidates on the ballot
        	    ED.addCandidate("Gompei");
        	    ED.addCandidate("Husky");
        	    ED.addCandidate("Joe");
        	    // cast votes
        	    try {
        	  	  ED.processVote("Gompei", "Joe", "Husky");  // Number of points for each candidate: 
        		  ED.processVote("Gompei", "Joe", "Husky");  // Gompei=18, Husky=12, Joe= 18, Gompei and Joe are equal in points
        		  ED.processVote("Joe", "Gompei", "Husky");  // Joe and Gompei occur 1st same amount
        		  ED.processVote("Husky", "Gompei", "Joe");
        		  ED.processVote("Joe", "Gompei", "Husky");
        		  ED.processVote("Joe", "Gompei", "Husky");
        		  ED.processVote("Gompei", "Joe", "Husky");
        		  ED.processVote("Husky", "Joe", "Gompei");
        		  
        	    } catch (Exception e) {}
        	    return(ED);
        	  }
    	  	
    	  // checking findWinnerMostFirstVotes with one clear winner
    	  boolean testMostFirstWinner (Tester t) throws CandidateExistsException {
    	    return t.checkExpect(Setup1().findWinnerMostFirstVotes(),
    	                         "Joe");
    	  }
    	  
    	  // checking findWinnerMostFirstVotes with multiple winners
    	  boolean testMostFirstWinnerMultipleWinners (Tester t) throws CandidateExistsException {
    		  LinkedList<String> allWinners = new LinkedList<String>();
    		  allWinners.add("Gompei");
    		  allWinners.add("Joe");
    		  
    		  return (t.checkExpect(allWinners.contains(Setup2().findWinnerMostFirstVotes()), true));
    	  }
    	  
       	  
    	  // checking findWinnerMostFirstVotes with no one having voted
    	  boolean testMostFirstWinnerNoOneVotes (Tester t) throws CandidateExistsException {
    		  LinkedList<String> allWinners = new LinkedList<String>();
    		  return (t.checkExpect(allWinners.contains(Setup2().findWinnerMostFirstVotes()), false));  // reports back "No winner"
    	  }
    	  
    	  // checking findWinnerMostPoints with one clear winner (winner does not get the most first votes but still has most points) 
    	  boolean testMostPoints (Tester t) throws CandidateExistsException {
    	    return t.checkExpect(Setup1().findWinnerMostPoints(),
    	                         "Gompei");
    	  }
    	  
    	  // checking findWinnerMostPoints with multiple winners 
    	  boolean testMostPointsMultipleWinners (Tester t) throws CandidateExistsException {
    		  LinkedList<String> allWinnersPointSystem = new LinkedList<String>();
    		  allWinnersPointSystem.add("Joe");
    		  allWinnersPointSystem.add("Gompei");
    	
    		  return (t.checkExpect(allWinnersPointSystem.contains(Setup2().findWinnerMostPoints()), true));
    	  }
    	  
    	// checking findWinnerMostPoints with no one having voted
    	  boolean testMostPointsNoWinners (Tester t) throws CandidateExistsException {
    		  LinkedList<String> allWinnersPointSystem = new LinkedList<String>();
    		  
    		  return (t.checkExpect(allWinnersPointSystem.contains(Setup2().findWinnerMostPoints()), false));
    	  }
    	  
    	  // exception is raised when someone votes for same person multiple times
    	  boolean testDuplicateVotesException (Tester t) throws CandidateExistsException, DuplicateVotesException, UnknownCandidateException {
    	    	    ElectionData ED3 = new ElectionData();
    	    	  
    	    	    // put candidates on the ballot
    	    	    ED3.addCandidate("Joe");
       	    	    ED3.addCandidate("Husky");
    	    	    ED3.addCandidate("Gompei");
    	    	    
    	    	    return t.checkException(new DuplicateVotesException("Joe"), 
        				  	Setup1(), "processVote", "Joe", "Gompei", "Joe"); 
    	  }

    	  // add an already existing name to the ballot
    	  boolean testCandidateExistsException (Tester t) throws CandidateExistsException { 
    		  return t.checkException(new CandidateExistsException("Gompei"), 
    				  	Setup1(), "addCandidate", "Gompei"); 
    		  } 

    	  // vote for someone who isn't on the ballot
    	  boolean testUnknownCandidateException (Tester t) throws CandidateExistsException, DuplicateVotesException, UnknownCandidateException {
	    	    ElectionData ED3 = new ElectionData();
	    	  
	    	    // put candidates on the ballot
	    	    ED3.addCandidate("Joe");
 	    	    ED3.addCandidate("Husky");
	    	    ED3.addCandidate("Gompei");
	    	    
	    	    return t.checkException(new UnknownCandidateException("Richard"), 
  				  	Setup1(), "processVote", "Joe", "Gompei", "Richard"); 
	  }
    	  
    	  // none of the people are on the ballot
    	  boolean testUnknownCandidateExceptionNoneOnBallot (Tester t) throws CandidateExistsException, DuplicateVotesException, UnknownCandidateException {
	    	    ElectionData ED3 = new ElectionData();
	    	  
	    	    // put candidates on the ballot
	    	    ED3.addCandidate("Joe");
 	    	    ED3.addCandidate("Husky");
	    	    ED3.addCandidate("Gompei");
	    	    
	    	    return t.checkException(new UnknownCandidateException("Ben"),   // returns error with first one (as stated in assignment)
  				  	Setup1(), "processVote", "Ben", "Liam", "Richard"); 
	  }
    	  
    	  // unknown candidate and multiple people are voted for twice
    	  boolean testUnknownCandidateDuplicateVotesExceptions (Tester t) throws CandidateExistsException, DuplicateVotesException, UnknownCandidateException {
	    	    ElectionData ED3 = new ElectionData();
	    	  
	    	    // put candidates on the ballot
	    	    ED3.addCandidate("Joe");
 	    	    ED3.addCandidate("Husky");
	    	    ED3.addCandidate("Gompei");
	    	    
	    	    return t.checkException(new UnknownCandidateException("Liam"),   // goes with UnknownCandidateException first
  				  	Setup1(), "processVote", "Joe", "Liam", "Joe"); 
	  }
    	  
    	  // unknown candidate and multiple people are voted for twice (unknown name is repeated multiple times)
    	  boolean testUnknownCandidateDuplicateVotesExceptionsAllUnknown (Tester t) throws CandidateExistsException, DuplicateVotesException, UnknownCandidateException {
	    	    ElectionData ED3 = new ElectionData();
	    	  
	    	    // put candidates on the ballot
	    	    ED3.addCandidate("Joe");
 	    	    ED3.addCandidate("Husky");
	    	    ED3.addCandidate("Gompei");
	    	    
	    	    return t.checkException(new UnknownCandidateException("Liam"),   // goes with UnknownCandidateException first
  				  	Setup1(), "processVote", "Liam", "Liam", "Joe"); 
	  }
}
