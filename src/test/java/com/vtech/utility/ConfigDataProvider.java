package com.vtech.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	public Properties prop;

	public ConfigDataProvider(String fileName) {
		try {
			File fs = new File("./Config/" + fileName + ".properties");
			FileInputStream fins = new FileInputStream(fs);
			prop = new Properties();
			prop.load(fins);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public  String searchkey(String key) 
	{
		return prop.getProperty(key); 
	}	
	public String getUserName() {
		
		return prop.getProperty("username");
	}
	public String getPassword() {
		
		return prop.getProperty("password");
	}
	public String getAppURL() {
		
		return prop.getProperty("appUrl");
	}
	
	 public static void main(String[] args) 
	 {
		 ConfigDataProvider configDataProvider= new ConfigDataProvider("config");
		 String uname = configDataProvider.searchkey("username");
		String upass = configDataProvider.searchkey("password");
		String appURL = configDataProvider.searchkey("appUrl");
		
		System.out.println(uname+" "+upass+" "+appURL);
		System.out.println(configDataProvider.getUserName());
		System.out.println(configDataProvider.getPassword());
		System.out.println(configDataProvider.getAppURL());
	}
}
