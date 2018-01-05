// Kristen Behrakis

import java.util.LinkedList;

import tester.*;

class Examples {
	Examples () {} ;
	
// TOURNAMENT EXAMPLES
	
	// Rugby Contestants
	RugbyTeam Contestant1 = new RugbyTeam("WPI", "red", true, 10, 2);
	RugbyTeam Contestant2 = new RugbyTeam("Holy Cross", "purple", false, 8, 4);
	RugbyTeam Contestant3 = new RugbyTeam("MIT", "grey", false, 8, 4);
	RugbyTeam Contestant4 = new RugbyTeam("NYU", "green", false, 8, 4);
	RugbyTeam Contestant5 = new RugbyTeam("Penn", "green", false, 8, 4);
	RugbyTeam Contestant6 = new RugbyTeam("Olin", "green", false, 8, 4);
	RugbyTeam Contestant7 = new RugbyTeam("UNH", "red", true, 8, 4);
	RugbyTeam Contestant8 = new RugbyTeam("ULowell", "purple", true, 8, 4);
	
	// Rugby Results
	RugbyResult Results1and2 = new RugbyResult(17,16);  // 1 advances
	RugbyResult Results1and2TwoAdvances = new RugbyResult(17,26);  // 2 advances
	RugbyResult Results3and4 = new RugbyResult(20,14);  // 3 advances
	RugbyResult Results3and1 = new RugbyResult(20,24);  // 1 advances
	RugbyResult Results4and5 = new RugbyResult(30,20);  // 4 advances
	RugbyResult Results6and7 = new RugbyResult(30,35);  // 7 advances
	RugbyResult Results5and1 = new RugbyResult(30,35);  // 1 advances
	RugbyResult Results6and2 = new RugbyResult(30,35);  // 2 advances
	RugbyResult Results7and8 = new RugbyResult(30,35);  // 8 advances
	RugbyResult Results7and3 = new RugbyResult(30,35);  // 3 advances
	RugbyResult Results7and3SevenWins = new RugbyResult(35,30);  // 7 advances
	RugbyResult Results4and8 = new RugbyResult(30,20);  // 4 advances
	
	// Rugby Matches
	Match Match1vs2 = new Match (Contestant1, Contestant2, Results1and2);
	Match Match1vs2TwoAdvances = new Match (Contestant1, Contestant2, Results1and2TwoAdvances);
	Match Match3vs4 = new Match (Contestant3, Contestant4, Results3and4);	
	Match Match3vs1 = new Match (Contestant3, Contestant1, Results3and1);
	Match Match1vs3 = new Match (Contestant1, Contestant3, Results3and1);
	Match Match4vs5 = new Match (Contestant4, Contestant5, Results4and5);
	Match Match5vs1 = new Match (Contestant5, Contestant1, Results5and1);
	Match Match5vs1FiveAdvances = new Match (Contestant1, Contestant5, Results5and1);
	Match Match6vs2 = new Match (Contestant6, Contestant2, Results6and2);
	Match Match7vs8 = new Match (Contestant7, Contestant8, Results7and8);
	Match Match7vs3 = new Match (Contestant7, Contestant3, Results7and3);
	Match Match7vs3SevenWins = new Match (Contestant7, Contestant3, Results7and3SevenWins);
	Match Match4vs8 = new Match (Contestant4, Contestant8, Results4and8);
	
	// Rugby Initial Matches
	InitMatch Initial1vs2 = new InitMatch(Match1vs2);
	InitMatch Initial2AdvancesInsteadOf1 = new InitMatch(Match1vs2TwoAdvances);
	InitMatch Initial3vs4 = new InitMatch(Match3vs4);
	InitMatch Initial4vs5 = new InitMatch(Match4vs5);
	InitMatch Initial5vs1 = new InitMatch(Match5vs1);
	InitMatch Initial5AdvancesInsteadOf1 = new InitMatch(Match5vs1FiveAdvances);
	InitMatch Initial6vs2 = new InitMatch(Match6vs2);
	InitMatch Initial7vs8 = new InitMatch(Match7vs8);
	InitMatch Initial7vs3 = new InitMatch(Match7vs3);
	InitMatch Initial4vs8 = new InitMatch(Match4vs8);
	InitMatch Initial7vs3SevenAdvances = new InitMatch(Match7vs3SevenWins);
	
