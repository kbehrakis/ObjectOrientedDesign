class RugbyResult implements IResult {
	int pointsTeam1;  // points scored by first team
	int pointsTeam2;  // points scored by second team
	
	RugbyResult (int pointsTeam1, int pointsTeam2)
	{
		this.pointsTeam1 = pointsTeam1;
		this.pointsTeam2 = pointsTeam2;
	}
	
	// isValid () : returns a boolean indicating whether score components 
    //              are expected or reasonable (fewer than 150 points for each team)
	public boolean isValid () {
	      return this.pointsTeam1 < 150 && this.pointsTeam2 < 150;
	    }
	 
	// isFirstWinner () : helper function used for winner(), 
	// 					  produces true if first team won (team wins if it has more points)
	public boolean isFirstWinner () {
	      return (this.pointsTeam1 > this.pointsTeam2);
	    }
}