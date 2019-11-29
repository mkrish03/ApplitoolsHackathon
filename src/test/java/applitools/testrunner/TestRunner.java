package applitools.testrunner;

import java.io.File;

import org.apache.log4j.PropertyConfigurator;
import org.testng.TestNG;
import org.testng.annotations.Test;

public class TestRunner {
	public static void main(String[] args) {
//			 @Test
//			 public void executeTest() {
			testRunner();
		}
		
		public static void testRunner() {
		try {
			deleteOldLog();
			String log4jConfPath = "log4j.properties";
			PropertyConfigurator.configure(log4jConfPath);
			TestNG testNG = new TestNG();
			testNG.setTestClasses(new Class[] { RunCukesTest.class });
			testNG.run();
		} catch (Exception e) {
			// LOGGER.info(e);
		}

	}
		
		/**
		 * Delete old log is used to delete the old execution log file.
		 *
		 * @return nothing
		 * @exception Exception
		 *                the exception
		 */
		public static void deleteOldLog() throws Exception {
			File file = new File("executionlog.log");
			if (file.exists()) {
				file.delete();
			}
		}

}
