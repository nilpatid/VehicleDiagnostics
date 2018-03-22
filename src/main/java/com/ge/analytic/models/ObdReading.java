package com.ge.analytic.models;

import java.util.Map;

public class ObdReading {
    double latitude, longitude, altitude;
    long timestamp;
    String vehicleid; // vehicle id
    Map<String, String> readings;
    String vid;
/*
   public ObdReading() {
       readings = new HashMap<>();
   }

   public ObdReading(double latitude, double longitude, double altitude, long timestamp,
                     String vehicleid, Map<String, String> readings) {
       this.latitude = latitude;
       this.longitude = longitude;
       this.altitude = altitude;
       this.timestamp = timestamp;
       this.vehicleid = vehicleid;
       this.readings = readings;
   }
*/
    
    
   public double getLatitude() {
       return latitude;
   }

   public String getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(String vehicleid) {
		this.vehicleid = vehicleid;
	}

	public void setLatitude(double latitude) {
       this.latitude = latitude;
   }

   public double getAltitude() {
       return altitude;
   }

   public void setAltitude(double altitude) {
       this.altitude = altitude;
   }

   public double getLongitude() {
       return longitude;
   }

   public void setLongitude(double longitude) {
       this.longitude = longitude;
   }

   public long getTimestamp() {
       return timestamp;
   }

   public void setTimestamp(long timestamp) {
       this.timestamp = timestamp;
   }
/*
   public String getVin() {
       return vehicleid;
   }

   public void setVin(String vehicleid) {
       this.vehicleid = vehicleid;
   }
*/
   public Map<String, String> getReadings() {
       return readings;
   }

   public void setReadings(Map<String, String> readings) {
       this.readings = readings;
   }

   public String toString() {

       return "lat:" + latitude + ";" +
               "long:" + longitude + ";" +
               "alt:" + altitude + ";" +
               "vehicleid:" + vehicleid + ";" +
               "readings:" + readings.toString().substring(10).replace("}", "").replace(",", ";");
   }

}
