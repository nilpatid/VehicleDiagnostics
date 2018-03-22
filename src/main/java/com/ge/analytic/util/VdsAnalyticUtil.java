package com.ge.analytic.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

public class VdsAnalyticUtil {
	
	public static Timestamp getCurrentDate() {
		Date today = new Date();
		return new Timestamp(today.getTime());
	}

	public static Timestamp getCurrentDateMinus15() {
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		cal.add(Calendar.MINUTE, -2);
		Date startDate = cal.getTime();
		return new Timestamp(startDate.getTime());
	}
	public static Timestamp getCurrentDateCoustom(int day) {
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		cal.add(Calendar.DATE, -30);
		Date startDate = cal.getTime();
		return new Timestamp(startDate.getTime());
	}
}
