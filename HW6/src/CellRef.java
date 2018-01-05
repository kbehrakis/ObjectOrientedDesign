import java.util.HashMap;
import java.util.LinkedList;

// class for capturing references to cells in formulas

class CellRef implements IFormula {
  private String cellname; 
  
  CellRef(String cellname) {
    this.cellname = cellname;
  }
  
  // does formula reference other cells?
  public boolean noRefs() {
    return false;
  }
  
  // compute value of formula
  public int valueOf(HashMap<String, Cell> spread, LinkedList<String> seen) throws CyclicFormulaException, EmptyCellException{
	  
		  if(spread.containsKey((this.cellname)))     // if the spreadsheet contains a key with the referenced cell
		  {
			  if(seen.contains(cellname)){			 // if it's cyclic
				  throw new CyclicFormulaException(cellname);
			  }
			  return spread.get(this.cellname).getContents().valueOf(spread,seen); // gets the value at the given key and returns it 
		  }
		  else {    // spreadsheet does not contain the key with the referenced cell
			  throw new EmptyCellException(cellname);
		  }
  }

// should never reach this code
public int valueOf() {
	throw new RuntimeException();   
}
  
}
