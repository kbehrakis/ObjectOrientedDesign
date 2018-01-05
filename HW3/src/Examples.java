// Kristen Behrakis

/*
 * separate method to check heap
 * another method for checking if all elements are in heap
 *  
 *  
 *      4        (data)
 *   6     8    (left.data, right.data)
 *  boolean isHeap() {  // goes in binary tree classes
 *  if (this.data < this.left.data)  // isBigger method because it runs into trouble if left is empty - compiler error
 *  } copy paste for tree class? 
 * 
 * 
 */

import tester.*;
import java.util.LinkedList;

    class Examples {
    	Examples () {} ;
    	
    	Planning startObject = new Planning();

// **** rainfall tests ****     
    	// 2 elements occur before -999
        boolean testTwoElementsBeforeNeg999(Tester t) {
        	LinkedList<Double> rainfallExample = new LinkedList<Double>(); 
        	rainfallExample.add((double) 4); 
        	rainfallExample.add((double) 10); 
        	rainfallExample.add((double) -999); 
        	rainfallExample.add((double) 300);
	
         return t.checkExpect(startObject.rainfall(rainfallExample), (double) 7);
        }
      
        // only one element comes before -999 (number/1)
        boolean testOneElementBeforeNeg999(Tester t) {
        	LinkedList<Double> rainfallExample = new LinkedList<Double>(); 
        	rainfallExample.add((double) 10); 
        	rainfallExample.add((double) -999); 
        	rainfallExample.add((double) 300);
	
         return t.checkExpect(startObject.rainfall(rainfallExample), (double) 10);
        }
        
        // first element is -999 
        boolean testFirstElementNeg999(Tester t) {
        	LinkedList<Double> rainfallExample = new LinkedList<Double>(); 
        	rainfallExample.add((double) -999); 
        	rainfallExample.add((double) 300);
	
         return t.checkExpect(startObject.rainfall(rainfallExample), (double) -1);
        }

        // no -999 in the list
        boolean testNoNeg999(Tester t) {
        	LinkedList<Double> rainfallExample = new LinkedList<Double>(); 
        	rainfallExample.add((double) 4);
        	rainfallExample.add((double) -4); 
        	rainfallExample.add((double) 3); 
        	rainfallExample.add((double) 12); 
	
         return t.checkExpect(startObject.rainfall(rainfallExample), (double) 19/3);
        }
        
        
 // **** maxTripleLength tests **** 
        
        // testing the given example in the assignment, max length occurs with last 3 elements 
        boolean testGivenExampleList(Tester t) {  
        	LinkedList<String> maxLengthsExample = new LinkedList<String>(); 
        	maxLengthsExample.add("a"); 
        	maxLengthsExample.add("bb"); 
        	maxLengthsExample.add("c"); 
        	maxLengthsExample.add("dd");
	
		return t.checkExpect(startObject.maxTripleLength(maxLengthsExample), 5);
        }

        // max length occurs with first 3 elements        
        boolean testFirst3Longest(Tester t) {
        	LinkedList<String> maxLengthsExample = new LinkedList<String>(); 
          	maxLengthsExample.add("abc"); // length of 3
        	maxLengthsExample.add("abcd"); // length of 4
        	maxLengthsExample.add("abcde"); // length of 5
        	maxLengthsExample.add("a"); 
        	maxLengthsExample.add("bb"); 
        	maxLengthsExample.add("c"); 
        	maxLengthsExample.add("dd");
	
		return t.checkExpect(startObject.maxTripleLength(maxLengthsExample), 12);
        }
        
        // all strings have the same length        
        boolean testAllSameLength(Tester t) {
        	LinkedList<String> maxLengthsExample = new LinkedList<String>(); 
        	maxLengthsExample.add("aa"); 
        	maxLengthsExample.add("bb"); 
        	maxLengthsExample.add("cd"); 
        	maxLengthsExample.add("dd");
	
		return t.checkExpect(startObject.maxTripleLength(maxLengthsExample), 6);
        }
     
        // one string is very long in the middle, rest are same length (2)           
        boolean testOneVeryLongInMiddle(Tester t) {
        	LinkedList<String> maxLengthsExample = new LinkedList<String>(); 
        	maxLengthsExample.add("aa"); 
        	maxLengthsExample.add("bb");
        	maxLengthsExample.add("abcdefghijklmnopqrstuvwxyz");
        	maxLengthsExample.add("cd"); 
        	maxLengthsExample.add("dd");
	
		return t.checkExpect(startObject.maxTripleLength(maxLengthsExample), 30);
        }
        
}