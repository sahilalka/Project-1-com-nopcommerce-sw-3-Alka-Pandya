package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class TestSuite extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {
        //1.1 Click on Computer Menu.
        clickOnElement(By.linkText("Computers"));

        //1.2 Click on Desktop
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));

        // 1.3 Select Sort By position "Name: Z to A"
        selectAnElementFromList(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");

        // 1.4 Verify the Product will arrange in Descending order
        Thread.sleep(2000);
        ArrayList<String> actualList = new ArrayList<>();

        List<WebElement> listOfElement = driver.findElements(By.xpath("//h2[@class='product-title']/a"));
        for (WebElement element : listOfElement) {
            actualList.add(element.getText());
        }
        System.out.println(actualList);
        ArrayList<String> expectedList = new ArrayList<>();
        for (WebElement element : listOfElement) {
            expectedList.add(element.getText());
        }
        Collections.sort(expectedList);
        Collections.reverse(expectedList);

        System.out.println(expectedList);
        Assert.assertEquals("Not matching", expectedList, actualList);

    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu.
        clickOnElement(By.linkText("Computers"));
        //2.2 Click on Desktop
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));
        //2.3 Select Sort By position "Name: A to Z"
        selectAnElementFromList(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");

        //2.4 Click on "Add To Cart"
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@class='button-2 product-box-add-to-cart-button']"));

        // 2.5 Verify the Text "Build your own computer"
        By actualText = By.xpath("//h1[contains(text(),'Build your own computer')]");
        System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Build your own computer')]")).getText());
        asserVerifyText(actualText, "Build your own computer");

        // 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectAnElementFromList(By.cssSelector("#product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");
        Thread.sleep(2000);

        // 2.7.Select "8GB [+$60.00]" using Select class
        selectAnElementFromList(By.cssSelector("#product_attribute_2"), "8GB [+$60.00]");

        // 2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.cssSelector("#product_attribute_3_7"));

        // 2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.cssSelector("#product_attribute_4_9"));
        Thread.sleep(2000);

        // 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));

        // 2.11 Verify the price "$1,475.00"
        By actualPrice = By.xpath("(//span[@id='price-value-1'])[1]");
        System.out.println(driver.findElement(By.xpath("(//span[@id='price-value-1'])[1]")).getText());
        asserVerifyText(actualPrice, "$1,470.00");

        // 2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        //clickOnElement(By.cssSelector("#add-to-cart-button-1"));

        // 2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        By actualMessage = By.xpath("//p[@class='content']");
        System.out.println(driver.findElement(By.xpath("//p[@class='content']")).getText());
        asserVerifyText(actualMessage, "The product has been added to your shopping cart");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//span[@title='Close']"));

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverOnElement(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        Thread.sleep(2000);

        // 2.15 Verify the message "Shopping cart"
        By actualMessage1 = By.xpath("//h1[contains(text(),'Shopping cart')]");
        System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Shopping cart')]")).getText());
       asserVerifyText(actualMessage1, "Shopping cart");

        // 2.16 Change the Qty to "2" and Click on "Update shopping cart"
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//input[@class='qty-input']"));
        element.clear();
        sendTextToTheElement(By.xpath("//input[@class='qty-input']"), "2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));

        // 2.17 Verify the Total"$2,950.00"
        By actualTotal = By.xpath("//span[@class='product-subtotal']");
        System.out.println(driver.findElement(By.xpath("//span[@class='product-subtotal']")).getText());
        asserVerifyText(actualTotal, "$2,950.00");
        Thread.sleep(2000);

        // 2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        // 2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        Thread.sleep(2000);

        // 2.20 Verify the Text “Welcome, Please Sign In!”
        By actualText1 = By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]");
        System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")).getText());
       asserVerifyText(actualText1, "Welcome, Please Sign In!");

        // 2.21 Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        // 2.22 Fill the all mandatory field
        //First name
        sendTextToTheElement(By.id("BillingNewAddress_FirstName"), "Stephen");
        //Last name
        sendTextToTheElement(By.id("BillingNewAddress_LastName"), "Smith");
        //Email
        String randomEmail = randomEmail();
        sendTextToTheElement(By.id("BillingNewAddress_Email"), randomEmail);
        //country
        selectAnElementFromList(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "Australia");
        //City
        sendTextToTheElement(By.id("BillingNewAddress_City"), "Col");
        //Address
        sendTextToTheElement(By.id("BillingNewAddress_Address1"), "CrossWay");
        //postal code
        sendTextToTheElement(By.id("BillingNewAddress_ZipPostalCode"), "363641");
        //phone number
        sendTextToTheElement(By.id("BillingNewAddress_PhoneNumber"), "9825655114");

        // 2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        // 2.24 Click on Radio Button “Next Day Air($0.00)”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));

        // 2.25 Click on “CONTINUE”
        clickOnElement(By.cssSelector(".button-1.shipping-method-next-step-button"));

        // 2.26 Select Radio Button “Credit Card”
        clickOnElement(By.cssSelector("#paymentmethod_1"));

        //Click on continue
        clickOnElement(By.cssSelector("button[class='button-1 payment-method-next-step-button']"));
        Thread.sleep(2000);

        // 2.27 Select “Master card” From Select credit card dropdown
        selectAnElementFromList(By.xpath("//select[@id='CreditCardType']"), "Master card");

        // 2.28 Fill all the details
        //name
        sendTextToTheElement(By.id("CardholderName"), "Magnus");
        //card number
        sendTextToTheElement(By.id("CardNumber"), "5425233430109903");
        selectAnElementFromList(By.xpath("//select[@id='ExpireMonth']"), "04");
        selectAnElementFromList(By.xpath("//select[@id='ExpireYear']"), "2026");
        sendTextToTheElement(By.xpath("//input[@id='CardCode']"), "079");

        // 2.29 Click on “CONTINUE"
        clickOnElement(By.cssSelector(".button-1.payment-info-next-step-button"));

        // 2.30 Verify “Payment Method” is “Credit Card".
        Thread.sleep(2000);
        By actualText2 = By.xpath("//li[@class='payment-method']");
        System.out.println(driver.findElement(By.xpath("//li[@class='payment-method']")).getText());
        asserVerifyText(actualText2, "Payment Method: Credit Card");

        // 2.32 Verify “Shipping Method” is “Next Day Air”
        By actualText3 = By.xpath("//li[@class='shipping-method']");
        System.out.println(driver.findElement(By.xpath("//li[@class='shipping-method']")).getText());
        asserVerifyText(actualText3, "Shipping Method: Next Day Air");

        // 2.33 Verify Total is “$2,950.00”
        By actualText4 = By.xpath("//tbody/tr[1]/td[6]/span[1]");    ////span[@class='product-subtotal'] //strong[normalize-space()='$2,950.00']
        System.out.println(driver.findElement(By.xpath("//tbody/tr[1]/td[6]/span[1]")).getText());
        Thread.sleep(2000);
        asserVerifyText(actualText4, "$2,950.00");

        // 2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));

        // 2.35 Verify the Text “Thank You"
        By actualText5 = By.xpath("//h1[normalize-space()='Thank you']");
        System.out.println(driver.findElement(By.xpath("//h1[normalize-space()='Thank you']")).getText());
        asserVerifyText(actualText5, "Thank you");

        // 2.36 Verify the message “Your order has been successfully processed!”
        Thread.sleep(2000);
        By actualText6 = By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]");
        System.out.println(driver.findElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]")).getText());
        asserVerifyText(actualText6, "Your order has been successfully processed!");

        // 2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        // 2.37 Verify the text “Welcome to our store”
        By actualText7 = By.xpath("//h2[contains(text(),'Welcome to our store')]");
        System.out.println(driver.findElement(By.xpath("//h2[contains(text(),'Welcome to our store')]")).getText());
        asserVerifyText(actualText7, "Welcome to our store");

    }

    private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@example.com";
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
























