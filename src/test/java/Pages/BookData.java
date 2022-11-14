package Pages;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;


public class BookData {
    WebDriver driver;

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
            APIPojoClass bookData = new APIPojoClass(JsonObject.get("title").toString(), JsonObject.get("author").toString(), JsonObject.get("publisher").toString());
            books.add(bookData);
        }
        System.out.println(books);
        APIPojoClass apiPojoClass = books.get(0);
        System.out.println(apiPojoClass.getAuthor());
    }
}
