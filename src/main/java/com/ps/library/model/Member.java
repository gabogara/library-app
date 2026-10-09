package com.ps.library.model;

import java.util.*;

public class Member {
    private final String id;
    private final String name;
    private final List<String> borrowedIds = new ArrayList<>();

    public Member(String id, String name) {
        if (id == null || id.isBlank())
            throw new IllegalArgumentException("id cannot be blank");
        // Task 2.3 - validate name is not blank


        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public List<String> getBorrowedIds() { return Collections.unmodifiableList(borrowedIds); }

    public void borrow(String itemId) {
        borrowedIds.add(itemId);
    }
    public void giveBack(String itemId) { borrowedIds.remove(itemId);
    }
}
