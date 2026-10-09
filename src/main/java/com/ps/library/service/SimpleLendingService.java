package com.ps.library.service;

import com.ps.library.model.BookItem;
import com.ps.library.model.LibraryItem;
import com.ps.library.model.Member;
import com.ps.library.model.exceptions.ItemNotAvailableException;
import com.ps.library.model.exceptions.MemberLimitExceededException;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SimpleLendingService implements LendingService {
    private final LibraryCatalog catalog;
    private final Map<String, Member> members = new LinkedHashMap<>();
    private final int borrowLimit;

    public SimpleLendingService(LibraryCatalog catalog, int borrowLimit) {
        this.catalog = catalog;
        this.borrowLimit = borrowLimit;
    }

    @Override
    public void register(Member member) {
        members.put(member.getId(), member);
    }

    @Override
    public void lend(String memberId, String itemId) {
        Member m = requireMember(memberId);
        if (m.getBorrowedIds().size() >= borrowLimit) {
            // Task 6.1 - throw MemberLimitExceededException
            throw new IllegalStateException("Borrow limit reached for member " + memberId);
        }
        LibraryItem item = catalog.findById(itemId).orElseThrow(() -> new IllegalArgumentException("Item not found"));
        // Task 4.3 - Use instanceof

        {
            if (!b.isAvailable()) {
                // Task 6.2 - throw ItemNotAvailableException
                throw new IllegalStateException("Book already borrowed");
            }
            b.markBorrowed();
            m.borrow(itemId);
        }
    }

    @Override
    public void returnItem(String memberId, String itemId) {
        Member m = requireMember(memberId);
        LibraryItem item = catalog.findById(itemId).orElseThrow(() -> new IllegalArgumentException("Item not found"));
        // Task 4.4 - Use instanceof

            b.markReturned();
    }

    @Override
    public List<String> listBorrowed(String memberId) {
        return requireMember(memberId).getBorrowedIds();
    }

    private Member requireMember(String memberId) {
        Member m = members.get(memberId);
        if (m == null)
            throw new IllegalArgumentException("Member not registered: " + memberId);
        return m;
    }
}
