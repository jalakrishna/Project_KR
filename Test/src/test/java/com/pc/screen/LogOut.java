package com.pc.screen;

import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;

import com.pc.utilities.Common;

public class LogOut {
	
	public static String sheetname = "LogOut";
	private WebDriver driver = Common.driver;
	static Logger logger =Logger.getLogger(sheetname);
	
	public Boolean SCRLogOut() throws Exception{

		Boolean status = true;
		status = Common.ClassComponent(sheetname, Common.o);
		if(!status)
		{
			return false;
		}
		/*if(Common.WaitUntilClickable(driver, o.getObject("edtUserName"),  Integer.valueOf(Common.pro.getProperty("VERYLONGWAIT"))))
		{
			logger.info("Application loggedout Successfully");
			HTML.fnInsertResult(HTML.properties.getProperty("testcasename"), HTML.properties.getProperty("methodName"), "Application should logout Successfully","Application loggedout Successfully", "PASS");
			status = true;
		}
		else
		{
			logger.info("Application not loggedout Successfully");
			HTML.fnInsertResult(HTML.properties.getProperty("testcasename"), HTML.properties.getProperty("methodName"), "Application should logout Successfully","Application not loggedout Successfully", "FAIL");
			status = false;
		}*/
		Common.Terminate();
		return status;
	}
}
