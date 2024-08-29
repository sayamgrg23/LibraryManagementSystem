package com.youtubesb.librarymanagementsystem.Controller;

import com.youtubesb.librarymanagementsystem.Entity.BookEntity;
import com.youtubesb.librarymanagementsystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookEntity> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookEntity getBook(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping
    public BookEntity addBook(@RequestBody BookEntity book) {
        return bookService.save(book);
    }

    @PutMapping("/{id}")
    public BookEntity updateBook(@PathVariable Long id, @RequestBody BookEntity book) {
        return bookService.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @PostMapping("/{bookId}/borrow/{userId}")
    public ResponseEntity<BookEntity> borrowBook(@PathVariable Long bookId, @PathVariable Long userId) {
        BookEntity borrowedBook = bookService.borrowBook(bookId, userId);
        if (borrowedBook != null) {
            return ResponseEntity.ok(borrowedBook);
        } else {
            return ResponseEntity.badRequest().build(); // or a more descriptive error response
        }
    }

    @PostMapping("/{bookId}/return")
    public ResponseEntity<BookEntity> returnBook(@PathVariable Long bookId) {
        BookEntity returnedBook = bookService.returnBook(bookId);
        if (returnedBook != null) {
            return ResponseEntity.ok(returnedBook);
        } else {
            return ResponseEntity.badRequest().build(); // or a more descriptive error response
        }
    }
}