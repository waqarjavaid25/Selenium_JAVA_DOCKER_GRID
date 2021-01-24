package com.agoda.waqar.test.pages;


import com.agoda.waqar.pages.*;
import com.agoda.waqar.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookingFlightTest extends BaseTest {

    private String noOfPassengers;
    private String  expectedPrice;


    @BeforeTest
    @Parameters({"noOfPassengers","expectedPrice"})
    public void setUpParameter(String noOfPassengers,String expectedPrice ){
        this.noOfPassengers=noOfPassengers;
        this.expectedPrice=expectedPrice;
    }

    @Test(priority = 0)
    protected void RegistrationPageTest() {

        RegistrationPage registrationPage = new RegistrationPage (driver);

        registrationPage.goTo();
        registrationPage.enterUserDetails ( "selenium", "docker" );
        registrationPage.enterUserCredential ( "slenium", "docker" );
        registrationPage.submit ();
    }
    @Test(priority = 1)
    protected void registrationConfirmationPage() {

        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage (driver);
        registrationConfirmationPage.goToFlightDetailPage ();
    }
    @Test(priority = 2)
    protected void flightDetailPage() {

        FlightDetailPage flightDetailPage = new FlightDetailPage(driver);
        flightDetailPage.selectPassengers ( this.noOfPassengers );
        flightDetailPage.goToFlightPage ();
    }
    @Test(priority = 3)
    protected void flightPage() {

        FindFlightPage findFlightPage = new FindFlightPage(driver);
        findFlightPage.goToOrderConfirmationPage ();
        findFlightPage.submitFindFlightPage ();
    }
    @Test(priority = 4)
    protected void flightConfirmationPage() {

        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
        String actualPrice=flightConfirmationPage.getPrice();
        System.out.println(actualPrice);
        Assert.assertEquals(actualPrice,this.expectedPrice);
    }

}
