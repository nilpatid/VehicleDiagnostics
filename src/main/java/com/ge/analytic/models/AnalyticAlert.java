package com.ge.analytic.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Analytic_alert")
public class AnalyticAlert {

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  // An autogenerated id (unique for each user in the db)
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
    
  @NotNull
  private String vehicleNumber;
    
  @NotNull
  private String alertType;
  @NotNull
  private String alertMessage;

  private Date alertDateTime;
  
  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  public AnalyticAlert() { }

  public AnalyticAlert(long id) { 
    this.id = id;
  }
  


  public AnalyticAlert(String vehicleNumber, String alertType, String alertMessage, Date alertDateTime) {
	super();
	this.vehicleNumber = vehicleNumber;
	this.alertType = alertType;
	this.alertMessage = alertMessage;
	this.alertDateTime=alertDateTime;
}

// Getter and setter methods

  public long getId() {
    return id;
  }

  public void setId(long value) {
    this.id = value;
  }

public String getVehicleNumber() {
	return vehicleNumber;
}

public void setVehicleNumber(String vehicleNumber) {
	this.vehicleNumber = vehicleNumber;
}

public String getAlertType() {
	return alertType;
}

public void setAlertType(String alertType) {
	this.alertType = alertType;
}

public String getAlertMessage() {
	return alertMessage;
}

public void setAlertMessage(String alertMessage) {
	this.alertMessage = alertMessage;
}

public Date getAlertDateTime() {
	return alertDateTime;
}

public void setAlertDateTime(Date alertDateTime) {
	this.alertDateTime = alertDateTime;
}

  
} 