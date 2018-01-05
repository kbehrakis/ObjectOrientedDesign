abstract class AbsEarthquake implements IEarthquakeProbs{

	AbsEarthquake () {};
	
// makes a new MaxHzReport using the maximum frequency of the day and the day 
	MaxHzReport createNewReport(Double maxFreq, int day) {
		
		MaxHzReport reportForDay = new MaxHzReport(day, maxFreq);
		return reportForDay;
	}
}
