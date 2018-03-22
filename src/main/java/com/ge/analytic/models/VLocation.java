package com.ge.analytic.models;

import java.util.Date;

public class VLocation {
	
	double lat, longi;
    String vid;
    
    
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLongi() {
		return longi;
	}
	public void setLongi(double longi) {
		this.longi = longi;
	}
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}
	public VLocation() {
		super();
	}
    
    
}
