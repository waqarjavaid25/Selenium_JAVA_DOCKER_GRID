package com.agoda.waqar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    WebDriver driver;
    WebDriverWait webDriverWait;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "firstName")
    private WebElement firstNameTxt;

    @FindBy(name = "lastName")
    private WebElement lastNameTxt;

    @FindBy(name = "email")
    private WebElement userNameTxt;

    @FindBy(name = "password")
    private WebElement passwordTxt;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(name = "register")
    private WebElement submitBtn;

    public void goTo() {
        driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");

    }

    public void enterUserDetails(String firstName, String lastName) {
        firstNameTxt.sendKeys(firstName);
        lastNameTxt.sendKeys(lastName);
    }

    public void enterUserCredential(String userName, String password) {
        userNameTxt.sendKeys(userName);
        passwordTxt.sendKeys(password);
        confirmPasswordTxt.sendKeys(password);
    }

    public void submit() {
        submitBtn.click();
    }

}
