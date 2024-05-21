package stepdefs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UIBaseTest {
    protected static WebDriver driver;

    protected void getDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless");
        options.addArguments("--window-size=1400,1000");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }
}
