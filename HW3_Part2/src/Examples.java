// Kristen Behrakis

import tester.*;
import java.util.LinkedList;

 class Examples {
	 Examples(){}
	  
	    HeapTester HT = new HeapTester();
	  
	    IHeap leftChild = new DataHeap(15, new DataHeap(30, new MtHeap(), new MtHeap()), new MtHeap());
 	    IHeap rightChild = new DataHeap(20,new MtHeap(), new MtHeap());
 	    IHeap myHeap = new DataHeap(10, leftChild, rightChild);
 	    
 	    IHeap leftChildRemoved = new DataHeap(15, new DataHeap(20, new MtHeap(), new MtHeap()), new MtHeap());
	    IHeap rightChildRemoved = new DataHeap(20,new MtHeap(), new MtHeap());
	    IHeap myHeapRemoved = new DataHeap(20, new MtHeap(), new DataHeap(30, new MtHeap(), new MtHeap()));
 	    
 	    
 	    							// ********** addEltTester **********    
	  // binary tree is a heap and all elements are in common 
	     boolean testAddEltHeapCorrectNodes(Tester t) {
	 	    IBinTree myBinTree = new DataBT(5,myHeap,new MtBT());
	 	    
	      return t.checkExpect(HT.addEltTester(myHeap,5,myBinTree), true);
	    }
	     
		// binary tree is a heap and no original elements are in common 
	     boolean testAddEltHeapIncorrectNodes(Tester t) {
	  	    IHeap rightChildWrongNodes = new DataHeap(12,new MtHeap(), new DataHeap(25, new MtHeap(), new MtHeap()));
	 	    IHeap myHeapDifferentNodesLeft = new DataHeap(8, new MtHeap(), new MtHeap());
	 	    IHeap myHeapDifferentNodesRight = new DataHeap(12, new MtHeap(), rightChildWrongNodes);
	 	    
	 	    IBinTree myBinTree = new DataBT(6, myHeapDifferentNodesLeft, myHeapDifferentNodesRight);
	 	    
	      return t.checkExpect(HT.addEltTester(myHeap,25,myBinTree), false);
	    }
	     
		// binary tree is a heap and some elements are in common (element in deeper levels/subtrees is different)
	     boolean testAddEltHeapSomeIncorrectNodes(Tester t) {
	
	 	    IHeap leftChildWrongNodes = new DataHeap(15, new DataHeap(40, new MtHeap(), new MtHeap()), new MtHeap());
	 	    
	 	    IBinTree myBinTree = new DataBT(10, leftChildWrongNodes, rightChild);
	 	    
	      return t.checkExpect(HT.addEltTester(myHeap,25,myBinTree), false);
	    }
	     
		// binary tree is a heap and some elements are in common (element in first level/first subtrees is different)
	     boolean testAddEltHeapSomeIncorrectNodesFirstLevel(Tester t) {
	    		
		 	    IHeap leftChildWrongNodes = new DataHeap(11, new DataHeap(30, new MtHeap(), new MtHeap()), new MtHeap());
		 	    
		 	    IBinTree myBinTree = new DataBT(10, leftChildWrongNodes, rightChild);
		 	    
		      return t.checkExpect(HT.addEltTester(myHeap,25,myBinTree), false);
		    }
	     
	    // binary tree is not a heap (top element in a tree is not smallest) and all elements are in common
	     boolean testAddEltNotHeapCorrectNodes(Tester t) {
		 	    IBinTree myBinTree = new DataBT(75,myHeap,new MtBT());
		 	    return t.checkExpect(HT.addEltTester(myHeap,75,myBinTree), false);
		    }
	     
	    // binary tree is a not heap (subtrees are not heaps) and only some elements are in common (element in first level/first subtrees is different) 
	     boolean testAddEltNotHeapIncorrectNodes(Tester t) {
	    	IHeap leftChild2 = new DataHeap(30, new DataHeap(15, new MtHeap(), new MtHeap()), new MtHeap());
	  	    IHeap myHeap2 = new DataHeap(10, leftChild2, rightChild);
		    IBinTree myBinTree = new DataBT(5,myHeap2,new MtBT());
		    	
			      return t.checkExpect(HT.addEltTester(myHeap2,5,myBinTree), false);
			    }
	     
	     
	     								// ********** remMinEltTester **********  
	 // binary tree is a heap and all elements are in common 
	     boolean testRemMinEltHeapCorrectNodes(Tester t) {
	 	    IHeap myHeapRemoved = new DataHeap(20, new MtHeap(), new DataHeap(30, new MtHeap(), new MtHeap()));
	 	    IBinTree myBinTree = new DataBT(15,new MtBT(), myHeapRemoved);
	 	    
	      return t.checkExpect(HT.remMinEltTester(myHeap,myBinTree), true);
	    }
	     
	  // binary tree is a heap and no original elements are in common 
	     boolean testRemMinEltHeapIncorrectNodes(Tester t) {

		 	    IBinTree myBinTree = new DataBT(14,new MtBT(), new DataHeap(21, new MtHeap(), new DataHeap(31, new MtHeap(), new MtHeap())));
		 	    
			      return t.checkExpect(HT.remMinEltTester(myHeap,myBinTree), false);
	    }  
	  
	  // binary tree is a heap and some elements are in common (element in deeper levels/subtrees is different)
	     boolean testRemMinEltHeapSomeIncorrectNodes(Tester t) {
	
	    	 IBinTree myBinTree = new DataBT(15,new MtBT(), new DataHeap(20, new MtHeap(), new DataHeap(31, new MtHeap(), new MtHeap())));
		 	    
		      return t.checkExpect(HT.remMinEltTester(myHeap,myBinTree), false);
	    }
	  
	 	// binary tree is a heap and some elements are in common (element in first level/first subtrees is different)
	     boolean testRemMinEltHeapSomeIncorrectNodesFirstLevel(Tester t) {
	    	 IBinTree myBinTree = new DataBT(14,new MtBT(), myHeapRemoved);
		 	    
		      return t.checkExpect(HT.remMinEltTester(myHeap,myBinTree), false);
	     }
	     
		// binary tree is not a heap (top element in a tree is not smallest) and all elements are in common
	     boolean testRemMinEltNotHeapCorrectNodes(Tester t) {
	    	 IBinTree myBinTree = new DataBT(600,new MtBT(), myHeapRemoved);
		 	    
		     return t.checkExpect(HT.remMinEltTester(myHeap,myBinTree), false);
	     }
	     
	  // binary tree is a not heap (subtrees are not heaps) and only some elements are in common
	     boolean testRemMinEltNotHeapIncorrectNodes(Tester t) {
	    	 IHeap myHeapRemoved = new DataHeap(20, new MtHeap(), new DataHeap(19, new MtHeap(), new MtHeap()));
	    	 IBinTree myBinTree = new DataBT(15, new MtBT(), myHeapRemoved);
	
		     return t.checkExpect(HT.remMinEltTester(myHeap,myBinTree), false);
	     }
 }