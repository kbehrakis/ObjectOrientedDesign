import java.util.LinkedList;

import tester.*;

class DataSmoothExamples {
  IDataSmoothProbs D;
  
  DataSmoothExamples(IDataSmoothProbs D) {
    this.D = D;
  }
  
  PHR obesePHR = new PHR ("Joe", 2.1, 150.0, 95);
  PHR borderObese = new PHR ("Sharon", 2, 120, 102); 
  PHR overPHR = new PHR ("Robert", 2, 115, 98); 
  PHR borderOverweight = new PHR ("Dan", 2, 100, 88);
  PHR healthyPHR = new PHR ("Kim", 2.3, 115.0, 105); 
  
  // using the example given in the homework (multiple value to average)
  boolean testDataSmoothGivenExample (Tester t) {
	  LinkedList<PHR> phrList = new LinkedList<PHR>(); 
	  phrList.add(obesePHR);
	  phrList.add(borderObese);
	  phrList.add(overPHR);
	  phrList.add(borderOverweight);
	  phrList.add(healthyPHR);
	  
	  LinkedList<Double> smoothedHeartRates = new LinkedList<Double>();
	  smoothedHeartRates.add(95.0);
	  smoothedHeartRates.add(98.33);
	  smoothedHeartRates.add(96.0);
	  smoothedHeartRates.add(97.0);
	  smoothedHeartRates.add(105.0);
	  
    return t.checkInexact(D.dataSmooth(phrList),  smoothedHeartRates, 0.01);
  }
  
  // only 2 values to use (should just return their values, no averaging)
  boolean testDataSmoothTwoElements (Tester t) {
	  LinkedList<PHR> phrList = new LinkedList<PHR>(); 
	  phrList.add(obesePHR);
	  phrList.add(borderObese);

	  
	  LinkedList<Double> smoothedHeartRates = new LinkedList<Double>();
	  smoothedHeartRates.add(95.0);
	  smoothedHeartRates.add(102.0);
	  
    return t.checkInexact(D.dataSmooth(phrList),  smoothedHeartRates, 0.01);
  }
  
  // only 1 value to use (should just return their values, no averaging)
  boolean testDataSmoothOneElement (Tester t) {
	  LinkedList<PHR> phrList = new LinkedList<PHR>(); 
	  phrList.add(obesePHR);

	  
	  LinkedList<Double> smoothedHeartRates = new LinkedList<Double>();
	  smoothedHeartRates.add(95.0);
	  
    return t.checkInexact(D.dataSmooth(phrList),  smoothedHeartRates, 0.01);
  }
  
  // no values to use
  boolean testDataSmoothNoValues (Tester t) {
	  LinkedList<PHR> phrList = new LinkedList<PHR>();
	  
	  LinkedList<Double> smoothedHeartRates = new LinkedList<Double>();
	  
    return t.checkInexact(D.dataSmooth(phrList),  smoothedHeartRates, 0.01);
  }
}