package com.fleet.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fleet.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 5;	
	static JavascriptExecutor js;	
	private static FileInputStream fis = null;
	private static FileOutputStream fileOut = null;
	private static Workbook book = null;
	private static Sheet sheet;
	private static Cell Cell;
	private static Row Row;
	private static String path;

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	public static void Implicitwaitforelement() {
	driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
	
	public static WebElement waitforelement(WebDriver driver,WebElement element) {
		try {
			long WaitTime = 60;
	 element = new WebDriverWait(driver,WaitTime).until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();	
		}
	 return element;
	}
	public static void switchtab() {
	 Set<String> handles = driver.getWindowHandles();
	    String currentHandle = driver.getWindowHandle();
	    for (String handle : handles) {

	     if (!handle .equals(currentHandle))
	     {
	         driver.switchTo().window(handle);
	     }
	   }
	}
	public static void switchparenttab() {

	    String currentHandle = driver.getWindowHandle();
	   //go back to first tab if you want
	    driver.switchTo().window(currentHandle);
	}
	
	public static void setExcelFile() throws Exception{
		path = (System.getProperty("user.dir")+ "/src/main/resources/Test.xlsx");
//		path = "D:\\Test.xlsx";
		 fis = new FileInputStream(path);
		 book = new XSSFWorkbook(fis);
	}
	
	public static void WriteExcel(String colName, String data, int count) throws Exception {
		TestUtil.setExcelFile();
		 sheet = book.getSheet("Data");
		try 	{
		 Row = sheet.getRow(0);
			int colNum = -1;
			for (int i = 0; i < Row.getLastCellNum(); i++) {
				if (Row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum = i;
			}
			if (colNum == -1)
				return;

			try {
			 Cell = sheet.getRow(count).createCell(colNum);
				System.out.println("get Cell");
			} catch (Exception e) {
				Cell = sheet.createRow(count).createCell(colNum);
				System.out.println("Created Cell");
			}
			Cell = sheet.getRow(count).getCell(colNum);
			Cell.setCellValue(data);
			fileOut = new FileOutputStream(path);
			book.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {

			System.out.println("setCellData"+ e);
		}
	}
	
}	
	

