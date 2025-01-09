package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {

    public static WebDriver getDriver(String browserName, String typeWindow){

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

    public static void chromeMode(ChromeOptions options, String typeWindow) {

        switch (typeWindow.toLowerCase()) {
            case "maximized":
                System.out.println("Вы выбрали Maximized");
                options.addArguments("--start-maximized");
                break;
            case "headless":
                System.out.println("Вы выбрали headless");
                options.addArguments("--headless");
                break;
            case "kiosk":
                System.out.println("Вы выбрали kiosk");
                options.addArguments("--kiosk");
                break;
        }
    }

    public static void firefoxSetting(FirefoxOptions options, String typeWindow) {
        switch (typeWindow) {
            case "maximized":
                System.out.println("Вы выбрали Maximized");
                options.addArguments("--start-maximized");
                break;
            case "headless":
                System.out.println("Вы выбрали headless");
                options.addArguments("--headless");
                break;
            case "kiosk":
                System.out.println("Вы выбрали kiosk");
                options.addArguments("--kiosk");
                break;
        }

    }
}
