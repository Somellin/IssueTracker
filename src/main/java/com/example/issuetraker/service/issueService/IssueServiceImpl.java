package com.example.issuetraker.service.issueService;

import com.example.issuetraker.model.Issue;
import com.example.issuetraker.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IssueServiceImpl implements IssueService {

    /**
     * Auto-create repository
     */
    @Autowired
    IssueRepository issueRepository;

    /**
     * Get All issue
     * @return - list all issues
     */
    @Override
    public List<Issue> getAllIssue() {
        return issueRepository.findAll();
    }

    /**
     * Save issue
     * @param issue - current issue
     */
    @Override
    public void saveIssue(Issue issue) {
        this.issueRepository.save(issue);
    }

    /**
     * Get issue by id
     * @param id - current issue id
     * @return - current issue
     */
    @Override
    public Issue getIssueById(Long id) {
        Optional<Issue> optional = issueRepository.findById(id);
        Issue issue = null;
        if (optional.isPresent()) {
            issue = optional.get();
        } else {
            throw new RuntimeException("Issue not found for id :: " + id);
        }
        return issue;
    }
}
