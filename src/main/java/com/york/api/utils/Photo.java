package com.york.api.utils;

public class Photo {
	private String photoReference;
	private int width;
	private int height;
	private String htmlAttribution;

	public Photo() {
	}	
	
	public Photo(String photoReference, int width, int height,
			String htmlAttribution) {
		super();
		this.photoReference = photoReference;
		this.width = width;
		this.height = height;
		this.htmlAttribution = htmlAttribution;
	}
	
	public String getPhotoReference() {
		return photoReference;
	}
	public void setPhotoReference(String photoReference) {
		this.photoReference = photoReference;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getHtmlAttribution() {
		return htmlAttribution;
	}
	public void setHtmlAttribution(String htmlAttribution) {
		this.htmlAttribution = htmlAttribution;
	}
		
}
