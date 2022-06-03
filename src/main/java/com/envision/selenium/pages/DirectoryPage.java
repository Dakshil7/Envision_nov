package com.envision.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import reusables.BasePage;
import reusables.BaseTest;
import reusables.PropertiesLoader;

public class DirectoryPage extends BasePage {

    WebDriver driver;

    DirectoryPage(WebDriver driver){
        this.driver=driver;
    }

    public boolean checkIfSearchDirectoryIsOpen(){
        boolean checkURL = driver.getCurrentUrl().
                equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/index.php/directory/viewDirectory/reset/1");
        return checkURL;
    }

    public DirectoryPage selectJobTitle() throws Exception {
        //WebElement jobTitleElement = driver.findElement(By.xpath("//select[@id = 'searchDirectory_job_title']"));
        WebElement jobTitleElement = findElement(driver,"directory.selectjob");
        Select selectJob = new Select(jobTitleElement);
        //selectJob.selectByVisibleText(PropertiesLoader.getProperties("jobtitle"));
        selectJob.selectByVisibleText(PropertiesLoader.getProperty("jobtitle"));
        return this;
    }

    public DirectoryPage selectLocation() throws Exception {
        //WebElement locationElement = driver.findElement(By.xpath("//select[@id = 'searchDirectory_location']"));
        WebElement locationElement = findElement(driver,"directory.selectlocation");
        Select selectLoc = new Select(locationElement);
        selectLoc.selectByValue("3");
        return this;
    }

    public DirectoryPage enterName() throws Exception {
        //driver.findElement(By.xpath("//input[@id = 'searchDirectory_emp_name_empName']")).
               // sendKeys(PropertiesLoader.getProperties("name"));
        typeInto(driver,"directory.entername",PropertiesLoader.getProperty("name"));
        return this;
    }

    public DirectoryPage clickSearchBtn() throws Exception {
        //driver.findElement(By.xpath("//input[@id = 'searchBtn']")).click();
        clickOn(driver,"directory.searchbtn");
        return this;
    }

    public boolean checkIfSearchIsCorrect() throws Exception {
        //boolean searchIsCorrect = driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[2]/td[2]/ul/li[1]/b")).isDisplayed();
        boolean searchIsCorrect = isDisplayed(driver,"directory.namedisplayed");

        return searchIsCorrect;
    }

    public DirectoryPage clickWelcomeBtn() throws Exception {
        //driver.findElement(By.xpath("//a[@id='welcome']")).click();
        clickOn(driver,"directory.welcomebtn");
        return this;
    }

    public LoginPage clickLogOut() throws Exception {

        //driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[3]/a")).click();
        clickOn(driver,"directory.logoutbtn");
        return new LoginPage(driver);
    }
}
