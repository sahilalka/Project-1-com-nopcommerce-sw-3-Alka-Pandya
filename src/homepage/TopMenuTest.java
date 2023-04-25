package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void SetUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        if (menu == "Computers") {
            //Select computer tab and click
            clickOnElement(By.linkText("Computers"));
            //Verify the page navigation
           asserVerifyText(By.xpath("//div[@class='page-title']"), "Computers");
        } else if (menu == "electronics") {
            clickOnElement(By.linkText("electronics"));
            asserVerifyText(By.className("page-title"), "electronics");
        } else if (menu == "Apparel") {
            clickOnElement(By.linkText("Apparel"));
            asserVerifyText(By.className("page-title"), "Apparel");
        } else if (menu == "Digital downloads") {
            clickOnElement(By.linkText("Digital downloads"));
            asserVerifyText(By.className("page-title"), "Digital downloads");
        } else if (menu == "Books") {
            clickOnElement(By.linkText("Books"));
           asserVerifyText(By.className("page-title"), "Books");
        } else if (menu == "Jewelry") {
            clickOnElement(By.linkText("Jewelry"));
           asserVerifyText(By.className("page-title"), "Jewelry");
        } else if (menu == "Gift Cards") {
            clickOnElement(By.linkText("Gift Cards"));
            asserVerifyText(By.className("page-title"), "Gift Cards");
        } else {
            System.out.println("Please enter valid Top-menu tab or check actual name");
        }
    }

    /**
     * 1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
     * select the Menu and click on it and verify the page navigation.
     */
    @Test
    public void verifyPageNavigation() {
        selectMenu("Computers");
        selectMenu("electronics");
        selectMenu("Apparel");
        selectMenu("Digital downloads");
        selectMenu("Books");
        selectMenu("Jewelry");
        selectMenu("Gift Cards");

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}









































