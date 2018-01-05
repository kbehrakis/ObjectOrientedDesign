import tester.*;

class Examples {
	Examples () {} ;
	
	Shark TrueShark = new Shark(100,4);
	Shark FalseShark = new Shark(4,0);
	Shark NiceShark = new Shark(40,0);
	Shark MeanShark = new Shark(40,100);
	
	Fish NewFish = new Fish(10, 0.4);
	Fish HugeFish = new Fish(100, 5.57);
	
	Dillo NewDillo = new Dillo(40, false);
	
	Boa NiceBoa = new Boa("Jim", 50, "pancakes");
	Boa MeanBoa = new Boa("Richard", 50, "people");
	
	 boolean testNewFish(Tester t) {
	      return t.checkExpect(NewFish.isNormalSize(),
	                           true) ;
	    }
	 
	 boolean testHugeFish(Tester t) {
	      return t.checkExpect(HugeFish.isNormalSize(),
	                           false) ;
	    }
	 
	 boolean testTrueShark(Tester t) {
	      return t.checkExpect(TrueShark.isNormalSize(),
	                           true) ;
	    }
	 
	 boolean testFalseShark(Tester t) {
	      return t.checkExpect(FalseShark.isNormalSize(),
	                           false) ;
	    }
	 
	 boolean testNiceShark(Tester t) {
	      return t.checkExpect(NiceShark.isDangerToPeople(),
	                           false) ;
	    }
	 
	 boolean testMeanShark(Tester t) {
	      return t.checkExpect(MeanShark.isDangerToPeople(),
	                           true) ;
	    }
	 
	 boolean testFish(Tester t) {
	      return t.checkExpect(NewFish.isDangerToPeople(),
	                           false) ;
	    }
	 
	 boolean testDillo(Tester t) {
	      return t.checkExpect(NewDillo.isDangerToPeople(),
	                           false) ;
	    }
	 
	 boolean testNiceBoa(Tester t) {
	      return t.checkExpect(NiceBoa.isDangerToPeople(),
	                           false) ;
	    }
	 
	 boolean testMeanBoa(Tester t) {
	      return t.checkExpect(MeanBoa.isDangerToPeople(),
	                           true) ;
	    }
}