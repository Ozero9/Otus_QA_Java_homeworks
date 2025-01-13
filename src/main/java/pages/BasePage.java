package pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver;
    private static final Logger logger = LogManager.getLogger(BasePage.class);

    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    public void open(String url){
        logger.info("Open page "+url);
        driver.get(url);
    }

    public void close(){
        if (driver!= null) {
            logger.info("Browser closed");
            driver.quit();
        }
    }
}
