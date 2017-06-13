package com.pc.screen;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.pc.utilities.Common;
import com.pc.utilities.HTML;

public class SearchNewAccount {
	
	public static String sheetname = "SearchNewAccount";
	private WebDriver driver = Common.dr();
	static Logger logger =Logger.getLogger(sheetname);
	
	public Boolean SCRSearchNewAccount() throws Exception{
		
		Boolean status = true;
		status = Common.ClassComponent(sheetname, Common.o);
		if(!status)
		{
			return false;
		}
		if(Common.WaitUntilClickable(Common.o.getObject("edtAddress1"),  Integer.valueOf(HTML.properties.getProperty("VERYLONGWAIT"))))
		{
			logger.info("System displayed Create New Account Page");
			HTML.fnInsertResult(HTML.properties.getProperty("testcasename"), HTML.properties.getProperty("methodName"), "System should display Create New Account Page","System displayed Create New Account Page", "PASS");
			status = true;
		}
		else
		{
			logger.info("System not displayed Create New Account Page");
			HTML.fnInsertResult(HTML.properties.getProperty("testcasename"), HTML.properties.getProperty("methodName"), "System should display Create New Account Page","System not displayed Create New Account Page", "FAIL");
			status = false;
		}
			return status;
	}
	
}
