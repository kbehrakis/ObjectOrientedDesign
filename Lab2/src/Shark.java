class Shark extends Fish{
    int attacks;
  
    Shark (int length, int attacks) {
      super(length, 3.75);
      this.salinity = 3.75;
      this.attacks = attacks;
    }
    
    public boolean isNormalSize () {
   	 return isLenWithin(6, this.length);  // put in this.length because that will always return true (<=)
   }
    
 // determines if animal is dangerous to people
	public boolean isDangerToPeople () {
		return (0 < attacks);
	}
}