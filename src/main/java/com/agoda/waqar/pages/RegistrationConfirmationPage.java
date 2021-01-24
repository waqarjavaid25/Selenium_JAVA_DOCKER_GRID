package com.agoda.waqar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmationPage {

    WebDriver driver;
    WebDriverWait webDriverWait;

    public RegistrationConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    @FindBy (partialLinkText = "sign-in")
    WebElement signinLink;

    @FindBy (linkText = "Flights")
    WebElement flightLink;

    public void goToFlightDetailPage(){
        this.webDriverWait.until(ExpectedConditions.visibilityOf(signinLink));
        this.flightLink.click();
    }

}
