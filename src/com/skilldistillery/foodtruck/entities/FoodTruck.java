package com.skilldistillery.foodtruck.entities;


public class FoodTruck {
	private String name;
	private String type;
	private double rating;
	private static int truckid = 1;
	private int id;

	
	//Constructors
	public FoodTruck() {
		
	}
	
	public FoodTruck(String name, String type, double rating) {
		this.name = name;
		this.type = type;
		this.rating = rating;
		id = truckid++;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "[FoodTruck name: " + name + ", Type of food: " + type + ", Rating: " + rating + ", Truck ID: " + id + "]";
	}
	
}
