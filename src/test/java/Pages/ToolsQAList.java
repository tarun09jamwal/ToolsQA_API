package Pages;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class ToolsQAList {
    WebDriver driver;
    List<WebElement> allElementDisplay;
    String arr[] = {"Elements", "Forms", "Alerts, Frame & Windows", "Widgets", "Interactions", "Book Store Application"};
    String allProducts = "//div[@class='card mt-4 top-card']";
    String listEle = "//h5[contains(text(),'%s')]";

    public ToolsQAList(WebDriver driver) {
        this.driver = driver;
    }

    public void AllList() {
        allElementDisplay = driver.findElements(By.xpath(allProducts));
        for (WebElement allElements : allElementDisplay) {
            String StrLinkText = allElements.getText();
            System.out.println(StrLinkText);
        }
        for (String str : Arrays.asList(arr)) {
            String actual = driver.findElement(By.xpath(String.format(listEle, str))).getText();
            Assert.isTrue(actual.equals(str), "Expected result does not match with actual result");
        }
    }
}
