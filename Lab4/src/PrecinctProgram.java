import java.util.Scanner;

class PrecinctProgram {

	public static void main(String[] args){
		System.out.println("hello, world");
		
		String message = "hello, world";
		System.out.println(message);
		
		int day;
		  day = 18;
		  System.out.println("Today is Wed, Nov " + day + ".");

		  Scanner keyboard = new Scanner(System.in);
		  
		  System.out.print("Enter a name: ");
		  String name = keyboard.nextLine();
		  
		  System.out.print("Enter an address: ");
		  String address = keyboard.nextLine();
		  
		  System.out.print("Enter a population size: ");
		  int population = keyboard.nextInt();
		  
		  Precinct worcester12;
		  worcester12 = new Precinct(name,
		                             address,
		                             population);
		  
		  System.out.println(worcester12);
		  
/*		  int pop = keyboard.nextInt();
		  String preName = keyboard.nextLine();
		  String preAddr = keyboard.nextLine();

		  Precinct worcester13;
		  worcester13 = new Precinct(preName,
				  					preAddr,
				  					pop);
		  
		  System.out.println(worcester13);
*/		  
		  System.out.print("Type a number to add to the population: ");
		 

		  int amount = keyboard.nextInt();
	
		  System.out.println("Updated Population: " +worcester12.grow(amount));

		
	  }
}
