package com.selenium;

import com.envision.selenium.pages.DirectoryPage;
import com.envision.selenium.pages.HomePage;
import com.envision.selenium.pages.LoginPage;
import com.envision.selenium.pages.MyInfoPage;
import org.testng.annotations.Test;
import reusables.BaseAssertion;
import reusables.BaseAssertion;
import reusables.BaseTest;
import reusables.PropertiesLoader;

public class OrangeHrmTest extends BaseTest {

    @Test
    public void validatePositiveFlowOrangeCrm() throws Exception {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.launchURL();
        loginpage.enterPassword();
        loginpage.enterUserName();

        HomePage homepage = loginpage.clickLoginBtn();
        boolean result = homepage.welcomeXXXIsDisplayed();
        BaseAssertion.shouldBeTrue(result);

        DirectoryPage directorypage = homepage.clickOnDirectoryTab();
        boolean checkURL = directorypage.checkIfSearchDirectoryIsOpen();
        BaseAssertion.shouldBeTrue(checkURL);
        directorypage.selectJobTitle();
        Thread.sleep(5000);
        directorypage.selectLocation();
        directorypage.enterName();
        directorypage.clickSearchBtn();
        boolean searchIsCorrect = directorypage.checkIfSearchIsCorrect();
        BaseAssertion.shouldBeTrue(searchIsCorrect);
        directorypage.clickWelcomeBtn();
        Thread.sleep(5000);

        loginpage=directorypage.clickLogOut();
        boolean logoutSuccessful = loginpage.checkIfLogOutSuccessful();
        BaseAssertion.shouldBeTrue(logoutSuccessful);

    }

    @Test
    public void validatePositiveFlowOfMyInfo() throws Exception {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.launchURL();
        loginpage.enterPassword();
        loginpage.enterUserName();

        HomePage homepage = loginpage.clickLoginBtn();
        boolean result = homepage.welcomeXXXIsDisplayed();
        BaseAssertion.shouldBeTrue(result);

        MyInfoPage myinfopage = homepage.clickOnMyInfoTab();
        boolean checkingURLOnmYInfoPage =myinfopage.checkIfYouArenOnMyInfoPage();
        BaseAssertion.shouldBeTrue(checkingURLOnmYInfoPage);
        boolean checkingFirstNameDisplayed = myinfopage.checkFirstNameDisplayed();
        BaseAssertion.shouldBeTrue(checkingFirstNameDisplayed);
        boolean checkingLastNameDisplayed=myinfopage.checkLastNameDisplayed();
        BaseAssertion.shouldBeTrue(checkingLastNameDisplayed);
        myinfopage.clickWelcomeBtn();
        Thread.sleep(5000);

        loginpage =myinfopage.clickLogOut();
        boolean logoutSuccessful =loginpage.checkIfLogOutSuccessful();
        BaseAssertion.shouldBeTrue(logoutSuccessful);
    }
}
