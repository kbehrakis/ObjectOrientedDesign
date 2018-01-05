import java.util.LinkedList;

import tester.*;

class EarthquakeExamples {
  IEarthquakeProbs E;
  
  EarthquakeExamples(IEarthquakeProbs E) {
    this.E = E;
  }
  

// test the given example (2 years, each have different number of frequencies, all of the same month)
  boolean testGivenExample(Tester t) {
	  LinkedList<Double> earthquakeSequence = new LinkedList<Double>();
	  LinkedList<MaxHzReport> HzReportList = new LinkedList<MaxHzReport>();
	  
	  earthquakeSequence.add((double)20151004);
	  earthquakeSequence.add((double)200);
	  earthquakeSequence.add((double)150);
	  earthquakeSequence.add((double)175);
	  earthquakeSequence.add((double)20151005);
	  earthquakeSequence.add((double)0.002);
	  earthquakeSequence.add((double)0.03);
	  
	  HzReportList.add(new MaxHzReport (4, 200));
	  HzReportList.add(new MaxHzReport (5, 0.03));
	  
    return t.checkExpect(E.dailyMaxForMonth(earthquakeSequence, 10), HzReportList);
  }
  

//test when one date has correct month, other does not
 boolean testOneWrongMonth(Tester t) {
	 LinkedList<Double> earthquakeSequence = new LinkedList<Double>();
	 LinkedList<MaxHzReport> HzReportList = new LinkedList<MaxHzReport>();
	 
	  earthquakeSequence.add((double)20151004);
	  earthquakeSequence.add((double)200);
	  earthquakeSequence.add((double)150);
	  earthquakeSequence.add((double)175);
	  earthquakeSequence.add((double)20151105);
	  earthquakeSequence.add((double)0.002);
	  earthquakeSequence.add((double)0.03);
	  
	  HzReportList.add(new MaxHzReport (4, 200));
	  
   return t.checkExpect(E.dailyMaxForMonth(earthquakeSequence, 10), HzReportList);
 }
 
//test when both dates have same wrong month
boolean testWrongMonths(Tester t) {
	
LinkedList<MaxHzReport> emptyReportList = new LinkedList<MaxHzReport>();
	LinkedList<Double> earthquakeSequence = new LinkedList<Double>();

	  earthquakeSequence.add((double)20151004);
	  earthquakeSequence.add((double)200);
	  earthquakeSequence.add((double)150);
	  earthquakeSequence.add((double)175);
	  earthquakeSequence.add((double)20151005);
	  earthquakeSequence.add((double)0.002);
	  earthquakeSequence.add((double)0.03);
	  
	 
  return t.checkExpect(E.dailyMaxForMonth(earthquakeSequence, 12), emptyReportList);
}

//test when both dates have different wrong month
boolean testDifferentWrongMonths(Tester t) {

  LinkedList<MaxHzReport> emptyReportList = new LinkedList<MaxHzReport>();
  LinkedList<Double> earthquakeSequence = new LinkedList<Double>();
  
	  earthquakeSequence.add((double)20151004);
	  earthquakeSequence.add((double)200);
	  earthquakeSequence.add((double)150);
	  earthquakeSequence.add((double)175);
	  earthquakeSequence.add((double)20150108); // skip days 
	  earthquakeSequence.add((double)0.002);
	  earthquakeSequence.add((double)0.03);
	  
return t.checkExpect(E.dailyMaxForMonth(earthquakeSequence, 12), emptyReportList);
}

//test when it starts with wrong month then goes into correct month
boolean testWrongMonthsToStart(Tester t) {

LinkedList<MaxHzReport> HzReportList = new LinkedList<MaxHzReport>();
LinkedList<Double> earthquakeSequence = new LinkedList<Double>();

	  earthquakeSequence.add((double)20151004);
	  earthquakeSequence.add((double)200);
	  earthquakeSequence.add((double)150);
	  earthquakeSequence.add((double)175);
	  
	  earthquakeSequence.add((double)20151005);
	  earthquakeSequence.add((double)0.002);
	  earthquakeSequence.add((double)0.03);
	  
	  earthquakeSequence.add((double)20151107);
	  earthquakeSequence.add((double)500);
	  earthquakeSequence.add((double)500);  // same frequencies
	  earthquakeSequence.add((double)20); 
	  
	  earthquakeSequence.add((double)20151225);
	  earthquakeSequence.add((double)500);
	  earthquakeSequence.add((double)500);  // same frequencies
	  earthquakeSequence.add((double)202); 
	  
	  earthquakeSequence.add((double)20151231);
	  earthquakeSequence.add((double)0); 
	  
	  HzReportList.add(new MaxHzReport (25, 500));
	  HzReportList.add(new MaxHzReport (31, 0));
	  
return t.checkExpect(E.dailyMaxForMonth(earthquakeSequence, 12), HzReportList);
}

//test month with a preceding 0 (i.e. 07)
boolean testPrecedingZeroMonth(Tester t) {

LinkedList<MaxHzReport> HzReportList = new LinkedList<MaxHzReport>();
LinkedList<Double> earthquakeSequence = new LinkedList<Double>();

	  earthquakeSequence.add((double)20150714);
	  earthquakeSequence.add((double)200);
	  earthquakeSequence.add((double)150);
	  earthquakeSequence.add((double)175);
	  
	  earthquakeSequence.add((double)20150716);
	  earthquakeSequence.add((double)0.002);
	  earthquakeSequence.add((double)0.03);
	  
	  HzReportList.add(new MaxHzReport (14, 200));
	  HzReportList.add(new MaxHzReport (16, 0.03));
	  
return t.checkExpect(E.dailyMaxForMonth(earthquakeSequence, 7), HzReportList);
}

//test day with a preceding 0 (i.e. 07)
boolean testPrecedingZeroDay(Tester t) {

LinkedList<MaxHzReport> HzReportList = new LinkedList<MaxHzReport>();
LinkedList<Double> earthquakeSequence = new LinkedList<Double>();

	  earthquakeSequence.add((double)20151106);
	  earthquakeSequence.add((double)200);
	  earthquakeSequence.add((double)150);
	  earthquakeSequence.add((double)175);
	  
	  earthquakeSequence.add((double)20151107);
	  earthquakeSequence.add((double)0.002);
	  earthquakeSequence.add((double)0.03);
	  
	  HzReportList.add(new MaxHzReport (6, 200));
	  HzReportList.add(new MaxHzReport (7, 0.03));
	  
return t.checkExpect(E.dailyMaxForMonth(earthquakeSequence, 11), HzReportList);
}


//test removing preceding zeros in both month and day
boolean testPrecedingZeroMonthAndDay(Tester t) {

LinkedList<MaxHzReport> HzReportList = new LinkedList<MaxHzReport>();
LinkedList<Double> earthquakeSequence = new LinkedList<Double>();

	  earthquakeSequence.add((double)20150904);
	  earthquakeSequence.add((double)200);
	  earthquakeSequence.add((double)150);
	  earthquakeSequence.add((double)175);
	  
	  earthquakeSequence.add((double)20150906);
	  earthquakeSequence.add((double)0.002);
	  earthquakeSequence.add((double)0.03);
	  
	  HzReportList.add(new MaxHzReport (4, 200));
	  HzReportList.add(new MaxHzReport (6, 0.03));
	  
return t.checkExpect(E.dailyMaxForMonth(earthquakeSequence, 9), HzReportList);
}

}