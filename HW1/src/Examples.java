// Kristen Behrakis

import tester.*;

class Examples {
	Examples () {} ;
	  
	RugbyTeam wpi = new RugbyTeam("WPI", "red", true, 10, 2);
	RugbyTeam holyCross = new RugbyTeam("Holy Cross", "purple", false, 8, 4);
	RugbyResult RugbyResultWpiHC = new RugbyResult(17, 16);
    Match WPIvsHC = new Match(wpi, holyCross, RugbyResultWpiHC);
	
	RoboticsTeam wpiRobots = new RoboticsTeam("WPI","goat-bot", 2);
	RoboticsTeam hcRobots = new RoboticsTeam("Holy Cross","watersprayer", 3);
    RoboticsResult RoboticsResultWpiHc = new RoboticsResult(4,5,false,3,3,true);
    Match robotsMatchCheck = new Match(wpiRobots, hcRobots, RoboticsResultWpiHc);
    
//     ***************************** TEST CASES ********************************* 
    
    
////////////////////////////////////// ** check isValid ** //////////////////////////////////////

    								//  ** RUGBY **
    RugbyResult RugbyResultBothTooBig = new RugbyResult(160, 180);
	RugbyResult RugbyResultFirstUnreasonable = new RugbyResult(160, 18);
	RugbyResult RugbyResultSecondUnreasonable = new RugbyResult(16, 180);
    //check when points for both rugby teams are too large (should return false) 
    boolean testBothUnreasonableRugby(Tester t) {
      return t.checkExpect(((IResult) RugbyResultBothTooBig).isValid(),
                           false) ;
    }
  
    //check when points for only one rugby teams is too large (should return false) 
    boolean testFirstUnreasonableRugby(Tester t) {
      return t.checkExpect(((IResult) RugbyResultFirstUnreasonable).isValid(),
                           false) ;
    }
    
    boolean testSecondUnreasonableRugby(Tester t) {
        return t.checkExpect(((IResult) RugbyResultSecondUnreasonable).isValid(),
                             false) ;
      }
    
    //check when points for both rugby teams are reasonable (should return true) 
    boolean testReasonableRugby(Tester t) {
        return t.checkExpect(((IResult) RugbyResultWpiHC).isValid(),
                             true) ;
      }
    
    
                               // ** ROBOTICS **
    RoboticsResult RoboticsResultBothTooHigh = new RoboticsResult(17,10,false,22,20,true);
    RoboticsResult RoboticsResultOneTooHigh = new RoboticsResult(17,10,false,3,3,true);
    
    //check when robotics scores have too many attempts and too many points
    boolean testBothTooHighRobotics(Tester t) {
      return t.checkExpect(((IResult) RoboticsResultBothTooHigh).isValid(),
                           false) ;
    }
    
    //check when robotics scores have one team with too many attempts and too many points
    boolean testOneTooHighRobotics(Tester t) {
      return t.checkExpect(((IResult) RoboticsResultOneTooHigh).isValid(),
                           false) ;
    }
    
    //check when robotics scores have both teams with reasonable attempts and points
    boolean testRoboticsResultWpiHc(Tester t) {
      return t.checkExpect(((IResult) RoboticsResultWpiHc).isValid(),
                           true) ;
    }
    
    
    
//////////////////////////////////////** check winner **//////////////////////////////////////
	   								// ** RUGBY **
    RugbyResult RugbyResultWpiHCSecondWins = new RugbyResult(16, 17);
    Match WPIvsHCSecondWins = new Match(wpi, holyCross, RugbyResultWpiHCSecondWins);
 
    // check when first rugby team wins
    boolean testFirstRugbyWins(Tester t) {
      return t.checkExpect((WPIvsHC).winner(),
                           wpi);
    }
    
