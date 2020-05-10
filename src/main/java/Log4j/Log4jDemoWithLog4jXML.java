package Log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemoWithLog4jXML {

	private static Logger logger = LogManager.getLogger(Log4jDemoWithLog4jXML.class);
	
	public static void main(String[] args) {
		
		logger.info("this is info message");
		logger.warn("this is warn message");

	}

}
