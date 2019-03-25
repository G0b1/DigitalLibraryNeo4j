package com.library.service.controller;

import com.library.service.domain.Book;
import com.library.service.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping(value = "/book")
    public Book findByTitle(@RequestParam String title) {
        return bookService.findByTitle(title);
    }
    @GetMapping(value = "/books")
    public Collection<Book> findByTitleLike(@RequestParam String title) {
        return bookService.findByTitleLike(title);
    }

    @GetMapping("/graph")
    public Map<String, Object> graph(@RequestParam(value = "limit",required = false) Integer limit) {
        return bookService.graph(limit == null ? 100 : limit);
    }
}
