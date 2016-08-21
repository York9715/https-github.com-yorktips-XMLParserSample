package com.york.api.utils;

import java.util.List;

public class PlaceSearchResponse {
	private String status;
	private List<Place> retults;
	private String next_page_token;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Place> getRetults() {
		return retults;
	}
	public void setRetults(List<Place> retults) {
		this.retults = retults;
	}
	public String getNext_page_token() {
		return next_page_token;
	}
	public void setNext_page_token(String next_page_token) {
		this.next_page_token = next_page_token;
	}
	
	
}
