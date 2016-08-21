package com.york.api.utils;

public class Location {
	private double lat;
	private double lng;

	public Location() {
		this.lat = 0;
		this.lng = 0;		
	}
	
	public Location(double lat, double lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}
	
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}	
	
}
