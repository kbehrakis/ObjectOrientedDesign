interface ITourneyTree {
	boolean winnersAlwaysAdvanced(); // produces a boolean indicating whether every match 
									// is either InitMatch or AdvanceMatch where winner is one of feeders

	int countUnderdogWins();  // produces the number of matches in the tournament in which the winner was an underdog
}
