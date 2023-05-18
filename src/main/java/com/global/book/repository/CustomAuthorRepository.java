package com.global.book.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface CustomAuthorRepository {
    void updateEmail(String email, String name, String phone);
}
