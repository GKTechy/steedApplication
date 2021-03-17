package com.app.steedApplication.Configuration;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateConversion {

	//	public static Date getStringToDate(String stringDateTime) throws ParseException {
	//		String[] stringDateTimeSplit = stringDateTime.split(" "); 
	//		String stringDate = stringDateTimeSplit[0];
	//		String stringTime = stringDateTimeSplit[1];
	//		String[] stringDateSplit = stringDate.split("/");
	//		String month = stringDateSplit[0];
	//		String day = stringDateSplit[1];
	//		String year = stringDateSplit[2];
	//		
	//		String originalDateTime = year+"-"+month+"-"+day+" "+stringTime;
	//		
	//		 DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	//         Date d2 = df2.parse(originalDateTime);
	//         return d2;
	//	}
	//	
	//	@SuppressWarnings("deprecation")
	//	public static Date getAsianDateTime() {
	//		Date date = new Date();
	//	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//	    Date gmt = new Date(sdf.format(date));
	//	    return gmt;
	//	}
	//	
	//	@SuppressWarnings("deprecation")
	//	public static Date getAsianKalkataDateTime() {
	//		Date date = new Date();
	//	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	//	    sdf.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
	//	    Date gmt = new Date(sdf.format(date));
	//	    return gmt;
	//	}

	public static Date getStringToDate(String stringDate) throws ParseException {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		Date dt = new Date(stringDate);
		return dt;
	}
	
	@SuppressWarnings("deprecation")
	public static String getStringToStringDate(String stringDate) throws ParseException {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		Date dt = new Date(stringDate);
		String dtString = formatter.format(dt);
		return dtString;
	}
	
	public static String getIndianDateTime() {			
		String pattern = "dd-MM-yyyy HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String date = sdf.format(new Date());		    
		return date;
	}
}
