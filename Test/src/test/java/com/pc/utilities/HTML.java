package com.pc.utilities;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.nio.file.*;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import com.pc.utilities.Common;

public class HTML
{
			private static WebDriver driver;
	        public static String g_FileName=""; //'Report Log File Name.
	        public static String g_sFileName = "";
	        public static String g_iCapture_Count = "";// 'Number of Image capture
	        public static int g_iImage_Capture;//=""; //'Flag for Image Capture in Result File
	        public static int g_iPass_Count = 0; //'Pass Count
	        public static int g_iFail_Count;//=0; //'Fail Count
	        public static Date g_tStart_Time; //'Start Time
	        public static Date g_tEnd_Time; //'End Time
	        public static String g_sScreenName = ""; //'Screen shot name
	        public static int g_Total_TC;//=0;
	        public static int g_Total_Pass;//=0;
	        public static int g_Total_Fail;//=0;
	        public static int g_Flag;//=0;
	        public static int g_Flag1;//=0;
	        public static Date g_tSummaryStart_Time;// 'Start Time
	        public static Date g_tSummaryEnd_Time; //'End Time
	        public static Date g_tSummaryTCStart_Time; //'Start time for each test case in Summary Report
	        public static Date g_tSummaryTCEnd_Time; //'Start time for each test case in Summary Report
	        public static int g_SummaryTotal_TC;//=0;
	        public static int g_SummaryTotal_Pass;//=0;
	        public static int g_SummaryTotal_Fail;//=0;
	        public static int g_SummaryFlag = 0;
	        public static String g_sSummaryFileName = "";
	        public static String g_ScriptName = "";
	        public static String g_sSection = "";
	        
	        public static File file ;
			public static FileInputStream fileInput;
			//public static Properties properties;
			//public static Date d = new Date();
        	
			public static Properties properties = new Properties();
			
////////////////////////////Summary Initialization Start//////////////////////////////////////////////////////////			
	        public static void fnSummaryInitialization(String strSummaryReportName) throws IOException
	        {
	        			File directory = new File (".");
	        			String sConfigfilespath = directory.getCanonicalPath()+"\\Config"; 
	        			System.out.println(sConfigfilespath);
	        			FileInputStream fis = new FileInputStream( sConfigfilespath+"\\Sys.properties");
	        			properties.load(fis);
	        			fis.close();
	        			
	        			//Common c = new Common();
	        			//driver= c.dr();
	        			//file = new File("D:\\FrameWorks\\SeleniumJava\\WorkSpace\\GuidewirePC\\ConfigFiles\\Sys.properties");
			        	//fileInput = new FileInputStream(file);
						//properties = new Properties();
			        	//properties.load(fileInput);
						//fileInput.close();
						
						
						
	        			properties.setProperty("TempResultPath",properties.getProperty("ResultsFolderPath"));
	        			properties.setProperty("TempResults",properties.getProperty("TempResultPath"));
	                    properties.setProperty("SummaryFileName","");
	                    properties.setProperty("SummaryFolderName",properties.getProperty("ResultsFolderPath"));
				        
	                    File objDir=new File(properties.getProperty("SummaryFolderName"));
				        if(!objDir.exists())
	                    {
				        	objDir.mkdir();
	                    }
	                 
				        properties.setProperty("SummaryFolderName1",properties.getProperty("ResultsFolderPath")+"\\" + strSummaryReportName);
				        File objDir1=new File(properties.getProperty("TempResults"));
				        if(!objDir1.exists())
	                    {
				        	objDir1.mkdir();
	                    }
				        fnSummaryOpenHtmlFile(strSummaryReportName);// 'logo, heading
				        fnSummaryInsertSection(); //'TestCaseID,Scenario Name and Result
	            }

