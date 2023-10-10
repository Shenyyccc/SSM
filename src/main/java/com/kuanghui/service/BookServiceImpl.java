package com.kuanghui.service;

import com.kuanghui.mapper.BookMapper;
import com.kuanghui.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    //因为Service层调Dao层：组合Dao层
    @Autowired
    BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Book book) {
        return bookMapper.addBook(book);
    }

    @Override
    public int deleteBookByID(int Id) {
        return bookMapper.deleteBookByID(Id);
    }

    @Override
    public int updateBook(Book book) {
        return bookMapper.updateBook(book);
    }

    @Override
    public Book queryBookByname(String name) {
        return bookMapper.queryBookByname(name);
    }

    @Override
    public List<Book> queryAllBooks() {
        return bookMapper.queryAllBooks();
    }
}
