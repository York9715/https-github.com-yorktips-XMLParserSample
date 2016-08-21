package com.york.api.utils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	if ( args.length > 1 ) {
    		for ( int n=0; n < args.length; n++ ) {
    			System.out.println("Your input para(" + n + ")=" + args[n]);    			
    		}
    	}
        System.out.println( "Hello World!" );
    }
    
    public String parse(String jsonLine) {
        //JsonElement jelement = new JsonParser().parse(jsonLine);
        //JsonObject  jobject = jelement.getAsJsonObject();
        //jobject = jobject.getAsJsonObject("data");
        //JsonArray jarray = jobject.getAsJsonArray("translations");
        //jobject = jarray.get(0).getAsJsonObject();
        //String result = jobject.get("translatedText").toString();
        //return result;
    	return "";
    }
    
}
