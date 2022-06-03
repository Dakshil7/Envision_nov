package LoginTest;

import reusables.BasePage;
import reusables.BaseTest;
import reusables.PropertiesLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumHomework07 extends BaseTest {

    @Test
    public void getCardInfo() throws Exception {

        driver.get("http://demo.guru99.com/payment-gateway/index.php");
        WebElement clickOnGenerateCard = driver.findElement(By.xpath("//*[@id='nav']/a[2]"));
        clickOnGenerateCard.click();
        BasePage.switchToWindow(1, driver);
        Thread.sleep(2000);

        //Getting card element

        WebElement cardNumber = driver.findElement(By.xpath("//*[@id='three']/div/h4[1]"));
        String card = cardNumber.getText();
        String[] cardArray = card.split(" ");
        System.out.println("Card Number = "+cardArray[2]);


        //Getting CVV

        WebElement cvvNumber = driver.findElement(By.xpath("//*[@id='three']/div/h4[2]"));
        String CVV = cvvNumber.getText();
        String[] CVVArray = CVV.split(" ");
        System.out.println("CVV = "+CVVArray[1]);

        //Getting Exp

        WebElement ExpDate = driver.findElement(By.xpath("//*[@id='three']/div/h4[3]"));
        String Exp = ExpDate.getText();
        String[] ExpArray = Exp.split(" ");
        //System.out.println(ExpArray[1]);
        String splitExp = ExpArray[1];
        System.out.println("Exp Date = "+splitExp);
        String[] splitMonthAndYear = splitExp.split("/");
        System.out.println("Exp Month = "+splitMonthAndYear[0]);
        System.out.println("Exp Year = "+splitMonthAndYear[1]);


        //Getting Credit Limit

        WebElement creditLimit = driver.findElement(By.xpath("//*[@id=\"three\"]/div/h4[4]"));
        String credit = creditLimit.getText();
        String[] creditLimitArray = credit.split(" ");
        System.out.println("Card Limit = "+creditLimitArray[2]);
        String cardLimit = creditLimitArray[2].substring(1, 4);
        //System.out.println("Card Limit = "+cardLimit);
        int cardLimitInDollars = 0;
        try {
            cardLimitInDollars = Integer.parseInt(cardLimit);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        //Closing 2nd Window

        driver.close();

        //Switching to Main Window

        BasePage.switchToOriginalWindow(driver);

        WebElement cart = driver.findElement(By.xpath("//*[@id='nav']/a[1]"));
        cart.click();

        //Selecting Quantity to Purchase

        WebElement selectQuantity = driver.findElement(By.xpath("//select[@name='quantity']"));
        BasePage.selectBy(driver, selectQuantity, "text", PropertiesLoader.getProperty("Quantity"));

        //Getting Price of the Toy

        WebElement toyPrice = driver.findElement(By.xpath("//*[@id='three']/div/form/div/div[2]/h3"));
        String price = toyPrice.getText();
        String[] priceArray = price.split(" ");
        System.out.println("Toy Price = "+priceArray[1]);
        String priceWithout$ = priceArray[1];
        //System.out.println(priceWithout$.substring(1));
        String priceWithout$1 = priceWithout$.substring(1);
        Thread.sleep(2000);

        //Clicking on Buy now

        WebElement buyNow = driver.findElement(By.xpath("//input[@type='submit']"));
        buyNow.click();

        //Entering Card Details

        driver.findElement(By.xpath("//input[@id = 'card_nmuber']")).sendKeys(cardArray[2]);
        Thread.sleep(1000);
        WebElement selectMonth = driver.findElement(By.xpath("//select[@id = 'month']"));
        BasePage.selectBy(driver, selectMonth, "text", splitMonthAndYear[0]);
        WebElement selectYear = driver.findElement(By.xpath("//select[@id = 'year']"));
        BasePage.selectBy(driver, selectYear, "text", splitMonthAndYear[1]);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id = 'cvv_code']")).sendKeys(CVVArray[1]);
        Thread.sleep(2000);

        //Validating Price With the Quantity

        WebElement priceValidation = driver.findElement(By.xpath("//*[@id='three']/div/form/div[1]/div/font[2]"));
        //System.out.println(priceValidation.getText());
        String totalPriceWithout$ = priceValidation.getText();
        //System.out.println(totalPriceWithout$.substring(1));
        String totalPriceWithout$1 = totalPriceWithout$.substring(1, 3);
        //System.out.println(totalPriceWithout$1);
        Thread.sleep(1000);
        int totalPriceWithoutDollarSign = 0;
        try {
            totalPriceWithoutDollarSign = Integer.parseInt(totalPriceWithout$1);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int priceWithoutDollarSign = 0;
        try {
            priceWithoutDollarSign = Integer.parseInt(priceWithout$1);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int Quantity = Integer.parseInt(PropertiesLoader.getProperty("Quantity"));
        //System.out.println(Quantity);
        int totalCost = totalPriceWithoutDollarSign;
        int costGeneric = priceWithoutDollarSign * Quantity;
        System.out.println("Cost of n Toys = "+costGeneric);
        System.out.println("Total Cost Displayed = "+totalCost);

        Assert.assertEquals(costGeneric, totalCost);
        System.out.println("Verification of total cost display is completed");

        //Clicking on Pay Now

        driver.findElement(By.xpath("//input[@name= 'submit']")).click();

        //Validating Payment Successful text

        String paymentText = driver.findElement(By.xpath("//h2[text()= 'Payment successfull!']")).getText();
        Assert.assertTrue(paymentText.equalsIgnoreCase("Payment successfull!"));
        System.out.println("Verification of Payment Successful is completed ");

        //Getting order id

        String orderId = driver.findElement(By.xpath("//*[@id='three']/div/div/table/tbody/tr[1]/td[2]/h3/strong")).getText();
        Thread.sleep(2000);

        //Clicking on Credit Card Limit

        driver.get("https://demo.guru99.com/payment-gateway/index.php");
        driver.findElement(By.xpath("//*[@id='nav']/a[3]")).click();

        //Entering Card Number to Check Limit

        driver.findElement(By.xpath("//input[@id='card_nmuber']")).sendKeys(cardArray[2]);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //Validating Card Balance After Purchasing

        String cardBalance = driver.findElement(By.xpath("//*[@id='three']/div/div/h4/span")).getText();
        int cardBalanceInDollars = 0;
        try {
            cardBalanceInDollars = Integer.parseInt(cardBalance);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int remainingBalance = cardLimitInDollars - costGeneric;

        Assert.assertEquals(remainingBalance,cardBalanceInDollars);
        System.out.println("Verification of Remaining Balance is completed ");

        String orderId1 = driver.findElement(By.xpath("//*[@id=\"three\"]/div/div/table/tbody/tr/td[6]/b/font")).getText();
        Assert.assertTrue(orderId1.equalsIgnoreCase(orderId));
        System.out.println("Verification Order ID is completed");


    }
}
