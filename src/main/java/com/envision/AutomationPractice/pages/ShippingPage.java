package com.envision.AutomationPractice.pages;

import org.openqa.selenium.WebDriver;
import reusables.BasePage;

public class ShippingPage extends BasePage {
    WebDriver driver;
    ShippingPage(WebDriver driver){
        this.driver = driver;
    }

    public ShippingPage clickOnTermBtn() throws Exception {
        clickOn(driver,"shippingpage.termsbtn");
        return this;
    }

    public ShippingPage checkShippingCost() throws Exception {
        String shippingCostString = findElement(driver,"shippingpage.shippingcost").getText();
        System.out.println(shippingCostString);
        String shippingCostWithout$ = shippingCostString.substring(1);
        Float shippingCostInInt = Float.valueOf(shippingCostWithout$);
        if(shippingCostInInt<=5){
            System.out.println("Shipping Cost Is Less Than $5");
            return this;
        }else{
            return null;
        }
    }

    public PaymentPage clickOnPreceedToCheckout3() throws Exception {
        clickOn(driver,"checkoutpage.proceedtocheckoutbtn3");
        return new PaymentPage(driver);
    }
}
