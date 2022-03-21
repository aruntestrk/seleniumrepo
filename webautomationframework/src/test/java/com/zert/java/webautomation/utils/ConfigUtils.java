package com.zert.java.webautomation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigUtils {
	
	Properties properties;
	
	public ConfigUtils() {
		
		
		 String configFileName = "./config/%s-config.properties";
	     String EnvironmentName = System.getProperty("TestEnvironment");
	     System.out.println("TestEnvironment: " + EnvironmentName);

	        configFileName = String.format(configFileName, EnvironmentName);
	        System.out.println("configFileName: " + configFileName);
		File file = new File(configFileName);
		
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			properties= new Properties();
			properties.load(fileInputStream);
		}catch(Exception e) {
			
		}
	}
	
	public String getAppUrl() {
		return properties.getProperty("url");
	}
	
	public String getBrowserType() {
		return properties.getProperty("browser");
	}
	
	public String getUserName() {
		return properties.getProperty("user");
	}
	
	public String getPassword() {
		return properties.getProperty("password");
	}

}
