import java.util.LinkedList;
import java.util.List;

class MtBT implements IBinTree {
 MtBT(){}

 // returns false since empty tree has no elements
 public boolean hasElt(int e) {
  return false;
 }

 // returns 0 since empty tree has no elements
 public int size() {
  return 0;
 }

 // returns 0 since empty tree has no branches
 public int height() {
  return 0;
 }
 
 // returns true since an empty tree is still a tree
 public boolean isHeap() {
	 return true; 
 }
 
// returns null since empty tree will not have any nodes 
public List putNodesInSortedList(LinkedList<Integer> StartingHeapList) {
	return null;
}

// if it's empty, it is Mt 
public boolean isMt() {
	return true;
}

// no element, it cannot be the smallest
public boolean isSmallestElement() {
	return false;
}
}
