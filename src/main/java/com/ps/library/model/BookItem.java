package com.ps.library.model;

public class BookItem extends LibraryItem {
    private final BookInfo info;
    // Task 2.1 - Mark private
    boolean available = true;

    public BookItem(String id, BookInfo info) {
        // Task 5.2 - change from info.getTitle() to info.title()
        super(id, info.getTitle());
        this.info = info;
    }

    public BookInfo getInfo() {
        return info;
    }

    // Task 2.2 - Return state

    @Override
    public String toString() {
        // Task 5.3 - Use title and author accessor methods of BookInfo record
        return "[Book] " + getId() + " | " + info.getTitle() + " by " + info.getAuthor() + " | " + (available ? "Available" : "Borrowed");
    }
}
