package com.ps.library.model;

public abstract class LibraryItem {
    private final String id;
    private final String title;

    public LibraryItem(String id, String title) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("id cannot be blank");
        if (title == null || title.isBlank()) throw new IllegalArgumentException("title cannot be blank");
        this.id = id;
        this.title = title;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
}
