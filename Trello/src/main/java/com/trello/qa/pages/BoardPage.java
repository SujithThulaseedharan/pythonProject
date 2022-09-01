package com.trello.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trello.qa.base.TestBase;
import com.trello.qa.utils.Wait;

public class BoardPage extends TestBase {

	public BoardPage() {
		PageFactory.initElements(driver, this);

	}



	@FindBy(xpath = "//*[@id=\"board\"]/div[1]/div/div[2]/div/div[1]/div/textarea")
	WebElement cardName;

	@FindBy(xpath = "//input[@class='nch-button nch-button--primary confirm mod-compact js-add-card']")
	WebElement addCardButton;

	public void cardCreation() throws InterruptedException {
		cardName.sendKeys(prop.getProperty("cardname"));
		Wait.toBeclickable(addCardButton);
		addCardButton.click();

	}
}
