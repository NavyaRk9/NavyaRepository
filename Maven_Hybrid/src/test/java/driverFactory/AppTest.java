package driverFactory;

import org.testng.annotations.Test;

import Utilities.ExcelFileUtil;
import commonFunctions.FunctionLibrary;
import config.AppUtil;

public class AppTest extends AppUtil {
	String inputpath="/Users/ramakrishna/Desktop/Navya/SeleniumMaven/Maven_Hybrid/TestInput/DataEngineHybrid.xlsx";
	String outputpath="/Users/ramakrishna/Desktop/Navya/SeleniumMaven/Maven_Hybrid/TestOutput/DataEngineHybridResults.xlsx";
	String TCSheet="TestCases";
	String TSSheet="TestSteps";
	@Test
	public void startTest() throws Throwable
	{
		boolean res=false;
		String tcres="";
		ExcelFileUtil xl=new ExcelFileUtil(inputpath);
		int TCCount=xl.rowCount(TCSheet);
		int TSCount=xl.rowCount(TSSheet);
		for(int i=1;i<=TCCount;i++)
		{
			String exeFlag=xl.getCellData(TCSheet, i, 2);
			if(exeFlag.equalsIgnoreCase("y"))
			{
				String tcid=xl.getCellData(TCSheet, i, 0);
				for(int j=1;j<=TSCount;j++)
				{
					String tsid=xl.getCellData(TSSheet, j, 0);
					if(tcid.equalsIgnoreCase(tsid))
					{
						String keyword=xl.getCellData(TSSheet, j, 3);
						if(keyword.equalsIgnoreCase("AdminLogin"))
						{
							String para1=xl.getCellData(TSSheet, j, 5);
							String para2=xl.getCellData(TSSheet, j, 6);
							res=FunctionLibrary.verifyLogin(para1, para2);
						}
						else if(keyword.equalsIgnoreCase("NewBranch"))
						{
							String para1=xl.getCellData(TSSheet, j, 5);
							String para2=xl.getCellData(TSSheet, j, 6);
							String para3=xl.getCellData(TSSheet, j, 7);
							String para4=xl.getCellData(TSSheet, j, 8);
							String para5=xl.getCellData(TSSheet, j, 9);
							String para6=xl.getCellData(TSSheet, j, 10);
							String para7=xl.getCellData(TSSheet, j, 11);
							String para8=xl.getCellData(TSSheet, j, 12);
							String para9=xl.getCellData(TSSheet, j, 13);
							FunctionLibrary.clickBranches();
							res=FunctionLibrary.verifyNewBranch(para1, para2, para3, para4, para5, para6, para7, para8, para9);
						}
						else if(keyword.equalsIgnoreCase("BranchUpdation"))
						{
							String para1=xl.getCellData(TSSheet, j, 5);
							String para2=xl.getCellData(TSSheet, j, 6);
							String para3=xl.getCellData(TSSheet, j, 9);
							String para4=xl.getCellData(TSSheet, j, 10);
							FunctionLibrary.clickBranches();
							res=FunctionLibrary.verifyBranchUpdate(para1, para2, para3, para4);
							
						}
						else if(keyword.equalsIgnoreCase("AdminLogout"))
						{
							res=FunctionLibrary.verifyLogout();
						}
						String tsres="";
						if(res)
						{
							tsres="Pass";
							xl.setCellData(TSSheet, j, 4, tsres, outputpath);
						}
						else
						{
							tsres="Fail";
							xl.setCellData(TSSheet, j, 4, tsres, outputpath);
						}
						tcres=tsres;
				 	}//2nd if end
				}//j loop
				xl.setCellData(TCSheet, i, 3, tcres, outputpath);
			}//1st if end
			else
			{
				xl.setCellData(TCSheet, i, 3, "Blocked", outputpath);
			}
		}//i loop
	}
	

}
