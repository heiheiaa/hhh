package com.zking.mybatis.service;

import com.zking.mybatis.model.Book;

import java.util.List;

public interface IBookService {

    int insert(Book record);

    

    List<Book> queryBook();
}