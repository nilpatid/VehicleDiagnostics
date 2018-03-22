package com.ge.analytic.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.ge.analytic.models.DriverReport;


@Transactional
public interface DriverReportDao extends CrudRepository<DriverReport, Long> {

	public List<DriverReport> findByVehicleNumber (String vehicleNumber);
} 
