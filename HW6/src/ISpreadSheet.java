import java.util.LinkedList;

interface ISpreadsheet {
  // associates the given cellname with the given formula
  //   such that subsequent references to the cell yield the formula
  void editContents(String cellname, IFormula expr);
  
  // compute the current value of the named cell
  Integer lookupValue(String forcell) throws CyclicFormulaException, EmptyCellException;
}