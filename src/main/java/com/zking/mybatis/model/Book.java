package com.zking.mybatis.model;

import lombok.ToString;

import java.io.Serializable;
@ToString
public class Book implements Serializable{
    private Integer id;

    private String bookname;

    private Float price;

    private String booktype;

    public Book(Integer id, String bookname, Float price, String booktype) {
        this.id = id;
        this.bookname = bookname;
        this.price = price;
        this.booktype = booktype;
    }

    public Book() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }
}