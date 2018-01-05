import tester.*;

class ExamplesPQ {
	ExamplesPQ() {};
	
// adding element to an empty list
	  boolean testPQPushNotEmpty(Tester t) {
		  IPriorityQueue myPriorityQueue = new PriorityQueue().addElt(5);
		  return t.checkExpect(myPriorityQueue.isEmpty(), false);
		  }	
	  
// adding multiple elements then removing them all by taking out the smallest elements
	  boolean testPQAddRemAll(Tester t) {
		  IPriorityQueue myPriorityQueue = new PriorityQueue().addElt(5).addElt(5).addElt(6).remMinElt().remMinElt().remMinElt();
		  return t.checkExpect(myPriorityQueue.isEmpty(), false);
		  }	
	  
// adding multiple elements, removing minimum, then getting smallest element left
	  boolean testPQAddRemoveGet(Tester t) {
		  IPriorityQueue myPriorityQueue = new PriorityQueue().addElt(7).addElt(4).addElt(5).remMinElt();
		  return t.checkExpect(myPriorityQueue.getMinElt(), 5);
		  }			
	  
// adding element then taking smallest element
	  boolean testPQAddSmallest(Tester t) {
		  IPriorityQueue myPriorityQueue = new PriorityQueue().addElt(7);
		  return t.checkExpect(myPriorityQueue.getMinElt(), 7);
		  }	
	  
// testing with adding/removing the same element 
	  boolean testPQSameNumbers(Tester t) {
		  IPriorityQueue myPriorityQueue = new PriorityQueue().addElt(6).addElt(8).addElt(8).addElt(8).remMinElt().remMinElt();
		  return t.checkExpect(myPriorityQueue.getMinElt(), 8);
			  }		

// adding an element that is negative
	  boolean testPQNegativeNumbers(Tester t) {
		  IPriorityQueue myPriorityQueue = new PriorityQueue().addElt(-1).addElt(10).addElt(4).remMinElt();
		  return t.checkExpect(myPriorityQueue.getMinElt(), 4);
			  }		

// doing operations inside of addElt
	  boolean testPQInnerOperations(Tester t) {
		  int pqStart = new PriorityQueue().addElt(7).remMinElt().addElt(8).addElt(10).getMinElt(); // 8
		  IPriorityQueue addToQueue = new PriorityQueue().addElt(-2*pqStart).addElt(10);
		  
		  return t.checkExpect(addToQueue.getMinElt(), -16);
			  }	  
	  
}