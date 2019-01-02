package com.zking.mybatis.service;

import com.zking.mybatis.mapper.BookMapper;
import com.zking.mybatis.model.Book;
import com.zking.mybatis.util.mybatisSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class IBookServiceImplTest {

    private SqlSession sqlSession;
    private IBookService bookService;
    @Before
    public void setUp() throws Exception {
        sqlSession = mybatisSessionFactoryUtils.openSession();
        System.out.println(sqlSession);
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        IBookServiceImpl bs=new IBookServiceImpl();
        bs.setBookMapper(mapper);
        bookService=bs;
    }

    @After
    public void tearDown() throws Exception {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insert() {
        Book book=new Book();
        book.setBookname("saujdo ");
        book.setBooktype("不知");
        book.setPrice(93f);
        bookService.insert(book);
    }

    @Test
    public void queryBook() {
        List<Book> books = bookService.queryBook();
        for (Book book : books) {
            System.out.println(book);
        }

    }
}