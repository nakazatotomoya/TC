package controllers.localdriver;


import controllers.InitMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class LocalDriverFactory {

    static Logger log = Logger.getLogger(LocalDriverFactory.class);

    public static WebDriver createInstance(String browserName) {
        WebDriver driver;
        if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            return driver;
        }
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("download.default_directory", InitMethod.xpathPDF);
            options.setExperimentalOption("prefs", prefs);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            return driver;
        }
        if (browserName.equalsIgnoreCase("chromeHeadless")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
            return driver;
        }
        if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            return driver;
        }

        log.info("LocalDriverFactory created an instance of WebDriver for: " + browserName);
        return null;
    }
}
