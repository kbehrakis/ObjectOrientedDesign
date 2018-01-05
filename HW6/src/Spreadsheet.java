import java.util.HashMap;
import java.util.LinkedList;

class Spreadsheet implements ISpreadsheet {
  Spreadsheet(){}
  
  private HashMap<String, Cell> aCell = new HashMap<String,Cell>();  // String holds the position, i.e "a10"

  
  // associates the given cellname with the given formula
  //   such that subsequent references to the cell yield the formula
  public void editContents(String cellname, IFormula expr) {
		
		if(aCell.keySet().contains(cellname))  // if one of the keys matches the given cellname or if the spreadsheet doesn't have any elements
		{
			aCell.put(cellname, aCell.get(cellname).updateCell(expr));  // if cell has existing values
		}
	
		else {
			aCell.put(cellname, new Cell(expr, new LinkedList<Cell>()));  // if there isn't such cell already in the spreadsheet
		}
  }
  
  
  // compute the current value of the named cell
  public Integer lookupValue(String forcell) throws EmptyCellException, CyclicFormulaException {
	  LinkedList<String> seen = new LinkedList<String>();
	  seen.add(forcell);
	  
	  if (aCell.keySet().contains(forcell)){  // if the cell is in the spreadsheet
		  
		  if (aCell.get(forcell).getContents() != null) {  // if the cell has a formula (the content is not null) 
				  return aCell.get(forcell).getContents().valueOf(aCell, seen);
			  
		  }
		  else { 
			  throw new EmptyCellException(forcell);  // there is not value associated with the given cell (no formula) 
		  }    
	  }			
	  else throw new EmptyCellException(forcell);  // the cell is not in the spreadsheet
  }

}