			IContestant hello = new RugbyTeam("ULowell", "purple", true, 8, 4);
			
	// Rugby Advanced Matches
	AdvanceMatch Round3Advanced = new AdvanceMatch(Match3vs1, Initial3vs4, Initial1vs2);
	
	AdvanceMatch RightFeederIsAdvanced = new AdvanceMatch(Match3vs1, Initial3vs4, 
											new AdvanceMatch(Match1vs2, Initial5vs1, Initial6vs2));
	
	AdvanceMatch LeftFeederIsAdvanced = new AdvanceMatch(Match1vs3, 
											new AdvanceMatch(Match1vs2, Initial5vs1, Initial6vs2), 
											Initial3vs4);
	
	AdvanceMatch BothFeedersAdvanced = new AdvanceMatch(Match1vs3, 
											new AdvanceMatch(Match1vs2, Initial5vs1, Initial6vs2), 
											new AdvanceMatch(Match3vs4, Initial7vs3, Initial4vs8));
	
	
//  ***************************** TEST CASES ********************************* 
    
//////////////////////////////////////** check winnersAlwaysAdvanced ** //////////////////////////////////////

	                                   //  **** RUGBY ****
	
// ADVANCED MATCHES WITH 2 INITIAL FEEDER MATCHES	
	/*
	 * Reference Tree:
	 * 					    1
	 * 				    3	   1
	 *                3  4    1  2
	 */
	 // advanced rugby match where both feeders are initial matches and contestants are both winners of feeders
    boolean testWinnersAdvancedBothWonFeeders(Tester t) {
      return t.checkExpect(((ITourneyTree) Round3Advanced).winnersAlwaysAdvanced(),
                           true);
    }
    
	 // advanced rugby match where both feeders are initial matches and left contestant is winner of left feeder,
     // but right contestant is loser of right feeder
	RugbyResult Results1and2OnlyLeftWonFeeder = new RugbyResult(17,26);  // 2 advances instead of 1
	Match Match1vs2OnlyLeftWonFeeder = new Match (Contestant1, Contestant2, Results1and2OnlyLeftWonFeeder);
	InitMatch Initial1vs2OnlyLeftWonFeeder = new InitMatch(Match1vs2OnlyLeftWonFeeder);
    AdvanceMatch OnlyLeftWonFeeder = new AdvanceMatch(Match3vs1, Initial3vs4, Initial1vs2OnlyLeftWonFeeder);
	
    boolean testWinnersAdvancedLeftWonFeeder(Tester t) {
        return t.checkExpect(((ITourneyTree) OnlyLeftWonFeeder).winnersAlwaysAdvanced(),
                             false);
      }
    
    // advanced rugby match where both feeders are initial matches and right contestant is winner of right feeder,
    // but left contestant is loser of left feeder
	RugbyResult Results3and4OnlyRightWonFeeder = new RugbyResult(17,26);  // 4 advances instead of 3
	Match Match3vs4OnlyRightWonFeeder = new Match (Contestant3, Contestant4, Results3and4OnlyRightWonFeeder);
	InitMatch Initial3vs4OnlyRightWonFeeder = new InitMatch(Match3vs4OnlyRightWonFeeder);
    AdvanceMatch OnlyRightWonFeeder = new AdvanceMatch(Match3vs1, Initial3vs4OnlyRightWonFeeder, Initial1vs2);
	
    boolean testWinnersAdvancedRightWonFeeder(Tester t) {
        return t.checkExpect(((ITourneyTree) OnlyLeftWonFeeder).winnersAlwaysAdvanced(),
                             false);
      }
    
    // advanced rugby match where both feeders are initial matches and neither contestant is winner of feeder
	AdvanceMatch NeitherContIsWinner = new AdvanceMatch(Match3vs1, Initial3vs4OnlyRightWonFeeder, Initial1vs2OnlyLeftWonFeeder);
	
	boolean testWinnersAdvancedNeitherWonFeeders(Tester t) {
     return t.checkExpect(((ITourneyTree) NeitherContIsWinner).winnersAlwaysAdvanced(),
                          false);
   }
 
