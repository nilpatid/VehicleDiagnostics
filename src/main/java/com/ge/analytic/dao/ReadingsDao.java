package com.ge.analytic.dao;


import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ge.analytic.models.Readings;

@Transactional
public interface ReadingsDao extends CrudRepository<Readings, Long> {

	public List<Readings> findByVehicleidAndLatestTimesTampBetween (String vehicleid, Date startDate, Date EndDate);
	
	@Query("SELECT DISTINCT vehicleid FROM Readings")
	List<String> findDistinctVehicleId();
	
	
	@Query(value = "select * from public.readings r where r.vehicleid = :vid and r.latest_times_tamp = (select max(latest_times_tamp) from public.readings sr where sr.vehicleid=r.vehicleid)", nativeQuery = true)
	Readings getmaxdaterecord(@Param("vid")String vehicleId);

	
}
