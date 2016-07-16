package com.testMaven.AmazonMavenAutomation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.Color;
public class ReUsableMethodTest {
	static int countFails = 0;

	static BufferedWriter bw = null;
	static BufferedWriter bw1 = null;
	static String htmlname;
	static String objType;
	static String objName;
	static String TestData;
	static String rootPath;
	static int report;


	static Date cur_dt = null;
	static String filenamer;
	static String TestReport;
	int rowcnt;
	static String exeStatus = "True";
	static int iflag = 0;
	static int j = 1;

	static String fireFoxBrowser;
	static String chromeBrowser;

	static String result;

	static int intRowCount = 0;
	static String dataTablePath;
	static int i;
	static String browserName;

	/* Name of the Method: startReport
	 * Brief description: Start creating a report 
	 * Arguments: scriptName --> String , ReportsPath --> String 
	 * Created By: TechPirates 
	 * Creation Date: June 29 2016
	 * Last Modified: June 29 2016
	 * */
	public static void startReport(String scriptName, String ReportsPath) throws Exception{

		String strResultPath = null;


		String testScriptName =scriptName;


		cur_dt = new Date(); 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String strTimeStamp = dateFormat.format(cur_dt);

		if (ReportsPath == "") { 

			ReportsPath = "C:\\";
		}

		if (ReportsPath.endsWith("\\")) { 
			ReportsPath = ReportsPath + "\\";
		}

		strResultPath = ReportsPath + "Log" + "/" +testScriptName +"/"; 
		File f = new File(strResultPath);
		f.mkdirs();
		htmlname = strResultPath  + testScriptName + "_" + strTimeStamp 
				+ ".html";



		bw = new BufferedWriter(new FileWriter(htmlname));

		bw.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR><TD BGCOLOR=#66699 WIDTH=27%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Browser Name</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"
				+ "FireFox " + "</B></FONT></TD></TR>");
		bw.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR COLS=7><TD BGCOLOR=#BDBDBD WIDTH=3%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>SL No</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Step Name</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Execution Time</B></FONT></TD> "
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Status</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=47%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Detail Report</B></FONT></TD></TR>");


	}

	/* Name of the Method: Update_Report
	 * Brief description: Updating a report 
	 * Arguments: scriptName --> String , ReportsPath --> String 
	 * Created By: TechPirates 
	 * Creation Date: June 29 2016
	 * Last Modified: June 29 2016
	 * */
	public static void Update_Report(String Res_type,String Action, String result) throws Exception {
		String str_time;
		Date exec_time = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		str_time = dateFormat.format(exec_time);
		if (Res_type.startsWith("Pass")) {
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ "Passed"
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ result + "</FONT></TD></TR>");

		} else if (Res_type.startsWith("Fail")) {
			exeStatus = "Failed";
			report = 1;
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
					+ "<a href= "
					+ htmlname
					+ "  style=\"color: #FF0000\"> Failed </a>"

				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
				+ result + "</FONT></TD></TR>");
			countFails ++;

		} 
	}
	//Reading a excel file reusable function

	public static  String[][] readExcel(String dtTablePath, String sheetname) throws Exception{
		//Step1: Get the XLs Path
		File xlFile = new File(dtTablePath);
		//Step2: Access the Xls file
		FileInputStream xlDoc = new FileInputStream(xlFile);
		//Step3: Access the workBook (need to have POI jar file) Eclipse need support to read through xls
		XSSFWorkbook myWorkbook = new XSSFWorkbook(xlDoc);
		//Step4: Access the sheet
		XSSFSheet sheet = myWorkbook.getSheet(sheetname);

		int rowCount = sheet.getPhysicalNumberOfRows(); // get count of physical row present in sheet // 5
		//Returns the number of physically defined rows (NOT the number of rows in the sheet)
		//int rowCount = sheet.getLastRowNum()+1;//getLastRowNum starts from 0 so it count one less//4+1 =5
		//Returns the logical row (not physical) 0-based.
		int colCount = sheet.getRow(0).getLastCellNum();

		//System.out.println(rowCount+ " rowCount " +rowCount);

		String[][] xlData = new String[rowCount][colCount];

		for(int i=0; i< rowCount; i++){
			for(int j =0; j< colCount; j++){
				xlData[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}

		return xlData;
	}

	//Write in Excel
	public static  void writeExcel(String dtTablePath, String sheetname, int iRow, int iCol, String txtVal) throws Exception{
		File xlFile = new File(dtTablePath);
		//Step2: Access the Xls file
		FileInputStream xlDoc = new FileInputStream(xlFile);

		//Step3: Access the workBook (need to have POI jar file) Eclipse need support to read through xls
		XSSFWorkbook myWorkbook = new XSSFWorkbook(xlDoc);
		//Step4: Access the sheet
		XSSFSheet sheet = myWorkbook.getSheet(sheetname);

		//Access Row
		XSSFRow row = sheet.getRow(iRow);

		//Access Column
		XSSFCell cell = row.getCell(iCol);

		cell.setCellValue(XSSFCell.CELL_TYPE_STRING);
		cell.setCellValue(txtVal);

		//Fill the color in cell
		XSSFCellStyle titleStyle = myWorkbook.createCellStyle();
		titleStyle.setFillForegroundColor(new XSSFColor(java.awt.Color.GREEN));
		//titleStyle.setFillForegroundColor(new XSSFColor.Green().getIndex());
		titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cell.setCellStyle(titleStyle);


		FileOutputStream fout = new FileOutputStream(dtTablePath);
		myWorkbook.write(fout);
		fout.flush();
		fout.close();

	}
	//Fill The cell Color
	public static  void fillTheCell(String dtTablePath, String sheetname, int iRow, int iCol, String color) throws IOException{
		File xlFile = new File(dtTablePath);
		//Step2: Access the Xls file
		FileInputStream xlDoc = new FileInputStream(xlFile);

		//Step3: Access the workBook (need to have POI jar file) Eclipse need support to read through xls
		XSSFWorkbook myWorkbook = new XSSFWorkbook(xlDoc);
		//Step4: Access the sheet
		XSSFSheet sheet = myWorkbook.getSheet(sheetname);

		//Access Row
		XSSFRow row = sheet.getRow(iRow);

		//Access Column
		XSSFCell cell = row.getCell(iCol);
		//Fill the color in cell
		XSSFCellStyle titleStyle = myWorkbook.createCellStyle();
		if(color.equalsIgnoreCase("GREEN")){
			XSSFColor myColor = new XSSFColor(java.awt.Color.GREEN);
			titleStyle.setFillForegroundColor(myColor);
		}
		if(color.equalsIgnoreCase("RED")){
			XSSFColor myColor = new XSSFColor(java.awt.Color.RED);
			titleStyle.setFillForegroundColor(myColor);
		}

		//titleStyle.setFillForegroundColor(new HSSFColor.Green().getIndex());
		titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cell.setCellStyle(titleStyle);


		FileOutputStream fout = new FileOutputStream(dtTablePath);
		myWorkbook.write(fout);
		fout.flush();
		fout.close();

	}





	/* Name of the Method: enterText
	 * Brief description: Enter text value to text boxes 
	 * Arguments: obj --> webelement Object, textVal --> text to be entered, objName --> Object Name
	 * Created By: TechPirates 
	 * Creation Date: June 29 2016
	 * Last Modified: June 29 2016
	 * */
	public static void enterText(WebElement obj, String textVal, String objName) throws Exception{


		if(obj.isDisplayed()){
			obj.sendKeys(textVal);
			Update_Report("Pass", "enterText", textVal+ "  is entered in " + objName + " field");
		}else{
			Update_Report("Fail", "enterText", objName + " field is not displayed please check your application ");
		}

	}


	/* Name of the Method: clickButton
	 * Brief description: Click on Web Button 
	 * Arguments: obj --> webelement Object,objName --> Object Name
	 * Created By: TechPirates 
	 * Creation Date: June 29 2016
	 * Last Modified: June 29 2016
	 * */
	public static void clickButton(WebElement obj, String objName) throws Exception{
		if(obj.isDisplayed()){
			obj.click();
			Update_Report("Pass", "clickButton", objName + " is clicked");
		}
		else{
			Update_Report("Fail", "clickButton",  objName + " Button is not displayed please check your application");

		}
	}
	/* Name of the Method: validateTextMessage
	 * Brief description: validating Text message
	 * Arguments: obj --> webelement Object,objName --> Object Name
	 * Created By: TechPirates 
	 * Creation Date: June 29 2016
	 * Last Modified: June 29 2016
	 * */
	public static void validateText(WebElement obj, String expectedMsg, String objname) throws Exception{


		if(obj.isDisplayed()){
			String actualMsg = obj.getText().trim();
			if(expectedMsg.equals(actualMsg)){

				Update_Report("Pass","validateTextMessage", "Actual text '" + actualMsg+"' is matched with expected text "+expectedMsg);

			}
			else{

				Update_Report("Fail","validateTextMessage", "Actual text '" + actualMsg+"' is not matched with expected text "+expectedMsg);

			}
		}
		else{
			Update_Report("Fail", "validateTextMessage",  objname + " Button is not displayed please check your application");

		}

	}


	/* Name of the Method: validateTextInDropdn
	 * Brief description: validate drop down menu text //div -tag
	 * Arguments: obj --> webelement Object,objName --> Object Name
	 * Created By: TechPirates 
	 * Creation Date: July 4 2016
	 * Last Modified: July 4 2016
	 * */
	public static void validateTextInDropdn(WebElement obj, String[] expMenuItemes, String objname) throws Exception{
		String[] actualStr = obj.getText().split("[\\r\\n]+");
		if(obj.isDisplayed()){
			for(int i = 0; i < expMenuItemes.length; i++){

				if(actualStr[i].equals(expMenuItemes[i])){
					Update_Report("Pass", "validateTextInDropdn",  "Expected menu item is: "  +expMenuItemes[i]+ " is matched to actual item: "+actualStr[i]);

				}
				else{
					Update_Report("Fail", "validateTextInDropdn",  "Expected menu item is: "  +expMenuItemes[i]+ " is not matched to actual item: "+actualStr[i]);

				}

			}

		}
		else{
			Update_Report("Fail", "validateTextInDropdn",  objname + " DropDown menu is not displayed please check your application");

		}
	}

	/* Name of the Method: isDisplayed
	 * Brief description: isDisplayed and Validate value to text 
	 * Arguments: obj --> webelement Object, position --> position of searc drop down , objName --> Object Name
	 * Created By: TechPirates 
	 * Creation Date: July 15 2016
	 * Last Modified: July 15 2016
	 * */
	public static void isDisplayed(WebElement obj, String position, String objName) throws Exception{
		if(obj.isDisplayed()){
			String actualMsg = obj.getText().trim();
				Update_Report("Pass","isDisplayed", position+ " DropDown Search option '"+ actualMsg+ "' is Displayed");	
		}
		else{
			Update_Report("Fail", "isDisplayed",  objName + " Button is not displayed please check your application");

		}	

	}
	/* Name of the Method: changeColorMouseOver
	 * Brief description: object will change color after mouse over
	 * Arguments: obj --> webelement Object,objName --> Object Name
	 * Created By: TechPirates 
	 * Creation Date: July 15 2016
	 * Last Modified: July 15 2016
	 * */
	public static void changeColorMouseOver(WebDriver driver, WebElement obj, String objName) throws Exception{
		if(obj.isDisplayed()){
			
		Update_Report("Pass", "changeColorMouseOver", obj.getText() +" is Displayed, and Before mouse over color is "+obj.getCssValue("color"));
		Actions action = new Actions(driver);
		action.moveToElement(obj).build().perform();
		Update_Report("Pass", "changeColorMouseOver", "After mouse over color is "+obj.getCssValue("color"));
		}
		else{
			Update_Report("Fail", "changeColorMouseOver", objName + " Element is not displayed please check your application");
		}
		
	}
	/* Name of the Method: MouseOver
	 * Brief description: mouse over action performed over object
	 * Arguments: obj --> webelement Object,objName --> Object Name
	 * Created By: TechPirates 
	 * Creation Date: July 15 2016
	 * Last Modified: July 15 2016
	 * */
	public static void mouseOver(WebDriver driver, WebElement obj, String objName) throws Exception{
		if(obj.isDisplayed()){
		Actions action = new Actions(driver);
		action.moveToElement(obj).build().perform();
		Update_Report("Pass", "mouseOver", obj.getText() +" is Displayed");
		}
		else{
			Update_Report("Fail", "changeColorMouseOver", objName + " Element is not displayed please check your application");
		}
		
	}
	
	/* Name of the Method: isSelected
	 * Brief description: object is selected.
	 * Arguments: obj --> webelement Object,objName --> Object Name
	 * Created By: TechPirates 
	 * Creation Date: July 15 2016
	 * Last Modified: July 15 2016
	 * */
	public static void isDeSelected(WebElement obj, String objName ) throws Exception{
		if(obj.isDisplayed()){
			if(!obj.isSelected()){
				Update_Report("Pass", "isDeSelected", obj.getAttribute("alt") + " is displayed and unchecked");
			}
			else{
				Update_Report("Fail", "isDeSelected", obj.getAttribute("alt") + " is displayed and checked");
			}
		}
		else{
			Update_Report("Fail", "isDeSelected", objName + " is not displayed Please check your application");
		}
	}
	/* Name of the Method: isEnabled
	 * Brief description: object is Enabled.
	 * Arguments: obj --> webelement Object,objName --> Object Name
	 * Created By: TechPirates 
	 * Creation Date: July 15 2016
	 * Last Modified: July 15 2016
	 * */
	public static void isDeactivated(WebElement obj, String objName ) throws Exception{
		if(obj.isDisplayed()){
			if(obj.isEnabled()){
				Update_Report("Fail", "isDeactivated", objName + " is displayed and enabled");
			}
			else{
				Update_Report("Pass", "isDeactivated", objName + " is displayed and deactivated");
			}
		}
		else{
			Update_Report("Fail", "isDeactivated", objName + " is not displayed Please check your application");
		}
	}
	

}
