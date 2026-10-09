package com.ps.library.service;

import com.ps.library.model.LibraryItem;
import java.util.*;

public class InMemoryLibraryCatalog implements LibraryCatalog {
    private final Map<String, LibraryItem> items = new LinkedHashMap<>();

    @Override
    public void addItem(LibraryItem item) {
        items.put(item.getId(), item);
    }

    @Override
    public Optional<LibraryItem> findById(String id) {
        return Optional.ofNullable(items.get(id));
    }

    @Override
    public List<LibraryItem> findByTitle(String title) {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem it : items.values()) {
            if (it.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(it);
            }
        }
        return result;
    }

    @Override
    // Task 3.2 - Implement listAll

}
