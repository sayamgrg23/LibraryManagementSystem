package com.youtubesb.librarymanagementsystem.Service;

import com.youtubesb.librarymanagementsystem.Entity.BookEntity;
import com.youtubesb.librarymanagementsystem.Entity.UserEntity;
import com.youtubesb.librarymanagementsystem.Repository.BookRepository;
import com.youtubesb.librarymanagementsystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    public BookEntity findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public BookEntity save(BookEntity book) {
        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public BookEntity borrowBook(Long bookId, Long userId) {
        BookEntity book = findById(bookId);
        UserEntity user = userRepository.findById(userId).orElse(null);

        if (book != null && !book.isBorrowed() && user != null) {
            book.setBorrowedBy(user);
            book.setBorrowed(true);
            return save(book);
        }
        // Handle errors (e.g., book not found, book already borrowed, user not found)
        return null;
    }

    public BookEntity returnBook(Long bookId) {
        BookEntity book = findById(bookId);
        if (book != null && book.isBorrowed()) {
            book.setBorrowedBy(null);
            book.setBorrowed(false);
            return save(book);
        }
        // Handle errors (e.g., book not found, book not borrowed)
        return null;
    }
}
