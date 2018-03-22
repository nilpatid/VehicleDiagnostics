package com.ge.analytic.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "DriverReport")
public class DriverReport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	public String vehicleNumber;
	public String drivingStatus;
	public String notes;
	public Date reportStartDate;
	public Date reportEndDate;
	
	public String getDrivingStatus() {
		return drivingStatus;
	}
	public void setDrivingStatus(String drivingStatus) {
		this.drivingStatus = drivingStatus;
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
	public DriverReport(long id) {
		super();
		this.id = id;
	}
	public DriverReport() {
		// TODO Auto-generated constructor stub
	}
	public DriverReport(String vehicleNumber, String drivingStatus, String notes, Date reportStartDate,
			Date reportEndDate) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.drivingStatus = drivingStatus;
		this.notes = notes;
		this.reportStartDate = reportStartDate;
		this.reportEndDate = reportEndDate;
	}
	@Override
	public String toString() {
		return "DriverReport [vehicleNumber=" + vehicleNumber + ", drivingStatus=" + drivingStatus + ", notes=" + notes
				+ ", reportStartDate=" + reportStartDate + ", reportEndDate=" + reportEndDate + "]";
	}
	
	

	
	
	
}
