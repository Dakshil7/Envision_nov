package com.selenium;

import com.envision.GooglePages.HomePage;
import com.envision.GooglePages.LoginPage;
import org.testng.annotations.Test;
import reusables.BaseTest;

public class GoogleTest1 extends BaseTest {

    @Test
    public void checkTest() throws Exception {
        LoginPage lg = new LoginPage(driver);
        lg.launchURL();
        lg.enterText();
        HomePage hg = lg.clickOnSearch();
        hg.clickOnTool();

    }


}