	        public static void fnSummaryOpenHtmlFile(String sSection) throws IOException	
	        {
			        g_iPass_Count=0;
			        g_iFail_Count=0;
			        g_sFileName = "sScriptName";
			        //g_iImage_Capture = 1

			        g_SummaryTotal_TC = 0;
			        g_SummaryTotal_Pass = 0;
			        g_SummaryTotal_Fail = 0;
			        g_SummaryFlag = 0;
			        g_ScriptName="sScriptName";
			        
			        Date d = new Date();
	                String gsTempFile = properties.getProperty("FileName");
			        if(gsTempFile ==null)
	                {
				                gsTempFile = properties.getProperty("SummaryFolderName1") +d.getYear() + d.getMonth() + d.getDay() + "_" + d.getHours() + d.getMinutes() + d.getSeconds()+ ".htm";	
				                properties.setProperty("SummaryFileName",gsTempFile);
			        }
			   	 	Path objPath = Paths.get(gsTempFile);
					FileWriter objFile=new FileWriter(gsTempFile,true);
					objFile.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
					objFile.write("<TR COLS=2><TD BGCOLOR=WHITE WIDTH=6%><IMG SRC='https://www.capgemini.com/sites/all/themes/capgemini/logo.png'></TD><TD WIDTH=94% BGCOLOR=WHITE><FONT FACE=VERDANA COLOR=NAVY SIZE=3><B>&nbsp;GW PC Automation Test Results<BR/><FONT FACE=VERDANA COLOR=SILVER SIZE=2>&nbsp; Date: " + d +"</BR>&nbsp;On Machine :" + properties.getProperty("LocalHostName") + "</B></FONT></TD><TD BGCOLOR=WHITE WIDTH=6%><IMG SRC='https://www.capgemini.com/sites/all/themes/capgemini/logo.png'></TD></TR></TABLE>");
					objFile.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
					objFile.write("<TR><TD BGCOLOR=#66699 WIDTH=15%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Module Name:</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699 ><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>" + sSection + "</B></FONT></TD></TR>");
					objFile.write("</TABLE></BODY></HTML>");
					objFile.close();
				
					g_tSummaryStart_Time = d;
					g_tSummaryTCStart_Time = d;
					g_sSection=sSection;
	         }
	        
	        public static void fnSummaryInsertSection() throws IOException
	        {
	        		Date d = new Date();
	                String gsTempFile = properties.getProperty("SummaryFileName");
			        if(gsTempFile =="")
	                {
				                gsTempFile = properties.getProperty("SummaryFolderName") +d.getYear() + d.getMonth() + d.getDay() + "_" + d.getHours() + d.getMinutes() + d.getSeconds()+ ".htm";	
			        }
			        Path objPath=Paths.get(gsTempFile);			        
					FileWriter objFile=new FileWriter(gsTempFile,true);
					objFile.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
					objFile.write("<TR COLS=6><TD BGCOLOR=#FFCC99 WIDTH=15><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Test Case ID</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=45%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Test Case Name</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=20%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Scenario Name</B></FONT></TD><TD BGCOLOR=#FFCC99 SIZE=2 WIDTH=10%><B>Time</B></FONT></TD><TD BGCOLOR=#FFCC99 SIZE=2 WIDTH=10%><B>Result</B></FONT></TD></TR>");
					objFile.close();						
	        }
////////////////////////////Summary Initialization End/////////////////////////////////////////////////////////////		
			
////////////////////////////Test Case Initialization Start/////////////////////////////////////////////////////////			
	        public static void fnInitilization(String BprocessName) throws IOException, AWTException
	        {
					properties.setProperty("TempResultPath",properties.getProperty("ResultsFolderPath") + "\\temp");        
					properties.setProperty("TempResults",properties.getProperty("TempResultPath"));
					properties.setProperty("FileName","");
					properties.setProperty("FolderName",properties.getProperty("ResultsFolderPath"));
					properties.setProperty("FolderName1",properties.getProperty("ResultsFolderPath") + "\\" + BprocessName);
					File objDir=new File(properties.getProperty("TempResults"));
			        if(!objDir.exists())
                    {
			        	objDir.mkdir();
                    }
			        fnOpenHtmlFile(BprocessName);
			        fnInsertSection();
			        fnInsertTestCaseName("");
	        }
	
