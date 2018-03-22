package com.ge.analytic.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
public class VehicleMaster {

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
  private String vehicleName;
  @NotNull
  private String TankCapacity;
  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  public VehicleMaster() { }

  public VehicleMaster(long id) { 
    this.id = id;
  }

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getVehicleNumber() {
	return vehicleNumber;
}

public void setVehicleNumber(String vehicleNumber) {
	this.vehicleNumber = vehicleNumber;
}

public String getVehicleName() {
	return vehicleName;
}

public void setVehicleName(String vehicleName) {
	this.vehicleName = vehicleName;
}

public String getTankCapacity() {
	return TankCapacity;
}

public void setTankCapacity(String tankCapacity) {
	TankCapacity = tankCapacity;
}
  


 
// Getter and setter methods

  
  
} 