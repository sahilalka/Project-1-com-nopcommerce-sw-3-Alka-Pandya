package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utility extends BaseTest {

    //  1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    public void selectMenu(String menu) {
        driver.findElement(By.linkText(menu)).click();
    }

    // Method name verify page navigation use select menu method

    public void mouseHoverOnElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    public String getTextFromElement(By by) {
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }

    public void clickOnMouseHoverOnElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();


    }

    //Assert Method
    public void asserVerifyText(By by, String expectedText) {
        String actualText = getTextFromElement(by);
        String expectedText1 = expectedText;
        Assert.assertEquals("Error= Test Failed", expectedText1, actualText);

    }

    public void clickOnElement(By by) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(by);
        actions.moveToElement(driver.findElement(by)).click().build().perform();

    }

    public void clearText(By by) {
        driver.findElement(by).click();
    }

    public void sendTextToTheElement(By by, String text) {
        driver.findElement(by).getText();
    }
    public void selectAnElementFromList( By by ,String option) {
        driver.findElement(By.linkText(option)).click();


    }
    }
