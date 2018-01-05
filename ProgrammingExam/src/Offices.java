import java.util.LinkedList;

class Offices implements PlacesToVisit{
	  Building buildingName;
	  String nameOfOccupant;
	  Date whenOpened;
	  String neatFact; // will be empty string if nothing interesting about building
	  LinkedList<Building> nextTo; // adjacent buildings
	  
	  Offices(Building buildingName, String nameOfOccupant, Date whenOpened, String neatFact, LinkedList<Building> nextTo) {
		this.buildingName = buildingName;
		this.nameOfOccupant = nameOfOccupant;
		this.whenOpened = whenOpened;
		this.neatFact = neatFact;
		this.nextTo = nextTo;
		
	  }
}
