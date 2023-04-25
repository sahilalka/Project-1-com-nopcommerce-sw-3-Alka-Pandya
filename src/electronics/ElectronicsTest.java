package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.UUID;

public class ElectronicsTest  extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //1.1 Mouse Hover on “Electronics” Tab
        mouseHoverOnElement(By.linkText("Electronics"));

        // 1.2 Mouse Hover on “Cell phones” and click
        clickOnMouseHoverOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));

        // 1.3 Verify the text “Cell phones”
        By actualText = By.xpath("//h1[contains(text(),'Cell phones')]");
        System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Cell phones')]")).getText());
        asserVerifyText(actualText, "Cell phones");
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        // 2.1 Mouse Hover on “Electronics” Tab
        mouseHoverOnElement(By.linkText("Electronics"));

        // 2.2 Mouse Hover on “Cell phones” and click
        clickOnMouseHoverOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));

        /// 2.3 Verify the text “Cell phones”
        By actualText = By.xpath("//h1[contains(text(),'Cell phones')]");
        System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Cell phones')]")).getText());
        asserVerifyText(actualText, "Cell phones");

        // 2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(2000);

        // 2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));

        // 2.6 Verify the text “Nokia Lumia 1020”
        By actualText1 = By.xpath("//h1[normalize-space()='Nokia Lumia 1020']");
        System.out.println(driver.findElement(By.xpath("//h1[normalize-space()='Nokia Lumia 1020']")).getText());
        asserVerifyText(actualText1, "Nokia Lumia 1020");

        // 2.7 Verify the price “$349.00”
        By actualPrice = By.xpath("//span[@id='price-value-20']");
        System.out.println(driver.findElement(By.xpath("//span[@id='price-value-20']")).getText());
        asserVerifyText(actualPrice, "$349.00");

        // 2.8 Change quantity to 2
        WebElement element = driver.findElement(By.cssSelector("#product_enteredQuantity_20"));
        element.clear();
        sendTextToTheElement(By.cssSelector("#product_enteredQuantity_20"), "2");
        Thread.sleep(2000);

        // 2.9 Click on “ADD TO CART” tab
        clickOnElement(By.cssSelector("#add-to-cart-button-20"));

        // 2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        By actualMessage = By.xpath("//p[@class='content']");
        System.out.println(driver.findElement(By.xpath("//p[@class='content']")).getText());
        asserVerifyText(actualMessage, "The product has been added to your shopping cart");

        // After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("(//span[@title='Close'])[1]"));
        Thread.sleep(2000);

        // 2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverOnElement(By.xpath("(//span[@class='cart-label'])[1]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        // 2.12 Verify the message "Shopping cart"
        By actualMessage1 = By.xpath("//h1[contains(text(),'Shopping cart')]");
        System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Shopping cart')]")).getText());
        asserVerifyText(actualMessage1, "Shopping cart");
        Thread.sleep(2000);

        // 2.13 Verify the Total $698.00
        By actualMessage2 = By.xpath("//span[@class='product-subtotal']");
        System.out.println(driver.findElement(By.xpath("//span[@class='product-subtotal']")).getText());
        asserVerifyText(actualMessage2, "$698.00");

        // 2.14 click on checkbox “I agree with the terms of service"
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        // 2.15 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        // 2.16 Verify the Text “Welcome, Please Sign In!”
        Thread.sleep(2000);
        By actualMessage3 = By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]");
        System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")).getText());
        asserVerifyText(actualMessage3, "Welcome, Please Sign In!");

        // 2.17 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));

        // 2.18 Verify the text “Register”
        By actualMessage4 = By.xpath("//h1[contains(text(),'Register')]");
        System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Register')]")).getText());
        asserVerifyText(actualMessage4, "Register");
        Thread.sleep(2000);

        // 2.19 Fill the mandatory fields
        //First name
        sendTextToTheElement(By.xpath("//input[@id='FirstName']"), "Milton");
        //Last name
        sendTextToTheElement(By.xpath("//input[@id='LastName']"), "Smith");
        // Email
        String randomEmail = randomEmail();
        sendTextToTheElement(By.xpath("//input[@id='Email']"), randomEmail);
        // Password
        sendTextToTheElement(By.xpath("//input[@id='Password']"), "smith123456");
        // Confirm password
        sendTextToTheElement(By.xpath("//input[@id='ConfirmPassword']"), "smith123456");

        //2.20 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));

        // 2.21 Verify the message “Your registration completed”
        Thread.sleep(2000);
        By actualMessage5 = By.xpath("//div[contains(text(),'Your registration completed')]");
        System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]")).getText());
        asserVerifyText(actualMessage5, "Your registration completed");

        // 2.22 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        Thread.sleep(2000);

        // 2.23 Verify the text “Shopping cart”
        By actualMessage6 = By.xpath("//h1[contains(text(),'Shopping cart')]");
        System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Shopping cart')]")).getText());
        asserVerifyText(actualMessage6, "Shopping cart");
        Thread.sleep(2000);

        // 2.24 Click on login
        clickOnElement(By.xpath("//a[normalize-space()='Log in']"));

        //verify text
        By actualMessage7 = By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]");
        System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")).getText());
        asserVerifyText(actualMessage7, "Welcome, Please Sign In!");

        // Enter email
        sendTextToTheElement(By.xpath("//input[@id='Email']"), randomEmail);
        // password
        sendTextToTheElement(By.xpath("//input[@id='Password']"), "smith123456");
        // click
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));

        // 2.25 click on checkbox “I agree with the terms of service”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        // 2.26 Click on “CHECKOUT"
        clickOnElement(By.xpath("//button[@id='checkout']"));
        Thread.sleep(2000);

        // 2.27 Fill the Mandatory fields
        //country
        selectAnElementFromList(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United States");
        //state
        selectAnElementFromList(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"), "Alaska");
        //city
        sendTextToTheElement(By.id("BillingNewAddress_City"), "Reading");
        //Address
        sendTextToTheElement(By.id("BillingNewAddress_Address1"), "CrossWay");
        //Postal code
        sendTextToTheElement(By.id("BillingNewAddress_ZipPostalCode"), "363641");
        //Phone number
        sendTextToTheElement(By.id("BillingNewAddress_PhoneNumber"), "9825655114");

        // 2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        Thread.sleep(2000);

        // 2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("(//input[@id='shippingoption_2'])[1]"));

        // 2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("(//button[@class='button-1 shipping-method-next-step-button'])[1]"));

        // 2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("(//input[@id='paymentmethod_1'])[1]"));
        Thread.sleep(2000);

        //  Click
        clickOnElement(By.xpath("(//button[@class='button-1 payment-method-next-step-button'])[1]"));

        // 2.32 Select “Visa” From Select credit card dropdown
        selectAnElementFromList(By.xpath("//select[@id='CreditCardType']"), "Visa");

        // 2.33 Fill all the details
        // name
        sendTextToTheElement(By.xpath("//input[@id='CardholderName']"), "John");
        //Card number
        sendTextToTheElement(By.xpath("//input[@id='CardNumber']"), "5425233430109903");
        //month
        selectAnElementFromList(By.xpath("//select[@id='ExpireMonth']"), "01");
        //Year
        selectAnElementFromList(By.xpath("//select[@id='ExpireYear']"), "2026");
        // card code
        sendTextToTheElement(By.xpath("//input[@id='CardCode']"), "089");
        // 2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("(//button[@class='button-1 payment-info-next-step-button'])[1]"));
        Thread.sleep(2000);

        // 2.35 Verify “Payment Method” is “Credit Card"
        By actualMessage8 = By.xpath("//li[@class='payment-method']");
        System.out.println(driver.findElement(By.xpath("//li[@class='payment-method']")).getText());
        asserVerifyText(actualMessage8, "Payment Method: Credit Card");
        Thread.sleep(2000);

        // 2.36 Verify “Shipping Method” is “2nd Day Air”
        By actualMessage9 = By.xpath("//li[@class='shipping-method']");
        System.out.println(driver.findElement(By.xpath("//li[@class='shipping-method']")).getText());
        asserVerifyText(actualMessage9, "Shipping Method: 2nd Day Air");
        Thread.sleep(2000);

        // 2.37 Verify Total is “$698.00”
        By actualMessage10 = By.xpath("//span[@class='product-subtotal']");
        System.out.println(driver.findElement(By.xpath("//span[@class='product-subtotal']")).getText());
        asserVerifyText(actualMessage10, "$698.00");
        Thread.sleep(2000);

        // 2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        // 2.39 Verify the Text “Thank You”
        By actualMessage11 = By.xpath("//h1[normalize-space()='Thank you']");
        System.out.println(driver.findElement(By.xpath("//h1[normalize-space()='Thank you']")).getText());
        asserVerifyText(actualMessage11, "Thank you");
        Thread.sleep(2000);

        // 2.40 Verify the message “Your order has been successfully processed!”
        By actualMessage12 = By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]");
        System.out.println(driver.findElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]")).getText());
        asserVerifyText(actualMessage12, "Your order has been successfully processed!");

        // 2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        // 2.42 Verify the text “Welcome to our store”
        By actualMessage13 = By.xpath("//h2[contains(text(),'Welcome to our store')]");
        System.out.println(driver.findElement(By.xpath("//h2[contains(text(),'Welcome to our store')]")).getText());
        asserVerifyText(actualMessage13, "Welcome to our store");
        Thread.sleep(2000);

        // 2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

        // 2.44 Verify the URL is “https://demo.nopcommerce.com/"
        String actualString = driver.getCurrentUrl();
        String expected = "https://demo.nopcommerce.com/";
        Assert.assertEquals("not match", expected, actualString);

    }

    private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@example.com";
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}

































