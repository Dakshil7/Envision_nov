package com.envision.AutomationPractice.pages;

import org.openqa.selenium.WebDriver;
import reusables.BasePage;

public class AddressPage extends BasePage {
    WebDriver driver;
    AddressPage(WebDriver driver){
        this.driver=driver;
    }

    public ShippingPage clickonProceedToCheckout2() throws Exception {
        clickOn(driver,"checkoutpage.proceedtocheckoutbtn2");
        return new ShippingPage(driver);
    }
}
