package com.envision.AutomationPractice.pages;

import org.openqa.selenium.WebDriver;
import reusables.BasePage;

public class TshirtPage extends BasePage {

    WebDriver driver;
    TshirtPage(WebDriver driver){
        this.driver=driver;
    }

    public TshirtPage clickOnTshirtImage() throws Exception {
        clickOn(driver,"tshirtpage.tshirtimage");
        return this;
    }

    public TshirtPage clickOnAddToCart() throws Exception {
        clickOn(driver,"tshirtpage.addtocart");
        return this;
    }

    public boolean checkAddedToCartText() throws Exception {
        String addedToCartText = findElement(driver,"tshirtpage.confirmtext").getText();
        boolean result = addedToCartText.contains("Product successfully added to your shopping cart");
        return result;
    }

    public SummaryPage clickOnCheckOut() throws Exception {
        clickOn(driver,"tshirtpage.checkout");
        return new SummaryPage(driver);
    }
}
