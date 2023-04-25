package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public void openBrowser(String baseUrl){
        // Creating an Object
        driver = new ChromeDriver();
        // Launching the URL
        driver.get(baseUrl);
        // Maximize window
        driver.manage().window().maximize();
        // We give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    public void closeBrowser(){
        driver.quit();  // To Close all the Windows
    }



}
