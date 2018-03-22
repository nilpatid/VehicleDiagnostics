package com.ge.analytic.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Component
public class MainController {

  @RequestMapping("/")
  @ResponseBody
  public String index() {
	  
    return "Proudly handcrafted by CD ECOMM Team";
  }


 
  @Scheduled(fixedRate = 120000)
  public void Scheduler() throws IOException, SQLException {
	  final String USER_AGENT = "Mozilla/5.0";
	  String url = "https://vds-analytic.run.aws-usw02-pr.ice.predix.io/healthcheck";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// optional default is GET
		con.setRequestMethod("GET");
		
		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer resp = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			resp.append(inputLine);
		}
		in.close();
		// print result
		System.out.println(resp.toString());
	  
	  System.out.println("Scheduler started and Proudly handcrafted by CD ECOMM Team");
    //return "Proudly handcrafted by CD ECOMM Team";
  }

}
