import tester.*;

class Examples {
  
  Examples(){}
  
  // test that we can add two cell refs
  boolean testSimplePlusCellRefs(Tester t) {
	  try {
	      ISpreadsheet s = new Spreadsheet();
	      s.editContents("a10", new Num(5));
	      s.editContents("b10", new Num(3));
	      s.editContents("c10", new Plus(new CellRef("a10"),
	                                     new CellRef("b10")));
	      
	      return t.checkExpect(s.lookupValue("c10"),
	                           8);
	    } catch (CyclicFormulaException e) {
	      return t.checkExpect(false, true);
	    } catch (EmptyCellException e) {
	      return t.checkExpect(false, true);
	    }
  }
  
  
  // test that we can add two numbers
  boolean testAddTwoNums(Tester t) {
	  try {
	      ISpreadsheet s = new Spreadsheet();

	      s.editContents("c10", new Plus(new Num(5), new Num(25)));
	      
	      return t.checkExpect(s.lookupValue("c10"), 30);
	      
	    } catch (CyclicFormulaException e) {
	      return t.checkExpect(false, true);
	    } catch (EmptyCellException e) {
	      return t.checkExpect(false, true);
	    }
  }
  
  // test that we can add a number and a cell ref
  boolean testNumAndCellRef(Tester t) {
	  try {
	      ISpreadsheet s = new Spreadsheet();
	      s.editContents("a10", new Num(5));
	      s.editContents("c10", new Plus(new CellRef("a10"), new Num(3)));
	      
	      return t.checkExpect(s.lookupValue("c10"),
	                           8);
	    } catch (CyclicFormulaException e) {
	      return t.checkExpect(false, true);
	    } catch (EmptyCellException e) {
	      return t.checkExpect(false, true);
	    }
  }
  
  // test that we can add a number to a cell ref that references another cell
  boolean testCellRefWithinCellRef(Tester t) {
	  try {
	      ISpreadsheet s = new Spreadsheet();
	      s.editContents("a10", new CellRef("b10"));
	      s.editContents("b10", new Num(50));
	      s.editContents("c10", new Plus(new CellRef("a10"), new Num(3)));
	      
	      return t.checkExpect(s.lookupValue("c10"),
	                           53);
	    } catch (CyclicFormulaException e) {
	      return t.checkExpect(false, true);
	    } catch (EmptyCellException e) {
	      return t.checkExpect(false, true);
	    }
  } 

  
//test that we can add a cell ref to a cell ref that references another cell
 boolean testCellRefWithinCellRefAddCellRefs(Tester t) {
	  try {
	      ISpreadsheet s = new Spreadsheet();
	      s.editContents("a10", new CellRef("b10"));
	      s.editContents("b10", new Num(50));
	      s.editContents("c10", new Plus(new CellRef("a10"), new CellRef("a10")));
	      
	      return t.checkExpect(s.lookupValue("c10"), 100);
	      
	    } catch (CyclicFormulaException e) {
	      return t.checkExpect(false, true);
	    } catch (EmptyCellException e) {
	      return t.checkExpect(false, true);
	    }
 } 
  
//test that we can add a plus in a plus (and add two pluses)
boolean testPlusInPlus(Tester t) {
	  try {
	      ISpreadsheet s = new Spreadsheet();
	      s.editContents("a10", new CellRef("b10"));
	      s.editContents("a9", new Num(12));
	      s.editContents("b10", new Num(50));
	      s.editContents("c10", new Plus(new Plus(new Num(40), new CellRef("b10")), new Plus(new Num(10), new CellRef("a9"))));
	      
	      return t.checkExpect(s.lookupValue("c10"), 112);
	      
	    } catch (CyclicFormulaException e) {
	      return t.checkExpect(false, true);
	    } catch (EmptyCellException e) {
	      return t.checkExpect(false, true);
	    }
} 
 
//test just a num
boolean testNum(Tester t) {
	  try {
	      ISpreadsheet s = new Spreadsheet();
	     
	      s.editContents("c10", new Num(4));
	      
	      return t.checkExpect(s.lookupValue("c10"), 4);
	      
	    } catch (CyclicFormulaException e) {
	      return t.checkExpect(false, true);
	    } catch (EmptyCellException e) {
	      return t.checkExpect(false, true);
	    }
} 

  
  // test that cell refs grab current value of cells
  boolean testUpdateCellRefs(Tester t) {
	  try {
	      ISpreadsheet s = new Spreadsheet();
	      s.editContents("a10", new Num(5));
	      s.editContents("b10", new Num(3));
	      s.editContents("c10", new Plus(new CellRef("a10"),
	                                     new CellRef("b10")));
	      s.editContents("a10", new Num(9));
	      return t.checkExpect(s.lookupValue("c10"),
	                           12);
	    } catch (CyclicFormulaException e) {
	      return t.checkExpect(false, true);
	    } catch (EmptyCellException e) {
	      return t.checkExpect(false, true);
	    }
  }
  
