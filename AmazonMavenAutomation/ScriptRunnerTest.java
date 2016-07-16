package com.testMaven.AmazonMavenAutomation;

import java.lang.reflect.Method;


public class ScriptRunnerTest extends ReUsableMethodTest{

	public static void main(String[] args) throws Exception {

		String dtTablePath = "/Users/dimple/Desktop/AmazonTestReports/AmazonTestSuit.xlsx";
		//Java Reflection Or Reflexive API
		String[][] readData = AutomationScriptTest.readExcel(dtTablePath, "Sheet 1");
		for(int i = 2 ;i < readData.length; i++){
			String RunNorun = readData[i][1];
			if(RunNorun.equalsIgnoreCase("Y")){
				String autoScript = readData[i][2];
				Method ts = AutomationScriptTest.class.getMethod(autoScript);
				ts.invoke(ts);
			}
			if(ReUsableMethodTest.countFails > 0){
				writeExcel(dtTablePath, "Sheet 1", i, 3, "Fail");
				fillTheCell(dtTablePath, "Sheet 1", i, 3, "RED");
				//hyperLink(dtTablePath,"Sheet 1", i, 3); 
			}
			else{
				writeExcel(dtTablePath, "Sheet 1", i, 3, "Pass");
				fillTheCell(dtTablePath, "Sheet 1", i, 3, "GREEN");
				//hyperLink(dtTablePath,"Sheet 1", i, 3);
			}
		}

	}
}


