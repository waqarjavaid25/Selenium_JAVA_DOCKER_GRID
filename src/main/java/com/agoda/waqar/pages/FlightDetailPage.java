package com.agoda.waqar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailPage {

    WebDriver driver;
    WebDriverWait webDriverWait;

    public FlightDetailPage(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "passCount")
    WebElement passengers;

    @FindBy(name = "findFlights")
    WebElement submitBtn;

    public void selectPassengers(String noOfPassenger){
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(passengers));
        Select select=new Select(passengers);
        select.selectByValue(noOfPassenger);
    }

    public void goToFlightPage(){
        this.webDriverWait.until(ExpectedConditions.visibilityOf(submitBtn));
        this.submitBtn.click();
    }
}
