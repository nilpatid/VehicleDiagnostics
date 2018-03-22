package com.ge.analytic.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ge.analytic.dao.ReadingsDao;
import com.ge.analytic.models.Dashboard;
import com.ge.analytic.models.Location;
import com.ge.analytic.models.ObdReading;
import com.ge.analytic.models.Readings;
import com.ge.analytic.models.VLocation;

import ch.qos.logback.core.pattern.color.RedCompositeConverter;

@RestController
public class VehicleReading {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	ReadingsDao readingsDao;

	@CrossOrigin
	@RequestMapping(value = "/readings/{vid}", method = RequestMethod.GET)
	public Map<String, Readings> getObdReading(@PathVariable("vid") String vid) {


		Map<String, Readings> mapRet = new HashMap<String, Readings>();
		Readings readings=readingsDao.getmaxdaterecord(vid);
		Readings readings1=new Readings();
		readings1.setAirFuelRatio((readings.getAirFuelRatio()==null) ? "" : readings.getAirFuelRatio().replaceAll("[^\\d.]", ""));
		readings1.setAirIntakeTemp((readings.getAirIntakeTemp()==null) ? "" : readings.getAirIntakeTemp().replaceAll("[^\\d.]", ""));
		readings1.setAmbientAirTemp((readings.getAmbientAirTemp()==null) ? "" : readings.getAmbientAirTemp().replaceAll("[^\\d.]", ""));
		readings1.setBarometricPressure((readings.getBarometricPressure()==null) ? "" : readings.getBarometricPressure().replaceAll("[^\\d.]", ""));
		readings1.setControlModuleVoltage((readings.getControlModuleVoltage()==null) ? "" : readings.getControlModuleVoltage().replaceAll("[^\\d.]", ""));
		readings1.setDistanceTraveledMilOn((readings.getDistanceTraveledMilOn()==null) ? "" : readings.getDistanceTraveledMilOn().replaceAll("[^\\d.]", ""));
		readings1.setEngineCoolantTemp((readings.getEngineCoolantTemp()==null) ? "" : readings.getEngineCoolantTemp().replaceAll("[^\\d.]", ""));
		readings1.setEngineLoad((readings.getEngineLoad()==null) ? "" : readings.getEngineLoad().replaceAll("[^\\d.]", ""));
		readings1.setEngineOilTemp((readings.getEngineOilTemp()==null) ? "" : readings.getEngineOilTemp().replaceAll("[^\\d.]", ""));
		readings1.setEngineRpm((readings.getEngineRpm()==null) ? "" : readings.getEngineRpm().replaceAll("[^\\d.]", ""));
		readings1.setEngineRuntime((readings.getEngineRuntime()==null) ? "" : readings.getEngineRuntime().replaceAll("[^\\d.]", ""));
		readings1.setFuelConsumptionRate((readings.getFuelConsumptionRate()==null) ? "" : readings.getFuelConsumptionRate().replaceAll("[^\\d.]", ""));
		readings1.setFuelLevel((readings.getFuelLevel()==null) ? "" : readings.getFuelLevel().replaceAll("[^\\d.]", ""));
		readings1.setFuelPressure((readings.getFuelPressure()==null) ? "" : readings.getFuelPressure().replaceAll("[^\\d.]", ""));
		readings1.setFuelRailPressure((readings.getFuelRailPressure()==null) ? "" : readings.getFuelRailPressure().replaceAll("[^\\d.]", ""));
		readings1.setFuelType((readings.getFuelType()==null) ? "" : readings.getFuelType().replaceAll("[^\\d.]", ""));
		readings1.setId(readings.getId());
		readings1.setLatestTimesTamp(readings.getLatestTimesTamp());
		readings1.setLatitude(readings.getLatitude());
		readings1.setLongitude(readings.getLongitude());
		readings1.setSpeed((readings.getSpeed()==null) ? "" : readings.getSpeed().replaceAll("[^\\d.]", ""));
		readings1.setThrottlePos((readings.getThrottlePos()==null) ? "" : readings.getThrottlePos().replaceAll("[^\\d.]", ""));
		readings1.setTimingAdvance((readings.getTimingAdvance()==null) ? "" : readings.getTimingAdvance().replaceAll("[^\\d.]", ""));
		readings1.setVehicleid(readings.getVehicleid());
		mapRet.put("readings", readings1);
		return mapRet;
	}

