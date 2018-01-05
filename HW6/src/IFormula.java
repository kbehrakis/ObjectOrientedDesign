import java.util.HashMap;
import java.util.LinkedList;

// The interface for formulas
  
interface IFormula {

// does formula reference other cells?
  boolean noRefs();
  
  // compute value of formula, used for Num
  int valueOf();

  
  // compute value of formula, used for formulas
 int valueOf(HashMap<String, Cell> aSpreadsheet, LinkedList<String> seen) throws CyclicFormulaException, EmptyCellException;
}
