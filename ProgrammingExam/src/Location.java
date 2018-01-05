// locations on a campus map based on standard geometric coordinates
class Location {
  int x;
  int y;
  
  Location(int x, int y) {
    this.x = x;
    this.y = y;
  }
  
  
  // Computes the distance between two locations.  Uses Math.pow to square a number
  // and Math.abs to take the absolute value
  double distance(Location l1, Location l2) {
    return Math.sqrt(Math.pow(Math.abs(l1.x - l2.x), 2) + 
                     Math.pow(Math.abs(l1.y - l2.y), 2));
  }
}