	@CrossOrigin
	@RequestMapping(value = "/readings/save", method = RequestMethod.POST)
	public ResponseEntity<Void> saveObdReading(@RequestBody ObdReading obdReading, UriComponentsBuilder ucBuilder) {

		System.out.println("Got vehicle: " + obdReading);
		System.out.println("Got vehicle: " + obdReading.getReadings().toString());

		Readings readings=
				new Readings(obdReading.getVehicleid(), obdReading.getLatitude(), obdReading.getLongitude(),
						obdReading.getReadings().get("SPEED"), obdReading.getReadings().get("FUEL_LEVEL"),
						obdReading.getReadings().get("AIR_INTAKE_TEMP"), obdReading.getReadings().get("ENGINE_RPM"),
						obdReading.getReadings().get("FUEL_CONSUMPTION_RATE"), obdReading.getReadings().get("ENGINE_RUNTIME"),
						getCurrentDate(), obdReading.getReadings().get("AMBIENT_AIR_TEMP"), obdReading.getReadings().get("DISTANCE_TRAVELED_MIL_ON"),
						obdReading.getReadings().get("ENGINE_OIL_TEMP"), obdReading.getReadings().get("ENGINE_LOAD"),
						obdReading.getReadings().get("CONTROL_MODULE_VOLTAGE"), obdReading.getReadings().get("TIMING_ADVANCE"),
						obdReading.getReadings().get("FUEL_PRESSURE"),obdReading.getReadings().get("THROTTLE_POS"),
						obdReading.getReadings().get("FUEL_TYPE"), obdReading.getReadings().get("ENGINE_COOLANT_TEMP"),
						obdReading.getReadings().get("AIR_FUEL_RATIO"), obdReading.getReadings().get("BAROMETRIC_PRESSURE"), obdReading.getReadings().get("FUEL_RAIL_PRESSURE"));
/*		String query = "insert into public.readings(vehicleid,latitude,longitude,latesttimestamp,speed,fuel_level,air_intake_temp,engine_rpm,fuel_consumption_rate,engine_runtime) values(?,?,?,?,?,?,?,?,?,?)";

		int res = jdbcTemplate.update(query, obdReading.getVehicleid(), obdReading.getLatitude(),
				obdReading.getLongitude(), getCurrentDate(), obdReading.getReadings().get("SPEED"),
				obdReading.getReadings().get("FUEL_LEVEL"), obdReading.getReadings().get("AIR_INTAKE_TEMP"),
				obdReading.getReadings().get("ENGINE_RPM"), obdReading.getReadings().get("FUEL_CONSUMPTION_RATE"),
				obdReading.getReadings().get("ENGINE_RUNTIME"));


		System.out.println("Record inserted: " + res);*/
		readingsDao.save(readings);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/readings").buildAndExpand(obdReading.getVehicleid()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}

	@CrossOrigin
	@RequestMapping(value = "/getObdDash", method = RequestMethod.GET)
	public List<Dashboard> getObdDash() {

		String query = "SELECT a.id, a.vehicle_number, a.vehicle_name ,(SELECT count(vehicle_number) FROM analytic_alert b WHERE a.vehicle_number = b.vehicle_number) as level FROM vehicle_master a";

		List<Dashboard> map = (List<Dashboard>) jdbcTemplate.query(query, new ResultSetExtractor<List<Dashboard>>() {

			@Override
			public List<Dashboard> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Dashboard> mapRet = new ArrayList<Dashboard>();
				while (rs.next()) {
					Dashboard loc = new Dashboard();
					loc.setId(rs.getLong("id"));
					loc.setVid(rs.getString("vehicle_number"));
					loc.setVlevel(rs.getString("level"));
					loc.setVname(rs.getString("vehicle_name"));
					mapRet.add(loc);
				}
				return mapRet;
			}
		});
		return map;
	}

