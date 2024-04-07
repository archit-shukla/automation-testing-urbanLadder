package com.urbanladder.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class propertyFileReader {
	Properties prop;
	public propertyFileReader() {
		File src=new File("./config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
		}catch(Exception e){
			
			System.out.println("Exception is"+e.getMessage());
		}
	}
	public String chromepath() {
		String chrome=prop.getProperty("chromepath");
		return chrome;
	}
	public String firefoxpath() {
		String firefox=prop.getProperty("firefoxpath");
		return firefox;
}
	public String msedge() {
		String msedge=prop.getProperty("msedgepath");
		return msedge;
	}
	public String browser() {
		String browser=prop.getProperty("browser");
		return browser;
	}
}
