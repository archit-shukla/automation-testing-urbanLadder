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
	public String browser() {
		String br=prop.getProperty("browser");
		return br;}
	public String username() {
		String uname=prop.getProperty("username");
		return uname;}
	public String password() {
		String pwd=prop.getProperty("password");
		return pwd;}
	public String getURL() {
		String url=prop.getProperty("baseurl");
		return url;
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
	public String search() {
		String search=prop.getProperty("search");
		return search;
	}
	public String order() {
		String order=prop.getProperty("orderNumber");
		return order;
	}
	public String phone() {
		String phone=prop.getProperty("phoneNumber");
		return phone;
	}
	public String helpSearch() {
		String help=prop.getProperty("helpSearch");
		return help;
	}
	public String title1() {
		String title1=prop.getProperty("title1");
		return title1;
	}
	public String url1() {
		String url1=prop.getProperty("url1");
		return url1;
	}
	public String searchResult() {
		String url1=prop.getProperty("searchResult");
		return url1;
	}
	public String title2() {
		String title2=prop.getProperty("title2");
		return title2;
	}
	public String url2() {
		String url2=prop.getProperty("url2");
		return url2;
	}
	public String url3() {
		String url2=prop.getProperty("url3");
		return url2;
	}
	public String text() {
		String text=prop.getProperty("text");
		return text;
	}
	public String text2() {
		String text=prop.getProperty("text2");
		return text;
	}
	public String contactEmail() {
		String ce=prop.getProperty("contactEmail");
		return ce;
	}
	public String searchResult2() {
		String url1=prop.getProperty("searchResult2");
		return url1;
	}

}