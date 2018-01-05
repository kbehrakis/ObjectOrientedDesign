import java.util.Collections;
import java.util.LinkedList;

class MostFrequentWords1 extends AbsMostFreq {
  MostFrequentWords1(){}
  
  public LinkedList<String> frequentWords(LinkedList<String> words) {
	  LinkedList<String> mostFreqWords = new LinkedList<String>();
	
	  String mostFreq = getMostFreq(words);  
	  words = remove(words, mostFreq);
	  
	  String secondFreq = getMostFreq(words);
	  words = remove(words, secondFreq);
	  
	  String thirdFreq = getMostFreq(remove(words, secondFreq));  
	  
	  mostFreqWords.add(mostFreq);
	  mostFreqWords.add(secondFreq);
	  mostFreqWords.add(thirdFreq);
	  
	  return mostFreqWords;
}
}