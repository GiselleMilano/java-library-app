package org.example;

import java.io.File;
import java.util.List;
import org.example.utilities.FileUtility;

public class Library {
    private List<Book> books;
    private String path = "library.txt";

    FileUtility fileUtility = new FileUtility();

    public String saveBook(Book book) {
        String json = fileUtility.serializeJson(book);
        fileUtility.writeFile(path, json);
        return "Book Saved";
    }

    public List<Book> getBooks() {
        File file = fileUtility.getFileFromPath(path);
        List<Book> books = fileUtility.deserializeJson(file);
        return books;
    }

    public Book getBookByAuthor(String author) {
        System.out.println("Entro a getBookByAuthor");
        return null;
    }

    public Book getBookByTitle(String title) {
        System.out.println("Entro a getBookByTitle");
        return null;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Library{" + books + '}';
    }
}
