package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class ToolsQAList {
    WebDriver driver;
    List<WebElement> allElementDisplay;
    String allProducts = "//div[@class='card mt-4 top-card']";

    public ToolsQAList(WebDriver driver) {
        this.driver = driver;
    }

    public void AllList() {
        allElementDisplay = driver.findElements(By.xpath(allProducts));
        for (WebElement allElements : allElementDisplay) {
            {
                String StrLinkText = allElements.getText();
                System.out.println(StrLinkText);
            }
        }
    }
}
