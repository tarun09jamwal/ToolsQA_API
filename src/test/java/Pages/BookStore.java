package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import static Enums.ToolsQAEnums.ITEMS;

public class BookStore {
    WebDriver driver;
    WebDriverWait wait;
    String list = "//div[@class='card-body']/h5[contains(text(),'%s')]";
    By verify = By.xpath("//div[@class='main-header'][contains(text(),'Book Store')]");

    public BookStore(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    public void Books() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0, 1000)");
        driver.findElement(By.xpath(String.format(list, ITEMS.getResourcesName()))).click();
        String actual = driver.findElement(verify).getText();
        Assert.assertEquals(actual, ITEMS.getResourcesName(), "Expected does not match");
    }
}
