package com.ge.analytic.controllers;

import com.ge.analytic.models.AnalyticAlert;
import com.ge.analytic.logic.VdsAlertCheckServise;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AnalyticController {

  // ------------------------
  // ALERTS CONTROLLERS
  // ------------------------
  @CrossOrigin
  @RequestMapping("/healthcheck")
  @ResponseBody
  public String healthcheck() {
	  String Message="";
	 // System.out.println("=========================>In healthcheck");
  	try{
  		
  		boolean status=checkServise.checkAlerts();
  		if(status){
  			Message="Analytic Run Successfully :[ "+new Date()+"]";
  		}else{
  			Message="Analytic Run Successfully but no data for processing:[ "+new Date()+"]";
  		}
  		
  	}catch(Exception e){
  		Message="Analytic failed:[ "+e.getMessage()+"]";
  		e.printStackTrace();
  	}
  	//System.out.println("=========================>out healthcheck");
  	return String.format("{\"Message\":"+Message+"\"}");
  }
  
  
  @CrossOrigin
  @RequestMapping("/getVehicleAlert/{vid}")
  @ResponseBody
  public Map<String, Map<String, String>> getVehicleNo(@PathVariable("vid")String vehicleNo) {
	  List<AnalyticAlert> alert1 = null;
	  Map<String, Map<String, String>> alert = new HashMap<String, Map<String, String>>();
	  System.out.println("=========================>In getVehicleNo");
    try {
    	
    	alert1= checkServise.getAlerts(vehicleNo);
    	if(alert1.size()>0){
    	for(AnalyticAlert analyticAlert:alert1){
    		 Map<String, String> alert2 = new HashMap<String, String>();
    		alert2.put("title", analyticAlert.getAlertType());
    		alert2.put("message", analyticAlert.getAlertMessage());
    		alert2.put("time", analyticAlert.getAlertDateTime().toString());
    		alert.put(analyticAlert.getAlertType(), alert2);
    	}
    	}else{
    		Map<String, String> alert2 = new HashMap<String, String>();
    		alert2.put("message", "No Alerts for vehicle ["+vehicleNo+"]");
    		alert.put("errorMessage", alert2);
    	}
    	}
    catch (Exception ex) {
    	ex.printStackTrace();
    }
    return alert;
  }
  
  // ------------------------
  // REPORTS CONTROLLERS
  // ------------------------
  
  
  @CrossOrigin
  @RequestMapping("/healthReport")
  @ResponseBody
  public String healthReport() {
	  String Message="";
  	try{
  		
  		boolean status=checkServise.checkReports();
  		if(status){
  			Message="Analytic Run Successfully :[ "+new Date()+"]";
  		}else{
  			Message="Analytic Run Successfully but no data for processing:[ "+new Date()+"]";
  		}
  		
  	}catch(Exception e){
  		Message="Analytic failed:[ "+e.getMessage()+"]";
  		e.printStackTrace();
  	}
  	return String.format("{\"Message\":"+Message+"\"}");
  }
  

  @CrossOrigin
  @RequestMapping("/getVehicleReport/{vid}")
  @ResponseBody
  public  List<String> getVehicleReports(@PathVariable("vid")String vehicleNo) {
	  List<String> report1 = null;
    try {
    	
    	report1= checkServise.getReports(vehicleNo);
    	if(!(report1.size()>0)){
    	  	report1.add("message : No Report for vehicle ["+vehicleNo+"]");
    	}
    	}
    catch (Exception ex) {
    	ex.printStackTrace();
    }
    return report1;
  }
  // ------------------------
  // PRIVATE FIELDS
  // ------------------------

  @Autowired
  private VdsAlertCheckServise checkServise;
  
} 
