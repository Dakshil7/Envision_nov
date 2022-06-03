package com.selenium;

import com.envision.selenium.pages.DirectoryPage;
import com.envision.selenium.pages.HomePage;
import com.envision.selenium.pages.LoginPage;
import com.envision.selenium.pages.MyInfoPage;
import org.testng.annotations.Test;
import reusables.BaseAssertion;
import reusables.BasePage;
import reusables.BaseTest;

//import static reusables.BasePage.using;

//MADE THIS CLASS TEST TO LEARN HOW WE USE GENERIC METHOD FROM BASE PAGE WITH A INTENT OF NOT MAKING OBJECT OF DIFFRENT PAGE EVERY TIME
//SEE THE FISRT EXAMPLE OF LOGIN-PAGE and HOMEPAGE
public class OrangeHrmTest1 extends BaseTest {

    @Test
    public void validatePositiveFlowOrangeCrm() throws Exception {

        //using(driver).goTo(LoginPage.class).launchURL().enterPassword().enterUserName().clickLoginBtn();
//        LoginPage loginpage = new LoginPage(driver);
//        loginpage.launchURL();
//        loginpage.enterPassword();
//        loginpage.enterUserName();

//        boolean relust = using(driver).goTo(HomePage.class).welcomeXXXIsDisplayed();
////        HomePage homepage = loginpage.clickLoginBtn();
////        boolean result = homepage.welcomeXXXIsDisplayed();
//        BaseAssertions.shouldBeTrue(relust);
    }
}

//        DirectoryPage directorypage = homepage.clickOnDirectoryTab();
//        boolean checkURL = directorypage.checkIfSearchDirectoryIsOpen();
//        BaseAssertions.shouldBeTrue(checkURL);
//        directorypage.selectJobTitle();
//        Thread.sleep(5000);
//        directorypage.selectLocation();
//        directorypage.enterName();
//        directorypage.clickSearchBtn();
//        boolean searchIsCorrect = directorypage.checkIfSearchIsCorrect();
//        BaseAssertions.shouldBeTrue(searchIsCorrect);
//        directorypage.clickWelcomeBtn();
//        Thread.sleep(5000);
//
//        loginpage=directorypage.clickLogOut();
//        boolean logoutSuccessful = loginpage.checkIfLogOutSuccessful();
//        BaseAssertions.shouldBeTrue(logoutSuccessful);
//
//    }

//    @Test
//    public void validatePositiveFlowOfMyInfo() throws Exception {
//        LoginPage loginpage = new LoginPage(driver);
//        loginpage.launchURL();
//        loginpage.enterPassword();
//        loginpage.enterUserName();
//
//        HomePage homepage = loginpage.clickLoginBtn();
//        boolean result = homepage.welcomeXXXIsDisplayed();
//        BaseAssertions.shouldBeTrue(result);
//
//        MyInfoPage myinfopage = homepage.clickOnMyInfoTab();
//        boolean checkingURLOnmYInfoPage =myinfopage.checkIfYouArenOnMyInfoPage();
//        BaseAssertions.shouldBeTrue(checkingURLOnmYInfoPage);
//        boolean checkingFirstNameDisplayed = myinfopage.checkFirstNameDisplayed();
//        BaseAssertions.shouldBeTrue(checkingFirstNameDisplayed);
//        boolean checkingLastNameDisplayed=myinfopage.checkLastNameDisplayed();
//        BaseAssertions.shouldBeTrue(checkingLastNameDisplayed);
//        myinfopage.clickWelcomeBtn();
//        Thread.sleep(5000);
//
//        loginpage =myinfopage.clickLogOut();
//        boolean logoutSuccessful =loginpage.checkIfLogOutSuccessful();
//        BaseAssertions.shouldBeTrue(logoutSuccessful);
//    }
//}
