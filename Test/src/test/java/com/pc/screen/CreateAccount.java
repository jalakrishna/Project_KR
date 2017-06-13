package com.pc.screen;

import org.apache.log4j.Logger;

import com.pc.utilities.Common;
import com.pc.utilities.HTML;
import com.pc.utilities.XlsxReader;

public class CreateAccount {
	
	public static String sheetname = "CreateAccount";
	public static XlsxReader sXL;
	static Logger logger =Logger.getLogger(sheetname);
	public static String AccountNumber;

	public Boolean SCRCreateAccount() throws Exception{

					Boolean status = true;
					status = Common.ClassComponent(sheetname, Common.o);
					if(!status)
					{
						return false;
					}
					if(Common.WaitUntilClickable(Common.o.getObject("eleCreateNewAccountNumber"),  Integer.valueOf(HTML.properties.getProperty("VERYLONGWAIT"))))
					{
					    sXL = new XlsxReader(HTML.properties.getProperty("DataSheetName"));
						AccountNumber = Common.ReadElement(Common.o.getObject("eleCreateNewAccountNumber"), Integer.valueOf(HTML.properties.getProperty("VERYLONGWAIT")));
//						String row = HTML.properties.getProperty("Row");
//						int inte = Integer.parseInt(row)-1;
//						sXL.setCellData(sheetname,AccountNumber, inte, 2);
						status = Common.UpdateQuery(HTML.properties.getProperty("DataSheetName"), "Update CreateAccount Set AccountNumber = '"+AccountNumber+"' where ID='"+HTML.properties.getProperty("TCID")+"'");
						logger.info("System displayed Account Summary Page with Account Number: " + AccountNumber);  
						HTML.fnInsertResult(HTML.properties.getProperty("testcasename"), HTML.properties.getProperty("methodName"), "System should display Account Summary Page with Account Number","System displayed Account Summary Page with Account Number: '" + AccountNumber + "'", "PASS");
						status = true;
					}
					else
					{
						logger.info("System not displayed Account Summary Page");
						HTML.fnInsertResult(HTML.properties.getProperty("testcasename"), HTML.properties.getProperty("methodName"), "System should display Account Summary Page with Account Number","System not displayed Account Summary Page", "FAIL");
						status = false;
					}
					return status;
	}
	
}