package com.za.tutorial.tsp.ga;

public class City {
	private static final double EARTH_EQUATORIAL_RADIUS = 6378.1370D;
	private static final double CONVERT_DEGREES_TO_RADIANS = Math.PI/180D;
	private static final double CONVERT_KM_TO_MILES = 0.621371;

	private double longitude;
	private double latitude;
	private String name;
	public City(double longitude, double latitude, String name) {
		this.longitude = longitude * CONVERT_DEGREES_TO_RADIANS ;
		this.latitude = latitude * CONVERT_DEGREES_TO_RADIANS;
		this.name = name;
	}
//	public City(String string, double latitude2, double d) {
//		// TODO Auto-generated constructor stub
//	}
	public double getLongitude() {
		return longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return getName();
	}
	public double measureDistance(City city) {
		double deltaLongitude = city.getLongitude() - this.getLongitude();
		double deltaLatitude = city.getLatitude() - this.getLatitude();
		double a = Math.pow(Math.sin(deltaLatitude / 2D), 2D) + Math.cos(getLatitude()) * Math.cos(city.getLatitude()) * Math.pow(Math.sin(deltaLongitude / 2D), 2D);
		return CONVERT_KM_TO_MILES * EARTH_EQUATORIAL_RADIUS * 2D * Math.atan2(Math.sqrt(a), Math.sqrt(1D - a));
	}
	

}
