import java.util.LinkedList;
import java.util.List;

class BMI1 implements IBMIProbs {
  BMI1(){}
  
  public BMISummary bmiReport(LinkedList<PHR> phrs) {
	  LinkedList<String> underweightList = new LinkedList<String>();
	  LinkedList<String> healthyList = new LinkedList<String>();
	  LinkedList<String> overweightList = new LinkedList<String>();
	  LinkedList<String> obeseList = new LinkedList<String>();
	
	  
		// one for loop to separate out the PHRs and get the names 	 
			  for(PHR p : phrs){
				  double BMI = p.weight/(p.height*p.height);
				  
				  if (BMI < 18.5)
					  underweightList.add(p.name);
				  else if (BMI>= 18.5 && BMI<25)
					  healthyList.add(p.name);
				  else if (BMI>= 25 && BMI<30)
					  overweightList.add(p.name);
				  else if (BMI>= 30)
					  obeseList.add(p.name);
				}
	  
	  BMISummary finalReport = new BMISummary(underweightList,
			  									healthyList,
			  									overweightList,
			  									obeseList);
	  return finalReport;
  }
}