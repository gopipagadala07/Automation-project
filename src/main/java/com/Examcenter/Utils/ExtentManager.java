package com.Examcenter.Utils;

import java.util.Date;

/**
 * 
 * @author anamika.p
 *
 */

public class ExtentManager {

	public static String reportLocation;
	final public static String filePath = getReportLocation() + "/SummaryReport.html";
	public static String emailReports = "";

	public static String getReportLocation() {

			reportLocation = ReadProperties.projectLocation + "Reports/FocalPoint_Automation_Report_"
					+ (new Date()).toString().replace(":", "_").replace(" ", "_");
			return reportLocation;

	}

}
