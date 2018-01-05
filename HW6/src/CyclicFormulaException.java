class CyclicFormulaException extends Exception {
  String cellname;   
  
  CyclicFormulaException (String cellname) {
    this.cellname = cellname;   
  }
}