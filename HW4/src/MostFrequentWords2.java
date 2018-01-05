import java.util.Collections;
import java.util.LinkedList;

class MostFrequentWords2 extends AbsMostFreq {
  MostFrequentWords2(){}
    
    public LinkedList<String> frequentWords(LinkedList<String> words) {
  	  LinkedList<String> mostFreqWords = new LinkedList<String>();
  		int index = 0;
  	
  		// instead of adding manually, use a for loop to add the most frequent elements to the final list
  	  for(index=0; index < 3; index = index + 1){
  		  mostFreqWords.add(getMostFreq(words));
  		  words = remove(words, getMostFreq(words));
  	  }
  	  
  	  return mostFreqWords;
  	  }
    
}