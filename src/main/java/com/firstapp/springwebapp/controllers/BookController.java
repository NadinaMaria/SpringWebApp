package com.firstapp.springwebapp.controllers;

import com.firstapp.springwebapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //when we do an action against the URL of Books, the method is invoked by the Spring MVC
    @RequestMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("carti", bookRepository.findAll());
        return "books/list";
    }
}
