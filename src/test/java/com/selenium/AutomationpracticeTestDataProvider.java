package com.selenium;

import com.envision.AutomationPractice.pages.*;
import org.testng.annotations.Test;
import reusables.BaseAssertion;
import reusables.BaseTest;
import reusables.DataProviderArguments;
import reusables.DataProviderUtils;

public class AutomationpracticeTestDataProvider extends BaseTest {

    @DataProviderArguments(value = "AutomationpracticeTestDataProvider=username,password")
    @Test(dataProviderClass = DataProviderUtils.class,dataProvider = "jasonDataProvider")
    public void AutomationpracticeTestDataProvider(String email,String password) throws Exception {
        System.out.println(email+" "+password);
//        LoginPageWithDataProvider loginpage = new LoginPageWithDataProvider(driver);
//        loginpage.launchURL()
//                .clickSignIn()
//                .enterEmail(email)
//                .enterPassword(password);
//        Thread.sleep(2000);
//
//        HomePage homepage = loginpage.clickSubmit();
//
//        TshirtPage tpage = homepage.clickOnTshirts();
//        tpage.clickOnTshirtImage()
//                .clickOnAddToCart();
//        Thread.sleep(2000);
//        boolean addedToCartText = tpage.checkAddedToCartText();
//        BaseAssertions.shouldBeTrue(addedToCartText);
//
//        SummaryPage summaryPage =tpage.clickOnCheckOut();
//        Thread.sleep(2000);
//        summaryPage.checkTotalPrice();
//
//        AddressPage addressPage =summaryPage.clickOnPreceedToCheckout();
//
//        ShippingPage shippingPage=addressPage.clickonProceedToCheckout2();
//        shippingPage.clickOnTermBtn()
//                .checkShippingCost();
//
//        PaymentPage paymentPage=shippingPage.clickOnPreceedToCheckout3();
//        paymentPage.clickOnWire()
//                .clickOnConfirm();
//
//        boolean result = paymentPage.checkConfirmationText();
//        BaseAssertions.shouldBeTrue(result);
//
//        paymentPage.fetchTotalPrice()
//                .fetchName()
//                .fetchBankName();
    }
}
