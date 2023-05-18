package com.global.book.service;

import com.global.book.repository.AuthorRepository;
import com.global.book.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author findById(String id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author with id: " + id + " not found"));
    }

    public Author findByEmail(String email) {
        return authorRepository.findAuthorByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email: " + email + " doesn't exist"));
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author insert(Author author) {
        return authorRepository.insert(author);
    }

    public List<Author> insertAll(List<Author> authors) {
        return authorRepository.insert(authors);
    }

    public Author update(Author author) {
        Author dbAuthor = authorRepository.findById(author.getId())
                .orElseThrow(() -> new RuntimeException("Author with id: " + author.getId() + " doesn't exist"));

        dbAuthor.setName(author.getName());
        dbAuthor.setEmail(author.getEmail());
        dbAuthor.setPhone(author.getPhone());

        return authorRepository.save(dbAuthor);
    }

    public void updateEmail(String email, String name, String phone) {
        authorRepository.updateEmail(email, name, phone);
    }

    public void deleteById(String id) {
        authorRepository.deleteById(id);
    }


}
