package Test;

import Pages.BaseClass;
import org.testng.annotations.Test;
import java.io.IOException;

public class TestToolsQAList extends BaseClass {
    @Test
    public void ListElements() throws IOException {
        pageFactory.getToolsQAList().AllList();
    }

    @Test(priority = 1)
    public void Book()
    {
        pageFactory.getBookStore().Books();
    }
    @Test(priority = 2)
    public void BooksData() {
        pageFactory.getBookData().API();
    }
}
