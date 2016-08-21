package com.york.app;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.york.api.utils.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class DOMParserDemo {
	
		private	static final String USER_AGENT = "Mozilla/5.0";
	
		public static void main(String[] args) throws Exception {
			//String ret=sendGet("json");
			//System.out.println(ret);
			testParser();
		}
		
	// HTTP GET request
	public static  String sendGet(String type) {
		String url = "http://www.google.com/search?q=mkyong";
		url = "https://maps.googleapis.com/maps/api/place/nearbysearch/" + type + "?location=43.767461,-79.41243&radius=1500&key=AIzaSyCc_txmCyClsXAQNGVTXG-rnGVVZecs254";
		String ret="";
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			// add request header
			con.setRequestProperty("User-Agent", USER_AGENT);

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			ret= response.toString();
			
		} catch (Exception e) {

		}
		
		return ret;
	}
		
	public static void testParser() throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    PlaceSearchResponse placeSearchResponse = new PlaceSearchResponse();
	    
	    //1. Use file
	    String file="C:\\york\\1.Projects\\47. GooglePlacesApi\\xml_result.xml";
	    File f = new File(file);
	    Document document = builder.parse(f);
	    
	    //2. use String
	    //String xml=sendGet("xml");//"json"
	    //InputSource is = new InputSource(new StringReader(xml));
	    //Document document = builder.parse(is);
	    
	    //Iterating through the nodes and extracting the data.
	    NodeList nodeList = document.getDocumentElement().getChildNodes();
	    List<Place> results= new ArrayList<Place>();
	    for (int i = 0; i < nodeList.getLength(); i++) {
	    	
	      //We have encountered an <employee> tag.
	      Node node = nodeList.item(i);
	      String name=node.getNodeName();
	      
	      
	      if (node instanceof Element) {
	    	  System.out.println(node.getNodeName());	      
	    	  
	    	  if (name.equalsIgnoreCase("status")) {
	    		  placeSearchResponse.setStatus(node.getLastChild().getTextContent().trim());
	    	  }
	    	  
	    	  if (name.equalsIgnoreCase("next_page_token")) 
	    		  placeSearchResponse.setNext_page_token(node.getLastChild().getTextContent().trim());
	    	  node.getLastChild().getTextContent().trim();
	    	  
	    	  if (name.equalsIgnoreCase("result")) {
	    		  Place place= new Place();
	    	  
	    		  NodeList nodeList2 = node.getChildNodes();
	    		  for (int i2 = 0; i2 < nodeList2.getLength(); i2++) {
	    			  Node node2 = nodeList2.item(i2);
	    			  List<String> types = new ArrayList<String>();
	    			  if (node2 instanceof Element) {
	    				  String name2=node2.getNodeName();
	    				  if (name2.equalsIgnoreCase("name")) place.setName(node2.getLastChild().getTextContent().trim());
	    				  if (name2.equalsIgnoreCase("vicinity")) place.setVicinity(node2.getLastChild().getTextContent().trim());
	    				  
	    				  if (name2.equalsIgnoreCase("type")) {
	    					  types.add(node2.getLastChild().getTextContent().trim());
	    				  }
	    				  
	    				  if (name2.equalsIgnoreCase("geometry")) {
	    					  Geometry geometry = new Geometry();	    					  
	    					  NodeList nodeList3 = node2.getChildNodes();
	    					  for (int i3 = 0; i3 < nodeList3.getLength(); i3++) {
	    						  Node node3 = nodeList3.item(i3);
	    						  String name3=node3.getNodeName();
	    						  if (name3.equalsIgnoreCase("location")) {
	    							  Location location= new Location();
	    							  NodeList nodeList4 = node3.getChildNodes();
	    							  
	    							  for (int i4 = 0; i4 < nodeList4.getLength(); i4++) {
	    								  Node node4 = nodeList4.item(i4);
	    								  String name4=node4.getNodeName();
	    								  if (name4.equalsIgnoreCase("lat")) {
	    									  String sLat=node4.getLastChild().getTextContent().trim();
	    									  location.setLat(Double.parseDouble(sLat));
	    								  }
	    								  if (name4.equalsIgnoreCase("lng")) {
	    									  String sLng=node4.getLastChild().getTextContent().trim();
	    									  location.setLng(Double.parseDouble(sLng));
	    									  System.out.println("lat=" + location.getLat() + ",lng=" + location.getLng());
	    								  }
	    							  }
	    							  geometry.setLocation(location);
	    						  }
	    						  place.setGeometry(geometry);
	    					  }
	    					 
	    				  }

	    				  if (name2.equalsIgnoreCase("icon")) place.setIcon(node2.getLastChild().getTextContent().trim());
	    				  if (name2.equalsIgnoreCase("reference")) place.setReference(node2.getLastChild().getTextContent().trim());
	    				  if (name2.equalsIgnoreCase("id")) place.setId(node2.getLastChild().getTextContent().trim());
	    				  //if (name2.equalsIgnoreCase("opening_hours")) place.setOpeningHours(node2.getLastChild().getTextContent().trim());
	    				  if (name2.equalsIgnoreCase("photo")) place.setId(node2.getLastChild().getTextContent().trim());
	    				  if (name2.equalsIgnoreCase("place_id")) place.setPlace_id(node2.getLastChild().getTextContent().trim());
	    				  if (name2.equalsIgnoreCase("scope")) place.setPlace_id(node2.getLastChild().getTextContent().trim());
	    				  
	    			  }
	    		  }
	    		  results.add(place);
	    	  }
	      } 	 
	    }	    
	    placeSearchResponse.setRetults(results);
	    System.out.println("end");
	  }
	 
}
