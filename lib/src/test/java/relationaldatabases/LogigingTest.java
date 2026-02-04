package relationaldatabases;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogigingTest {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(LogigingTest.class);
		logger.trace(null);
		logger.debug(null);
		logger.info("");
		logger.warn(null);
		logger.error(null);
		
		
	}

}
