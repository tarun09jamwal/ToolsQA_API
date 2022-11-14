package Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    WebDriver driver;

    private ToolsQAList toolsQAList;
    private BookStore bookStore;
    private BookData bookData;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public BookData getBookData()
    {
        if (bookData == null)
        {
            bookData = new BookData(driver);
        }
        return bookData;
    }
    public ToolsQAList getToolsQAList()
    {
        if(toolsQAList ==null)
        {
            toolsQAList = new ToolsQAList(driver);
        }
        return toolsQAList;
    }
    public BookStore getBookStore()
    {
        if (bookStore ==  null)
        {
            bookStore = new BookStore(driver);
        }
        return bookStore;
    }

}
