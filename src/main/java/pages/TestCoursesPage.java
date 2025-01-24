package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestCoursesPage extends BasePage {

    public TestCoursesPage(WebDriver driver) {

        super(driver);
    }

    private static final Logger logger = LogManager.getLogger(StartOtusPage.class);

    private By coursesPage_MoreButton = By.cssSelector("button[class='sc-mrx253-0 enxKCy sc-prqxfo-0 cXVWAS']"); //Кнопка "Показать все курсы тестирования"
    private By coursesPage_AllCards = By.xpath("//div[@class='sc-18q05a6-1 bwGwUO']/child::*"); //Селектор для всех карточек
    private By coursesPage_CardTitle = By.cssSelector("h1[class='sc-1x9oq14-0 sc-s2pydo-1 kswXpy diGrSa']"); //Название курса
    private By coursesPage_CardPeriod = By.cssSelector("p[class='sc-1x9oq14-0 sc-3cb1l3-0 doSDez dgWykw']"); //Период
    private By coursesPage_CardInfo = By.cssSelector("div[class='sc-1x9oq14-0 sc-s2pydo-3 enpOeQ dZDxRw']"); //Описание
    private By coursesPage_CardFormat = By.cssSelector("p[class='sc-1x9oq14-0 sc-3cb1l3-0 doSDez dgWykw']"); //Формат


    public void openAllCurses() {
        try {
            logger.info("Раскрываем список всех курсов тестирования");
            getElement(coursesPage_MoreButton).click();
        } catch (Exception e) {
            logger.error(
                    "Не получилось нажать на кнопку 'Показать все курсы тестирования'", e);
        }
    }

    public void countCards() {
        try {
            logger.info("Подсчитываем количество карточек");
            List<WebElement> list = driver.findElements(coursesPage_AllCards);
            Number countCards = list.size();
            logger.info("Всего посчитано карточек "+countCards);
            Assertions.assertEquals(11,countCards,
                            "\n а должно быть 11");
        } catch (Exception e) {
            logger.error(
                    "Не получилось посчитать карточки", e);
        }
    }

    public void infoCards(){
        try {
            logger.info("Открываем карточку");
            List<WebElement> list = driver.findElements(coursesPage_AllCards);
            WebElement card = list.get(1);
            card.click();
            int cardTitle = getElement(coursesPage_CardTitle).getText().length();
            logger.info("Проверяем название");
            Assertions.assertTrue(cardTitle>0,"Название карточки не заполнено" );
            logger.info("Проверяем период");
            int cardPeriod = getElement(coursesPage_CardPeriod).getText().length();
            Assertions.assertTrue(cardPeriod>0,"Период не заполнен" );
            logger.info("Проверяем описание");
            int cardInfo = getElement(coursesPage_CardInfo).getText().length();
            Assertions.assertTrue(cardInfo>0,"Описание не заполнено" );
            logger.info("Проверяем формат");
            int cardFormat = getElement(coursesPage_CardFormat).getText().length();
            Assertions.assertTrue(cardFormat>0,"Формат не заполнен" );

        } catch (Exception e) {
            logger.error(
                    "Не получилось проверить карточку", e);
        }
    }
}


