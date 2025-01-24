package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class StartOtusPage extends BasePage{
    public StartOtusPage(WebDriver driver) {
        super(driver);
    }

    private static final Logger logger = LogManager.getLogger(StartOtusPage.class);

    private By mainPage_OpenUpperMenu = By.cssSelector("span[title='Обучение']"); //Кнопка "Обучение" в верхнем трее
    //private By mainPage_OpenUpperMenu = By.xpath("header[@class='header3 js-header3']/div[1]/nav[1]/div[2]"); //Кнопка "Обучение" в верхнем трее
    private By mainPage_TestCourseButton = By.xpath("//a[contains(text(),'Тестирование')]"); //Кнопка "Тестирвоание" в выпадаюем списке
    private By mainPage_CalendarButton = By.cssSelector("a[href='https://otus.ru/events/near']"); //Кнопка "События" в выпадаюем списке
    private By mainPage_CookieButton = By.cssSelector("button.sc-9a4spb-0.izekQs"); //Кнопка "Ок" принятия куков

    //Переход на страницу курсов по тестированию
    public void enter_To_TestCourse() {
        try {
            logger.info("Переходим на страницу курсов тестирования");
            Actions actions = new Actions(driver);
            actions.moveToElement(getElement(mainPage_OpenUpperMenu)).perform(); //Наводим курсор на кнопку "Обучение"
            getElement(mainPage_TestCourseButton).click(); //Кликаем
            String url = driver.getCurrentUrl();
            Assertions.assertEquals("https://otus.ru/catalog/courses?categories=testing",url,
                    "Перешли на страницу "+url+
                            " а должны были на https://otus.ru/catalog/courses?categories=testing");
        } catch (Exception e) {
            logger.error(
                    "Не получилось перейти на страницу с курсом по тестированию", e);
        }
    }

    public void enter_To_Calendar(){
        try {
            logger.info("Переходим на страницу календаря");
            Actions actions = new Actions(driver);
            actions.moveToElement(getElement(mainPage_OpenUpperMenu)).perform(); //Наводим курсор на кнопку "Обучение"
            getElement(mainPage_CalendarButton).click(); //Кликаем
            String url = driver.getCurrentUrl();
            Assertions.assertEquals("https://otus.ru/events/near/",url,
                    "Перешли на страницу "+url+
                            " а должны были на https://otus.ru/events/near/");
        } catch (Exception e) {
            logger.error(
                    "Не получилось перейти на страницу событий", e);
        }
    }
}