	        public static void fnOpenHtmlFile(String sSection) throws IOException, AWTException
	        {
			        g_iPass_Count=0;
			        g_iFail_Count=0;
			        g_sFileName = "sScriptName";
			        g_iImage_Capture = 1;
			        g_Total_TC = 0;
			        g_Total_Pass = 0;
			        g_Total_Fail = 0;
			        g_Flag = 0;
			        g_Flag1 = 0;
			        g_ScriptName="sScriptName";
			        String machinename = null;
		    
			        Date d = new Date();
			        String gsTempFile = properties.getProperty("FileName");
			        Path objPath=Paths.get(gsTempFile); 
			        if(gsTempFile =="")
	                {
			        	gsTempFile = properties.getProperty("FolderName1")+d.getYear() + d.getMonth() + d.getDay() + "_" + d.getHours() + d.getMinutes() + d.getSeconds()+ ".htm";	
	                    properties.setProperty("FileName", gsTempFile);
			        } 
			        if(Files.exists(objPath)) 
		        	  {
		        		 FileWriter objFile=new FileWriter(gsTempFile,true);
		        		 objFile.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		        		 objFile.write("<TR COLS=2><TD BGCOLOR=WHITE WIDTH=6%><IMG SRC='https://www.capgemini.com/sites/all/themes/capgemini/logo.png'></TD><TD WIDTH=94% BGCOLOR=WHITE><FONT FACE=VERDANA COLOR=NAVY SIZE=3><B>GW PC Automation Test Results<BR/><FONT FACE=VERDANA COLOR=SILVER SIZE=2>Date: " + d +"</BR>on Machine :" + machinename + "</B></FONT></TD><TD BGCOLOR=WHITE WIDTH=6%><IMG  SRC='https://www.capgemini.com/sites/all/themes/capgemini/logo.png'></TD></TR></TABLE>");
		        		 objFile.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		        		 objFile.write("<TR><TD BGCOLOR=#66699 WIDTH=15%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Module Name:</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699 ><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>" + sSection + "</B></FONT></TD></TR>");
		        		 objFile.write("</TABLE></BODY></HTML>");
		        		 objFile.close();
	                    }
			        ScreenVideoCapture.startVideoCapture();
	                g_tStart_Time = d;
			        g_sSection=sSection;
	        }

	        public static void fnInsertSection() throws IOException
	        {
	        	Date d = new Date();
	        		String gsTempFile = properties.getProperty("FileName");
	        		Path objPath=Paths.get(gsTempFile); 
			        if(gsTempFile =="")
	                {
			        	gsTempFile = properties.getProperty("FolderName")+d.getYear() + d.getMonth() + d.getDay() + "_" + d.getHours() + d.getMinutes() + d.getSeconds()+ ".htm";	
			        } 
		
			        if(Files.exists(objPath)) 
		        	 {
		        		 FileWriter objFile=new FileWriter(gsTempFile,true);
		        		 objFile.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		        		 objFile.write("<TR COLS=6><TD BGCOLOR=#FFCC99 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Test Case Name</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Component</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Expected Value</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Actual Value</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Result</B></FONT></TD></TR>");
		        		 objFile.close();
	                 }
	        }

