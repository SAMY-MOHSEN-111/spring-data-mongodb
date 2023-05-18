package com.global.book.config;

import com.global.book.repository.AuthorRepository;
import com.global.book.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Startup implements CommandLineRunner {

    private final AuthorRepository authorRepository;

    @Autowired
    public Startup(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) {
        if (authorRepository.findAll().isEmpty())
            authorRepository.insert(List.of(
                    new Author("Samy", "samy@gmail.com", "+201156261362"),
                    new Author("Ali", "ali@gmail.com", "+201556261882"),
                    new Author("Omar", "omar@gmail.com", "+201056255322")
            ));


    }
}
