package org.example.booksearchusingmvc;

public class BookPojo {
    private int bookId;
    private String bookName;
    private String subject;
    private double bookPrice;

    public BookPojo() {}

    public BookPojo(int bookId, String bookName, String subject, double bookPrice) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.subject = subject;
        this.bookPrice = bookPrice;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }
}