    // check when second rugby team wins
    boolean testSecondRugbyWins(Tester t) {
        return t.checkExpect((WPIvsHCSecondWins).winner(),
                             holyCross);
      }

    	
    								// ** ROBOTICS **
    RoboticsResult RoboticsResultWpiHcSecondWins = new RoboticsResult(4,5,false,8,8,true);
    Match robotsMatchCheckSecondWins = new Match(wpiRobots, hcRobots, RoboticsResultWpiHcSecondWins);

    RoboticsResult RoboticsResultWpiHcDeduction = new RoboticsResult(4,5,false,4,8,true);
    Match robotsMatchCheckDeduction = new Match(wpiRobots, hcRobots, RoboticsResultWpiHcDeduction);
    
	//check when first robotics team wins (also one team that did fall and another that didn't to check deduction)
	boolean testFirstRoboticsWins(Tester t) {
		return t.checkExpect((robotsMatchCheck).winner(),
                       wpiRobots);
	}
	
	//check when second robotics team wins 
		boolean testSecondRoboticsWins(Tester t) {
			return t.checkExpect((robotsMatchCheckSecondWins).winner(),
	                       hcRobots);
		}
		
	//check when sum of points is higher, but deduction makes overall score lower
		boolean testDeductionLower(Tester t) {
			return t.checkExpect((robotsMatchCheckDeduction).winner(),
	                       wpiRobots);
		}
		
		
///////////////////////////// ** check helper functions for winner (ifFirstWinner)**////////////////////////////////////
									// ** RUGBY **
/*		// first is winner
		boolean testIsFirstWinner_True(Tester t) {
			return t.checkExpect(RugbyResultWpiHC.isFirstWinner(),
	                       true);
		}
		
		// first is winner
		RugbyResult Result_SecondWins = new RugbyResult(16, 17);
		boolean testIsFirstWinner_False(Tester t) {
			return t.checkExpect((Result_SecondWins).isFirstWinner(),
	                       false);
		}
		
								// ** ROBOTICS **
		// first is winner
		boolean testIsFirstWinner_True_Robots(Tester t) {
			return t.checkExpect((RoboticsResultWpiHc).isFirstWinner(),
	                       true);
		}
		
		// first isn't winner
		 RoboticsResult RoboticsResultWpiHc_SecondWins = new RoboticsResult(4,5,true,3,3,false);
		 boolean testIsFirstWinner_False_Robots(Tester t) {
				return t.checkExpect((RoboticsResultWpiHc_SecondWins).isFirstWinner(),
		                       false);
			}
		 
		// deduction (robotics specific)
		 boolean testDeduction(Tester t) {
				return t.checkExpect((RoboticsResultWpiHc_SecondWins).deduction(true),
		                       -5);
			}
		 
		 boolean testNoDeduction(Tester t) {
				return t.checkExpect((RoboticsResultWpiHc_SecondWins).deduction(false),
		                       0);
			}
		
		*/
////////////////////////////////////// ** check expectToBeat ** //////////////////////////////////////
		 								// ** RUGBY **
	// check when first team has intimidation ritual, second does not (return true)
		boolean testFirstIntimidation(Tester t) {
			return t.checkExpect((wpi).expectToBeat(holyCross),
	                       true);
		}
		
	// check when second team has intimidation ritual, first does not (return false)
		RugbyTeam wpiNoInt = new RugbyTeam("WPI", "red", false, 10, 2);
		RugbyTeam holyCrossInt = new RugbyTeam("Holy Cross", "purple", true, 8, 4);
		
		boolean testSecondIntimidation(Tester t) {
			return t.checkExpect((wpiNoInt).expectToBeat(holyCrossInt),
	                       false);
		}
		
	// check when both have intimidation ritual, first team has better ratio (return true)
		boolean testFirstRatioBetter(Tester t) {
			return t.checkExpect((wpi).expectToBeat(holyCrossInt),
	                       true);
		}
		
	// check when both have intimidation ritual, second team has better ratio (return false)
		boolean testSecondRatioBetter(Tester t) {
			return t.checkExpect((holyCrossInt).expectToBeat(wpi),
	                       false);
		}
		
