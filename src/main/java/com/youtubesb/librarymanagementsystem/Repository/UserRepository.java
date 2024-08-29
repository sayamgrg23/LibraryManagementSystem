package com.youtubesb.librarymanagementsystem.Repository;

import com.youtubesb.librarymanagementsystem.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
