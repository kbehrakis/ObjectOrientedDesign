// class for a heap with at least one number
class DataHeap {
  int data;
  IHeap left;
  IHeap right;

  int newroot = 0; 
  IHeap ST1 = null;
  IHeap ST2 = null;
  IHeap ST3 = null;
  
  DataHeap(int data, IHeap left, IHeap right) {
   this.data = data;
   this.left = left;
   this.right = right;
  }
  
  IHeap Merge(IHeap H1, IHeap H2){
	if (H1.size() == 0)
		return H2;
	else if(H2.size() == 0)
			return H1;
	
			newroot = min(root((DataHeap)H1), root((DataHeap)H2));
			if (newroot == root((DataHeap)H1))
				ST1 = ((DataHeap)H1).left;
				ST2 = ((DataHeap)H2).right;
				ST3 = H2;
				else 
					ST1 = ((DataHeap)H1).right;
					ST2 = ((DataHeap)H2).left;
					ST3 = H1;
  }
  
public int root(DataHeap h1) {
	if (h1.data < root((DataHeap)h1.left))
			if (h1.data < root((DataHeap)h1.right))
					return data;  // smaller than all elements in left and right
			else return root((DataHeap) h1.right);  // smaller than left, but larger than right, so find smallest on right
	else if (((DataHeap)(h1.left)).data < ((DataHeap)(h1.right)).data)  
		return ((DataHeap)(h1.left)).data; //left root less than right root, so return left root
		else return ((DataHeap)(h1.right)).data; //right root less than left root, so return right root
}

public int min (int root1, int root2){
	if (root1 < root2)
		return root1;
		else return root2;
}

int size(){
	  return 1 + left.size() + right.size();
	  }
  
}

//class for the empty heap
class MtHeap {
MtHeap(){}
}