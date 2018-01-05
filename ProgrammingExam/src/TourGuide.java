import java.util.LinkedList;

// This is the main Campus Tour application class.  It holds
//   the methods for analyzing tours
class TourGuide {
  
  // Uncomment and complete next line as part of question 3c
   LinkedList<PlacesToVisit> enhancedTour = new LinkedList<PlacesToVisit>();
  
  // constructor
  TourGuide(){}

  // what percentage of tour stops were requested?
  double percentRequested(LinkedList<Building> tour,
                          LinkedList<String> targetNames) {

	  double numBuildingsShared = 0;
	  double totalBuildingsOnTour = tour.size();
	  
	  // for every building in the tour
	  for(Building b : tour){
		  if(targetNames.contains(b.name)){
			  numBuildingsShared++;     // add one if they building in the tour is in the list of building names
		  }
	  }
	  
	  double decimalVal = numBuildingsShared/totalBuildingsOnTour;
	  
      return decimalVal;
  }
 
}
