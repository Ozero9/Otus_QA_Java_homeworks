import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class first {
    private WebDriver driver;
    private static final String URL = "https://otus.home.kartushin.su/training.html";
    private By message = By.xpath("//input[@id='textInput']");
    private By button = By.xpath("//button[@id='openModalBtn']");
    private  By close = By.xpath("//span[@id='closeModal']");
    private By modalText = By.xpath("//div[@class='modal-content']/h2");
    private By name = By.xpath("//input[@id='name']");
    private By email = By.xpath("//input[@id='email']");
    private  By submit = By.xpath("//button[@type='submit']");
    private By messageBox = By.xpath("//div[@id='messageBox']");

    @BeforeAll
    static void webDriverInstall() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void webDriverStart() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(URL);
    }

    @AfterEach
    public void webDriverStop(){
        if(driver !=null){
            driver.close();
        }
    }

    private WebElement getElement(By locator){
        return new WebDriverWait(driver,Duration.ofSeconds(5)).
                until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Test
    public void windowTestHeadless(){
        WebElement element = driver
                .findElement(message);
        element.sendKeys("ОТУС");
        Assertions.assertEquals("ОТУС",element.getAttribute("value"));
    }

    @Test
    public void windowTestHeadless2(){
        getElement(message).sendKeys("ОТУС");
        Assertions.assertEquals("ОТУС",getElement(message).getAttribute("value"));
    }




    @Test
    public void windowTestKiosk() {
        driver.manage().window().setSize(new Dimension(800,600));
        getElement(button).click();
        String expected = "Это модальное окно";
        String actual = getElement(modalText).getText();
        getElement(close).click();
        Assertions.assertEquals(expected,actual,"Messages are not equals");
        }

    @Test
     public void windowTestFullSize() {
        driver.manage().window().maximize();
        getElement(name).sendKeys("фыв");
        getElement(email).sendKeys("asdf@sdfg.rt");
        getElement(submit).click();
        String expected = "Форма отправлена с именем: фыв и email: asdf@sdfg.rt";
        String actual = getElement(messageBox).getText();
        Assertions.assertEquals(expected,actual,"Messages are not equals");
    }




//    @Test
//    public void windowTestKiosk() throws InterruptedException {
//        driver.manage().window().setSize(new Dimension(800,600));
//        Thread.sleep(2000);
//        driver
//                .findElement(button)
//                .click();
//        Thread.sleep(2000);
//        String expected = "Это модальное окно";
//        Thread.sleep(500);
//        String actual = driver.get;
//        Thread.sleep(500);
//        driver
//                .findElement(close)
//                .click();
//
//        Thread.sleep(500);
//        Assertions.assertEquals(expected,actual);
//    }

//    @Test
//    public void windowTestFullSize(){
//        driver.manage().window().maximize();
//        WebElement element = driver
//                .findElement(By.xpath("//input[@id='name']"));
//        element.sendKeys("фыв");
//        WebElement element2 = driver
//                .findElement(By.xpath("//input[@id='email']"));
//        element2.sendKeys("email");
//
//    }
}
