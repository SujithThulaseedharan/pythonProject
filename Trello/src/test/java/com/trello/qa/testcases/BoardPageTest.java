package com.trello.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.trello.qa.base.TestBase;
import com.trello.qa.pages.BoardPage;
import com.trello.qa.pages.HomePage;
import com.trello.qa.pages.LoginPage;

public class BoardPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	BoardPage boardPage;
	LoginPageTest loginpagetest;
	HomePageTest homepagetest;

	public BoardPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		// loginpagetest = new LoginPageTest();
		// loginpagetest.loginVerification();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepagetest = new HomePageTest();
		homepagetest.addNewBoard();

	}

	@Test(priority = 1)
	public void createCard() throws InterruptedException {
		boardPage = new BoardPage();
		boardPage.cardCreation();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}