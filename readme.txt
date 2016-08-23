1. use DOM/DOM4J/XPATH to parser google place API xml file

2. https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=43.767461,-79.41243&radius=1500&key=AIzaSyCc_txmCyClsXAQNGVTXG-rnGVVZecs254

3. Package com.york.api.utils are created manually. Package com.york.api.data are created by "google_places_api.xsd"
   use "google_places_api.xsd" to create Data classes:
        "new" -> "JAXB" -> "JAXB classes from schema" 
         will create all com.york.api.data 
     