    // check when both have intimidation ritual, same ratio (return false)
		RugbyTeam wpiIntSameRatio = new RugbyTeam("WPI", "red", true, 10, 2);
		RugbyTeam holyCrossIntSameRatio = new RugbyTeam("Holy Cross", "purple", true, 10, 2);
		
		boolean testRatioSame(Tester t) {
			return t.checkExpect((wpiIntSameRatio).expectToBeat(holyCrossIntSameRatio),
	                       false);
		}
		
    // check when neither have intimidation ritual, first team has better ratio (return true)
		RugbyTeam wpiNoIntBetterRatio = new RugbyTeam("WPI", "red", false, 10, 2);
		RugbyTeam holyCrossNoIntWorseRatio = new RugbyTeam("Holy Cross", "purple", false, 5, 2);
		
		boolean testNoIntFirstRatio(Tester t) {
			return t.checkExpect((wpiNoIntBetterRatio).expectToBeat(holyCrossNoIntWorseRatio),
	                       true);
		}

	// check when neither have intimidation ritual, second team has better ratio (return false)	
		boolean testNoIntSecondRatio(Tester t) {
			return t.checkExpect((holyCrossNoIntWorseRatio).expectToBeat(wpiNoIntBetterRatio),
	                       false);
		}
		
	// check when neither have intimidation ritual, same ratio (return false)	
		RugbyTeam wpiNoIntSameRatio = new RugbyTeam("WPI", "red", false, 10, 2);
		RugbyTeam holyCrossNoIntSameRatio = new RugbyTeam("Holy Cross", "purple", false, 10, 2);
		
		boolean testNoIntSameTatio(Tester t) {
			return t.checkExpect((wpiNoIntSameRatio).expectToBeat(holyCrossNoIntSameRatio),
	                       false);
		}
		
		
									// ** ROBOTICS **
	// check when first team has longer string (return true)
		RoboticsTeam wpiRobotsLonger = new RoboticsTeam("WPI","goat-bot", 2);
		RoboticsTeam hcRobotsShorter = new RoboticsTeam("Holy Cross","water", 3);
		
		boolean testFirstStringLonger(Tester t) {
			return t.checkExpect((wpiRobotsLonger).expectToBeat(hcRobotsShorter),
	                       true);
		}
		
    // check when second team has longer string (return false)
		boolean testSecondStringLonger(Tester t) {
			return t.checkExpect((wpiRobots).expectToBeat(hcRobots),
	                       false);
		}
		
	// check when first team has same string length as second team (return false)
		RoboticsTeam wpiRobotsSameLength = new RoboticsTeam("WPI","water", 2);
		RoboticsTeam hcRobotsSameLength = new RoboticsTeam("Holy Cross","water", 3);
		
		boolean testSameLength(Tester t) {
			return t.checkExpect((wpiRobotsSameLength).expectToBeat(hcRobotsSameLength),
	                       false);
		}
		
    // check when both teams have empty strings (return false)
		RoboticsTeam wpiRobotsEmpty = new RoboticsTeam("WPI", "", 2);
		RoboticsTeam hcRobotsEmpty = new RoboticsTeam("Holy Cross", "", 3);
		
		boolean testEmpty(Tester t) {
			return t.checkExpect((wpiRobotsEmpty).expectToBeat(hcRobotsEmpty),
	                       false);
		}
		
	// check when first team has a string, second string empty (return true)
		boolean testSecondEmpty(Tester t) {
			return t.checkExpect((wpiRobots).expectToBeat(hcRobotsEmpty),
	                       true);
		}
		
    // check when second team has a string, first string empty (return false)
		boolean testFirstEmpty(Tester t) {
			return t.checkExpect((wpiRobotsEmpty).expectToBeat(hcRobots),
	                       false);
		}
	
		
		 
//////////////////////////////////////** check underdogWon ** //////////////////////////////////////
		
