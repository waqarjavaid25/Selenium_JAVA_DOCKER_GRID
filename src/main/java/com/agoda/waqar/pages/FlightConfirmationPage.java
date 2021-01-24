package com.agoda.waqar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightConfirmationPage {

    WebDriver driver;
    WebDriverWait webDriverWait;
    @FindBy(xpath = "//font[contains(text(),'Flight Confirmation')]")
    private WebElement flightConfirmationHeader;
    @FindBy(xpath = "//font[contains(text(),'USD')]")
    private List<WebElement> prices;//driver.findElements ( By.xpath ( "//font[contains(text(),'USD')]" ) )
    @FindBy(linkText = "SIGN-OFF")
    private WebElement signOffLink;

    public FlightConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public String getPrice() {
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(flightConfirmationHeader));
        //    this.elementWait.until(ExpectedConditions.elementToBeClickable(prices))

        String header=flightConfirmationHeader.getText();
        String price=prices.get(1).getText();

        System.out.println();
        System.out.println(price);
        signOffLink.click();
        return price;
    }

}
