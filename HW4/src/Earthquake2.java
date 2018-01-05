import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Earthquake2 extends AbsEarthquake {
  Earthquake2(){}
  
  
//produces a list of reports indicating the highest frequency reading for each day in that month.  
 public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
	  LinkedList<MaxHzReport> finalReportList = new LinkedList<MaxHzReport>();  // includes list thus far, updating it until it becomes final list (reaches the end of the data list)
	  int index = 0;

	  for (index = 0; index < data.size(); index++)
	  {	
	  	if ((data.get(index) < 0) || (data.get(index) > 500)) // if it's a date
	  		{if (removeZeros(getSubstrings(data.get(index), 5, 7)) == (double)month)  // if it has the correct month
	  			{finalReportList.add(getReportOneDay(data.subList(index, data.size())));}  // getReportOneDay returns report for one day, adds one day report to final list
	  		}
	 }
	 return finalReportList; 	
	}
 
 
//checks to see if the month in the full date is equal to the provided month
String getSubstrings(Double fullDate, int substringStart, int substringEnd) {
	String dateString = fullDate.toString(); 
	String dataFromSubstring = dateString.substring(substringStart, substringEnd);  // turn the date into a string, then get just the month portion by using substrings
	
	return dataFromSubstring; 
	
}

// get rid of any preceding zeros 
int removeZeros(String dataFromSubstring){
	int dataWithoutZeros = 0;
	
	if(Integer.parseInt(dataFromSubstring.substring(0, 1)) == 0)  // if day is preceded by a 0
		dataWithoutZeros = Integer.parseInt(dataFromSubstring.substring(1, 2));
	else 
		dataWithoutZeros = Integer.parseInt(dataFromSubstring); // turn back into an integer
	
	return dataWithoutZeros;
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
			
		MaxHzReport oneDayReport = createNewReport(Collections.max(freqsForOneDay), removeZeros(getSubstrings(dataStartingWithDate.get(0), 7, 9)));  // create a new report with the max frequency and the given day (found by calling to a helper)
		return oneDayReport;                    // Collections.max gets the maximum element in the list
}

}  
