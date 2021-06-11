package com.example.issuetraker.repository;

import com.example.issuetraker.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Jpa repository for managing issue
 */

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
}
