package com.api.book.bootrestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.entity.Book;
import com.api.book.bootrestbook.services.bookService;

@RestController
public class bookcontroller {
    @Autowired
    private bookService bookService;

    // get all books handler

    @GetMapping("/books")
    public List<Book> getBooks() {
        // Book book = new Book();
        // book.setId(123);
        // book.setTitle("xyz");
        // book.setAuthor("abc");

        return this.bookService.getAllBooks();
    }

    // get one book handler

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id) {
        return bookService.getBookById(id);
    }

    // add a book handler

    @PostMapping("/book")
    public Book addBook(@RequestBody Book book) {
        Book b = this.bookService.addBook(book);
        return b;
    }

    // delete book handler

    @DeleteMapping("/book/{bookid}")
    public void deleteBook(@PathVariable("bookid") int bookid) {
        this.bookService.deleteBook(bookid);
    }

    // update book

    @PutMapping("/book/{bookid}")
    public Book updateBook(@RequestBody Book book, @PathVariable("bookid") int bookid) {
        this.bookService.updateBook(book, bookid);
        return book;
    }

}
