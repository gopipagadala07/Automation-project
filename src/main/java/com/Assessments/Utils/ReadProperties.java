package com.Assessments.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	public static String projectLocation = "src/test/resources";
	public static Properties prop = null;
	public static String env=null;
	
	FileInputStream ip;
	
	/**
	 * This method is used to load the properties from config.properties/ env properties file
	 * @return it returns Properties prop object
	 */
	
	public Properties loadConfig() {
		if (prop == null) {
			prop = new Properties();
			try {
				ip = new FileInputStream(projectLocation + "/config/Data.properties");
				prop.load(ip);
				String env=System.getProperty("env");
				Logs.info("Enviornment is : " + env.toUpperCase());
				if (prop != null && env != null) {
					ip = new FileInputStream(projectLocation + "/config/" + env.toLowerCase() + "-config.properties");
					prop.load(ip);
				}
				else
					Logs.fatal("Enviornment property not found");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				
			}
		}

		return prop;
		

	}

}
