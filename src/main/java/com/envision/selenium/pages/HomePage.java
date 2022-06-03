package com.envision.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import reusables.BasePage;

public class HomePage extends BasePage {
    WebDriver driver;

    HomePage(WebDriver driver){
        this.driver=driver;
    }

    public boolean welcomeXXXIsDisplayed() throws Exception {
        //boolean result = driver.findElement(By.xpath("//a[@id='welcome']")).isDisplayed();
        boolean result = isDisplayed(driver,"homepage.welcomebtn");
        return result;
    }

    public DirectoryPage clickOnDirectoryTab() throws Exception {
        //driver.findElement(By.xpath("//*[@id='menu_directory_viewDirectory']/b")).click();
        clickOn(driver,"homepage.directorytab");
        return new DirectoryPage(driver);
    }

    public MyInfoPage clickOnMyInfoTab() throws Exception {
        //driver.findElement(By.xpath("//*[@id='menu_pim_viewMyDetails']/b")).click();
        clickOn(driver,"homepage.myinfotab");
        return new MyInfoPage(driver);
    }
}
