package com.ge.analytic.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ge.analytic.dao.AnalyticDao;
import com.ge.analytic.dao.ReadingsDao;
import com.ge.analytic.models.AnalyticAlert;
import com.ge.analytic.models.Readings;
import com.ge.analytic.util.VdsAnalyticUtil;

@Component
public class VdsAnalyticPerform {
	@Autowired
	private AnalyticDao analyticDao;
	
	private int heatThreshold=25;
	private int speedThreshold=15;
	private int fualLevelThreshold=90;
	private int rPMThreshold=2000;
	private int fualConsmpThreshold=25;
	
	private static int minute=2;
	
	public String getFualAnlytic(List<Readings> readings, String mode) {
		double fualLevel = 0;
		double flevel = 0;
		int counter = 0;
		String avgFualLevel="";
		System.out.println("------------------> getFualAnlytic size of record " + readings.size());
		for (Readings reading : readings) {
			if (reading.getFuelLevel() != null) {
				String level = reading.getFuelLevel().replaceAll("[^\\d.]", "");
				if (!level.equalsIgnoreCase("")) {
					// flevel=Integer.parseInt(level);
					flevel = Double.parseDouble(level);
					counter++;
				}
				fualLevel = fualLevel + flevel;

			}

		}
		if (counter > 0 && mode.equalsIgnoreCase("alert")) {
			if ((fualLevel / counter) < fualLevelThreshold) {
				String alertMessage = "Your Vehicle has Low fual ["+fualLevelThreshold +" %]: " + fualLevel / counter + "%";
				analyticDao.save(new AnalyticAlert(readings.get(0).getVehicleid(), "fuel", alertMessage,
						VdsAnalyticUtil.getCurrentDate()));
				avgFualLevel="true";
			}
		}
		if (counter > 0 && mode.equalsIgnoreCase("report")) {
			avgFualLevel = fualLevel / counter + "%";
		}
		System.out.println(fualLevel);
		System.out.println(counter);
		return avgFualLevel;
	}

	public String getHeatAnlytic(List<Readings> readings, String mode) {
		double heatLevel = 0;
		double hlevel = 0;
		int counter = 0;
		String avgHeat="";
		System.out.println("------------------>getHeatAnlytic size of record " + readings.size());
		for (Readings reading : readings) {
			if (reading.getAirIntakeTemp() != null) {
				String level = reading.getAirIntakeTemp().replaceAll("[^\\d.]", "");
				if (!level.equalsIgnoreCase("")) {
					// flevel=Integer.parseInt(level);
					hlevel = Double.parseDouble(level);
					counter++;
				}
				heatLevel = heatLevel + hlevel;
			}
		}
		if (counter > 0 && mode.equalsIgnoreCase("alert")) {
			if ((heatLevel / counter) > heatThreshold) {
				String alertMessage = "Your Vehicle is over Heating["+heatThreshold+" C], Vehicle is Heating on average TEMP: "
						+ heatLevel / counter + "C from last "+minute+" Minute";
				analyticDao.save(new AnalyticAlert(readings.get(0).getVehicleid(), "heat", alertMessage,
						VdsAnalyticUtil.getCurrentDate()));
				avgHeat="true";
			}
		}
		if (counter > 0 && mode.equalsIgnoreCase("report")) {
			avgHeat = heatLevel / counter + "C";
		}
		System.out.println(heatLevel);
		System.out.println(counter);
		return avgHeat;
	}

	public String getSpeedAnlytic(List<Readings> readings, String mode) {
		int speedLevel = 0;
		int slevel = 0;
		int counter = 0;
		String avgSpeed="";
		System.out.println("------------------>getSpeedAnlytic size of record " + readings.size());
		for (Readings reading : readings) {
			if (reading.getSpeed() != null) {
				String level = reading.getSpeed().replaceAll("[^\\d.]", "");
				if (!level.equalsIgnoreCase("")) {
					slevel = Integer.parseInt(level);
					counter++;
				}
				speedLevel = speedLevel + slevel;

			}
		}
		if (counter > 0 && mode.equalsIgnoreCase("alert")) {
			if ((speedLevel / counter) > speedThreshold) {
				String alertMessage = "Your Vehicle is over speeding ["+speedThreshold+" km/h], Vehicle is running on average Speed : "
						+ speedLevel / counter + "km/h from last "+minute+" Minute";
				analyticDao.save(new AnalyticAlert(readings.get(0).getVehicleid(), "speed", alertMessage,
						VdsAnalyticUtil.getCurrentDate()));
				avgSpeed="true";
			}
		}
		if (counter > 0 && mode.equalsIgnoreCase("report")) {
			avgSpeed = speedLevel / counter + "km/h";
		}
		System.out.println(speedLevel);
		System.out.println(counter);
		return avgSpeed;
	}

	


	public String getFualConsumption(List<Readings> readings, String mode) {
		int fualConsumption = 0;
		int fclevel = 0;
		int counter = 0;
		String avgfclevel="";
		System.out.println("------------------>getFualConsumption size of record " + readings.size());
		for (Readings reading : readings) {
			if (reading.getSpeed() != null) {
				String level = reading.getFuelConsumptionRate().replaceAll("[^\\d.]", "");
				if (!level.equalsIgnoreCase("")) {
					fclevel = Integer.parseInt(level);
					counter++;
				}
				fualConsumption  = fualConsumption + fclevel;

			}
		}
		if (counter > 0 && mode.equalsIgnoreCase("alert")) {
			if ((fualConsumption  / counter) > fualConsmpThreshold) {
				String alertMessage = "Your Vehicle Fual Consumption is crocessing limits["+fualConsmpThreshold+" /h], Vehicle Fual Consumption is on average Speed : "
						+ fualConsumption  / counter + "/h from last "+minute+" Minute";
				analyticDao.save(new AnalyticAlert(readings.get(0).getVehicleid(), "fualconsumption", alertMessage,
						VdsAnalyticUtil.getCurrentDate()));
				avgfclevel="true";
			}
		}
		if (counter > 0 && mode.equalsIgnoreCase("report")) {
			avgfclevel = fualConsumption  / counter + "/h";
		}
		System.out.println(fualConsumption);
		System.out.println(counter);
		return avgfclevel;
	}

	public String getRPM(List<Readings> readings, String mode) {
		int rpmLevel = 0;
		int rplevel = 0;
		int counter = 0;
		String avgRPM="";
		System.out.println("------------------>getRPM size of record " + readings.size());
		for (Readings reading : readings) {
			if (reading.getSpeed() != null) {
				String level = reading.getEngineRpm().replaceAll("[^\\d.]", "");
				if (!level.equalsIgnoreCase("")) {
					rplevel = Integer.parseInt(level);
					counter++;
				}
				rpmLevel = rpmLevel + rplevel;

			}
		}
		if (counter > 0 && mode.equalsIgnoreCase("alert")) {
			if ((rpmLevel / counter) > rPMThreshold) {
				String alertMessage = "Your Vehicle RPM is crocessing limets["+rPMThreshold+" RPM], Vehicle average RPM Speed : "
						+ rpmLevel / counter + "/min from last "+minute+" Minute";
				analyticDao.save(new AnalyticAlert(readings.get(0).getVehicleid(), "RPM", alertMessage,
						VdsAnalyticUtil.getCurrentDate()));
				avgRPM="true";
			}
		}
		if (counter > 0 && mode.equalsIgnoreCase("report")) {
			avgRPM = rpmLevel / counter + "/min";
		}
		System.out.println(rpmLevel);
		System.out.println(counter);
		return avgRPM;
	}
}
