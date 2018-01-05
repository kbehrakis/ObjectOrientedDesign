import java.util.LinkedList;

class Planning {

		Planning(){};  //constructor
		// Produce the average of the non-negative values in the list up to the first -999 (if it shows up), and
		// if average cannot be found, return -1
		double rainfall(LinkedList<Double> rainfallList){
			double sum; // holds value of sum of elements
			sum = 0;
			double numElements; // holds the number of elements averages (becomes the denominator when averaging)
			numElements = 0; 
			
			double defaultValue = -1; // default is when average cannot be computed
			
			for(Double d : rainfallList){
				if ((d != -999) && d>=0)
				{	
					sum = (sum + d); 
					numElements++;
				}
				
				else if (d == -999)
					break;				// exit out of the loop
				
			}
			
			if (numElements != 0)
				return sum/numElements;	
			else return defaultValue;
		}
	
	// produces the length of the longest concatenation of three consecutive elements		
	int maxTripleLength(LinkedList<String> manyStringList){
			int numChar; // holds value of the current number of characters
			numChar = 0;
			int index = 0; //monitor position in the list
			int oldNumChar = 0;  // holds the value of the previous number of longest concatenation 
			
			for(index=0; index <  (manyStringList.size() - 2); index = index + 1){  // -2 on list length because we want only full groups of 3
				numChar =  manyStringList.get(index).length()
							+ manyStringList.get(index+1).length() 
							+ manyStringList.get(index+2).length();  // get length of 3 consecutive element 
				
				if (oldNumChar < numChar)
					oldNumChar = numChar;  
			}
			
			return oldNumChar;	
	}

}
