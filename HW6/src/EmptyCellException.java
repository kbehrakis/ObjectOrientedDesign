// exception to throw if try to reference an empty cell

class EmptyCellException extends Exception {
  String cellname;   
  
  EmptyCellException (String name) {
    this.cellname = name;
  }
}