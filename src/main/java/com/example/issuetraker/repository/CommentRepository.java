package com.example.issuetraker.repository;


import com.example.issuetraker.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Jpa repository for managing comments
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
