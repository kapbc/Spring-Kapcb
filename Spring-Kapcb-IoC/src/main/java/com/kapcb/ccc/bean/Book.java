package com.kapcb.ccc.bean;

/**
 * <a>Title:Book</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/5/30 19:51
 */
public class Book {

    private String bookName;
    private String author;

    public void myInit(){
        System.out.println("这是图书的初始化方法····");
    }
    public void myDestroy(){
        System.out.println("这是图书的销毁方法····");
    }

    public Book() {
        System.out.println("Book的无参构造器被调用");
    }

    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
