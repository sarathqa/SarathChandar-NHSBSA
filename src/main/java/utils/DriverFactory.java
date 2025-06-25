package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.time.Duration;

public class DriverFactory {

    public static WebDriver initDriver() throws IOException {
        WebDriver driver = null;
        String browserType = System.getProperty("Browser");
        if (browserType.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Given browser is not applicable");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }


}

