package com.example.issuetraker.service.issueService;

import com.example.issuetraker.model.Issue;

import java.util.List;

/**
 * Issue Service
 *
 * getAllIssue - getting all issue
 *
 * saveIssue - save issue
 *
 * getIssueById - get issue by id
 */

public interface IssueService {
    List<Issue> getAllIssue();

    void saveIssue(Issue issue);

    Issue getIssueById(Long id);
}
