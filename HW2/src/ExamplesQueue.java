import tester.*;

class ExamplesQueue {
	ExamplesQueue () {};
	
	// adding element to an empty list
	  boolean testQueueEnqueueNotEmpty(Tester t) {
		  IQueue myQueue = new Queue().enqueue(5);
		  return t.checkExpect(myQueue.isEmpty(), false);
		  }	
	
	// adding multiple elements then removing them all
	  boolean testQueueEnqueueHasNoElements(Tester t) {
		    IQueue myQueue = new Queue().enqueue(5).enqueue(8).enqueue(10).dequeue().dequeue().dequeue();
		    return (t.checkExpect(myQueue.isEmpty(), true));
		  }	
	  
	// adding multiple elements, removing one, then taking front
	  boolean testQueueEnqueueHasTwoElements(Tester t) {
		    IQueue myQueue = new Queue().enqueue(7).enqueue(4).enqueue(5).dequeue();
		    return (t.checkExpect(myQueue.front(), 4));
		  }	
	  
	// adding element then taking front
	  boolean testQueueEnqueueAddFront(Tester t) {
		    IQueue myQueue = new Queue().enqueue(-7*-1);
		    return (t.checkExpect(myQueue.front(), 7));
		  }	
	  
	// adding element, taking front, then seeing if it is equal to another queue that underwent same process
	  boolean testQueueEnqueueAddFrontEqualQueue(Tester t) {
		    IQueue myQueue = new Queue().enqueue(7);
		    return (t.checkExpect(myQueue.front(), new Queue().enqueue(7).front()));
		  }	
	  
	 // adding element, removing the element, then checking if it's empty
	  boolean testQueueEnqueueAddRemove(Tester t) {
		    IQueue myQueue = new Queue().enqueue(-7).dequeue();
		    return (t.checkExpect(myQueue.isEmpty(), true));
		  }	
	  
	// adding element, removing element, adding element, adding element, taking front, and finally using front to make new stack
	  boolean testQueueAddRemoveAddFront(Tester t) {
		    int myQueue = new Queue().enqueue(7).dequeue().enqueue(10).enqueue(11).front();
		    IQueue myNewQueue = new Queue().enqueue(myQueue).enqueue(16);
		    		
		    return (t.checkExpect(myNewQueue.front(), myQueue));
		  }	


}
