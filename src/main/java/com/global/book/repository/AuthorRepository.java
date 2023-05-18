package com.global.book.repository;

import com.global.book.entity.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends MongoRepository<Author, String>, CustomAuthorRepository {
    @Query(value = "{email: ?0}", fields = "{name: 1,email: 1,_id: 0}")
    Optional<Author> findAuthorByEmail(String email);
}
