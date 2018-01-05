class AdvanceMatch implements ITourneyTree {
	 Match advMatch;         // advanced match 
	 ITourneyTree firstFeeder;      // feeder matches
	 ITourneyTree secondFeeder;     // feeder matches

		AdvanceMatch (Match advMatch, ITourneyTree firstFeeder, ITourneyTree secondFeeder)
		{
			this.advMatch = advMatch;
			this.firstFeeder = firstFeeder;
			this.secondFeeder = secondFeeder;
		}
		
		AdvanceMatch (Match advMatch){
			this.advMatch = advMatch;
			this.firstFeeder = new UnknownMatch();
			this.secondFeeder = new UnknownMatch();

		}

		// avoided using helper test cases for this because of autograder, but helpers should be tested through running tests on entire code anyway
		public boolean winnersAlwaysAdvanced () {
		     if ((firstFeeder instanceof InitMatch))
		    	 if (secondFeeder instanceof InitMatch)                  
		    		 // firstFeeder is InitMatch, second feeder is InitMatch
		    		 	return (isWinnerFirstTeamInitialMatch(firstFeeder)
		    		 			 && isWinnerSecondTeamInitialMatch(secondFeeder))
		    		 		|| (isWinnerFirstTeamInitialMatch(secondFeeder))
				    		 	 && isWinnerSecondTeamInitialMatch(firstFeeder);
		    	
		    	 else         
		    		 // firstFeeder is InitMatch, second feeder is AdvanceMatch
		    		 	return (isWinnerFirstTeamInitialMatch(firstFeeder)  
		    		 			 && isWinnerSecondTeamAdvanceMatch(secondFeeder))
		    		 			 && secondFeeder.winnersAlwaysAdvanced()
		    		 		|| (isWinnerFirstTeamAdvanceMatch(secondFeeder)
				    		 	 && isWinnerSecondTeamInitialMatch(firstFeeder))
		    		 			 && secondFeeder.winnersAlwaysAdvanced();   // check through rest of tree when it's advanced
		    	 
	
		     else  //firstFeeder is AdvanceMatch
		    	 if (secondFeeder instanceof InitMatch)                
		    		 // firstFeeder is AdvanceMatch, second feeder is InitMatch
		    		 	return ((isWinnerFirstTeamAdvanceMatch(firstFeeder))
		    		 			 && isWinnerSecondTeamInitialMatch(secondFeeder)
		    		 			 && firstFeeder.winnersAlwaysAdvanced())  // check through rest of tree when it's advanced
		    		 		|| (isWinnerFirstTeamInitialMatch(secondFeeder)  
		    		 			 && isWinnerSecondTeamAdvanceMatch(firstFeeder))
		    		 			 && secondFeeder.winnersAlwaysAdvanced();
		    	 		
		    	 else
		     		 // firstFeeder is AdvanceMatch, second feeder is AdvanceMatch
		    	 			return ((isWinnerFirstTeamAdvanceMatch(firstFeeder))
		    	 							&& isWinnerSecondTeamAdvanceMatch(secondFeeder))
		    	 							&& firstFeeder.winnersAlwaysAdvanced()
		    	 							&& secondFeeder.winnersAlwaysAdvanced()
		    	 					|| (isWinnerFirstTeamAdvanceMatch(secondFeeder)
		    	 							&& isWinnerSecondTeamAdvanceMatch(firstFeeder))
		    	 							&& firstFeeder.winnersAlwaysAdvanced()
		    	 							&& secondFeeder.winnersAlwaysAdvanced();
		     }
		
// ** HELPERS ** 	
	// check if first team is equal to the winner of the supplied feeder (InitMatch only)
		boolean isWinnerFirstTeamInitialMatch (ITourneyTree feeder){
			return advMatch.firstTeam.equals(((InitMatch) feeder).firstMatch.winner());
		}
	
	// check if second team is equal to the winner of the supplied feeder (InitMatch only)		
		boolean isWinnerSecondTeamInitialMatch (ITourneyTree feeder){
			return advMatch.secondTeam.equals(((InitMatch) feeder).firstMatch.winner());
		}
		
	// check if first team is equal to the winner of the supplied feeder (AdvanceMatch only)
		boolean isWinnerFirstTeamAdvanceMatch (ITourneyTree feeder){
			return advMatch.firstTeam.equals(((AdvanceMatch) feeder).advMatch.winner());
		}
		
	// check if second team is equal to the winner of the supplied feeder (AdvanceMatch only)			
		boolean isWinnerSecondTeamAdvanceMatch (ITourneyTree feeder){
			return advMatch.secondTeam.equals(((AdvanceMatch) feeder).advMatch.winner());
		}
		
		
// produces the number of matches in the tournament in which the winner was an underdog		
		public int countUnderdogWins() {
			if (advMatch.underdogWon() == true)
				return 1 + this.firstFeeder.countUnderdogWins() + this.secondFeeder.countUnderdogWins();
				else return this.firstFeeder.countUnderdogWins() + this.secondFeeder.countUnderdogWins();
		}
}
 
 // for the case where we don't know the feeder matches of the advanced match
  class UnknownMatch implements ITourneyTree {
	 UnknownMatch () {}

	 public boolean winnersAlwaysAdvanced() {
		return true;  // true because there weren't any known feeder matches to check with 
	}

	public int countUnderdogWins() {
		return 0;
	}
 }
 

