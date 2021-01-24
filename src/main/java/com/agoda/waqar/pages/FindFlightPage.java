package com.agoda.waqar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage {

    WebDriver driver;
    WebDriverWait webDriverWait;

    public FindFlightPage(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "reserveFlights")
    WebElement firstSubmitBtn;

    @FindBy(name = "buyFlights")
    WebElement secondSubmitBtn;

    public void submitFindFlightPage() {
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(secondSubmitBtn));
        secondSubmitBtn.click();
    }

    public void goToOrderConfirmationPage(){
        this.webDriverWait.until(ExpectedConditions.visibilityOf(firstSubmitBtn));
        this.firstSubmitBtn.click();
    }


}
