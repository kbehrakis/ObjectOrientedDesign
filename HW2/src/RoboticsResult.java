class RoboticsResult implements IResult {
	int pointsTeam1;       // total points scored by first team
	int tasksTeam1;        // total attempted tasks
	boolean didFallTeam1;  // true if robot fell down during competition
	
	int pointsTeam2;        // total points scored by second team
	int tasksTeam2;         // total attempted tasks
	boolean didFallTeam2;   // true if robot fell down during competition
	
	RoboticsResult (int pointsTeam1, int tasksTeam1, boolean didFallTeam1, int pointsTeam2, int tasksTeam2, boolean didFallTeam2)
	{
		this.pointsTeam1 = pointsTeam1;
		this.tasksTeam1 = tasksTeam1;
		this.didFallTeam1 = didFallTeam1;
		
		this.pointsTeam2 = pointsTeam2;
		this.tasksTeam2 = tasksTeam2;
		this.didFallTeam2 = didFallTeam2;
	}
	
	
	// isValid () : returns a boolean indicating whether score components 
	//              are expected or reasonable (fewer than 8 tasks and no more than 16 points)
	public boolean isValid () {
	      return (this.tasksTeam1 < 8 && this.pointsTeam1 <= 16)
	    		  && (this.tasksTeam2 < 8 && this.pointsTeam2 <= 16);
	    }

	// isFirstWinner () : helper function used for winner(), produces true if first team won 
	//				      (team wins if it has the highest sum of points and tasks, 
	//					  with a 5 point deduction if the robot fell down)
	public boolean isFirstWinner () {
	      return ((this.pointsTeam1 + tasksTeam1 + deduction(didFallTeam1)) 
	      			> (this.pointsTeam2 + tasksTeam2 + deduction(didFallTeam2)));
	}
	
	// deduction (): helper function called in isFirstWinner to 
	//               determine if there is a necessary deduction (if it fell, subtract 5, else 0)
	public int deduction (boolean didFall) {
	     if (didFall)
	    	 return -5;
	     	else return 0;
	}
	
}	