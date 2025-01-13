package pages;

import enumData.LanguageLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FormPage extends BasePage{

    public FormPage(WebDriver driver) {

        super(driver);
    }

    private static final Logger logger = LogManager.getLogger(FormPage.class);

    public static By getTextMode(String text){
        switch (text){
            case "username":
            default:
                return By.id("username");
            case "email":
                return By.id("email");
            case "password":
                return By.id("password");
            case "confirm_password":
                return By.id("confirm_password");
            case "birthdate":
                return By.cssSelector("input[id=\"birthdate\"]");
            case "language_level":
                return By.id("language_level");
            case "submit":
                return By.cssSelector("input[type='submit']");
        }
    }

    public void enterInfo(String text, String textInfo) {
        try {
            logger.info("Entering info: " + text);
            driver.findElement(getTextMode(text)).sendKeys(textInfo);
        } catch (Exception e) {
            logger.error("Error by "+text, e);
        }
    }

    public void selectLanguageLevel(LanguageLevel level) {
        logger.info("Отправка формы");
        WebElement dropdown = driver.findElement(getTextMode("language_level"));
        Select select = new Select(dropdown);
        select.selectByValue(level.getValue());
    }

    public void submitForm() {
        try {
            logger.info("Отправка формы");
            driver.findElement(getTextMode("submit")).click();
        } catch (Exception e) {
            logger.error("Ошибка при отправке формы", e);
        }
    }

    public boolean isPasswordMatching() {
        String password = driver.findElement(getTextMode("password")).getAttribute("value");
        String confirmPassword = driver.findElement(getTextMode("confirm_password")).getAttribute("value");
        return password.equals(confirmPassword);
    }
}
