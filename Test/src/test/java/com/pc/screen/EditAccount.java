package com.pc.screen;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.pc.utilities.Common;

public class EditAccount {
	
		public static String sheetname = "EditAccount";
		private WebDriver driver = Common.driver;
		static Logger logger =Logger.getLogger(sheetname);
		
		public Boolean SCREditAccount() throws Exception{
			
			Boolean status = true;
			status = Common.ClassComponent(sheetname, Common.o);
			if(!status)
			{
				return false;
			}
			/*if(Common.WaitUntilClickable(driver, o.getObject("eleAddWCOptions"),  Integer.valueOf(Common.pro.getProperty("VERYLONGWAIT"))))
			{
				logger.info("System displayed WCOptions Page");  
				HTML.fnInsertResult(HTML.properties.getProperty("testcasename"), HTML.properties.getProperty("methodName"), "System should display WCOptions Page","System displayed WCOptions Page", "PASS");
				status = true;
			}
			else
			{
				logger.info("System not displayed WCOptions Page");
				HTML.fnInsertResult(HTML.properties.getProperty("testcasename"), HTML.properties.getProperty("methodName"), "System should display WCOptions Page","System not displayed WCOptions Page", "FAIL");
				status = false;
			}*/
			return true;
	}
}
