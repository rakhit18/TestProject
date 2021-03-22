package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

import freemarker.log.Logger;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(id="myaccount-button")
	WebElement account;
	
	@FindBy(id="Thermofisher-two-step-login-username")
	WebElement myaccount;
	
	@FindBy(id="next-button")
	WebElement nbutton;
	
	@FindBy(name="loginID")
	WebElement loginId;
	
	@FindBy(id="username-field")
	WebElement username;
	
	@FindBy(id="password-field")
	WebElement password;
	
	
	
	@FindBy(id="signin-button")
	WebElement signUpBtn;
	
	@FindBy(linkText="Account")
	WebElement acct;
	
	@FindBy(xpath="//a[contains(text(),'Connect: Lab, Data, Apps')]")
	WebElement labData;
	
	@FindBy(xpath="//div[@id='myaccount-div']/div/div/div/li/a")
	WebElement menuOption;

	@FindBy(linkText="Tutorials")
	WebElement tutorial;

	@FindBy(linkText="Upload a file")
	WebElement upload;
	
	@FindBy(id="uploadLink_tutorial")
	WebElement uploadLink;

	@FindBy(id="closeBtn")
	WebElement closeBtn;
	
	@FindBy(id="view-files-link")
	WebElement fileLink;
	
	

	
//identify menu option from the resulting menu display and click
    

	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	//public boolean validateCRMImage(){
		
		//return crmLogo.isDisplayed();
	//}
	
	public String login(String un, String pwd) throws InterruptedException{
		account.click();
		Thread.sleep(5000);
		myaccount.click();
		loginId.isDisplayed();
		username.sendKeys(un);
		nbutton.click();
		long timeoutInSeconds=5000;
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password-field")));
		password.sendKeys(pwd);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signin-button")));
		signUpBtn.click();
		//Thread.sleep(5000);
		
		 Actions action = new Actions(driver);
		    action.moveToElement(acct).build().perform();
		    action.moveToElement(labData).click();
		menuOption.click();
		//Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Tutorials")));
		tutorial.click();
		//Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Upload a file")));
		upload.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadLink_tutorial")));
		uploadLink.click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("closeBtn")));
		driver.switchTo().frame(0);
		closeBtn.click();
		//
		driver.switchTo().defaultContent();
		fileLink.click();
		//wait();
		driver.switchTo().defaultContent();
		
		driver.findElement(By.id("row_FILE:_0")).click();
	    driver.findElement(By.id("dataConnectSDKOverlay")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='data']/div/div")));
	    Thread.sleep(5000);
	    String ele = driver.findElement(By.xpath("//div[@id='data']/div/div")).getText();
        
        //Logger log = Logger.getLogger(ele);
        //log.debug(ele);
        System.out.println("This is just test "+ ele);
        driver.close();
	    //loginBtn.click();
		    	//JavascriptExecutor js = (JavascriptExecutor)driver;
		    	//js.executeScript("arguments[0].click();", loginBtn);
		    return ele;	
	
	}
	
}
