import java.lang.Math;
import java.util.LinkedList;
import java.util.List;

interface IBinTree {

// determines whether element is in the tree
 boolean hasElt(int e);
 // returns number of nodes in the tree; counts duplicate elements as separate items
 int size();
 // returns depth of longest branch in the tree
 int height();
 
boolean isHeap();
List putNodesInSortedList(LinkedList<Integer> StartingHeapList);
boolean isMt();
boolean isSmallestElement();

 
}