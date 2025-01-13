import enumData.LanguageLevel;
import factory.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.FormPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PageTest {

    private static final Logger logger = LogManager.getLogger(FormPage.class);
    protected WebDriver driver;


    @BeforeEach
    public void setUp(){
        logger.info("Browser starting");
        String browserName = System.getProperty("browser", "chrome");
        String typeWindow = System.getProperty("mode", "headless");
        String baseUrl = System.getProperty("baseUrl", "https://otus.home.kartushin.su/form.html");

        driver = WebDriverFactory.getDriver(browserName,typeWindow);
        FormPage formPage = new FormPage(driver);
        formPage.open(baseUrl);
        logger.info("Browser started.");
    }

    @AfterEach
    public void down() {
        FormPage formPage = new FormPage(driver);
        formPage.close();
    }

    @Test
    public void testForm() throws InterruptedException {
        logger.info("Начало тестов");
        FormPage formPage = new FormPage(driver);
        String username = System.getProperty("username");
        String email = System.getProperty("email");
        String password = System.getProperty("password");
        String birthdate = System.getProperty("birthdate");
        LanguageLevel languageLevel = LanguageLevel.NATIVE;

        formPage.enterInfo("username", username);
        formPage.enterInfo("email", email);
        formPage.enterInfo("password", password);
        formPage.enterInfo("confirm_password", password);
        formPage.enterInfo("birthdate", birthdate);

        formPage.selectLanguageLevel(languageLevel);

        assertTrue(formPage.isPasswordMatching(), "Пароли не совпадают!");

        formPage.submitForm();

        logger.info("Проверка наличия имени пользователя на странице");
        assertTrue(driver.getPageSource().contains(username), "Имя пользователя не отображается на странице");
        logger.info("Проверка наличия электронной почты на странице");
        assertTrue(driver.getPageSource().contains(email), "Электронная почта не отображается на странице");
        logger.info("Проверка наличия даты рождения");
    }
}
