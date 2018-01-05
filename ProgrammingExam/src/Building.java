import java.util.LinkedList;
import java.lang.Math;

class Building implements PlacesToVisit{ 
  Location where;  // location on the campus map
  String name;
  Date whenOpened;
  String neatFact; // will be empty string if nothing interesting about building
  LinkedList<Building> nextTo; // adjacent buildings
  
  Building(Location where, String name, Date opened, String fact) {
    this.where= where;  // location on the campus map
    this.name = name;
    this.whenOpened = opened;
    this.neatFact = fact;
    this.nextTo = new LinkedList<Building>();
  }

  // check whether distance to building b1 within given distance
  boolean distanceWithin(Building b1, double dist) {
	  return (where.distance(this.where, b1.where) <= dist);
	  
 //   originally: return (distance(this.where, b1.where) <= dist);
  }
}
