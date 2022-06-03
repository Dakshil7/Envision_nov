package com.selenium;

import com.envision.AutomationPractice.pages.*;
import org.testng.annotations.Test;
import reusables.BaseAssertion;
import reusables.BaseAssertion;
import reusables.BaseTest;

public class AutomationpracticeTest extends BaseTest {

    @Test
    public void automationPracticeTest1() throws Exception {

        LoginPage loginpage = new LoginPage(driver);
        loginpage.launchURL()
                .clickSignIn()
                .enterEmail()
                .enterPassword();
        Thread.sleep(2000);

        HomePage homepage = loginpage.clickSubmit();

        TshirtPage tpage = homepage.clickOnTshirts();
        tpage.clickOnTshirtImage()
                .clickOnAddToCart();
        Thread.sleep(2000);
        boolean addedToCartText = tpage.checkAddedToCartText();
        BaseAssertion.shouldBeTrue(addedToCartText);

        SummaryPage summaryPage =tpage.clickOnCheckOut();
        Thread.sleep(2000);
        summaryPage.checkTotalPrice();

        AddressPage addressPage =summaryPage.clickOnPreceedToCheckout();

        ShippingPage shippingPage=addressPage.clickonProceedToCheckout2();
        shippingPage.clickOnTermBtn()
                .checkShippingCost();

        PaymentPage paymentPage=shippingPage.clickOnPreceedToCheckout3();
        paymentPage.clickOnWire()
                .clickOnConfirm();

        boolean result = paymentPage.checkConfirmationText();
        BaseAssertion.shouldBeTrue(result);

        paymentPage.fetchTotalPrice()
                .fetchName()
                .fetchBankName();
    }
}
