package com.envision.AutomationPractice.pages;

import org.openqa.selenium.WebDriver;
import reusables.BasePage;

public class PaymentPage extends BasePage {
    WebDriver driver;
    PaymentPage(WebDriver driver){
        this.driver=driver;
    }

    public PaymentPage clickOnWire() throws Exception {
        clickOn(driver,"paymentpage.paybywire");
        return this;
    }

    public PaymentPage clickOnConfirm() throws Exception {
        clickOn(driver,"paymentpage.confirm");
        return this;
    }

    public boolean checkConfirmationText() throws Exception {
        String corfirmationText=findElement(driver,"paymentpage.text").getText();
        boolean result = corfirmationText.equalsIgnoreCase("Your order on My Store is complete.");
        return result;
    }

    public PaymentPage fetchTotalPrice() throws Exception {
        String priceOfItem = findElement(driver,"paymentpage.totalprice").getText();
        System.out.println(priceOfItem);
        return this;
    }

    public PaymentPage fetchName() throws Exception {
        String name= findElement(driver,"paymentpage.name").getText();
        System.out.println(name);
        return this;
    }

    public PaymentPage fetchBankName() throws Exception {
        String bankName= findElement(driver,"paymentpage.bankname").getText();
        System.out.println(bankName);
        return this;
    }
}
