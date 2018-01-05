class Match {
	IContestant firstTeam;  // first contestant in match
	IContestant secondTeam; // second contestant in match
	IResult results;        // results of competition between the two contestants
	
	Match (IContestant firstTeam, IContestant secondTeam, IResult results)
	{
		this.firstTeam = firstTeam;
		this.secondTeam = secondTeam;
		this.results = results;
	}
	
	// winner() : returns contestant that won according to results
	public IContestant winner () {
		if (this.results.isFirstWinner())  // call to method that produces true if first team won
			return this.firstTeam;
			else return this.secondTeam;
	}
	
	// underdogWon() : returns true if contestant that won was not expected to 
	boolean underdogWon () {
		return (this.results.isFirstWinner() && this.secondTeam.expectToBeat(firstTeam)) 
				|| (!this.results.isFirstWinner() && !this.secondTeam.expectToBeat(firstTeam));
	}
}