package com.trello.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trello.qa.base.TestBase;
import com.trello.qa.utils.Wait;

public class HomePage extends TestBase {
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(xpath = "//span[@class='_9SWxH3f490pDnE']//span[@class='icon-board icon-sm _9SWxH3f490pDnE']")
	WebElement boardButton;
	
	@FindBy(xpath = "//li[@class=\"boards-page-board-section-list-item\"]//div[@class='board-tile mod-add']")
	WebElement createNewBoard;
	
	@FindBy(xpath = "//label[@class='Yb0we30YG32Gdb']//input[@class='nch-textfield__input Hj0IB7nx8rs7UO Hj0IB7nx8rs7UO ysTE7s-UXRkpYP']")
	WebElement boardTitle;
	
	@FindBy(xpath = "//button[@class='G2lWjDVJsvar3H Ts+YceGnvTbKoG HPCwi137Em5EYI JIXQq8gDYY04N6']")
	WebElement bCreateButton;
	
	
	
	
	public void boardCreation() throws InterruptedException {
		
		Wait.toBeclickable(boardButton);
		boardButton.click();
		Wait.toBeclickable(createNewBoard);
		createNewBoard.click();
		boardTitle.sendKeys(prop.getProperty("boardtitle"));
		Wait.toBeclickable(bCreateButton);
		bCreateButton.click();
		
		
		
	}
	
}
