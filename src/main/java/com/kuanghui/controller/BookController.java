package com.kuanghui.controller;

import com.kuanghui.pojo.Book;
import com.kuanghui.service.BookService;
import com.kuanghui.utils.UUIDutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/book1")
public class BookController {
    //controller调service
    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    //查询所有的书籍
    @RequestMapping("/allBook")
    public String list(Model model){
        model.addAttribute("list",bookService.queryAllBooks());
        return "allbook";
    }

    //跳转到增加书籍页面
    @RequestMapping("/toaddBook")
    public String toadd(Model model){
        return "toaddBook";
    }

    //增加书籍
    @RequestMapping("/addBook")
    public String add(Book book){
        Random random=new Random();
        book.setId(random.nextInt(10000));
        System.out.println("==>"+book);
        bookService.addBook(book);
        return "redirect:/book1/allBook";
    }

    //跳转到修改书籍页面
    @RequestMapping("/tomodifyBook")
    public String tomodify(String bookName,Model model){
        Book book = bookService.queryBookByname(bookName);
        System.out.println(book);
        model.addAttribute("book",book);
        return "tomodifyBook";
    }

    //修改书籍
    @RequestMapping("/modifyBook")
    public String modify(Book book){
        Book b1=bookService.queryBookByname(book.getBookName());
        book.setId(b1.getId());
        System.out.println("===>modify:"+book);
        int i = bookService.updateBook(book);
        return "redirect:/book1/allBook";
    }

    //删除书籍
    @RequestMapping("/deleteBook")
    public String delete(String bookName){
        Book book=bookService.queryBookByname(bookName);
        System.out.println("===>modify:"+book);
        int i = bookService.deleteBookByID(book.getId());
        return "redirect:/book1/allBook";
    }

    //查询书籍
    //查询所有的书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookname,Model model){
        System.out.println(queryBookname);
        Book book;
        List<Book> list=new ArrayList<>();
        if(queryBookname!=null&&queryBookname!=""){
            book = bookService.queryBookByname(queryBookname);
            list.add(book);
            System.out.println("==>query:"+book);
        }else {
            list = bookService.queryAllBooks();
        }
        model.addAttribute("list",list);
        return "allbook";
    }
}
