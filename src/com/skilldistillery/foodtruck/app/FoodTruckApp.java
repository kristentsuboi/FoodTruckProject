package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {
	private final int MAXID = 5;
	private FoodTruck[] fleet = new FoodTruck[MAXID];
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		FoodTruckApp fta = new FoodTruckApp();
		fta.run();
	}

	public void run() {
		FoodTruck ft = new FoodTruck();
		System.out.println("Welcome to the Food Truck Application!");
		for (int i = 0; i < 6; i++) {

			System.out.println("Please enter the Food Truck's name OR quit to exit input: ");
			String name = sc.nextLine();
			if (name.equals("quit")) {
				printMenu();
				break;
			} else {
				System.out.println("Please enter the Food Truck's type: ");
				String type = sc.nextLine();
				System.out.println("Please enter your rating for this Food Truck (1-5): ");
				double rating = sc.nextDouble();
				sc.nextLine(); 
				FoodTruck newft = new FoodTruck(name, type, rating);
				fleet[i] = newft;
			}
		}
	}

	public void printMenu() {
		int option = 0;
		while (option != 4) {
			System.out.println("*** MENU ***");
			System.out.println("1. List all existing food trucks.");
			System.out.println("2. See the average rating of food trucks.");
			System.out.println("3. Display the highest-rated food truck.");
			System.out.println("4. Quit the program.");
			System.out.println("Please select from option 1-4: ");
			option = sc.nextInt();
			if (option == 1) {
				for (int i = 0; i < fleet.length; i++) {
					if (fleet[i] != null) {
						System.out.println("\n" + fleet[i].toString() + "\n");
					}
					continue;
				}
			} else if (option == 2) {
				getAverage();
				System.out.println();
				continue;
			} else if (option == 3) {
				getHighest();
				continue;
			} else if (option == 4) {
				System.out.println("You are exiting the program. Goodbye!");
				break;
			} else {
				System.out.println("***PLEASE ENTER A VALID RESPONSE: \n ");
			}
		}
	}

	public void getAverage() {
		int i = 0;
		double sum = 0.0;
		for (FoodTruck newft : fleet) {
			if (newft != null) {
				i += 1;
				sum += newft.getRating();
			}
		}
		System.out.println("The average food truck rating is: " + sum / i);
	}

	public void getHighest() {
		FoodTruck max = new FoodTruck();
		for (FoodTruck newft : fleet) {
			if (newft != null) {
				if (newft.getRating() > max.getRating()) {
					max = newft;
				}
			}
		}
		System.out.println("\n The highest rated FoodTruck:\n" + max.toString() + "\n");
	}

}
