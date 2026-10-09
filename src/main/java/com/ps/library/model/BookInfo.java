package com.ps.library.model;

// Task 5.1 - Change BookInfo class to use Record
public final class BookInfo {
    private final String title;
    private final String author;
    private final String isbn;

    public BookInfo(String title, String author, String isbn) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("title cannot be blank");
        if (author == null || author.isBlank()) throw new IllegalArgumentException("author cannot be blank");
        if (isbn == null || isbn.isBlank()) throw new IllegalArgumentException("isbn cannot be blank");
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (ISBN: " + isbn + ")";
    }
}
