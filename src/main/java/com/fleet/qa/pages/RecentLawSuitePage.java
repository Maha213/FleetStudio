package com.fleet.qa.pages;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.Set;
import com.fleet.qa.base.TestBase;
import com.fleet.qa.util.TestUtil;

public class RecentLawSuitePage extends TestBase{
	
	//Page Factory - OR:

	@FindBy(id="hs-eu-confirmation-button")
	WebElement CookieAcceptPopup;
	
	@FindBy(id="hs-eu-confirmation-button1")
	WebElement CookieAlertPopup;
	
	@FindBy(xpath="//h2[.='Plaintiff']")
	WebElement PlaintiffTitle;
	
	@FindBy(xpath="//h2[.='Plaintiff']//parent::div//ul//li//span[.='Name:']//parent::li")
	WebElement PlaintiffName;
	
	@FindBy(xpath="//h2[.='Plaintiff']//parent::div//ul//li//span[.='Filing date:']//parent::li")
	WebElement PlaintiffFillingDate;
	
	@FindBy(xpath="//h2[.='Plaintiff']//parent::div//ul//li//span[.='State of filing:']//parent::li")
	WebElement PlaintiffStateofFilling;
	
	@FindBy(xpath="//h2[.='Defendant']//parent::div//ul//li//span[.='Name:']//parent::li")
	WebElement DefendantName;
	
	@FindBy(xpath="//h2[.='Defendant']//parent::div//ul//li//span[.='Website:']//parent::li")
	WebElement DefendantWebsite;
	
	@FindBy(xpath="//h2[.='Defendant']//parent::div//ul//li//span[.='Industry:']//parent::li")
	WebElement DefendantIndustry;
	
	@FindBy(xpath="//h2[.='Defendant']//parent::div//ul//li//span[.='Summary:']//parent::li")
	WebElement DefendantSummary;
	
	@FindBy(xpath="//div[@class='blog-pagination-right']/a/span[.='Last page number']/parent::a")
	WebElement Lastpagenumber;
	
	@FindBy(xpath="//div[@class='mostrecent-list post-listing active']//div[@class='postDetail']//a[@href]")
	List<WebElement> Recentlawsuiteinpage;
	
	@FindBy(xpath="//a[@class='next-link'][@href]")
	WebElement Nextlink;
	
	//Initializing the Page Objects:
	public RecentLawSuitePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public void Nextlink() throws Exception{
		Thread.sleep(5000);
		Nextlink.isDisplayed();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", Nextlink);
		Thread.sleep(5000);
	}
		
	public boolean validateCookiePopup() throws InterruptedException {
		TestUtil.waitforelement(driver, CookieAcceptPopup);
		return CookieAcceptPopup.isDisplayed();
	}
	
	public boolean validatealertsPopup()throws InterruptedException {
		return CookieAlertPopup.isDisplayed();
	}
	
	public RecentLawSuitePage ClickAcceptCookiePopup() throws Throwable {
		TestUtil.waitforelement(driver, CookieAcceptPopup);
		CookieAcceptPopup.click();
		return new RecentLawSuitePage();
	}

	public RecentLawSuitePage clicklawsuitepage(int a) throws Throwable{
		TestUtil.Implicitwaitforelement();
		for ( WebElement we: Recentlawsuiteinpage) {
		String clicklnk = Keys.chord(Keys.CONTROL,Keys.ENTER);
		we.sendKeys(clicklnk);
		TestUtil.Implicitwaitforelement();
		}
		return new RecentLawSuitePage();
		}

	
	public boolean ValidatePlaintiffpage() throws InterruptedException{
		TestUtil.waitforelement(driver, PlaintiffName);
		return PlaintiffName.isDisplayed();
	}
	
	public String GetplaintiffName() throws InterruptedException{
		return PlaintiffName.getText();
	}
	
	public String GetplaintiffFilingdate() throws InterruptedException{
		return PlaintiffFillingDate.getText();
	}
	
	public String GetPlaintiffStateofFilling() throws InterruptedException{
		return PlaintiffStateofFilling.getText();
	}
	
	public String GetDefendantName() throws InterruptedException{
		return DefendantName.getText();
	}
	
	public String GetDefendantWebsite() throws InterruptedException{
		return DefendantWebsite.getText();
	}
	
	public String GetDefendantIndustry() throws InterruptedException{
		return DefendantIndustry.getText();
	}
	
	public String GetDefendantSummary() throws InterruptedException{
		return DefendantSummary.getText();
	}
		
