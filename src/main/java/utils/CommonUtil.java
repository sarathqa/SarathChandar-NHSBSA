package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class CommonUtil {

    public static String getDataFromProp(String fileName, String key) throws IOException {
        Properties properties = new Properties();
        File file = new File(System.getProperty("user.dir") + "//src//main//resources//" + fileName + ".properties");
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            properties.load(fileInputStream);
        }
        return properties.get(key).toString();

    }

    public static void selectByVisibleText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public static void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public static void selectByIndex(WebElement element, int value) {
        Select select = new Select(element);
        select.selectByIndex(value);
    }

    public static List<WebElement> getAllValuesFromDropdown(WebElement element) {
        Select select = new Select(element);
        return select.getOptions();
    }

    public static void explicitWait(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public static void explicitWaitElementClick(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public static void getScreenshot(WebDriver driver, String filename) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
         FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"/target/screenshot/"+filename+timeStamp+".png"));
    }

    public static void zoomOut(WebDriver driver, Object zoomValue){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom = '"+zoomValue+"'");
    }

}
