import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class DataBT implements IBinTree {
 int data;
 IBinTree left;
 IBinTree right;

 DataBT(int data, IBinTree left, IBinTree right) {
  this.data = data;
  this.left = left;
  this.right = right;
 }		
 
 // an alternate constructor for when both subtrees are empty
 DataBT(int data) {
   this.data = data;
   this.left = new MtBT();
   this.right = new MtBT();
 }

 // determines whether this node or node in subtree has given element
 public boolean hasElt(int e) {
  return this.data == e || this.left.hasElt(e) || this.right.hasElt(e) ;
 }

 // adds 1 to the number of nodes in the left and right subtrees
 public int size() {
  return 1 + this.left.size() + this.right.size();
 }

 // adds 1 to the height of the taller subtree
 public int height() {
  return 1 + Math.max(this.left.height(), this.right.height());
 }

 // returns true if tree is a heap (smallest element on top, left and right subtrees both heaps)
 public boolean isHeap() {
	 if(this.size()==0)
		 return true;
	 else return (this.right.isHeap()  // check if left and right subtrees are also heaps
				  && this.left.isHeap() 
	 			  && isSmallestElement());
		}
 
 // helper function to check if smallest element is on top of given tree
 public boolean isSmallestElement() {
	  if(this.size() == 1)  			// only has one node, children are empty 
		   return true;
	  else if (this.left.isMt())  		// only the left node is empty, the right has data
		  return (((DataHeap) right).isBigger(this.data));
	  else if (this.right.isMt()) 		// only the right node is empty, the left has data
		  return (((DataHeap) left).isBigger(this.data));
	  else   							// both left and right have data 
		  return (((DataHeap) right).isBigger(this.data)) && (((DataHeap) left).isBigger(this.data));
}

 // helped function to put all nodes of the given tree into a list and sort them based on size
public List<Integer> putNodesInSortedList(LinkedList<Integer> StartingHeapList) {
	
	LinkedList<Integer> emptyList = new LinkedList<Integer>(); 

	if (this.left.isMt() && (this.right.isMt())) 
		{StartingHeapList.add(this.data);        // both children empty, return list with only this.data
		}

	else if(this.left.isMt())    			    // only left is empty, recursively add nodes in right child
		{StartingHeapList.add(this.data);
		LinkedList<Integer> emptyList2 = new LinkedList<Integer>(); 
		StartingHeapList.addAll(this.right.putNodesInSortedList(emptyList2));
		}

	else if(this.right.isMt())                  // only right is empty, recursively add nodes in left child
		{
		StartingHeapList.add(this.data); 
		LinkedList<Integer> emptyList3 = new LinkedList<Integer>(); 
		StartingHeapList.addAll(this.left.putNodesInSortedList(emptyList3));
		}
	else                                        // both children are not empty, recursively add nodes from both children
		{
		StartingHeapList.add(this.data);
		LinkedList<Integer> emptyList4 = new LinkedList<Integer>(); 
		LinkedList<Integer> emptyList5 = new LinkedList<Integer>(); 
		StartingHeapList.addAll(this.left.putNodesInSortedList(emptyList4)); // 15, 30
		StartingHeapList.addAll(this.right.putNodesInSortedList(emptyList5)); // 20
		}
		
	Collections.sort(StartingHeapList);
	return StartingHeapList;
 }
 
// produces true if tree is empty
 public boolean isMt(){
	 return (this.size() == 0);
 }
}