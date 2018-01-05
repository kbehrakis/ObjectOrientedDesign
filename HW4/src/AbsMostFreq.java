import java.util.Collections;
import java.util.LinkedList;

abstract class AbsMostFreq implements IFreqWordsProbs {
	
	AbsMostFreq () {};
	
	   // remove all instances of given string from a list
    LinkedList<String> remove(LinkedList<String> words, String word){
  	  LinkedList<String> elementsRemoved = new LinkedList<String>();
  	  elementsRemoved.addAll(words);
  	  
  	  for (String w : words){
  		  if (w.equals(word))
  			  elementsRemoved.remove(w);
  	  }
  	  
  	  return elementsRemoved;
    }
    
    
    // get the most frequent element in a list
    String getMostFreq (LinkedList<String> words){
  	    int index = 0;
  	    String mostFreqWord = words.get(index);  // set it to the first element of the list
  	    int count = Collections.frequency(words, mostFreqWord);  // keeps count of how many occurrences there are of a string
  	 
  	    for(index=1; index < words.size(); index = index + 1){
  			  if (Collections.frequency(words, words.get(index)) > count) // Collections.frequency gets number of times string appears in list of words 
  				  { count = Collections.frequency(words, words.get(index));
  				  mostFreqWord = words.get(index); }
  			  else if (Collections.frequency(words, words.get(index)) == count)
  				  if (words.get(index).length() < mostFreqWord.length())
  					  mostFreqWord = words.get(index);
  		  }
  		  return mostFreqWord;
    }
}