	private static java.sql.Timestamp getCurrentDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
	}

	@CrossOrigin
	@RequestMapping(value = "/readings", method = RequestMethod.POST)
	public List<Readings> getObdDashLatLong(@RequestBody List<VLocation> vLocations) {
		List<Readings> list=new ArrayList<Readings>();
		for(VLocation location:vLocations){
			Readings readings=readingsDao.getmaxdaterecord(location.getVid());
			Readings readings1=new Readings();
			readings1.setAirFuelRatio((readings.getAirFuelRatio()==null) ? "" : readings.getAirFuelRatio().replaceAll("[^\\d.]", ""));
			readings1.setAirIntakeTemp((readings.getAirIntakeTemp()==null) ? "" : readings.getAirIntakeTemp().replaceAll("[^\\d.]", ""));
			readings1.setAmbientAirTemp((readings.getAmbientAirTemp()==null) ? "" : readings.getAmbientAirTemp().replaceAll("[^\\d.]", ""));
			readings1.setBarometricPressure((readings.getBarometricPressure()==null) ? "" : readings.getBarometricPressure().replaceAll("[^\\d.]", ""));
			readings1.setControlModuleVoltage((readings.getControlModuleVoltage()==null) ? "" : readings.getControlModuleVoltage().replaceAll("[^\\d.]", ""));
			readings1.setDistanceTraveledMilOn((readings.getDistanceTraveledMilOn()==null) ? "" : readings.getDistanceTraveledMilOn().replaceAll("[^\\d.]", ""));
			readings1.setEngineCoolantTemp((readings.getEngineCoolantTemp()==null) ? "" : readings.getEngineCoolantTemp().replaceAll("[^\\d.]", ""));
			readings1.setEngineLoad((readings.getEngineLoad()==null) ? "" : readings.getEngineLoad().replaceAll("[^\\d.]", ""));
			readings1.setEngineOilTemp((readings.getEngineOilTemp()==null) ? "" : readings.getEngineOilTemp().replaceAll("[^\\d.]", ""));
			readings1.setEngineRpm((readings.getEngineRpm()==null) ? "" : readings.getEngineRpm().replaceAll("[^\\d.]", ""));
			readings1.setEngineRuntime((readings.getEngineRuntime()==null) ? "" : readings.getEngineRuntime().replaceAll("[^\\d.]", ""));
			readings1.setFuelConsumptionRate((readings.getFuelConsumptionRate()==null) ? "" : readings.getFuelConsumptionRate().replaceAll("[^\\d.]", ""));
			readings1.setFuelLevel((readings.getFuelLevel()==null) ? "" : readings.getFuelLevel().replaceAll("[^\\d.]", ""));
			readings1.setFuelPressure((readings.getFuelPressure()==null) ? "" : readings.getFuelPressure().replaceAll("[^\\d.]", ""));
			readings1.setFuelRailPressure((readings.getFuelRailPressure()==null) ? "" : readings.getFuelRailPressure().replaceAll("[^\\d.]", ""));
			readings1.setFuelType((readings.getFuelType()==null) ? "" : readings.getFuelType().replaceAll("[^\\d.]", ""));
			readings1.setId(readings.getId());
			readings1.setLatestTimesTamp(readings.getLatestTimesTamp());
			readings1.setLatitude(readings.getLatitude());
			readings1.setLongitude(readings.getLongitude());
			readings1.setSpeed((readings.getSpeed()==null) ? "" : readings.getSpeed().replaceAll("[^\\d.]", ""));
			readings1.setThrottlePos((readings.getThrottlePos()==null) ? "" : readings.getThrottlePos().replaceAll("[^\\d.]", ""));
			readings1.setTimingAdvance((readings.getTimingAdvance()==null) ? "" : readings.getTimingAdvance().replaceAll("[^\\d.]", ""));
			readings1.setVehicleid(readings.getVehicleid());
			list.add(readings1);
			
		}
		
		return list;
	}
}