	public boolean AcceptCookiePopup() throws IOException, Throwable{
		boolean kywdResult;
		try {
		validateCookiePopup();
		ClickAcceptCookiePopup();
		kywdResult =true;
		}
		catch (NoSuchElementException e) {
			e.getStackTrace();
			TestUtil.takeScreenshotAtEndOfTest();
			kywdResult=false;
		}  	
		return kywdResult;
	}
	
	public boolean VerifyCookiePopup() throws IOException, Throwable{
		boolean kywdResult;
		try {
			validatealertsPopup();
		kywdResult =true;
		}
		catch (NoSuchElementException e) {
			e.getStackTrace();
			TestUtil.takeScreenshotAtEndOfTest();
			kywdResult=false;
		}  	
		return kywdResult;
	}
	
	
	public boolean Clickandnavigatelawsuitepage(int a) throws IOException, Throwable{
		boolean kywdResult;
		try {
			clicklawsuitepage(a);
			TestUtil.Implicitwaitforelement();
		kywdResult =true;
		}
		catch (NoSuchElementException e) {
			e.getStackTrace();
			TestUtil.takeScreenshotAtEndOfTest();
			kywdResult=false;
		}  	
		return kywdResult;
	}
		
	public boolean GetPlaintiffFillingDatevalue(int count) throws IOException, Throwable{
		boolean kywdResult;
		try {
//			ValidatePlaintiffpage();
			String data1=GetplaintiffFilingdate();
			String data=data1.replaceAll("Filing date:","").trim();
			System.out.println(data);
			TestUtil.WriteExcel("Filing date",data, count);
		kywdResult =true;
		}
		catch (NoSuchElementException e) {
			e.getStackTrace();
			TestUtil.takeScreenshotAtEndOfTest();
			kywdResult=false;
		}  	
		return kywdResult;
	}
	
	public boolean GetplaintiffStateoffilingvalue(int count) throws IOException, Throwable{
		boolean kywdResult;
		try {
//			ValidatePlaintiffpage();
			String data1=GetPlaintiffStateofFilling();
			String data=data1.replaceAll("State of filing:","").trim();
			System.out.println(data);
			TestUtil.WriteExcel("State of filing",data,count);
		kywdResult =true;
		}
		catch (NoSuchElementException e) {
			e.getStackTrace();
			TestUtil.takeScreenshotAtEndOfTest();
			kywdResult=false;
		}  	
		return kywdResult;
	}
	
	public boolean GetDefendantNamevalue(int count) throws IOException, Throwable{
		boolean kywdResult;
		try {
//			ValidatePlaintiffpage();
			String data1=GetDefendantName();
			String data=data1.replaceAll("Name:","").trim();
			System.out.println(data);
			TestUtil.WriteExcel("Defendant Name",data,count);
		kywdResult =true;
		}
		catch (NoSuchElementException e) {
			e.getStackTrace();
			TestUtil.takeScreenshotAtEndOfTest();
			kywdResult=false;
		}  	
		return kywdResult;
	}
	
	public boolean GetDefendantWebsitevalue(int count) throws IOException, Throwable{
		boolean kywdResult;
		try {
//			ValidatePlaintiffpage();
			String data1=GetDefendantWebsite();
			String data=data1.replaceAll("Website:","").trim();
			System.out.println(data);
			TestUtil.WriteExcel("Website",data,count);
		kywdResult =true;
		}
		catch (NoSuchElementException e) {
			e.getStackTrace();
			TestUtil.takeScreenshotAtEndOfTest();
			kywdResult=false;
		}  	
		return kywdResult;
	}
	
	public boolean GetDefendantSummaryvalue(int count) throws IOException, Throwable{
		boolean kywdResult;
		try {
//			ValidatePlaintiffpage();
			String data1=GetDefendantSummary();
			String data=data1.replaceAll("Summary:","").trim();
			System.out.println(data);
			TestUtil.WriteExcel("Summary",data,count);
		kywdResult =true;
		}
		catch (NoSuchElementException e) {
			e.getStackTrace();
			TestUtil.takeScreenshotAtEndOfTest();
			kywdResult=false;
		}  	
		return kywdResult;
	}
	
	public boolean GetDefendantIndustryvalue(int count) throws IOException, Throwable{
		boolean kywdResult;
		try {
//			ValidatePlaintiffpage();
			String data1=GetDefendantIndustry();
			String data=data1.replaceAll("Industry:","").trim();
			System.out.println(data);
			TestUtil.WriteExcel("Industry",data, count);
		kywdResult =true;
		}
		catch (NoSuchElementException e) {
			e.getStackTrace();
			TestUtil.takeScreenshotAtEndOfTest();
			kywdResult=false;
		}  	
		return kywdResult;
	}
	
