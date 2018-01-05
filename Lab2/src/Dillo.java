class Dillo extends AbsAnimal {
  boolean isDead ;
  
  Dillo (int length, boolean isDead) {
    super(length) ;
    this.isDead = isDead ;
  }
  
  // produces a dead Dillo one unit longer than this one
  Dillo hitWithTruck () {
    return new Dillo(this.length + 1 , true) ;
  }

  // determines whether this dillo's length is between 2 and 3
  public boolean isNormalSize () {
    return isLenWithin(2,3);
  }
  
  //determines if animal is dangerous to people
  public boolean isDangerToPeople () {
	  return false;
  }
  
}
