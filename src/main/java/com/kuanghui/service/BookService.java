package com.kuanghui.service;

import com.kuanghui.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    //增加一本书
    int addBook(Book book);
    //删除一本书
    int deleteBookByID(int Id);
    //更新一本书
    int updateBook(Book book);
    //根据名字查一本书
    Book queryBookByname(@Param("bookName") String name);
    //查询所有书籍
    List<Book> queryAllBooks();
}
