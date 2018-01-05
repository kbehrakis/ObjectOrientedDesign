import java.util.LinkedList;
import javax.sql.rowset.Predicate;

class BMI2 implements IBMIProbs {
  BMI2(){}
  
  public BMISummary bmiReport(LinkedList<PHR> phrs) {
	  LinkedList<PHR> underweightListPHR = new LinkedList<PHR>();
	  LinkedList<PHR> healthyListPHR = new LinkedList<PHR>();
	  LinkedList<PHR> overweightListPHR = new LinkedList<PHR>();
	  LinkedList<PHR> obeseListPHR = new LinkedList<PHR>();
	  
    // first separate original PHR list into separate PHR lists based on BMI
	  for(PHR p : phrs){
		  double BMI = p.weight/(p.height*p.height);
		  
		  if (BMI < 18.5)
			  underweightListPHR.add(p);
		  else if (BMI>= 18.5 && BMI<25)
			  healthyListPHR.add(p);
		  else if (BMI>= 25 && BMI<30)
			  overweightListPHR.add(p);
		  else if (BMI>=30)
			  obeseListPHR.add(p);
		}
	  
	  // take the separated PHR lists and make a call to a helper that returns a list of the names
	  LinkedList<String> underweightList = getNames(underweightListPHR);
	  LinkedList<String> healthyList = getNames(healthyListPHR);
	  LinkedList<String> overweightList = getNames(overweightListPHR);
	  LinkedList<String> obeseList = getNames(obeseListPHR);
	
	  BMISummary finalReport = new BMISummary(underweightList,
												healthyList,
												overweightList,
												obeseList);
	  
	  return finalReport;

  }
  
  // helper function to get the names of the people in the PHRs 
  public LinkedList<String> getNames(LinkedList<PHR> phrs)
  {
	  LinkedList<String> phrsNames = new LinkedList<String>(); 
	 
	  for(PHR p : phrs){
		  phrsNames.add(p.name);
	  }
	  
	  return phrsNames;
  }
}