import java.util.LinkedList;

import tester.*;

class FreqWordsExamples {
  IFreqWordsProbs F;
  
  FreqWordsExamples(IFreqWordsProbs F) {
    this.F = F;
  }
  
 // two most frequent words have same number of occurrences  
  boolean testFreqWordsTwoOccurSameAmount(Tester t) {
	  LinkedList<String> wordList = new LinkedList<String>(); 
	  wordList.add("purple");
	  wordList.add("green");
	  wordList.add("purple");
	  wordList.add("red");
	  wordList.add("green");
	  wordList.add("purple");
	  wordList.add("brown");  // brown and purple both have 3 occurrences, brown goes first b/c less letters
	  wordList.add("brown");
	  wordList.add("brown");
	  
	  LinkedList<String> mostFreqList = new LinkedList<String>();
	  mostFreqList.add("brown");
	  mostFreqList.add("purple");
	  mostFreqList.add("green");
	  
    return t.checkExpect(F.frequentWords(wordList), mostFreqList);
  }
  
  // three most frequent words have same number of occurrences  
  boolean testFreqWordsThreeOccurSameAmount(Tester t) {
	  LinkedList<String> wordList = new LinkedList<String>(); 
	  wordList.add("purple");
	  wordList.add("green");
	  wordList.add("purple");
	  wordList.add("red");
	  wordList.add("green");
	  wordList.add("purple");
	  wordList.add("brown");  // brown, purple, red have 3 occurrences, result (based on least letters): red, brown, purple
	  wordList.add("brown");
	  wordList.add("brown");
	  wordList.add("red");
	  wordList.add("red");
	  
	  LinkedList<String> mostFreqList = new LinkedList<String>();
	  mostFreqList.add("red");
	  mostFreqList.add("brown");
	  mostFreqList.add("purple");
	  
    return t.checkExpect(F.frequentWords(wordList), mostFreqList);
  }
  
  // all have different frequencies
  boolean testFreqWordsNoneOccurSameAmount(Tester t) {
	  LinkedList<String> wordList = new LinkedList<String>(); 
	  wordList.add("purple");
	  wordList.add("green");
	  wordList.add("purple");
	  wordList.add("red");
	  wordList.add("green");
	  wordList.add("purple");   // 4 purple
	  wordList.add("purple");
	  wordList.add("brown");  //  3 brown
	  wordList.add("brown");
	  wordList.add("brown");
	  wordList.add("red"); // 5 red
	  wordList.add("red");
	  wordList.add("red");
	  wordList.add("red");
	  
	  LinkedList<String> mostFreqList = new LinkedList<String>();
	  mostFreqList.add("red");
	  mostFreqList.add("purple");
	  mostFreqList.add("brown");
	  
    return t.checkExpect(F.frequentWords(wordList), mostFreqList);
  }
  
  // last two have same frequency 
  boolean testFreqWordsLastTwoSame(Tester t) {
	  LinkedList<String> wordList = new LinkedList<String>(); 
	  wordList.add("purple");
	  wordList.add("green");
	  wordList.add("purple");  // 3 purple
	  wordList.add("red");
	  wordList.add("green");  
	  wordList.add("purple");
	  wordList.add("brown");  //  3 brown
	  wordList.add("brown");
	  wordList.add("brown");
	  wordList.add("red"); // 5 red
	  wordList.add("red");
	  wordList.add("red");
	  wordList.add("red");
	  
	  LinkedList<String> mostFreqList = new LinkedList<String>();
	  mostFreqList.add("red");
	  mostFreqList.add("brown");
	  mostFreqList.add("purple");
	  
    return t.checkExpect(F.frequentWords(wordList), mostFreqList);
  }
  
  // 3rd and 4th most frequency have same frequency
  boolean testFreqWordsThirdFourthSame(Tester t) {
	  LinkedList<String> wordList = new LinkedList<String>(); 
	  wordList.add("purple");
	  wordList.add("orange");
	  wordList.add("purple");
	  wordList.add("red");
	  wordList.add("orange");
	  wordList.add("green");
	  wordList.add("purple");    // 4 purple
	  wordList.add("purple");
	  wordList.add("brown");     //  3 brown
	  wordList.add("brown");
	  wordList.add("orange");    // 3 orange
	  wordList.add("brown");
	  wordList.add("red");       // 5 red
	  wordList.add("red");
	  wordList.add("red");
	  wordList.add("red");
	  
	  LinkedList<String> mostFreqList = new LinkedList<String>();
	  mostFreqList.add("red");
	  mostFreqList.add("purple");
	  mostFreqList.add("brown");
	  
    return t.checkExpect(F.frequentWords(wordList), mostFreqList);
  }
}