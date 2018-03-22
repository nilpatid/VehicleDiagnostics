package com.ge.analytic.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ge.analytic.models.AnalyticAlert;
import com.ge.analytic.models.DriverReport;
import com.ge.analytic.models.VehicleReport;


@Transactional
public interface VehicleReportDao extends CrudRepository<VehicleReport, Long> {

	public List<VehicleReport> findByVehicleNumber (String vehicleNumber);

  
} 