	// advanced rugby match where both contestants were never in the competition
	Match ContestantsNotInCompetition = new Match (Contestant5, Contestant6, Results3and1);
	AdvanceMatch NotInCompetition = new AdvanceMatch(ContestantsNotInCompetition, Initial1vs2, Initial3vs4);

	boolean testWinnersWonWinnerIsNotInCompetition(Tester t) {
		return t.checkExpect(((ITourneyTree) NotInCompetition).winnersAlwaysAdvanced(),
						false);
	}
	
	
	
// ADVANCED MATCHES WITH LEFT FEEDER INITIAL MATCH AND RIGHT FEEDER ADVANCED MATCH
	/*
	 * Reference Tree:
	 * 					       1
	 * 				    3	         1
	 *               3    4      1      2
	 *                         5  1    6  2
	 */
	// contestants are both winners of feeders
    boolean testWinnersInitAdvBothWonFeeders(Tester t) {
      return t.checkExpect(((ITourneyTree) RightFeederIsAdvanced).winnersAlwaysAdvanced(),
                           true);
    }
    
    
	 // left contestant is winner of left feeder, right contestant is loser of right feeder
	RugbyResult SixAdvancesInsteadOf2 = new RugbyResult(27,20);  // 6 advances instead of 2
	Match MatchSixAdvancesInsteadOf2 = new Match (Contestant6, Contestant2, SixAdvancesInsteadOf2);
	AdvanceMatch Adv1vs2OnlyLeftWonFeeder = new AdvanceMatch(Match1vs2TwoAdvances, Initial5vs1, new InitMatch(MatchSixAdvancesInsteadOf2));
    AdvanceMatch InitAdvOnlyLeftWonFeeder = new AdvanceMatch(Match3vs1, Initial3vs4, Adv1vs2OnlyLeftWonFeeder);
	
    boolean testWinnersInitAdvLeftWonFeeder(Tester t) {
        return t.checkExpect(((ITourneyTree) InitAdvOnlyLeftWonFeeder).winnersAlwaysAdvanced(),
                             false);
      }
    
    
    // right contestant is winner of right feeder, left contestant is loser of left feeder
	RugbyResult FourAdvancesInsteadOf3 = new RugbyResult(17,26);  // 4 advances instead of 3
	Match Match4AdvancesInsteadOf3 = new Match (Contestant3, Contestant4, FourAdvancesInsteadOf3);
	InitMatch Initial4AdvancesInsteadOf3 = new InitMatch(Match4AdvancesInsteadOf3);
    AdvanceMatch InitAdvFourAdvancesInsteadOf3 = new AdvanceMatch(Match3vs1, Initial4AdvancesInsteadOf3, new AdvanceMatch(Match1vs2, Initial5vs1, Initial6vs2));
	
    boolean testWinnersInitAdvRightWonFeeder(Tester t) {
        return t.checkExpect(((ITourneyTree) InitAdvFourAdvancesInsteadOf3).winnersAlwaysAdvanced(),
                             false);
      }
    
    
    // neither contestant is winner of feeder
 	AdvanceMatch NeitherContIsWinnerIntAdv = new AdvanceMatch(Match3vs1, Initial4AdvancesInsteadOf3, Adv1vs2OnlyLeftWonFeeder);
 	
 	boolean testWinnersIntAdvNeitherWonFeeders(Tester t) {
      return t.checkExpect(((ITourneyTree) NeitherContIsWinner).winnersAlwaysAdvanced(),
                           false);
    }
	
	
	// both contestants were never in the competition
	Match ContestantsNotHere = new Match (Contestant5, Contestant6, Results3and1);
	AdvanceMatch NotHere = new AdvanceMatch(Match3vs1, Initial4vs5, new AdvanceMatch(Match7vs8, Initial4vs5, Initial7vs8));

	boolean testWinnersNotInCompetition(Tester t) {
		return t.checkExpect(((ITourneyTree) NotHere).winnersAlwaysAdvanced(),
						false);
	}
    
	
 
// ADVANCED MATCHES WITH LEFT FEEDER ADVANCED MATCH AND RIGHT FEEDER INITIAL MATCH
		/*
		 * Reference Tree:
		 * 					       1
		 * 				    1	         3
		 *              1      2      3     4
		 *            5  1   6  2
		 */
	
