import java.util.HashMap;
import java.util.LinkedList;

// Class for addition formulas

class Plus implements IFormula {
  private IFormula left;  // first number being added
  private IFormula right; // second number being added
  
  Plus(IFormula left, IFormula right) {
    this.left = left;
    this.right = right;
  }
  
  // does formula reference other cells?
  public boolean noRefs() {
    return this.left.noRefs() && this.right.noRefs();
  }
  
  // compute value of formula
  public int valueOf(HashMap<String, Cell> spread, LinkedList<String> seen) throws CyclicFormulaException, EmptyCellException {

	 if(this.left.noRefs() && this.right.noRefs()){  // if both are of type Num, no cell references
		   return this.left.valueOf() + this.right.valueOf();    
	 }
	 else if (this.left.noRefs()){    // the right is a CellRef, the left is Num
		 return this.right.valueOf(spread, seen) + this.left.valueOf();
	 }
	 else if (this.right.noRefs()){  // left is a CellRef, the right is Num
		 return this.left.valueOf(spread, seen) + this.right.valueOf();    
	 }
	 else {						// both are CellRef
		 return this.left.valueOf(spread, seen) + this.right.valueOf(spread, seen);
	 }
  }
 //add the left and the right to get the value of a sum
public int valueOf() {
	// TODO Auto-generated method stub
	 return this.left.valueOf() + this.right.valueOf();
}

}