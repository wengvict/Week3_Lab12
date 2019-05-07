import java.util.ArrayList;
import java.util.Scanner;

public class CarApp {

	public static void main(String[] args) {
		int numCars;
		String make = "", model = "";
		int year = 0;
		double price = 0;
		int userNum = 0;
		String userConfirm = "";

		Scanner scan = new Scanner(System.in);
		ArrayList<Car> cars = new ArrayList<>();

		System.out.println("Welcome to the Grand Circus Motors admin console!");
		System.out.print("How many cars are you entering? ");
		numCars = scan.nextInt();

		for (int i = 0; i < numCars; i++) {
			System.out.print("Enter Car #" + (i + 1) + " Make: ");
			make = scan.next();
			scan.nextLine();
			System.out.print("Enter Car #" + (i + 1) + " Model: ");
			model = scan.nextLine();
			System.out.print("Enter Car #" + (i + 1) + " Year: ");
			year = scan.nextInt();
			System.out.print("Enter Car #" + (i + 1) + " Price: ");
			price = scan.nextDouble();
			scan.nextLine();
			cars.add(new Car(make, model, year, price));
		}

		System.out.println("Current Inventory: ");
		
		// loops through arraylist to print cars entered
		for (int i = 0; i < numCars; i++) {
			System.out.println(cars.get(i));
		}

		System.out.println("\n");
		
		// *********Part 2*******************
		
		// hard-coded car list
		ArrayList<Car> carsForSale = new ArrayList<>();

		carsForSale.add(new Car("Nikolai", "Model S", 2017, 54999.90));
		carsForSale.add(new Car("Fourd", "Escapade", 2017, 31999.90));
		carsForSale.add(new Car("Chewie", "Vette", 2017, 44989.95));
		carsForSale.add(new UsedCar("Hyonda", "Prior", 2015, 14795.50, 35987.6));
		carsForSale.add(new UsedCar("GC", "Chirpus", 2013, 8500, 12345));
		carsForSale.add(new UsedCar("GC", "Witherell", 2016, 14450, 3500.3));
		
		// prevents negative input with while loop jump starting menu
		while (userNum >= 0) {
			
			// i numbers the menu options
			int i = 0;
			for (Car c : carsForSale) {
				if (c instanceof Car) {
					System.out.print((i + 1) + ". ");
					System.out.print(carsForSale.get(i) + "\n");
				
				// used car class below, part of for each loop
				} else if (c instanceof UsedCar) {
					System.out.print((i + 1) + ". ");
					System.out.print(carsForSale.get(i) + "\n");
				} else {
					break;
				}
				i++;	// continues looping to continue numbering
			}
			// added quit option that's not a part of arraylist
			System.out.print((i + 1) + ". " + "Quit" + "\n");

			System.out.print("\n" + "Which car would you like? ");
			userNum = scan.nextInt() - 1;
			
			// allows user to quit
			if(userNum >= carsForSale.size()) {
				System.out.println("Have a great day!");
				break;
			}
			
			// takes user menu option number
			System.out.println(carsForSale.get(userNum));
			// garbage line
			scan.nextLine();
			
			// confirmation on buying car
			System.out.print("Would you like to buy this car? (y/n) ");
			userConfirm = scan.next();
			
			// confirm car purchase w/ user validation
			if (userConfirm.toLowerCase().contains("y")) {
				carsForSale.remove(userNum);
				System.out.println("Excellent! Our finance department will be in touch shortly." + "\n");
			}

		}
		scan.close();
	}
}
