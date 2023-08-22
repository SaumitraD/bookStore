package com.api.book.bootrestbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entity.Book;

@Service
public class bookService {

    @Autowired
    private BookRepository bookRepository;

    // private static List<Book> list = new ArrayList<>();
    // static {
    // list.add(new Book(12, "Java", "XYZ"));
    // list.add(new Book(123, "Python", "LMN"));
    // list.add(new Book(124, "C++", "ABC"));
    // }

    // get all books

    public List<Book> getAllBooks() {
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    // get single book

    public Book getBookById(int id) {
        Book book = null;

        try {
            // book = list.stream().filter(e -> e.getId() == id).findFirst().get();
            book = this.bookRepository.findByID(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    // add book

    public Book addBook(Book b) {
        // list.add(b);
        Book result = this.bookRepository.save(b);
        return result;
    }

    // delete book

    public void deleteBook(int bookid) {

        // list = list.stream().filter(book -> {
        // if (book.getId() != bookid) {
        // return true;
        // } else {
        // return false;
        // }
        // }).collect(Collectors.toList());

        bookRepository.deleteById(bookid);
    }

    // update book

    public void updateBook(Book book, int bookid) {

        // list.stream().map(b -> {
        // if (b.getId() == bookid) {
        // b.setTitle(book.getTitle());
        // b.setAuthor(book.getAuthor());
        // }
        // return b;
        // }).collect(Collectors.toList());
        book.setId(bookid);
        bookRepository.save(book);
    }
}
