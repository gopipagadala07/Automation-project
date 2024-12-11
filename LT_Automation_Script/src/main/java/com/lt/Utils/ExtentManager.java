package com.lt.Utils;

import java.util.Date;

import com.Utils.ReadProperties;

/**
 * 
 * @author anamika.p
 *
 */

public class ExtentManager {

	public static String emailReports = "";
	final public static String filePath = getReportLocation() + "/SummaryReport.html";
	public static String reportLocation;

	public static String getReportLocation() {

			reportLocation = ReadProperties.projectLocation + "Reports/FocalPoint_Automation_Report_"
					+ (new Date()).toString().replace(":", "_").replace(" ", "_");
			return reportLocation;

	}

}
