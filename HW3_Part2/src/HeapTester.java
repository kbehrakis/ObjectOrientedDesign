import java.util.LinkedList;

class HeapTester {

	
	// returns true if the binary tree is a valid result of adding the given integer to the first Heap	
		public Boolean addEltTester(IHeap Horig, int elt, IBinTree Hadded){
			LinkedList<Integer> emptyList = new LinkedList<Integer>(); 
			LinkedList<Integer> emptyList2 = new LinkedList<Integer>(); 
			
			return  Hadded.isHeap() &&
						Hadded.putNodesInSortedList(emptyList).equals((Horig.addElt(elt)).putNodesInSortedList(emptyList2));
		}
	
	// returns true if the binary tree retains all elements that were in the original heap other than removing one occurrence of the smallest element	
		public boolean remMinEltTester(IHeap Horig, IBinTree Hadded) {
			LinkedList<Integer> emptyList = new LinkedList<Integer>(); 
			LinkedList<Integer> emptyList2 = new LinkedList<Integer>(); 
			
				return Hadded.isHeap() 
						&& (Horig.remMinElt().putNodesInSortedList(emptyList).equals(Hadded.putNodesInSortedList(emptyList2)));
			  }
	}