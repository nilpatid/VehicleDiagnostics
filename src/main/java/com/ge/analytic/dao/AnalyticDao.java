package com.ge.analytic.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ge.analytic.models.AnalyticAlert;


@Transactional
public interface AnalyticDao extends CrudRepository<AnalyticAlert, Long> {

  public List<AnalyticAlert> findByVehicleNumberAndAlertDateTimeBetween(String vehicleNumber,Date startDate, Date EndDate);
  
  @Query(value = "SELECT DISTINCT ON (a.alert_type) * FROM public.analytic_alert a INNER JOIN public.analytic_alert b ON a.id=b.id where a.vehicle_number=:vehicleNo and (a.alert_date_time between :startDate and :endDate) ORDER BY a.alert_type, b.alert_date_time DESC", nativeQuery = true)
  public List<AnalyticAlert> findByVehicleNumberCoustom(@Param("vehicleNo") String vehicleNumber, @Param("startDate") Date startDate, @Param("endDate")Date EndDate);
 
} 
