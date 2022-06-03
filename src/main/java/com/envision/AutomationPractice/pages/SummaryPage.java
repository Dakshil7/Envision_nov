package com.envision.AutomationPractice.pages;

import org.openqa.selenium.WebDriver;
import reusables.BasePage;

public class SummaryPage extends BasePage {
    WebDriver driver;
    SummaryPage(WebDriver driver){
        this.driver=driver;
    }

    public SummaryPage checkTotalPrice() throws Exception {
        String totalPrice = findElement(driver,"checkoutpage.totalprice").getText();
        String totalPricewithout$=totalPrice.substring(1);
        System.out.println(totalPricewithout$);
        Float totalPriceInInt = Float.valueOf(totalPricewithout$);
        if (totalPriceInInt<20){
            System.out.println("Total Price is Less Than $20");
            return this;
        }else {
            return null;
        }
    }

    public AddressPage clickOnPreceedToCheckout() throws Exception {
        clickOn(driver,"checkoutpage.proceedtocheckoutbtn");
        return new AddressPage(driver);
    }
}