	// contestants are both winners of feeders
	   boolean testWinnersAdvInitBothWonFeeders(Tester t) {
	    return t.checkExpect(((ITourneyTree) LeftFeederIsAdvanced).winnersAlwaysAdvanced(),
	                           true);
	    }
	    
    // left contestant is winner of left feeder, right contestant is loser of right feeder
	    AdvanceMatch AdvInitOnlyLeftWonFeeder = new AdvanceMatch(Match1vs3, new AdvanceMatch(Match1vs2, Initial5vs1, Initial6vs2), Initial4AdvancesInsteadOf3);
		
	    boolean testWinnersAdvInitLeftWonFeeder(Tester t) {
	        return t.checkExpect(((ITourneyTree) AdvInitOnlyLeftWonFeeder).winnersAlwaysAdvanced(),
	                             false);
	      }	
	
	    
	// right contestant is winner of right feeder, left contestant is loser of left feeder
		Match Match3vs1ThreeWins = new Match (Contestant1, Contestant3, Results3and1);
	    AdvanceMatch AdvLeftWrongInitRightCorrect = new AdvanceMatch(Match1vs3, new AdvanceMatch(Match1vs2, Initial5AdvancesInsteadOf1, Initial6vs2), Initial6vs2);
		
	    boolean testWinnersAdvInitRightWonFeeder(Tester t) {
	        return t.checkExpect(((ITourneyTree) AdvLeftWrongInitRightCorrect).winnersAlwaysAdvanced(),
	                             false);
	      } 
    
	    
	 // neither contestant is winner of feeder
	 	AdvanceMatch AdvLeftNeitherWon = new AdvanceMatch(Match1vs3, new AdvanceMatch(Match1vs2, Initial5AdvancesInsteadOf1, Initial6vs2), new InitMatch(MatchSixAdvancesInsteadOf2));
	 		
	 	 boolean testWinnersNeitherWon(Tester t) {
	 	    return t.checkExpect(((ITourneyTree) AdvLeftNeitherWon).winnersAlwaysAdvanced(),
	 	                           false);
	 	      }
	    
	// both contestants were never in the competition
	 	AdvanceMatch NotHereAdvInit = new AdvanceMatch(Match1vs3, new AdvanceMatch(Match7vs8, Initial4vs5, Initial7vs8), Initial4vs5);

	 	boolean testWinnersNotInCompetitionAdvInit(Tester t) {
	 		return t.checkExpect(((ITourneyTree) NotHereAdvInit).winnersAlwaysAdvanced(),
	 						false);
	 	}
	         
	    
// ADVANCED MATCHES WITH LEFT FEEDER ADVANCED MATCH AND RIGHT FEEDER ADVANCED MATCH
	 		/*
	 		 * Reference Tree:
	 		 * 					       1
	 		 * 				    1	           3
	 		 *              1      2       3      4
	 		 *            5  1   6  2    7  3   4   8
	 		 */
	 	 	 
		// contestants are both winners of feeders
		   boolean testWinnersAdvAdvBothWonFeeders(Tester t) {
		    return t.checkExpect(((ITourneyTree) BothFeedersAdvanced).winnersAlwaysAdvanced(),
		                           true);
		    }	
	 	
	   // left contestant is winner of left feeder, right contestant is loser of right feeder
		    AdvanceMatch BothAdvOnlyLeftWonFeeder = new AdvanceMatch(Match1vs3, new AdvanceMatch(Match1vs2, Initial5vs1, Initial6vs2),
		    																	new AdvanceMatch(Match3vs4, Initial7vs3SevenAdvances, Initial4vs8));
			
		    boolean testWinnersBothAdvLeftWonFeeder(Tester t) {
		        return t.checkExpect(((ITourneyTree) BothAdvOnlyLeftWonFeeder).winnersAlwaysAdvanced(),
		                             false);
		      }	

		 // right contestant is winner of right feeder, left contestant is loser of left feeder
		    AdvanceMatch BothAdvanceOnlyRightWonFeeder = new AdvanceMatch(Match1vs3, new AdvanceMatch(Match1vs2, Initial5AdvancesInsteadOf1, Initial6vs2),
																					 new AdvanceMatch(Match3vs4, Initial7vs3, Initial4vs8));
			
