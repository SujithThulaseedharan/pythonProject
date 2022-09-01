package com.trello.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.trello.qa.base.TestBase;
import com.trello.qa.pages.BoardPage;
import com.trello.qa.pages.HomePage;
import com.trello.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	BoardPage boardPage;

	public LoginPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginPage = new LoginPage();

	}

	// @Test(priority=1, enabled = false)
	@Test(priority = 1)
	public void loginPageTitleVerification() {
		String title = loginPage.validateLoginPageTitle();
		System.out.println("Your page title is : " + title);
		Assert.assertEquals(title, "Manage Your Team’s Projects From Anywhere | Trello");
	}

	@Test(priority = 2)
	public void logoVerification() {

		boolean flag = loginPage.validateTrelloImage();
		Assert.assertTrue(flag);

	}

	@Test(priority = 3)
	public void loginVerification() throws InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
