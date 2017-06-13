package com.pc.driver;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.pc.utilities.Common;


public class Driver1{
		
	@Parameters({ "DataSheetName","Region","Browser" })
	@Test(priority=1,enabled=true)
	public void Main1(String DataSheetName, String Region, String Browser) throws Exception
	{
		System.out.println("TestCase1 Started");
		Common.RunTest("RunModeYes","CreateAccount_1",DataSheetName,Region, Browser);
	}
	
	@Parameters({ "DataSheetName","Region","Browser" })
	@Test(priority=1,enabled=false)
	public void Main2(String DataSheetName, String Region, String Browser) throws Exception
	{
		System.out.println("TestCase1 Started");
		Common.RunTest("RunModeNo","CreateAccount_2",DataSheetName,Region, Browser);
	}
	
	@Parameters({ "DataSheetName","Region","Browser" })
	@Test(priority=1,enabled=false)
	public void Main3(String DataSheetName, String Region, String Browser) throws Exception
	{
		System.out.println("TestCase1 Started");
		Common.RunTest("RunModeNo","CreateAccount_3",DataSheetName,Region, Browser);
	}
		
}