  // test that cell refs grab current value of cells and that it can return a single cell ref (no addition involved) 
  boolean testUpdateCellRefsNoPlus(Tester t) {
    try{
    	ISpreadsheet s = new Spreadsheet();

    s.editContents("a10", new Num(5));
    s.editContents("b10", new Num(3));
    s.editContents("c10", new CellRef("a10"));
    s.editContents("a10", new Num(9));
    
    return t.checkExpect(s.lookupValue("c10"),
                         9);
  } catch (CyclicFormulaException e) {
      return t.checkExpect(false, true);
    } catch (EmptyCellException e) {
      return t.checkExpect(false, true);
    }
  }
  
  
// test for adding two nums (no cell reference)
 boolean testNoCellRefAddition(Tester t) {
   try{
   	ISpreadsheet s = new Spreadsheet();

   s.editContents("a10", new Num(5));
   s.editContents("b10", new Num(3));
   s.editContents("c10", new Plus(new Num(10), new Num(10)));
   s.editContents("a10", new Num(9));
   
   return t.checkExpect(s.lookupValue("c10"), 20);
   
 } catch (CyclicFormulaException e) {
     return t.checkExpect(false, true);
   } catch (EmptyCellException e) {
     return t.checkExpect(false, true);
   }
 }
 
 
 								/****** CHECK CYCLIC EXCEPTIONS *****/
//test embedded cyclic cells
boolean testCyclicEmbedded(Tester t) {
	 	ISpreadsheet s = new Spreadsheet();
	
	      s.editContents("a10", new Num(5));
	      s.editContents("b10", new Num(4));
	      s.editContents("c10", new Plus(new CellRef("a10"),
	                                     new CellRef("c10")));

	 return t.checkException(new CyclicFormulaException("c10"), s, "lookupValue", "c10");
}
 
//test cell references itself right away
boolean testCyclicFirstCell(Tester t) {
	 	ISpreadsheet s = new Spreadsheet();
	
	      s.editContents("c10", new CellRef("c10"));

	      return t.checkException(new CyclicFormulaException("c10"), s, "lookupValue", "c10");
}


   // test a simple cycle
  boolean testCycle(Tester t) {
    ISpreadsheet s = new Spreadsheet();
    s.editContents("a10", new CellRef("a10"));
    return t.checkException(new CyclicFormulaException("a10"), s, "lookupValue", "a10");
  }  
  
  // test a bigger cycle
 boolean testBigCycle(Tester t) {
   ISpreadsheet s = new Spreadsheet();
   s.editContents("a10", new CellRef("b10"));
   s.editContents("b10", new CellRef("c10"));
   s.editContents("c10", new CellRef("d10"));
   s.editContents("d10", new CellRef("e10"));
   s.editContents("e10", new CellRef("a10"));
   
   
   return t.checkException(new CyclicFormulaException("a10"), s, "lookupValue", "a10");
 }  
 
 // test two loops
 boolean testTwoLoops(Tester t) {
   ISpreadsheet s = new Spreadsheet();
   s.editContents("a10", new CellRef("b10"));
   s.editContents("b10", new CellRef("a10"));
   s.editContents("c10", new CellRef("d10"));
   s.editContents("d10", new CellRef("e10"));
   s.editContents("e10", new Plus(new CellRef("a10"), new CellRef("c10")));
   return t.checkException(new CyclicFormulaException("a10"), s, "lookupValue", "a10");
 }  

  								/****** CHECK EMPTYCELL EXCEPTIONS *****/
  // test not in spreadsheet (first reference)
 boolean testNotInSpreadsheet(Tester t) {
   ISpreadsheet s = new Spreadsheet();
   s.editContents("a10", new CellRef("b10"));
   return t.checkException(new EmptyCellException("b10"), s, "lookupValue", "c10");
 }  
  
 // test not in spreadsheet, with a reference
boolean testReferenceNotInSpreadsheet(Tester t) {
  ISpreadsheet s = new Spreadsheet();
  s.editContents("a10", new Num(5));
  s.editContents("b10", new Num(3));
  s.editContents("c10", new Plus(new CellRef("a10"),
                                 new CellRef("d10")));
  
  return t.checkException(new EmptyCellException("d10"), s, "lookupValue", "c10");
}  
}