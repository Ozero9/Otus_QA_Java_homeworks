package factory;

import exceptions.BrowserNotFoundException;
import factory.impl.ChromeSettings;
import factory.impl.FireFoxSettings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static factory.impl.ChromeSettings.chromeMode;
import static factory.impl.FireFoxSettings.firefoxSetting;

public class WebDriverFactory {

    public String browserName = System.getProperty("browser");


    public WebDriver getDriver(String browserName, String typeWindow){

        WebDriver driver;

        switch (browserName){
            case"chrome":
                default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeMode(chromeOptions,typeWindow);
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxSetting(firefoxOptions,typeWindow);
                driver = new FirefoxDriver(firefoxOptions);
                break;
        }
        return driver;
    }

    
}
