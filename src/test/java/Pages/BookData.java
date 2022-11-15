package Pages;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.util.ArrayList;
import static Enums.ToolsQAEnums.*;


public class BookData {
    WebDriver driver;
    String book = "//span[@class='mr-2']//a[contains(text(),'%s')]";
    String author = "//div[@class='rt-td'][contains(text(),'%s')]";
    By publisher = By.xpath("//div[@class='rt-td'][contains(text(),'Reilly Media')][1]");

    public BookData(WebDriver driver) {
        this.driver = driver;
    }

    public void API() {

        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.get("https://demoqa.com/BookStore/v1/Books");
        ResponseBody responseBody = response.getBody();
        String responseBod = responseBody.asString();

        JsonElement fileElement = JsonParser.parseString(responseBod);
        JsonObject fileObject = fileElement.getAsJsonObject();
        JsonArray jsonArrayOfBooks = fileObject.get("books").getAsJsonArray();

        ArrayList<APIPojoClass> books = new ArrayList<>();
        for (JsonElement booksElement : jsonArrayOfBooks.getAsJsonArray()) {
            JsonObject JsonObject = booksElement.getAsJsonObject();
            APIPojoClass bookData = new APIPojoClass(JsonObject.get("title").getAsString(), JsonObject.get("author").getAsString(), JsonObject.get("publisher").getAsString());
            books.add(bookData);
        }
        System.out.println(books);
        APIPojoClass apiPojoClass = books.get(0);

        String actual = apiPojoClass.getTitle();
        String expected = driver.findElement(By.xpath(String.format(book, BOOK.getResourcesName()))).getText();
        Assert.assertEquals(actual, expected);

        String actual1 = apiPojoClass.getAuthor();
        String expected1 = driver.findElement(By.xpath(String.format(author, AUTHOR.getResourcesName()))).getText();
        Assert.assertEquals(actual1, expected1);

        String actual2 = apiPojoClass.getPublisher();
        String expected2 = driver.findElement(publisher).getText();
        Assert.assertEquals(actual2, expected2);
    }
}
