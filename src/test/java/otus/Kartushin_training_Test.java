package otus;

import factory.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Kartushin_training_Test {

    private static final Logger logger = LogManager.getLogger(Kartushin_training_Test.class);
    public WebDriver driver;
    private String browserName = System.getProperty("browser");
    private String baseUrl = System.getProperty("base.url");
    private By message = By.cssSelector("input[id='textInput']"); //By.xpath("//input[@id='textInput']");
    private By button = By.cssSelector("button[id='openModalBtn']"); //By.xpath("//button[@id='openModalBtn']");
    private  By close = By.cssSelector("span[id='closeModal']"); //By.xpath("//span[@id='closeModal']");
    private By modalText = By.xpath("//div[@class='modal-content']/h2"); //By.cssSelector("div[class='modal-content']//h2");
    private By name = By.cssSelector("input[id='name']"); //By.xpath("//input[@id='name']");
    private By email = By.cssSelector("input[id='email']"); //By.xpath("//input[@id='email']");
    private  By submit = By.cssSelector("button[type='submit']"); //By.xpath("//button[@type='submit']");
    private By messageBox = By.cssSelector("div[id='messageBox']");  //By.xpath("//div[@id='messageBox']");

     @AfterEach
     public void webDriverStop(){
       if(driver !=null){
           driver.close();
           logger.info("Браузер закрыт");
        }
   }

    @Test
    public void windowTestHeadless(){
        logger.info("Тест в headless режиме");
        String typeWindow = "headless";
        driver = new WebDriverFactory().getDriver(browserName, typeWindow);
        driver.get(baseUrl);
        logger.info("Перешли на страницу: " + baseUrl);

        getElement(message).sendKeys("ОТУС");
        String actual = getElement(message).getAttribute("value");
        Assertions.assertEquals("ОТУС",actual,"Messages are not equals");
    }

    @Test
    public void windowTestKiosk() {
        logger.info("Тест в kiosk режиме");
        String typeWindow = "kiosk";
        driver = new WebDriverFactory().getDriver(browserName, typeWindow);
        driver.get(baseUrl);
        logger.info("Перешли на страницу: " + baseUrl);
        getElement(button).click();
        String expected = "Это модальное окно";
        String actual = getElement(modalText).getText();
        getElement(close).click();
        Assertions.assertEquals(expected,actual,"Messages are not equals");
    }

    @Test
    public void windowTestFullSize() {
        logger.info("Тест в maximized режиме");
        String typeWindow = "maximized";
        driver = new WebDriverFactory().getDriver(browserName, typeWindow);
        driver.get(baseUrl);
        logger.info("Перешли на страницу: " + baseUrl);
        getElement(name).sendKeys("фыв");
        getElement(email).sendKeys("asdf@sdfg.rt");
        getElement(submit).click();
        String expected = "Форма отправлена с именем: фыв и email: asdf@sdfg.rt";
        String actual = getElement(messageBox).getText();
        Assertions.assertEquals(expected,actual,"Messages are not equals");
    }

    public WebElement getElement(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(5)).
                until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
