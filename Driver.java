package com.za.tutorial.tsp.ga;

import java.util.ArrayList;
import java.util.Arrays;

public class Driver {
	public ArrayList<City> initialRoute = new ArrayList<City>(Arrays.asList(
			new City(-71.0589, 42.3601, "Boston"),
			new City(-95.3698, 29.7604, "Houston"),
			new City(-97.7431, 30.2672, "Austin"),
			new City(-122.4194, 37.7749, "San francisco"),
			new City(-104.9903, 39.7392, "Denver"),
			new City(-118.2437, 34.0522, "Los Angeles"),
			new City(-87.6298, 41.8781, "Chicago"),
			new City(-74.0059, 40.7128, "New York"),
			new City(-96.7970, 32.7767, "Dallas"),
			new City(-122.3321, 47.6062, "Seattle")
			));
	public static void main(String[] args) {
		Driver driver = new Driver();
		Population population = new Population(GA.POPULATION_SIZE, driver.initialRoute);
		population.sortRoutesByFitness();
		int generationNumber = 0;
		driver.printHeading(generationNumber++);
		driver.printPopulation(population);
	}
	public void printPopulation(Population population) {
		population.getRoutes().forEach(x ->{
			System.out.println(Arrays.toString(x.getCities().toArray()) + " | "+
					String.format("%.4f", x.getFitness()) +" | "+ String.format("%.2f", x.calculateTotalDistance()));
		});
		System.out.println("");
	}
	public void printHeading(int generationNumber) {
		System.out.println("> Generation # " + generationNumber);
		String headingColumn1 = "Route";
		String remainingHeadingColumns = "Fitness   | Distance (in mailes)";
		int cityNamesLength = 0;
		for (int x=0; x < initialRoute.size(); x++) cityNamesLength += initialRoute.get(x).getName().length();
		int arrayLength = cityNamesLength + initialRoute.size()*2;
		int partialLength = (arrayLength - headingColumn1.length())/2;
		for(int x=0; x<partialLength; x++)System.out.println(" ");
		System.out.println(headingColumn1);
		for(int x=0; x<partialLength; x++)System.out.println(" ");
		if((arrayLength %2)== 0)System.out.println(" ");
		System.out.println(" | "+ remainingHeadingColumns);
		cityNamesLength += remainingHeadingColumns.length() + 3;
		for(int x=0; x< cityNamesLength + initialRoute.size()*2; x++)System.out.println("-");
		System.out.println("");
	}

}
