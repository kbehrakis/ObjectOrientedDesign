import java.util.HashMap;
import java.util.LinkedList;

// class for simple formulas consisting of just a single number

class Num implements IFormula {
  private int value;
  
  Num(int value) {
    this.value = value;
  }
  
  // does formula reference other cells?
  public boolean noRefs() {
    return true;
  }
  
  // compute value of formula
  public int valueOf() {
    return this.value;
  }
  
 // base case, when it's within a CellRef
public int valueOf(HashMap<String, Cell> aSpreadsheet, LinkedList<String> seen) throws CyclicFormulaException {
	// TODO Auto-generated method stub
	 return this.value;
}

}