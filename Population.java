package com.za.tutorial.tsp.ga;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Population {

	private ArrayList<Route> routes = new ArrayList<Route>(GA.POPULATION_SIZE);
	
	public Population(int populationSize, GA ga) {
		IntStream.range(0, populationSize).forEach(x -> routes.add(new Route(ga.getInitialRoute())));	
	}
	public Population(int populationSize, ArrayList<City> cities) {
		IntStream.range(0, populationSize).forEach(x -> routes.add(new Route(cities)));
	}
	public ArrayList<Route> getRoutes(){
		return routes;
	}
	public void sortRoutesByFitness() {
		routes.sort((route1, route2) -> {
			int flag = 0;
			if (route1.getFitness() > route2.getFitness()) flag = -1;
			else if (route1.getFitness() < route2.getFitness()) flag = 1;
			return flag;
		});
	}
}
