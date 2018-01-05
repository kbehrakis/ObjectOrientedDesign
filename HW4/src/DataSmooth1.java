import java.util.LinkedList;

class DataSmooth1 implements IDataSmoothProbs {
  DataSmooth1(){}
  
  //  produces a list of the smoothed heartRate values
  public LinkedList<Double> dataSmooth(LinkedList<PHR> phrs) {
	  int index = 0; //monitor position in the list
		
	  LinkedList<Double> smoothedData = new LinkedList<Double>();
	
	  if(phrs.size() == 1)
		  {smoothedData.add((double) phrs.get(0).heartRate);
		  return smoothedData;}
	  else if (phrs.size() == 0)
	  {
		  return smoothedData;
	  }
	  
	  smoothedData.add((double) phrs.get(0).heartRate); // can't get average of first element, so always just add first element
	  
	for(index=1; index < phrs.size() - 1; index = index + 1){
		smoothedData.add(((double) phrs.get(index-1).heartRate + (double) phrs.get(index).heartRate + (double) phrs.get(index + 1).heartRate)/3);    // get: get element at that index 
	}

	smoothedData.add(((double) phrs.get(index).heartRate)); // can't get average of last elements, so always add last element
	
	return smoothedData;
  }
}