	public boolean Getplaintiffnamevalue(int count) throws IOException, Throwable{
		boolean kywdResult;
		try {
			TestUtil.Implicitwaitforelement();
//			ValidatePlaintiffpage();
			String data1=GetplaintiffName();
			String data=data1.replaceAll("Name:","").trim();
			System.out.println(data);
			TestUtil.WriteExcel("Plaintiff Name",data,count);
		kywdResult =true;
		}
		catch (NoSuchElementException e) {
			e.getStackTrace();
			TestUtil.takeScreenshotAtEndOfTest();
			kywdResult=false;
		}  	
		return kywdResult;
	}
	
	public boolean GetFirstpagedigitallawsuitsvalue() throws IOException, Throwable{
		boolean kywdResult;
		try {
			Thread.sleep(2000);
			String originalWindow = driver.getWindowHandle();
			int count=0;
				for ( WebElement we: Recentlawsuiteinpage) {	
					++count;
					String clicklnk = Keys.chord(Keys.CONTROL,Keys.ENTER);
					we.sendKeys(clicklnk);
					Thread.sleep(3000);
					Set<String> windowHandle = driver.getWindowHandles();
					for (String childwindow : windowHandle) {
					    if(!originalWindow.equals(childwindow)) {
					        driver.switchTo().window(childwindow); 
				ValidatePlaintiffpage();
				System.out.println(count);
				Getplaintiffnamevalue(count);
				GetplaintiffStateoffilingvalue(count);
				GetPlaintiffFillingDatevalue(count);
				GetDefendantNamevalue(count);
				GetDefendantWebsitevalue(count);
				GetDefendantIndustryvalue(count);
				GetDefendantSummaryvalue(count);
				driver.close();	
					    }
			}
					driver.switchTo().window(originalWindow);
				}
			
		kywdResult =true;
		
		}
		catch (NoSuchElementException e) {
			e.getStackTrace();
			TestUtil.takeScreenshotAtEndOfTest();
			kywdResult=false;
		}
		return kywdResult;
	}
	public boolean GetAllpagedigitallawsuitsvalue() throws IOException, Throwable{
		boolean kywdResult;
		try {
			
			TestUtil.Implicitwaitforelement();
			
			String originalWindow = driver.getWindowHandle();
			int count=0;
			while(Nextlink.isDisplayed()) {
				for ( WebElement we: Recentlawsuiteinpage) {	
					++count;
					String clicklnk = Keys.chord(Keys.CONTROL,Keys.ENTER);
					we.sendKeys(clicklnk);
					TestUtil.Implicitwaitforelement();
					Set<String> windowHandle = driver.getWindowHandles();
					for (String childwindow : windowHandle) {
					    if(!originalWindow.equals(childwindow)) {
					        driver.switchTo().window(childwindow); 
				ValidatePlaintiffpage();
				System.out.println(count);
				Getplaintiffnamevalue(count);
				GetplaintiffStateoffilingvalue(count);
				GetPlaintiffFillingDatevalue(count);
				GetDefendantNamevalue(count);
				GetDefendantWebsitevalue(count);
				GetDefendantIndustryvalue(count);
				GetDefendantSummaryvalue(count);
				driver.close();	
					    }
			}
					driver.switchTo().window(originalWindow);
					if(count==18){  
			            //breaking the loop  
			            break;  
			        }
				}
				if(count==18){  
		            //breaking the loop  
		            break;  
		        }
				TestUtil.Implicitwaitforelement();
				Nextlink.isDisplayed();
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", Nextlink);
				TestUtil.Implicitwaitforelement();
				 
			}
				
			
		kywdResult =true;
		
		}
		catch (NoSuchElementException e) {
			e.getStackTrace();
			TestUtil.takeScreenshotAtEndOfTest();
			kywdResult=false;
		}
		return kywdResult;
	}		

public int GetLastpagenumber(){
	
	String s1 = Lastpagenumber.getText();
	String s=s1.replaceAll("Last page number","").trim();
	int i=Integer.parseInt(s); 
	
	return i;
	
}

public boolean GetAllpage() throws Exception, Throwable{
	boolean kywdResult;
	try {
while(Nextlink.isDisplayed()); {
		GetAllpagedigitallawsuitsvalue();
		Nextlink.click();
		Thread.sleep(3000);
		kywdResult=true;
}}
		catch (NoSuchElementException e) {
			e.printStackTrace();
			kywdResult=false;
		}
		return kywdResult;
}
		
	
}






	

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               