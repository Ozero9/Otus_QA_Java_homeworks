package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class CalendarPage extends BasePage {

    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    private By calendarPage_AllCards = By.xpath("//div[@class='dod_new-events__list js-dod_new_events']/child::*"); //Селектор для всех карточек
    private By calendarPage_AllDates = By.xpath("//div[@class='dod_new-event__time']/span[1]/span[2]");//Селектор для дат событий
    private By calendarPage_FilterButton = By.cssSelector("span[class='dod_new-events-dropdown__input-selected']"); //Кнопка фильтрации событий
    private By calendarPage_OpenWebinarButton = By.cssSelector("a[title='Открытый вебинар']");//Кнопка "Открытые Вебинары"
    private By calendarPage_OpenWebinarSelector = By.cssSelector("div[class='dod_new-type__text']"); // Селектор для всех открытых вебинаров
    private static final Logger logger = LogManager.getLogger(StartOtusPage.class);

    public void countEvents() {
        try {
            logger.info("Подсчитываем количество событий");
            List<WebElement> cards = driver.findElements(calendarPage_AllCards);
            Integer countCards = cards.size();
            logger.info("Всего посчитано событий " + countCards);
            Assertions.assertTrue(countCards > 0,
                    "\n а должно быть больше 0");
        } catch (Exception e) {
            logger.error(
                    "Не получилось посчитать события", e);
        }
    }

    public boolean checkDate() {
        logger.info("Проверка дат мероприятий");
        LocalDate currentDate = LocalDate.now(); //Устанавливаем текущую дату
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", new Locale("ru"));
        List<WebElement> dateElement = driver.findElements(calendarPage_AllDates);
        for (WebElement date : dateElement) {
            try {

                String dateText = date.getText();
                logger.info("Дата мероприятия: " + dateText + " " + LocalDate.now().getYear() + "года");
                LocalDate eventDate = LocalDate.parse(dateText + " " + LocalDate.now().getYear(), formatter);
                if (eventDate.isBefore(currentDate)) {
                    logger.error("Мероприятие уже прошло: " + eventDate);
                    return false;
                }
            } catch (Exception e) {
                logger.error("Не получилось обработать дату мероприятия", e);
                return false;
            }
        }
        logger.info("Все даты мероприятий актуальны.");
        return true;
    }


    public void enterToWebinars() {
        try {
            logger.info("Выбираем открытые вебинары");
            getElement(calendarPage_FilterButton).click();
            getElement(calendarPage_OpenWebinarButton).click();
        } catch (Exception e) {
            logger.error(
                    "Не получилось выбрать открытые вебинары", e);
        }
    }

    public boolean openWebinars() {
        logger.info("Проверяем, что все вебинары открытые");
        List<WebElement> webinars = driver.findElements(calendarPage_OpenWebinarSelector);

        for (WebElement webinar : webinars) {
            String type = webinar.getText();
            logger.info("Тип мероприятия: " + type);
            if (!type.equals("Открытый вебинар")) {
                logger.error("Найден закрытый вебинар: " + type);
                return false;
            }
        }
        logger.info("Все вебинары открытые");
        return true;
    }


}
