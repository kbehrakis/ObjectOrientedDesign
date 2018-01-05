class Fish extends AbsAnimal {
    double salinity;
  
    Fish (int length, double salinity) {
      super(length);
      this.salinity = salinity;
    }
  
    public boolean isNormalSize () {
    	 return isLenWithin(3, 15);
    }
    
	// determines if animal is dangerous to people
	public boolean isDangerToPeople () {
		return false;
	}
  }