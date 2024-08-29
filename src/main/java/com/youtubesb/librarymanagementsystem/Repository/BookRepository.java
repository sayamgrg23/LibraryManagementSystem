package com.youtubesb.librarymanagementsystem.Repository;

import com.youtubesb.librarymanagementsystem.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
