import com.kuanghui.pojo.Book;
import com.kuanghui.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl = context.getBean("bookServiceImpl", BookService.class);
        for (Book queryAllBook : bookServiceImpl.queryAllBooks()) {
            System.out.println(queryAllBook);
        }
    }

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl = context.getBean("bookServiceImpl", BookService.class);
        Book book= new Book(1, "java1", 5,null);
        bookServiceImpl.updateBook(book);
    }
}