	        public static void fnInsertTestCaseName(String sDesc)
	        {
	        	Date d = new Date();
	        	String gsTempFile = properties.getProperty("FileName");
	        	Path objPath=Paths.get(gsTempFile); 
		        if(gsTempFile =="")
                {
		        	gsTempFile = properties.getProperty("FolderName")+d.getYear() + d.getMonth() + d.getDay() + "_" + d.getHours() + d.getMinutes() + d.getSeconds()+ ".htm";	
		        } 
			        g_Total_TC = g_Total_TC+1;
			        if(g_Flag1!=0)
	                {
					        if(g_Flag == 0)
	                        {
						        g_Total_Pass = g_Total_Pass+1;
	                        }
					        else
	                    {
						        g_Total_Fail = g_Total_Fail+1;
				        }
			        }
			        g_Flag = 0;
	        }
////////////////////////////Test Case Initialization End/////////////////////////////////////////////////////////
	        
////////////////////////////Write Results Start//////////////////////////////////////////////////////////////////	        
	        public static void fnInsertResult(String sTestCaseName, String sDesc, String sExpected, String sActual, String sResult) throws IOException
	        {
	    			Common c = new Common();
	    			driver= c.dr();
		            g_Flag1=1;
		            Date d = new Date();
		            String gsTempFile = properties.getProperty("FileName");
		            Path objPath=Paths.get(gsTempFile); 
			        if(gsTempFile =="")
	                {
			        	gsTempFile = properties.getProperty("FolderName")+d.getYear() + d.getMonth() + d.getDay() + "_" + d.getHours() + d.getMinutes() + d.getSeconds()+ ".htm";	
			        } 	
			        if(Files.exists(objPath)) 
		        	  {
		        		 FileWriter objFile=new FileWriter(gsTempFile,true);
				        if(sResult.toUpperCase()=="PASS")
	                    {
					        g_iPass_Count = g_iPass_Count + 1;
					        if (properties.getProperty("CaptureScreenShotforPass").equalsIgnoreCase("YES"))
	                        {
	                                String I_sFile="";
							        g_iCapture_Count="Screen" + d.getHours() +d.getMinutes() + d.getSeconds();
	                                I_sFile = properties.getProperty("FolderName") + "\\Screen" + g_iCapture_Count + ".png";
	                                if(driver != null)
	                                {
		                                File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
		                                FileUtils.copyFile(scrFile, new File(I_sFile));	                                	
	                                }
	                                objFile.write("<TR COLS=5><TD BGCOLOR=#EEEEEE WIDTH=15%><FONT FACE=VERDANA SIZE=2>" + sTestCaseName +"</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=15%><FONT FACE=VERDANA SIZE=2>" + sDesc +"</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>" + sExpected +"</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=WINGDINGS SIZE=4>2></FONT><FONT FACE=VERDANA SIZE=2><A HREF='" + I_sFile +"'>" + sActual + "</A></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE='WINGDINGS 2' SIZE=5 COLOR=GREEN>P</FONT><FONT FACE=VERDANA SIZE=2 COLOR=GREEN><B>" + sResult + "</B></FONT></TD></TR>");
	                        }
	                        else
	                        {
	                        	objFile.write("<TR COLS=5><TD BGCOLOR=#EEEEEE WIDTH=15%><FONT FACE=VERDANA SIZE=2>" + sTestCaseName + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=15%><FONT FACE=VERDANA SIZE=2>" + sDesc + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>" + sExpected +"</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>" + sActual + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE='WINGDINGS 2' SIZE=5 COLOR=GREEN>P</FONT><FONT FACE=VERDANA SIZE=2 COLOR=GREEN><B>" + sResult + "</B></FONT></TD></TR>");
	                        }
	                    }
				        else if(sResult.toUpperCase()=="FAIL")
	                    {
						        g_Flag = 1;
						        g_SummaryFlag = 1;
						        g_iFail_Count = g_iFail_Count + 1;
						        if (properties.getProperty("CaptureScreenShotforFail").equalsIgnoreCase("YES"))
		                        {
						        	String I_sFile="";
							        g_iCapture_Count="Screen" + d.getHours() +d.getMinutes() + d.getSeconds();
	                                I_sFile = properties.getProperty("FolderName") + "\\Screen" + g_iCapture_Count + ".png";
	                                if(driver != null)
	                                {
		                                File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		                                FileUtils.copyFile(scrFile, new File(I_sFile));	                                	
	                                }
	                                objFile.write("<TR COLS=5><TD BGCOLOR=#EEEEEE WIDTH=15%><FONT FACE=VERDANA SIZE=2>" + sTestCaseName +"</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=15%><FONT FACE=VERDANA SIZE=2>" + sDesc +"</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>" + sExpected +"</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=WINGDINGS SIZE=4>2></FONT><FONT FACE=VERDANA SIZE=2><A HREF='" + I_sFile +"'>" + sActual + "</A></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE='WINGDINGS 2' SIZE=5 COLOR=GREEN>P</FONT><FONT FACE=VERDANA SIZE=2 COLOR=RED><B>" + sResult + "</B></FONT></TD></TR>");
	                            }
	                            else
	                            {
	                            	objFile.write("<TR COLS=5><TD BGCOLOR=#EEEEEE WIDTH=15%><FONT FACE=VERDANA SIZE=2>" + sTestCaseName + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=15%><FONT FACE=VERDANA SIZE=2>" + sDesc + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>" + sExpected +"</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>" + sActual + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE='WINGDINGS 2' SIZE=5 COLOR=GREEN>P</FONT><FONT FACE=VERDANA SIZE=2 COLOR=RED><B>" + sResult + "</B></FONT></TD></TR>");
	                            }
				        }
	                    else if(sResult.toUpperCase()=="WARNING")
	                    {
	                    	 if (properties.getProperty("CaptureScreenShotforWarning").equalsIgnoreCase("YES"))
		                        {
	                    		 	String I_sFile="";
							        g_iCapture_Count="Screen" + d.getHours() +d.getMinutes() + d.getSeconds();
	                                I_sFile = properties.getProperty("FolderName") + "\\Screen" + g_iCapture_Count + ".jpeg";
	                                if(driver != null){
		                                File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		                                FileUtils.copyFile(scrFile, new File(I_sFile));	                                	
	                                }
	                                objFile.write("<TR COLS=5><TD BGCOLOR=#EEEEEE WIDTH=15%><FONT FACE=VERDANA SIZE=2>" + sTestCaseName +"</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=15%><FONT FACE=VERDANA SIZE=2>" + sDesc +"</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>" + sExpected +"</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=WINGDINGS SIZE=4>2></FONT><FONT FACE=VERDANA SIZE=2><A HREF='" + I_sFile +"'>" + sActual + "</A></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE='WINGDINGS 2' SIZE=5 COLOR=GREEN>P</FONT><FONT FACE=VERDANA SIZE=2 COLOR=GREEN><B>" + sResult + "</B></FONT></TD></TR>");
	                            }
	                            else
	                            {
	                                objFile.write("<TR COLS=5><TD BGCOLOR=#EEEEEE WIDTH=15%><FONT FACE=VERDANA SIZE=2>" + sTestCaseName + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=15%><FONT FACE=VERDANA SIZE=2>" + sDesc + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>" + sExpected +"</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>" + sActual + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE='WINGDINGS 2' SIZE=5 COLOR=GREEN>P</FONT><FONT FACE=VERDANA SIZE=2 COLOR=GREEN><B>" + sResult + "</B></FONT></TD></TR>");
	                            }
				        }
				        objFile.close();
	                    }
	        }
////////////////////////////Write Results End//////////////////////////////////////////////////////////////////
	        public static void fnSummaryInsertTestCase() throws IOException
	        {
	        	
                String tCaseID = properties.getProperty("TestCaseID");
                String tSetID = properties.getProperty("TestSetID");
                
	        		Date d = new Date();
	        		String gsTempFile = properties.getProperty("SummaryFileName");
	        		Path objPath=Paths.get(gsTempFile); 
			        if(gsTempFile =="")
	                {
				                gsTempFile = properties.getProperty("SummaryFolderName") +d.getYear() + d.getMonth() + d.getDay() + "_" + d.getHours() + d.getMinutes() + d.getSeconds()+ ".htm";	
			        }
			        g_SummaryTotal_TC = g_SummaryTotal_TC+1;
			        if (g_SummaryFlag==0)
	                {
					        g_SummaryTotal_Pass = g_SummaryTotal_Pass+1;
	                }
			        else
	                {
					        g_SummaryTotal_Fail = g_SummaryTotal_Fail+1;
	                } 
			        g_tSummaryTCEnd_Time = d;
	                    String strStatus="";
	                    switch (g_SummaryFlag)
	                    {
	                        case 0:
					            strStatus = "PASSED";
	                            break;
	                        case 1:
					            strStatus = "FAILED";
	                           break;
	                        default:
					            strStatus = "FAILED";
	                            break;
	                    }
	                    String intDateDiff = "";
	                    long diff = g_tSummaryTCEnd_Time.getTime() - g_tSummaryTCStart_Time.getTime();
	                    long intDateDiff1 = diff / (60 * 1000) % 60;
//	                    Date ts = d;

	                    if (intDateDiff1 == 0)
	                    {
	                            //intDateDiff = d.getSeconds() + " Seconds";
	                    		intDateDiff1 = diff / 1000 % 60;
	                    		intDateDiff = Long.toString(intDateDiff1) + " Seconds";
	                    }
				        else
	                    {
	                            //intDateDiff = d.getMinutes()+ " Minutes";
				        		intDateDiff1 = diff / (60 * 1000) % 60;
				        		intDateDiff = Long.toString(intDateDiff1) + " Minutes";
				        }

	                    if(Files.exists(objPath)) 
			        	  {
			        		 FileWriter objFile=new FileWriter(gsTempFile,true);
			                    if(strStatus.toUpperCase()== "PASSED")
	                            {
			                    	objFile.write("<TR COLS=6><TD BGCOLOR=#EEEEEE WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2>" + properties.getProperty("TCID") + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=45%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><A HREF='" + properties.getProperty("FileName") + "'>" + properties.getProperty("testcasename") + "</A></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=20%><FONT FACE=VERDANA COLOR=BLACK SIZE=2>" + properties.getProperty("testcasename") + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2>" + intDateDiff + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=WINGDINGS 2' SIZE=5 COLOR=GREEN>P</FONT><FONT FACE=VERDANA SIZE=2 COLOR=GREEN><B>" + strStatus + "</B></FONT></TD></TR>");
	                            }
			                    else if (strStatus.toUpperCase()== "FAILED")
	                            {
			                    	objFile.write("<TR COLS=6><TD BGCOLOR=#EEEEEE WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2>" + properties.getProperty("TCID") + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=45%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><A HREF='" + properties.getProperty("FileName") + "'>" + properties.getProperty("testcasename") + "</A></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=20%><FONT FACE=VERDANA COLOR=BLACK SIZE=2>" + properties.getProperty("testcasename") + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2>" + intDateDiff + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=WINGDINGS 2' SIZE=5 COLOR=RED>O</FONT><FONT FACE=VERDANA SIZE=2 COLOR=RED><B>" + strStatus + "</B></FONT></TD></TR>");
			                    }
			                   // int intDiff = 0;
			                    g_tSummaryTCStart_Time = d;
			                    objFile.close();
			                    String  ALMUpdate = properties.getProperty("ALMUpdate");
			                    if(ALMUpdate.contains("YES"))
			                    {
				                    Common.RunScript(tCaseID,tSetID,Integer.toString(g_SummaryFlag), properties.getProperty("FileName"), properties.getProperty("testcasename"),properties.getProperty("ALMUserName"),properties.getProperty("ALMPassword"),properties.getProperty("sQCURL"),properties.getProperty("sDomain"),properties.getProperty("sProject"),properties.getProperty("ALMDraftRun"));
//				                    ,properties.getProperty("ALMDraftRun")
			                    }
			                    g_SummaryFlag = 0;
	                     }
	        }       
////////////////////////////Write Test Case Summary Results End//////////////////////////////////////////////////////////////////	   	        
	        
////////////////////////////Close Summary Report Start///////////////////////////////////////////////////////////////////////////
	        public static void fnSummaryCloseHtml(String strRelease) throws IOException
	        {
	        		Date d = new Date();
	             	String gsTempFile = properties.getProperty("SummaryFileName");
	        	 	Path objPath=Paths.get(gsTempFile); 
	       			if(gsTempFile =="")
	                {
				                gsTempFile = properties.getProperty("SummaryFolderName") +d.getYear() + d.getMonth() + d.getDay() + "_" + d.getHours() + d.getMinutes() + d.getSeconds()+ ".htm";	
			        }
	            
			        g_tSummaryEnd_Time = d;
                   // String sTime ;
                   ////Date ts = g_tSummaryStart_Time - g_tSummaryEnd_Time;
                    Date ts = d;
                    //// Difference in days.
                    ////int differenceInDays = ts.Minutes;

                    //if (ts.getMinutes() == 0)
                    //{
                    //        sTime = (String)(ts.getSeconds() + " Seconds");
                    //}
			        //else
                   // {
                   //         sTime =  (String)(ts.getMinutes()  + " Minutes");
			       // }

                    
                    String sTime = "";
                    long diff = g_tSummaryEnd_Time.getTime() - g_tSummaryStart_Time.getTime();
                    long intDateDiff1 = diff / (60 * 1000) % 60;
//                    Date ts = d;

                    if (intDateDiff1 == 0)
                    {
                            //intDateDiff = d.getSeconds() + " Seconds";
                    		intDateDiff1 = diff / 1000 % 60;
                    		sTime = Long.toString(intDateDiff1) + " Seconds";
                    }
			        else
                    {
                            //intDateDiff = d.getMinutes()+ " Minutes";
			        		intDateDiff1 = diff / (60 * 1000) % 60;
			        		sTime = Long.toString(intDateDiff1) + " Minutes";
			        }
                    
                    if(Files.exists(objPath)) 
		        	  {
		        		 FileWriter objFile=new FileWriter(gsTempFile,true);    
		        		 objFile.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		        		 objFile.write("<TR><TD BGCOLOR=#66699 WIDTH=15%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Release :</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>" + strRelease + "</B></FONT></TD></TR>");
		        		 objFile.write("<TR COLS=5><TD BGCOLOR=#66699 WIDTH=25%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Total Test Case Executed : " + g_SummaryTotal_TC + "</B></FONT></TD><TD BGCOLOR=#66699 WIDTH=15%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Total Test Cases Passed : " + g_SummaryTotal_Pass + "</B></FONT></TD><TD BGCOLOR=#66699 WIDTH=25%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B> Total Test Cases Failed : " + g_SummaryTotal_Fail + "</B></FONT></TD><TD BGCOLOR=#66699 WIDTH=25%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Total Execution Time : " + sTime + " </B></FONT></TD></TR>");
		        		 objFile.write("</TABLE></BODY></HTML>");
		        		 objFile.close();
                     }
                    String  SendMail = properties.getProperty("SendMail");
                    if(SendMail.contains("YES"))
                    {
                    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	                    Common.SendMail(properties.getProperty("MailTo"), properties.getProperty("MailCC"), gsTempFile, formatter.format(g_tSummaryEnd_Time),formatter.format(g_tSummaryStart_Time),strRelease, properties.getProperty("ModuleName"), String.valueOf(g_SummaryTotal_TC), String.valueOf(g_SummaryTotal_Pass),String.valueOf(g_SummaryTotal_Fail), properties.getProperty("Region"));
                    }
	        }
////////////////////////////Close Summary Report End/////////////////////////////////////////////////////////////////////////////
	        public static String fnSecondsToTime(int intSeconds)
	        {
				        int hours, minutes, seconds;
				        hours = intSeconds / 3600;
				        intSeconds = intSeconds % 3600;
				        minutes = intSeconds / 60;
				        seconds = intSeconds % 60;
				        return hours + ":" + minutes + ":" + seconds;
	        }
////////////////////////////Send Email End/////////////////////////////////////////////////////////////////////////////////////	        
}