		    boolean testWinnersBothAdvanceRightWonFeeder(Tester t) {
		        return t.checkExpect(((ITourneyTree) BothAdvanceOnlyRightWonFeeder).winnersAlwaysAdvanced(),
		                             false);
		      } 		    
		 
		 // neither contestant is winner of feeder
		 	AdvanceMatch BothAdvancedNeitherWon =  new AdvanceMatch(Match1vs3, new AdvanceMatch(Match1vs2, Initial5AdvancesInsteadOf1, Initial6vs2),
					 														   new AdvanceMatch(Match3vs4, Initial7vs3SevenAdvances, Initial4vs8));
			
		 	 boolean testWinnersBothAdvancedNeitherWon(Tester t) {
		 	    return t.checkExpect(((ITourneyTree) BothAdvancedNeitherWon).winnersAlwaysAdvanced(),
		 	                           false);
		 	      }		    
    
		 // both contestants were never in the competition
			 	AdvanceMatch BothContestantsNotHere = new AdvanceMatch(Match1vs3, new AdvanceMatch(Match7vs8, Initial4vs5, Initial7vs8), new AdvanceMatch(Match7vs8, Initial4vs5, Initial7vs8));

			 	boolean testWinnersBothAdvancedNotInCompetition(Tester t) {
			 		return t.checkExpect(((ITourneyTree) BothContestantsNotHere).winnersAlwaysAdvanced(),
			 						false);
			 	}		 	 
		 	 
// TRY RUNNING ON AN INITIAL MATCH (AS AN ITOURNEY), WHICH SHOULD ALWAYS PRODUCE TRUE 
	 // input it an initial round, which returns true because an initial round does not have any feeders
    boolean testWinnersWonInitialMatch(Tester t) {
      return t.checkExpect((Initial4vs5).winnersAlwaysAdvanced(),
                           true);
    }
	
	
//////////////////////////////////////** check countUnderdogWins ** //////////////////////////////////////
	
	// ** RUGBY **
    
 // first Rugby contestant won, was underdog
    RugbyTeam holyCrossExpectedWinner = new RugbyTeam("WPI", "red", true, 9, 2);
    RugbyTeam wpiUnderdog = new RugbyTeam("WPI", "red", false, 9, 2);
    RugbyResult RugbyResultWPIUnderdog = new RugbyResult(18, 16);
    Match WPIvsHC_FirstUnderdog = new Match(wpiUnderdog, holyCrossExpectedWinner, RugbyResultWPIUnderdog);
    
 // second Rugby contestant won, was underdog
    RugbyTeam holyCrossUnderdog = new RugbyTeam("WPI", "red", false, 9, 2);
    RugbyTeam wpiExpectedWinner = new RugbyTeam("WPI", "red", true, 9, 2);
    RugbyResult RugbyResultHCUnderdog = new RugbyResult(16, 18);
    Match WPIvsHC_SecondUnderdog = new Match(wpiExpectedWinner, holyCrossUnderdog, RugbyResultHCUnderdog);
    
 // second Rugby contestant won, wasn't underdog
    RugbyResult ResultExpected_SecondTeamWins = new RugbyResult(16, 18);
    Match WPIvsHC_SecondWon = new Match(holyCrossUnderdog,wpiExpectedWinner, ResultExpected_SecondTeamWins);
    
	// Initial Matches
	InitMatch UnderdogRound1 = new InitMatch(WPIvsHC_FirstUnderdog);  // 1 underdog won
	InitMatch UnderdogRound2 = new InitMatch(WPIvsHC_SecondUnderdog); // 1 underdog won
	InitMatch UnderdogRound3 = new InitMatch(WPIvsHC_SecondWon);      // 0 underdogs won
	
	// Advanced Matches
	AdvanceMatch AllUnderdogAdvanced = new AdvanceMatch(WPIvsHC_SecondUnderdog, UnderdogRound1, UnderdogRound2);
	AdvanceMatch OneUnderdogAdvanced = new AdvanceMatch(Match3vs1, UnderdogRound1, 
															new AdvanceMatch(Match4vs5, UnderdogRound3, new UnknownMatch()));
	AdvanceMatch NoUnderdogsAdvanced = new AdvanceMatch(Match3vs1, Initial1vs2, Initial3vs4);
	
	
					// **** TESTS BEGIN ****
	// case where 1 underdog won and 2 expected winners won 
    boolean testOneUnderdogWonRugby(Tester t) {
    	return t.checkExpect(OneUnderdogAdvanced.countUnderdogWins(),
    			1);
    }
    
