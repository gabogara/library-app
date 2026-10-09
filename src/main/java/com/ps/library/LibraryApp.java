package com.ps.library;

import com.ps.library.model.BookInfo;
import com.ps.library.model.BookItem;
import com.ps.library.model.MagazineItem;
import com.ps.library.model.Member;
import com.ps.library.service.InMemoryLibraryCatalog;
import com.ps.library.service.LendingService;
import com.ps.library.service.LibraryCatalog;
import com.ps.library.service.SimpleLendingService;

import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {

        LibraryCatalog catalog = new InMemoryLibraryCatalog();
        LendingService lending = new SimpleLendingService(catalog, 3);

        seed(catalog, lending);

        printMenu(catalog, lending);
    }

    private static void printMenu(LibraryCatalog catalog, LendingService lending) {
        System.out.println("=== Pluralsight Library ===");
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("[1] Add Book  [2] Add Magazine  [3] Register Member  [4] List Items  " +
                    "[5] Lend  [6] Return  [7] List Borrowed  [8] Exit");
            System.out.print("Choose: ");

            String choice = sc.nextLine().trim();
            try {
                switch (choice) {
                    case "1" -> addBook(sc, catalog);
                    case "2" -> addMagazine(sc, catalog);
                    case "3" -> register(sc, lending);
                    case "4" -> listItems(catalog);
                    case "5" -> lend(sc, lending);
                    case "6" -> returnItem(sc, lending);
                    case "7" -> listBorrowed(sc, lending);
                    case "8" -> running = false;
                    default -> System.out.println("Invalid option");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("Goodbye");
    }

    private static void seed(LibraryCatalog catalog, LendingService lending) {
        catalog.addItem(new BookItem("B1", new BookInfo("Effective Java", "Joshua Bloch", "9780134685991")));
        catalog.addItem(new BookItem("B2", new BookInfo("Clean Code", "Robert C. Martin", "9780132350884")));
        catalog.addItem(new MagazineItem("M1", "The Java Magazine", 87, "July"));
        lending.register(new Member("M001", "Alice"));
        lending.register(new Member("M002", "Bob"));
    }

    private static void addBook(Scanner sc, LibraryCatalog catalog) {
        System.out.print("Id: ");
        String id = sc.nextLine();
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Author: ");
        String author = sc.nextLine();
        System.out.print("ISBN: ");
        String isbn = sc.nextLine();
        catalog.addItem(new BookItem(id, new BookInfo(title, author, isbn)));
        System.out.println("Added book");
    }

    private static void addMagazine(Scanner sc, LibraryCatalog catalog) {
        System.out.print("Id: ");
        String id = sc.nextLine();
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Issue number: ");
        int issue = Integer.parseInt(sc.nextLine());
        System.out.print("Month: ");
        String month = sc.nextLine();
        catalog.addItem(new MagazineItem(id, title, issue, month));
        System.out.println("Added magazine");
    }

    private static void register(Scanner sc, LendingService lending) {
        System.out.print("Member id: ");
        String id = sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        lending.register(new Member(id, name));
        System.out.println("Member registered");
    }

    private static void listItems(LibraryCatalog catalog) {
        System.out.println("Items:");
        for (var it : catalog.listAll()) {
            System.out.println(" - " + it.toString());
        }
    }

    private static void lend(Scanner sc, LendingService lending) {
        System.out.print("Member id: ");
        String mid = sc.nextLine();
        System.out.print("Item id: ");
        String iid = sc.nextLine();
        lending.lend(mid, iid);
        System.out.println("Lent successfully");
    }

    private static void returnItem(Scanner sc, LendingService lending) {
        System.out.print("Member id: ");
        String mid = sc.nextLine();
        System.out.print("Item id: ");
        String iid = sc.nextLine();
        lending.returnItem(mid, iid);
        System.out.println("Returned successfully");
    }

    private static void listBorrowed(Scanner sc, LendingService lending) {
        System.out.print("Member id: ");
        String mid = sc.nextLine();
        var list = lending.listBorrowed(mid);
        System.out.println("Borrowed: " + list);
    }
}
