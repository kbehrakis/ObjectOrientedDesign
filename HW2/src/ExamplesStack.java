import tester.*;

class ExamplesStack {
	ExamplesStack() {};
	
	// adding element to an empty list
		  boolean testStackPushNotEmpty(Tester t) {
			  IStack myStack = new Stack().push(5);
			  return t.checkExpect(myStack.isEmpty(), false);
			  }	
		  
	// adding multiple elements then removing them all
		  boolean testStackPushPopAll(Tester t) {
			  IStack myStack = new Stack().push(-5).push(5).push(6).pop().pop().pop();
			  return t.checkExpect(myStack.isEmpty(), true);
			  }	
		  
	// adding multiple elements, removing one, then taking top element
		  boolean testStackPushPopTop(Tester t) {
			  IStack myStack = new Stack().push(7).push(-4).push(5).pop();
			    return (t.checkExpect(myStack.top(), -4));
			  }			
		  
	// adding element then taking top
		  boolean testStackAddTop(Tester t) {
			  IStack myStack = new Stack().push(7);
			  return (t.checkExpect(myStack.top(), 7));
			  }	
		  
   // adding element, taking top, then seeing if it is equal to another stack that underwent same process
		  boolean testStackAddTopEqual(Tester t) {
			  IStack myStack = new Stack().push(7-5);
			  return (t.checkExpect(myStack.top(), new Stack().push(2).top()));
			  }	
		  
  // adding element, removing the element, then checking if it's empty		
		  boolean testStackAddRemoveEmpty(Tester t) {
			  IStack myStack = new Stack().push(7).pop();
			  return (t.checkExpect(myStack.isEmpty(), true));
			  }	
		  	  
    // adding element, removing element, adding element, adding element, taking top, and finally using top to make new stack	  
		  boolean testStartNewStackWithTop (Tester t) {
			  int stackStart = new Stack().push(7).pop().push(8).push(10).top();
			  IStack addToStack = new Stack().push(stackStart).push(2*10);
			  
			  return (t.checkExpect(addToStack.top(), 20));
			  }	
		  	    
}
