/**
 *
 */
package controllers;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;
import java.util.Set;


public class BaseMethod extends InitMethod {
    static Logger log = Logger.getLogger(BaseMethod.class);

    /* Open defaulte URL */
    public void openUrlDefault() {
        WebDriverManager.getDriver().get(InitMethod.appConfig.getWebsiteUrl());
        setMaxPageLoadTime();
        implicitlywait();
        try {
            WebDriverManager.getDriver().manage().window().maximize();
        } catch (Exception ex) {
            // do nothing
        }
    }

    /* To Perform a WebAction of Mouse Over */
    public void mousehover(WebElement element) {
        ac = new Actions(WebDriverManager.getDriver());
        ac.moveToElement(element).build().perform();
    }

    /* To Perform Select Option by Index */
    public void selectByIndex(WebElement element, int value) {
        log.info("Select text of index " + value + " from dropdown list " + element);
        se = new Select(element);
        se.selectByIndex(value);
    }

    /* Type */
    public static void type(String text, WebElement webElement) {
        if (text == null) {
            return;
        }
        webElement.sendKeys(text);
    }

    public void type(double number, WebElement webElement) {
        type(toString(number), webElement);
    }

    public String toString(double number) {
        if (number == (int) number) {
            return String.format("%d", (int) number);
        } else {
            return String.format("%s", number);
        }
    }


    /* Clear */
    public void clear(WebElement webElement) {
        webElement.clear();
//    	if (ApplicationConfigReader.instance.isLocal()) {
//    		webElement.clear();
//    	} else {
//            webElement.clear();
//    		webElement.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
//    	}
    }

    public void clearAndType(WebElement webElement, String text) {
        clear(webElement);
        type(text, webElement);
        log.info("clear and type text " + text + " to " + webElement);
    }

    public void waitForElementToDisplay(WebElement webElement) {
        waitForElementToDisplay(webElement, InitMethod.WAIT_TIME_10);
    }

    public void waitForElementToDisplay(WebElement webElement, long secondsToWait) {
        WebDriverWait wait = new WebDriverWait(WebDriverManager.getDriver(), secondsToWait);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }


    /* To click a certain Web Element */
    public void click(WebElement element) {
        waitForElementToDisplay(element, InitMethod.WAIT_TIME_15);
        element.click();
        log.info("click To Element " + element);
    }

    public void assertIsDisplayed(WebElement webElement) {
        log.info("verify element " + webElement + " is display");
        if (isNotDisplayed(webElement)) {
            throw new AssertionError("Element " + webElement + "is not displayed");
        }
    }

    public void assertIsDisplayed(WebElement webElement, long secondsToWait) {
        log.info("verify element " + webElement + " is display with " + secondsToWait + " seconds");
        if (isNotDisplayed(webElement, secondsToWait)) {
            throw new AssertionError("Element is not displayed within " + secondsToWait + " seconds");
        }
    }

    public boolean isNotDisplayed(WebElement webElement, long secondsToWait) {
        return !isDisplayed(webElement, secondsToWait);
    }

    /* Is Displayed */
    public boolean isDisplayed(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isNotDisplayed(WebElement webElement) {
        return !isDisplayed(webElement);
    }

    public boolean isDisplayed(WebElement webElement, long secondsToWait) {
        log.info("verify element " + webElement + " is display in " + secondsToWait);
        try {
            WebElement foundWebElement = new WebDriverWait(WebDriverManager.getDriver(), secondsToWait).until(ExpectedConditions.visibilityOf(webElement));

            return foundWebElement != null;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public boolean notEquals(String text1, String text2) {
        return !StringUtils.equals(text1, text2);
    }

    public void assertEquals(String name, String expected, String actual) {
        if (notEquals(expected, actual)) {
            throw new AssertionError(expected + " is not equal to " + actual);
        }
    }

    public void assertEquals(String expected, String actual) {
        if (notEquals(expected, actual)) {
            throw new AssertionError(expected + " is not equal to " + actual);
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }

    public void scrollToElement(WebElement webElement) throws InterruptedException {
        Thread.sleep(InitMethod.SLEEP_500_MS);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
        log.info("scroll To Element " + webElement);
    }

    public WebDriver getWebDriver() {
        return WebDriverManager.getDriver();
    }

    public void saveScreenShotFullPage(String imageName, String location) throws InterruptedException {
        Thread.sleep(InitMethod.SLEEP_2000_MS);
        Capabilities caps = ((RemoteWebDriver) getWebDriver()).getCapabilities();
        String browserName = caps.getBrowserName();
        Shutterbug.shootPage(getWebDriver(), ScrollStrategy.WHOLE_PAGE).withName(imageName + browserName).save(location);
    }

    public File getLatestFilefromDir(String dirPath){
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }
        File lastModifiedFile = files[0];
        return lastModifiedFile;
    }
}
