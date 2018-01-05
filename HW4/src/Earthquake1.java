import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Earthquake1 extends AbsEarthquake {
  Earthquake1(){}

  
//produces a list of reports indicating the highest frequency reading for each day in that month.  
 public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
	  LinkedList<MaxHzReport> finalReportList = new LinkedList<MaxHzReport>();  // includes list thus far, updating it until it becomes final list (reaches the end of the data list)
	  int index = 0;
	  for (index = 0; index < data.size(); index++)
	  {	
	  	if ((data.get(index) < 0) || (data.get(index) > 500)) // if it's a date
	  		{if (isCorrectMonth(data.get(index), month))  // if it has the correct month
	  			{finalReportList.add(getReportOneDay(data.subList(index, data.size())));}  // getReportOneDay returns report for one day, adds one day report to final list
	  		}
	 }
	 return finalReportList; 	
	}
 
 
//checks to see if the month in the full date is equal to the provided month
boolean isCorrectMonth(Double fullDate, int month) {
	String dateString = fullDate.toString(); 
	String monthFromSubstring = dateString.substring(5, 7);  // turn the date into a string, then get just the month portion by using substrings
	int monthFromFullDate = 0;
	
	// check if month in data has 0 preceding it (i.e. 01, 02, etc.)
	if(Integer.parseInt(monthFromSubstring.substring(0, 1)) == 0)  // if month is preceded by a 0
		monthFromFullDate = Integer.parseInt(monthFromSubstring.substring(1, 2));
	else 
		monthFromFullDate = Integer.parseInt(monthFromSubstring); // turn back into an integer
	
	return (monthFromFullDate == month);  // returns true if the month in the date is correct
	
}


//accepts data starting with a date through the end of the list, return a report for one day
MaxHzReport getReportOneDay(List<Double> dataStartingWithDate) {
	
	LinkedList<Double> freqsForOneDay = new LinkedList<Double>();	
	int index = 0; //monitor position in the list

		for(index=1; index < dataStartingWithDate.size(); index = index + 1){  // start index at 1 because you know the when index = 0, it's going to be a date (we break when we hit a date, so we're not going to start by breaking)
			if ((dataStartingWithDate.get(index) >= 0) && (dataStartingWithDate.get(index) <= 500))  // valid (not date), should add to list
				freqsForOneDay.add(dataStartingWithDate.get(index));  // if it's valid, add it to the list with the day's frequency
			else if ((dataStartingWithDate.get(index) < 0) || (dataStartingWithDate.get(index) > 500))  // if it's a date
				break;  // break out of loop, it's the end of the data for the given day
		}
			
		MaxHzReport oneDayReport = createNewReport(Collections.max(freqsForOneDay), getDay(dataStartingWithDate.get(0)));  // create a new report with the max frequency and the given day (found by calling to a helper)
		return oneDayReport;                    // Collections.max gets the maximum element in the list
}


//extracts the day from the full date
int getDay(Double fullDate) {
	String dateString = fullDate.toString();
	int day = 0;
	
	String dayFromSubstring = dateString.substring(7, 9);   // turn the date into a string, then get just the day portion by using substrings
	if(Integer.parseInt(dayFromSubstring.substring(0, 1)) == 0)  // if day is preceded by a 0
		day = Integer.parseInt(dayFromSubstring.substring(1, 2));
	else 
		day = Integer.parseInt(dayFromSubstring); // turn back into an integer
	
	return day;
}
}  
