package com.ge.analytic.logic;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ge.analytic.dao.AnalyticDao;
import com.ge.analytic.dao.DriverReportDao;
import com.ge.analytic.dao.ReadingsDao;
import com.ge.analytic.dao.VehicleReportDao;
import com.ge.analytic.models.AnalyticAlert;
import com.ge.analytic.models.DriverReport;
import com.ge.analytic.models.Readings;
import com.ge.analytic.models.VehicleReport;
import com.ge.analytic.util.VdsAnalyticUtil;

@Component
public class VdsAlertCheckServise {
	@Autowired
	private ReadingsDao readingsDao;
	@Autowired
	private AnalyticDao analyticDao;
	@Autowired
	private VdsAnalyticPerform perform;
	@Autowired
	private DriverReportDao driverReportDao;
	@Autowired
	private VehicleReportDao vehicleReportDao;
	
	public List<AnalyticAlert> getAlerts(String vehicleNo) {
		return analyticDao.findByVehicleNumberCoustom(vehicleNo, VdsAnalyticUtil.getCurrentDateMinus15(),
				VdsAnalyticUtil.getCurrentDate());
	}

	public void delete() {
		analyticDao.deleteAll();
	}

	

	public boolean checkAlerts() throws ParseException {
		String result = "false";
		List<Readings> readings;

		Timestamp currenttime = VdsAnalyticUtil.getCurrentDate();
		Timestamp currenttimeMinus15 = VdsAnalyticUtil.getCurrentDateMinus15();

		//System.out.println("Start Date -------------------> " + currenttimeMinus15);
		//System.out.println("End Date -------------------> " + currenttime);

		List<String> vehileId = readingsDao.findDistinctVehicleId();
		String mode="alert";
		for (String id : vehileId) {
			//System.out.println("vehicle -------------------> " + id);
			readings = readingsDao.findByVehicleidAndLatestTimesTampBetween(id, currenttimeMinus15, currenttime);
			if (readings.size() > 0) {
				result = perform.getFualAnlytic(readings,mode);
				result = perform.getHeatAnlytic(readings,mode);
				result = perform.getSpeedAnlytic(readings,mode);
			} else {
				System.out.println("No Data for Vehicle Id [" + id + "] in last 15 min ");
			}
		}

		return Boolean.parseBoolean(result);
	}

	
	public boolean checkReports() {
		List<Readings> readings;
		boolean result = false;
		
		Timestamp endDate = VdsAnalyticUtil.getCurrentDate();
		Timestamp startDate = VdsAnalyticUtil.getCurrentDateCoustom(30);
		String mode="report";
		System.out.println("Start Date -------------------> " + startDate);
		System.out.println("End Date -------------------> " + endDate);

		List<String> vehileId = readingsDao.findDistinctVehicleId();
		for (String id : vehileId) {
			System.out.println("vehicle -------------------> " + id);
			readings = readingsDao.findByVehicleidAndLatestTimesTampBetween(id, startDate, endDate);
			if (readings.size() > 0) {
				VehicleReport vehicleReport = new VehicleReport();
				vehicleReport.setAverageFuelLevel(perform.getFualAnlytic(readings,mode));
				vehicleReport.setAverageTemp(perform.getHeatAnlytic(readings,mode));
				vehicleReport.setAverageSpeed(perform.getSpeedAnlytic(readings,mode));
				vehicleReport.setAverageFualConsumption(perform.getFualConsumption(readings,mode));
				vehicleReport.setAverageRPM(perform.getRPM(readings,mode));
				String vehicleStatus="Good";
				vehicleReport.setVehicleStatus(vehicleStatus);
				String notes="Vehicle is good";
				vehicleReport.setNotes(notes);
				vehicleReport.setReportStartDate(startDate);
				vehicleReport.setReportEndDate(endDate);
				vehicleReport.setVehicleNumber(id);
				vehicleReportDao.save(vehicleReport);
				
				DriverReport driverReport = new DriverReport();
				driverReport.setVehicleNumber(id);
				driverReport.setReportStartDate(startDate);
				driverReport.setReportEndDate(endDate);
				String drivingStatus="Good";
				driverReport.setDrivingStatus(drivingStatus);
				notes="Driver is good";
				driverReport.setNotes(notes);
				driverReportDao.save(driverReport);
				result=true;
			} else {
				System.out.println("No Data for Vehicle Id [" + id + "] in last 15 min ");
			}
		}

		return result;
	}

	public List<String> getReports(String vehicleNo) {
		List<String> reports= new ArrayList<String> ();

		reports.add(vehicleReportDao.findByVehicleNumber(vehicleNo).get(0).toString());		
		reports.add(driverReportDao.findByVehicleNumber(vehicleNo).get(0).toString());
		return reports;
	}
	  
}
