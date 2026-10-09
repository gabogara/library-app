package com.ps.library.model;

// Task 4.1 - inherit LibraryItem
public class MagazineItem {
    private final int issueNumber;
    private final String month;

    public MagazineItem(String id, String title, int issueNumber, String month) {
        // Task 4.2 - Call super constructor


        this.issueNumber = issueNumber;
        this.month = month;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public String getMonth() {
        return month;
    }

    @Override
    public String toString() {
        return "[Magazine] " + getId() + " | " + getTitle() + " #" + issueNumber + " (" + month + ")";
    }
}
