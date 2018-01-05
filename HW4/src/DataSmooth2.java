import java.util.LinkedList;

class DataSmooth2 implements IDataSmoothProbs {
  DataSmooth2(){}
 
 //  produces a list of the smoothed heartRate values
  public LinkedList<Double> dataSmooth(LinkedList<PHR> phrs) {
	  int index = 0; //monitor position in the list
	  
	  LinkedList<Double> heartRatesList = new LinkedList<Double>();
	  LinkedList<Double> smoothedData = new LinkedList<Double>();

	  if(phrs.size() == 1)
	  	{smoothedData.add((double) phrs.get(0).heartRate);
	  		return smoothedData;}
	  else if (phrs.size() == 0)
	  {
		  return smoothedData;
	  }
	  
// a for loop to get just the heart rates
	for(PHR p : phrs){
		heartRatesList.add((double) p.heartRate);
	}

	 smoothedData.add((double)heartRatesList.get(0)); // can't get average of first element, so always just add first element
	
// a second for doing the averaging
	for(index=1; index < heartRatesList.size() - 1; index = index + 1){
		smoothedData.add(((double) heartRatesList.get(index-1) + 
						  (double) heartRatesList.get(index) + 
						  (double) heartRatesList.get(index + 1)) /3);    // get: get element at that index 
	}
	
	smoothedData.add(((double) phrs.get(index).heartRate)); // can't get average of last elements, so always add last element
	
	return smoothedData;
  }
}