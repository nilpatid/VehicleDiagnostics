package com.ge.analytic.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "VehicleReport")
public class VehicleReport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	public String vehicleNumber;
	public String vehicleStatus;
	public String AverageRPM;
	public String AverageFualConsumption;
	public String AverageSpeed;
	public String AverageFuelLevel;
	public String AverageTemp;
	public String notes;
	public Date reportStartDate;
	public Date reportEndDate;
	
	
	public String getVehicleStatus() {
		return vehicleStatus;
	}
	public void setVehicleStatus(String vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}
	public String getAverageRPM() {
		return AverageRPM;
	}
	public void setAverageRPM(String averageRPM) {
		AverageRPM = averageRPM;
	}
	public String getAverageFualConsumption() {
		return AverageFualConsumption;
	}
	public void setAverageFualConsumption(String averageFualConsumption) {
		AverageFualConsumption = averageFualConsumption;
	}
	public String getAverageSpeed() {
		return AverageSpeed;
	}
	public void setAverageSpeed(String averageSpeed) {
		AverageSpeed = averageSpeed;
	}
	public String getAverageFuelLevel() {
		return AverageFuelLevel;
	}
	public void setAverageFuelLevel(String averageFuelLevel) {
		AverageFuelLevel = averageFuelLevel;
	}
	public String getAverageTemp() {
		return AverageTemp;
	}
	public void setAverageTemp(String averageTemp) {
		AverageTemp = averageTemp;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	public Date getReportStartDate() {
		return reportStartDate;
	}
	public void setReportStartDate(Date reportStartDate) {
		this.reportStartDate = reportStartDate;
	}
	public Date getReportEndDate() {
		return reportEndDate;
	}
	public void setReportEndDate(Date reportEndDate) {
		this.reportEndDate = reportEndDate;
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
	public VehicleReport() {
	}
	
	public VehicleReport(long id) {
		super();
		this.id = id;
	}
	@Override
	public String toString() {
		return "VehicleReport [vehicleNumber=" + vehicleNumber + ", vehicleStatus=" + vehicleStatus + ", AverageRPM="
				+ AverageRPM + ", AverageFualConsumption=" + AverageFualConsumption + ", AverageSpeed=" + AverageSpeed
				+ ", AverageFuelLevel=" + AverageFuelLevel + ", AverageTemp=" + AverageTemp + ", notes=" + notes
				+ ", reportStartDate=" + reportStartDate + ", reportEndDate=" + reportEndDate + "]";
	}
	public VehicleReport(String vehicleNumber, String vehicleStatus, String averageRPM, String averageFualConsumption,
			String averageSpeed, String averageFuelLevel, String averageTemp, String notes, Date reportStartDate,
			Date reportEndDate) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.vehicleStatus = vehicleStatus;
		AverageRPM = averageRPM;
		AverageFualConsumption = averageFualConsumption;
		AverageSpeed = averageSpeed;
		AverageFuelLevel = averageFuelLevel;
		AverageTemp = averageTemp;
		this.notes = notes;
		this.reportStartDate = reportStartDate;
		this.reportEndDate = reportEndDate;
	}
	
	
	
	
	
	
	

}
