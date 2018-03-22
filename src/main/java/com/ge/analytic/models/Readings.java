package com.ge.analytic.models;
// Generated Nov 22, 2016 8:01:02 AM by Hibernate Tools 5.2.0.Beta1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "readings")
public class Readings{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String vehicleid;
	private Double latitude;
	private Double longitude;
	private String speed;
	private String fuelLevel;
	private String airIntakeTemp;
	private String engineRpm;
	private String fuelConsumptionRate;
	private String engineRuntime;
	
	
	private String ambientAirTemp;
	private String distanceTraveledMilOn;
	private String engineOilTemp;
	private String engineLoad;
	private String controlModuleVoltage;
	private String timingAdvance;
	private String fuelPressure;
	private String throttlePos;
	private String fuelType;
	private String engineCoolantTemp;
	private String airFuelRatio;
	private String barometricPressure;
	private String fuelRailPressure;
	private Date latestTimesTamp;
	
	public Readings() {
		super();
	}

	public Readings(String vehicleid, Double latitude, Double longitude, String speed, String fuelLevel,
			String airIntakeTemp, String engineRpm, String fuelConsumptionRate, String engineRuntime,
			Date latestTimesTamp, String ambientAirTemp, String distanceTraveledMilOn, String engineOilTemp,
			String engineLoad, String controlModuleVoltage, String timingAdvance, String fuelPressure,
			String throttlePos, String fuelType, String engineCoolantTemp, String airFuelRatio,
			String barometricPressure, String fuelRailPressure) {
		super();
		this.vehicleid = vehicleid;
		this.latitude = latitude;
		this.longitude = longitude;
		this.speed = speed;
		this.fuelLevel = fuelLevel;
		this.airIntakeTemp = airIntakeTemp;
		this.engineRpm = engineRpm;
		this.fuelConsumptionRate = fuelConsumptionRate;
		this.engineRuntime = engineRuntime;
		this.latestTimesTamp = latestTimesTamp;
		this.ambientAirTemp = ambientAirTemp;
		this.distanceTraveledMilOn = distanceTraveledMilOn;
		this.engineOilTemp = engineOilTemp;
		this.engineLoad = engineLoad;
		this.controlModuleVoltage = controlModuleVoltage;
		this.timingAdvance = timingAdvance;
		this.fuelPressure = fuelPressure;
		this.throttlePos = throttlePos;
		this.fuelType = fuelType;
		this.engineCoolantTemp = engineCoolantTemp;
		this.airFuelRatio = airFuelRatio;
		this.barometricPressure = barometricPressure;
		this.fuelRailPressure = fuelRailPressure;
	}

	@Override
	public String toString() {
		return "Readings [vehicleid=" + vehicleid + ", latitude=" + latitude + ", longitude=" + longitude + ", speed="
				+ speed + ", fuelLevel=" + fuelLevel + ", airIntakeTemp=" + airIntakeTemp + ", engineRpm=" + engineRpm
				+ ", fuelConsumptionRate=" + fuelConsumptionRate + ", engineRuntime=" + engineRuntime
				+ ", latestTimesTamp=" + latestTimesTamp + ", ambientAirTemp=" + ambientAirTemp
				+ ", distanceTraveledMilOn=" + distanceTraveledMilOn + ", engineOilTemp=" + engineOilTemp
				+ ", engineLoad=" + engineLoad + ", controlModuleVoltage=" + controlModuleVoltage + ", timingAdvance="
				+ timingAdvance + ", fuelPressure=" + fuelPressure + ", throttlePos=" + throttlePos + ", fuelType="
				+ fuelType + ", engineCoolantTemp=" + engineCoolantTemp + ", airFuelRatio=" + airFuelRatio
				+ ", barometricPressure=" + barometricPressure + ", fuelRailPressure=" + fuelRailPressure + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(String vehicleid) {
		this.vehicleid = vehicleid;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getFuelLevel() {
		return fuelLevel;
	}

	public void setFuelLevel(String fuelLevel) {
		this.fuelLevel = fuelLevel;
	}

	public String getAirIntakeTemp() {
		return airIntakeTemp;
	}

	public void setAirIntakeTemp(String airIntakeTemp) {
		this.airIntakeTemp = airIntakeTemp;
	}

	public String getEngineRpm() {
		return engineRpm;
	}

	public void setEngineRpm(String engineRpm) {
		this.engineRpm = engineRpm;
	}

	public String getFuelConsumptionRate() {
		return fuelConsumptionRate;
	}

	public void setFuelConsumptionRate(String fuelConsumptionRate) {
		this.fuelConsumptionRate = fuelConsumptionRate;
	}

	public String getEngineRuntime() {
		return engineRuntime;
	}

	public void setEngineRuntime(String engineRuntime) {
		this.engineRuntime = engineRuntime;
	}

	public Date getLatestTimesTamp() {
		return latestTimesTamp;
	}

	public void setLatestTimesTamp(Date latestTimesTamp) {
		this.latestTimesTamp = latestTimesTamp;
	}

	public String getAmbientAirTemp() {
		return ambientAirTemp;
	}

	public void setAmbientAirTemp(String ambientAirTemp) {
		this.ambientAirTemp = ambientAirTemp;
	}

	public String getDistanceTraveledMilOn() {
		return distanceTraveledMilOn;
	}

	public void setDistanceTraveledMilOn(String distanceTraveledMilOn) {
		this.distanceTraveledMilOn = distanceTraveledMilOn;
	}

	public String getEngineOilTemp() {
		return engineOilTemp;
	}

	public void setEngineOilTemp(String engineOilTemp) {
		this.engineOilTemp = engineOilTemp;
	}

	public String getEngineLoad() {
		return engineLoad;
	}

	public void setEngineLoad(String engineLoad) {
		this.engineLoad = engineLoad;
	}

	public String getControlModuleVoltage() {
		return controlModuleVoltage;
	}

	public void setControlModuleVoltage(String controlModuleVoltage) {
		this.controlModuleVoltage = controlModuleVoltage;
	}

	public String getTimingAdvance() {
		return timingAdvance;
	}

	public void setTimingAdvance(String timingAdvance) {
		this.timingAdvance = timingAdvance;
	}

	public String getFuelPressure() {
		return fuelPressure;
	}

	public void setFuelPressure(String fuelPressure) {
		this.fuelPressure = fuelPressure;
	}

	public String getThrottlePos() {
		return throttlePos;
	}

	public void setThrottlePos(String throttlePos) {
		this.throttlePos = throttlePos;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getEngineCoolantTemp() {
		return engineCoolantTemp;
	}

	public void setEngineCoolantTemp(String engineCoolantTemp) {
		this.engineCoolantTemp = engineCoolantTemp;
	}

	public String getAirFuelRatio() {
		return airFuelRatio;
	}

	public void setAirFuelRatio(String airFuelRatio) {
		this.airFuelRatio = airFuelRatio;
	}

	public String getBarometricPressure() {
		return barometricPressure;
	}

	public void setBarometricPressure(String barometricPressure) {
		this.barometricPressure = barometricPressure;
	}

	public String getFuelRailPressure() {
		return fuelRailPressure;
	}

	public void setFuelRailPressure(String fuelRailPressure) {
		this.fuelRailPressure = fuelRailPressure;
	}


}
