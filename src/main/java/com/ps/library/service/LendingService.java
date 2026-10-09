package com.ps.library.service;

import com.ps.library.model.Member;
import java.util.List;

public interface LendingService {
    void register(Member member);
    void lend(String memberId, String itemId);
    void returnItem(String memberId, String itemId);
    List<String> listBorrowed(String memberId);
}