										// ** RUGBY **
	// first Rugby contestant won, was underdog
		RugbyTeam holyCrossExpectedWinner = new RugbyTeam("WPI", "red", true, 9, 2);
		RugbyTeam wpiUnderdog = new RugbyTeam("WPI", "red", false, 9, 2);
		RugbyResult RugbyResultWPIUnderdog = new RugbyResult(18, 16);
	    Match WPIvsHC_FirstUnderdog = new Match(wpiUnderdog, holyCrossExpectedWinner, RugbyResultWPIUnderdog);
	  
		boolean testFirstUnderdogWonRugby(Tester t) {
			return t.checkExpect(WPIvsHC_FirstUnderdog.underdogWon(),
	                       true);
		}
		
	// second Rugby contestant won, was underdog
		RugbyTeam holyCrossUnderdog = new RugbyTeam("WPI", "red", false, 9, 2);
		RugbyTeam wpiExpectedWinner = new RugbyTeam("WPI", "red", true, 9, 2);
		RugbyResult RugbyResultHCUnderdog = new RugbyResult(16, 18);
	    Match WPIvsHC_SecondUnderdog = new Match(wpiExpectedWinner, holyCrossUnderdog, RugbyResultHCUnderdog);
	  
	    boolean testSecondUnderdogWonRugby(Tester t) {
			return t.checkExpect((WPIvsHC_SecondUnderdog).underdogWon(),
	                       true);
		}
	    
	// first Rugby contestant won, wasn't underdog
	    RugbyResult ResultExpected_FirstTeamWins = new RugbyResult(18, 16);
	    Match WPIvsHC_FirstWon = new Match(wpiExpectedWinner, holyCrossUnderdog, ResultExpected_FirstTeamWins);
		  
	    boolean testFirstWonRugby(Tester t) {
			return t.checkExpect((WPIvsHC_FirstWon).underdogWon(),
	                       false);
		}
	    
	// second Rugby contestant won, wasn't underdog
	    RugbyResult ResultExpected_SecondTeamWins = new RugbyResult(16, 18);
	    Match WPIvsHC_SecondWon = new Match(holyCrossUnderdog,wpiExpectedWinner, ResultExpected_SecondTeamWins);
	    
	    boolean testSecondWonRugby(Tester t) {
			return t.checkExpect((WPIvsHC_SecondWon).underdogWon(),
	                       false);
		}
	    
	    
	    								// ** ROBOTICS **
	// first Robotics contestant won, was underdog
	    boolean testFirstUnderdogWonRobtoics(Tester t) {
			return t.checkExpect((robotsMatchCheck).underdogWon(),
	                       true);
		}
	    
	// second Robotics contestant won, was underdog
	    RoboticsResult RoboticsResultWpiHcSecondWon = new RoboticsResult(4,5,true,3,3,false);
	    Match robotsMatchCheckSecondUnderdogWins = new Match(hcRobots, wpiRobots, RoboticsResultWpiHcSecondWon);
	    
	    boolean testSecondUnderdogWonRobtoics(Tester t) {
			return t.checkExpect((robotsMatchCheckSecondUnderdogWins).underdogWon(),
	                       true);
		}
	// first Robotics contestant won, wasn't underdog
	    RoboticsResult RoboticsResultWpiHcFirst = new RoboticsResult(4,5,false,3,3,false);
	    Match robotsMatchCheck_FirstTeamWins = new Match(hcRobots, wpiRobots, RoboticsResultWpiHcFirst);
	    
	    boolean testFistWonRobtoics(Tester t) {
			return t.checkExpect((robotsMatchCheck_FirstTeamWins).underdogWon(),
	                       false);
		}
	    
	// second Robotics contestant won, wasn't underdog
	    RoboticsResult RoboticsResultWpiHcSecond = new RoboticsResult(4,5,true,3,3,false);
	    Match robotsMatchCheck_SecondTeamWins = new Match(wpiRobots, hcRobots, RoboticsResultWpiHcSecond);
	    
	    boolean testSecondWonRobtoics(Tester t) {
			return t.checkExpect((robotsMatchCheck_SecondTeamWins).underdogWon(),
	                       false);
		}    
}