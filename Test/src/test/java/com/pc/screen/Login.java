package com.pc.screen;

import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;

import com.pc.utilities.Common;
import com.pc.utilities.HTML;

public class Login {
	
	public static String sheetname = "Login";
	private WebDriver driver = null;
	static Logger logger =Logger.getLogger(sheetname);
	
	public Boolean SCRLogin() throws Exception{
			
		Boolean s = Common.OpenApp();
		if(!s)
		{
			logger.info("Application not Loggedin Successfully");
			HTML.fnInsertResult(HTML.properties.getProperty("testcasename"), HTML.properties.getProperty("methodName"), "Application should login successfully","Application not loggedin successfully", "PASS");
			return false;
		}
		Boolean status = true;
		driver= Common.dr();
		status = Common.ClassComponent(sheetname,Common.o);
		if(!status)
		{
			return status;
		}
		if(Common.WaitUntilClickable(Common.o.getObject("eleDeskTopAction"),  Integer.valueOf(HTML.properties.getProperty("VERYLONGWAIT"))))
		{
			logger.info("Application Loggedin Successfully");
			HTML.fnInsertResult(HTML.properties.getProperty("testcasename"), HTML.properties.getProperty("methodName"), "Application should login successfully","Application loggedin successfully", "PASS");
			status = true;
		}
		else
		{
			logger.info("Application not Loggedin Successfully");
			HTML.fnInsertResult(HTML.properties.getProperty("testcasename"), HTML.properties.getProperty("methodName"), "Application should login successfully","Application not loggedin successfully", "FAIL");
			status = false;
		}
		return status;
	}
	
}

