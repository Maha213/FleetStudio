package com.fleet.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.fleet.qa.base.TestBase;
import com.fleet.qa.pages.RecentLawSuitePage;

public class RecentLawSuitePageTest extends TestBase{

	RecentLawSuitePage recentLawSuitePage;
	
	public RecentLawSuitePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		recentLawSuitePage = new RecentLawSuitePage();	
	}
	
	@Test(priority=2)
	public void VerifyCookiePopupfailure() throws Exception, Throwable{
		Assert.assertTrue(recentLawSuitePage.VerifyCookiePopup());	
		
	}
	
	@Test(priority=1)
	public void Getvaluefromfigitallawsuite() throws Exception, Throwable{
		Assert.assertTrue(recentLawSuitePage.AcceptCookiePopup());	
		Assert.assertTrue(recentLawSuitePage.GetAllpagedigitallawsuitsvalue());
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
