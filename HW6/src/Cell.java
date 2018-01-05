import java.util.LinkedList;

class Cell {
	private IFormula contents;  // formula that is in each cell
	private LinkedList<Cell> references;  // other cells it references in a formula
	
	Cell(IFormula contents, LinkedList<Cell> cellList){
		this.contents = contents;
		this.references = cellList;
	}

	Cell(IFormula contents){  // does not reference other cells in formula, has a constant instead
		this.contents = contents;
	}


	/******* Getter and Setters for contents *****/
	public void setContents(IFormula newContents){
		contents = newContents;
	}
	
	public IFormula getContents(){
		return contents;
	}
	
	
	/******* Additional Methods *****/
	
// update the value of the cell with the new formula	
	public Cell updateCell(IFormula expr){
		return new Cell(expr, this.references);
		
	}
}
