package com.ps.library.service;

import com.ps.library.model.LibraryItem;
import java.util.*;

public interface LibraryCatalog {
    void addItem(LibraryItem item);
    Optional<LibraryItem> findById(String id);
    List<LibraryItem> findByTitle(String title);
    // Task 3.1 - Define contract to list all items in the catalog
}
