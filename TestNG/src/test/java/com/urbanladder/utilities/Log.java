package com.urbanladder.utilities;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {
	public static Logger logger;
	public static void log() {
		logger=Logger.getLogger("urbanLadder");
		PropertyConfigurator.configure("./Log4j.properties");
	}

}
