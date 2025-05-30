package com.dino.book;

public class Book {
	private String bookId;
    private String title;
    private String author;
    private int price;


    public Book(String bookId, String title, String author, int price) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
            this.price = price;
    }


    public String getBookId() {
            return bookId;
    }


    public String getTitle() {
            return title;
    }


    public String getAuthor() {
            return author;
    }


    public int getPrice() {
            return price;
    }
}
