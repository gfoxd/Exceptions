package Exceptions;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int availableCopies;

    public Book(String title, String author, int availableCopies) {
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void availableCopiesMinusOne() {
        this.availableCopies--;
    }

    public void availableCopiesPlusOne() {
        this.availableCopies++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return availableCopies == book.availableCopies && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, availableCopies);
    }
}
