package Log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {

	private static Logger logger = LogManager.getLogger(Log4jDemo.class);
	
	public static void main(String[] args) {
		
		System.out.println("\n Hello World.....!\n");
		logger.trace("This is trace message"); // this is not print in console and log file as well because in Log4j2.properties file,
		//logger.file.level and rootLogger.level is set to debug. when we will change this to trace then trace 
		//will print in console and log file as well.
		logger.info("This is information message");
		logger.error("This is error message");
		logger.warn("This is warning message");
		logger.fatal("This is fatal message");
		
		System.out.println("\n Completed");
	}

}
