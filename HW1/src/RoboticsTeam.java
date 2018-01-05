class RoboticsTeam implements IContestant{
	String school;  // school team is from
	String specialFeature;  // special feature, such ad powerful arm
	int rank; // numeric position/rank that team had in last competition, 0 if a team has never competed before
	
	RoboticsTeam (String school, String specialFeature, int rank)
	{
		this.school = school;
		this.specialFeature = specialFeature;
		this.rank = rank;
	}
	
	// expectToBeat : returns a boolean indicating whether the contestant would be expected to win 
	//				  against the given/input contestant (For robotics, the team with a longer feature description)
	public boolean expectToBeat (IContestant opponent) {
	      if  (specialFeature.length() > ((RoboticsTeam)opponent).specialFeature.length())
	    		  return true;
	      		  else return false;
	}
}