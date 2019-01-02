package com.zking.mybatis.service;

import com.zking.mybatis.mapper.BookMapper;
import com.zking.mybatis.model.Book;

import java.util.List;

public class IBookServiceImpl implements IBookService {
    private BookMapper bookMapper;

    public BookMapper getBookMapper() {
        return bookMapper;
    }

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int insert(Book record) {
        return bookMapper.insert(record);
    }

    @Override
    public List<Book> queryBook() {
        return bookMapper.queryBook();
    }
}
