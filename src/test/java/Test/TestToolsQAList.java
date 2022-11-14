package Test;

import Pages.BaseClass;
import org.testng.annotations.Test;
import java.io.IOException;

public class TestToolsQAList extends BaseClass {
    @Test
    public void ListElements() {
        pageFactory.getToolsQAList().AllList();
    }

    @Test(priority = 1)
    public void Book()
    {
        pageFactory.getBookStore().Books();
    }
    @Test(priority = 2)
    public void BooksData() throws IOException {
        pageFactory.getBookData().API();
    }
}
