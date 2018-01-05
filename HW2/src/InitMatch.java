 class InitMatch implements ITourneyTree {
	Match firstMatch;  // initial match 
	
	InitMatch (Match firstMatch)
	{
		this.firstMatch = firstMatch;
	}

	// returns true because an initial round does not have any feeders
	public boolean winnersAlwaysAdvanced () {
	      return true;
	    }

	// returns the number of matches in the tournament in which the winner was an underdog		
	public int countUnderdogWins() {
		if (firstMatch.underdogWon() == true)
			return 1;
			else return 0;
	}
}
