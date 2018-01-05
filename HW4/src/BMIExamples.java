import java.util.LinkedList;
import tester.*;

class BMIExamples {
  IBMIProbs B;
  
  BMIExamples(IBMIProbs b) {
    this.B = b;
  }
  
  PHR obesePHR = new PHR ("Joe", 2.1, 150.0, 175); // BMI: ~34, obese
  PHR borderObese = new PHR ("Sharon", 2, 120, 125); // BMI: 30, obese
  PHR overPHR = new PHR ("Robert", 2, 115, 165); // BMI: ~ 28.75, overweight
  PHR borderOverweight = new PHR ("Dan", 2, 100, 160);  // BMI: 25, overweight
  PHR healthyPHR = new PHR ("Kim", 2.3, 115.0, 165); // BMI: ~ 21.7, healthy
  PHR borderHealthy = new PHR ("Tim", 2, 74, 160);  // BMI: 18.5, healthy
  PHR underPHR = new PHR ("Karen", 2.6, 110.0, 155); // BMI: ~ 16.2,  underweight
  
  
  // test case where there are elements in all of the final lists
  boolean testBMIElementsInAll (Tester t) {
	  LinkedList<String> underList = new LinkedList<String>();
	  LinkedList<String> healthyList = new LinkedList<String>();
	  LinkedList<String> overList = new LinkedList<String>();
	  LinkedList<String> obeseList = new LinkedList<String>();

	  LinkedList phrList = new LinkedList<PHR>(); 
	  phrList.add(obesePHR);
	  phrList.add(borderObese);
	  phrList.add(overPHR);
	  phrList.add(borderOverweight);
	  phrList.add(healthyPHR);
	  phrList.add(borderHealthy);
	  phrList.add(underPHR);
	  
	  underList.add("Karen");
	  healthyList.add("Kim");
	  healthyList.add("Tim");
	  overList.add("Robert");
	  overList.add("Dan");
	  obeseList.add("Joe");
	  obeseList.add("Sharon");
	 
    return t.checkExpect(B.bmiReport(phrList), new BMISummary(underList, healthyList, overList, obeseList));
  }
  
  // test case where there are no elements in any of the final lists
  boolean testBMINoElements (Tester t) {
	  LinkedList<String> underList = new LinkedList<String>();
	  LinkedList<String> healthyList = new LinkedList<String>();
	  LinkedList<String> overList = new LinkedList<String>();
	  LinkedList<String> obeseList = new LinkedList<String>();

	  
	  LinkedList phrList = new LinkedList<PHR>(); 
	  
    return t.checkExpect(B.bmiReport(phrList), new BMISummary(underList, healthyList, overList, obeseList));
  }
  
  // test case where there are only elements in the overweight and underweight name lists 
  boolean testBMIUnderOver (Tester t) {
	  LinkedList<String> underList = new LinkedList<String>();
	  LinkedList<String> healthyList = new LinkedList<String>();
	  LinkedList<String> overList = new LinkedList<String>();
	  LinkedList<String> obeseList = new LinkedList<String>();

	  LinkedList phrList = new LinkedList<PHR>(); 
	  
	  phrList.add(overPHR);
	  phrList.add(borderOverweight);
	  phrList.add(underPHR);
	  
	  underList.add("Karen");
	  overList.add("Robert");
	  overList.add("Dan");
	
    return t.checkExpect(B.bmiReport(phrList), new BMISummary(underList, healthyList, overList, obeseList));
  }
  
  // test case where there are only elements in one category
  boolean testBMIOneCategory (Tester t) {
	  LinkedList<String> underList = new LinkedList<String>();
	  LinkedList<String> healthyList = new LinkedList<String>();
	  LinkedList<String> overList = new LinkedList<String>();
	  LinkedList<String> obeseList = new LinkedList<String>();

	  LinkedList phrList = new LinkedList<PHR>(); 
	  
	  phrList.add(overPHR);
	  phrList.add(borderOverweight);
	  
	  overList.add("Robert");
	  overList.add("Dan");
	
    return t.checkExpect(B.bmiReport(phrList), new BMISummary(underList, healthyList, overList, obeseList));
  }
  
  // test case where all are border
  boolean testBMIAllBorder(Tester t) {
	  LinkedList<String> underList = new LinkedList<String>();
	  LinkedList<String> healthyList = new LinkedList<String>();
	  LinkedList<String> overList = new LinkedList<String>();
	  LinkedList<String> obeseList = new LinkedList<String>();

	  LinkedList phrList = new LinkedList<PHR>(); 
	  
	  phrList.add(borderObese);
	  phrList.add(borderOverweight);
	  phrList.add(borderHealthy);
	  
	  healthyList.add("Tim");
	  overList.add("Dan");
	  obeseList.add("Sharon");
	 
    return t.checkExpect(B.bmiReport(phrList), new BMISummary(underList, healthyList, overList, obeseList));
  }
}