class Precinct {
	 
	String name;
	String address;
	int population;
		
	 Precinct (String name, String address, int population)
		{
			this.name = name;
			this.address = address;
			this.population = population;
		}
	 
	 public String toString() {
		String output = "Precinct: " + this.name +", Address: " +this.address + ", Population: " +this.population;
		return output;
		 
	 }

	  // Produces precinct with same name and address as this,
	  // but with given amount added to the population
	  public Precinct grow(int amount) {
		return new Precinct (this.name, this.address, this.population + amount);
	  }


}
