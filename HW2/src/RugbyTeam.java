 class RugbyTeam implements IContestant{
	String country;       // country team represents (shown in examples as school names because that was what was given for examples in the main)
	String jerseyColor;   // specific jersey color
	boolean hasRitual;    // true if team has intimidation ritual
	int wins;             // number of wins for the season
	int losses;           // number of losses for the season
	
	RugbyTeam (String country, String jerseyColor, boolean hasRitual, int wins, int losses)
	{
		this.country = country;
		this.jerseyColor = jerseyColor;
		this.hasRitual = hasRitual;
		this.wins = wins;
		this.losses = losses;
	}
	
	// expectToBeat : returns a boolean indicating whether the contestant would be expected to win 
	//				  against the given/input contestant (For rugby, if only one team has an 
	//				  intimidation ritual, that team is the expected winner; if neither or both teams 
	//				  have such rituals, the expected winner is the one with a better win/loss ratio.)
	public boolean expectToBeat (IContestant opponent){
	     if (((RugbyTeam)opponent).hasRitual == this.hasRitual)
	    	 return (this.wins/this.losses > ((RugbyTeam)opponent).wins/((RugbyTeam)opponent).losses);
	         else return this.hasRitual;    
	}
}
