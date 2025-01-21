import factory.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.CalendarPage;
import pages.StartOtusPage;
import pages.TestCoursesPage;

public class PageTest {

    private static final Logger logger = LogManager.getLogger(StartOtusPage.class);
    WebDriver driver;
    StartOtusPage startOtusPage;
    TestCoursesPage testCoursesPage;
    CalendarPage calendarPage;

    @BeforeEach
    public void setUp() {
        logger.info("Создание браузера");
        String browserName = System.getProperty("browser", "chrome");
        String typeWindow = System.getProperty("mode", "headless");
        String baseUrl = System.getProperty("base.url", "https://otus.ru/");

        driver = WebDriverFactory.getDriver(browserName, typeWindow);

        startOtusPage = new StartOtusPage(driver);
        testCoursesPage = new TestCoursesPage(driver);
        calendarPage = new CalendarPage(driver);

        logger.info("Открытие страницы");
        startOtusPage.open(baseUrl);
    }

    @AfterEach
    public void down() {
        startOtusPage.close();
        testCoursesPage.close();
        calendarPage.close();
    }

    @Test
    public void checkTestCurses(){
        logger.info("Начало тестов карточек курсов");
        startOtusPage.enter_To_TestCourse(); //Переход на страницу тестирования
        testCoursesPage.openAllCurses(); //Раскрытие списка всех курсов тестирования
        testCoursesPage.countCards();//Подсчет числа карточек
        testCoursesPage.infoCards();//Проверка карточкек
    }

    @Test
    public void checkCalendar(){
        logger.info("Начало теста проверки календаря");
        startOtusPage.enter_To_Calendar(); //Переход на страницу Календаря
        calendarPage.countEvents(); //Подсчет событий
        calendarPage.checkDate(); //Проверка дат
    }

    @Test
    public void checkWebinars() {
        logger.info("Начало теста проверки вебинаров");
        startOtusPage.enter_To_Calendar(); //Переход на страницу Календаря
        calendarPage.enterToWebinars(); //Переход к открытым вебинарам
        calendarPage.openWebinars(); //Проверка типа вебинаров
    }
}
