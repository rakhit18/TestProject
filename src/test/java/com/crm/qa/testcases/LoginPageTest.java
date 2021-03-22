package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;

import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	//@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	//@Test(priority=2)
	/*
	 * public void crmLogoImageTest(){ boolean flag = loginPage.validateCRMImage();
	 * Assert.assertTrue(flag); }
	 */
	public static void takeScreenshot(String fileName) throws IOException{
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// now copy the screenshot to desired location using copyFile //method
		FileUtils.copyFile(src, 
				new File("/Users/rakhitrivedi/Documents/screenshots/" + fileName +".png"));

	}

	
	@Test(priority=3)
	public void loginTest() throws InterruptedException, IOException{
		String metaData = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("Custom Information\n"
				+ "test:\n"
				+ "test\n"
				+ "New label\n"
				+ "Add description");
		if (metaData.equals("Custom Information\n"+ "test:\n"+ "test\n"
				+ "New label\n"
				+ "Add description"))
		{
			System.out.println("Custom Information\\n\""+ "test:\n"+ "test\n"
					+ "New label\n"
					+ "Add description");	
			Assert.assertTrue(true);
		} 
	else {
			
			//TODO: Finish ScreenShot error
			//takeScreenshot("metaDataPage");
			Assert.assertTrue(false);
		}

		
		Assert.assertEquals(metaData, "Custom Information\n"
				+ "test:\n"
				+ "test\n"
				+ "New label\n"
				+ "Add description");
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
