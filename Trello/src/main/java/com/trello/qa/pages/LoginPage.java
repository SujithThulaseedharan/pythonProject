package com.trello.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trello.qa.base.TestBase;
import com.trello.qa.utils.Wait;

public class LoginPage extends TestBase{

	
	@FindBy(xpath = "//div[@class='Buttonsstyles__ButtonGroup-sc-1jwidxo-3 jnMZCI']//a[@class='Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr']")
	WebElement hLoginButton;
	
	@FindBy(id="user")
	WebElement user;
	

	@FindBy(id = "login")
	WebElement AtlassianLogin;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(xpath = "//*[@id=\"login-submit\"]/span/span")
	WebElement loginButton;
	
	@FindBy(xpath = "//div[@class='grid__Column-sc-p40pqe-2 drDANa ui-column']//img[@class='Picture__Image-sc-1wdxyb4-0 eYmxm']")
	WebElement logo;
	
	
	
	//Initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	//Action
	public  String validateLoginPageTitle() {
		System.out.println(driver.getTitle());
		return driver.getTitle();
		
	}
	public boolean validateTrelloImage() {
		
		try {return logo.isDisplayed();
			
		} catch (Exception e) {
			// TODO: handle exception
		}return false;
	}
	public HomePage login(String username, String userpassword) throws InterruptedException {
		Wait.toBeclickable(hLoginButton);
		hLoginButton.click();
		user.sendKeys(username);
		Wait.toBeclickable(AtlassianLogin);
		AtlassianLogin.click();
		Wait.toBeclickable(password);
		Thread.sleep(5000);
		password.sendKeys(userpassword);
		Wait.toBeclickable(loginButton);
		loginButton.click();
		return new HomePage();
		
	}
	
}