	// case where all winners were underdogs
    boolean testAllUnderdogWonRugby(Tester t) {
    	return t.checkExpect(AllUnderdogAdvanced.countUnderdogWins(),
    			3);
    }

	// case where no winners were underdogs
    boolean testNoUnderdogWonRugby(Tester t) {
    	return t.checkExpect(NoUnderdogsAdvanced.countUnderdogWins(),
    			0);
    }


    // ** ROBOTICS
	RoboticsTeam wpiRobots = new RoboticsTeam("WPI","goat-bot", 2);
	RoboticsTeam hcRobots = new RoboticsTeam("Holy Cross","watersprayer", 3);
    RoboticsResult RoboticsResultWpiHc = new RoboticsResult(4,5,false,3,3,true);
    Match robotsMatchCheck = new Match(wpiRobots, hcRobots, RoboticsResultWpiHc);
    
    	// second Robotics contestant won, was underdog
    		RoboticsResult RoboticsResultWpiHcSecondWon = new RoboticsResult(4,5,true,3,3,false);
    		Match robotsMatchCheckSecondUnderdogWins = new Match(hcRobots, wpiRobots, RoboticsResultWpiHcSecondWon);
    
    	// first Robotics contestant won, wasn't underdog
    		RoboticsResult RoboticsResultWpiHcFirst = new RoboticsResult(4,5,false,3,3,false);
    		Match robotsMatchCheck_FirstTeamWins = new Match(hcRobots, wpiRobots, RoboticsResultWpiHcFirst);
    
    	// second Robotics contestant won, wasn't underdog
    		RoboticsResult RoboticsResultWpiHcSecond = new RoboticsResult(4,5,true,3,3,false);
    		Match robotsMatchCheck_SecondTeamWins = new Match(wpiRobots, hcRobots, RoboticsResultWpiHcSecond);
 
	// Initial Matches
	InitMatch RoboticsOneUnderdog = new InitMatch(WPIvsHC_FirstUnderdog);  // 1 underdog won
	InitMatch RoboticsAnotherUnderdog = new InitMatch(WPIvsHC_SecondUnderdog); // 1 underdog won
	InitMatch RoboticsNoUnderdog = new InitMatch(WPIvsHC_SecondWon);      // 0 underdogs won
	InitMatch RoboticsNoUnderdog2 = new InitMatch(robotsMatchCheck_FirstTeamWins);   // 0 underdogs won
	
	// Advanced Matches
	AdvanceMatch RoboticsAllUnderdogAdvanced = new AdvanceMatch(robotsMatchCheckSecondUnderdogWins, RoboticsOneUnderdog, RoboticsAnotherUnderdog);
	AdvanceMatch RoboticsOneUnderdogAdvanced = new AdvanceMatch(robotsMatchCheck_SecondTeamWins, RoboticsNoUnderdog, 
															new AdvanceMatch(robotsMatchCheck_SecondTeamWins, RoboticsAnotherUnderdog, new UnknownMatch()));
	AdvanceMatch RoboticsNoUnderdogsAdvanced = new AdvanceMatch(robotsMatchCheck_SecondTeamWins, RoboticsNoUnderdog, RoboticsNoUnderdog2);
	
					// **** TESTS BEGIN ****
	// case where 1 underdog won and 2 expected winners won 
    boolean testOneUnderdogWonRobotics(Tester t) {
    	return t.checkExpect(RoboticsOneUnderdogAdvanced.countUnderdogWins(),
    			1);
    }
    
	// case where all winners were underdogs
    boolean testAllUnderdogWonRobotics(Tester t) {
    	return t.checkExpect(RoboticsAllUnderdogAdvanced.countUnderdogWins(),
    			3);
    }

	// case where no winners were underdogs
    boolean testNoUnderdogWonRobotics(Tester t) {
    	return t.checkExpect(RoboticsNoUnderdogsAdvanced.countUnderdogWins(),
    			0);
    }
}