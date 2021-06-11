package com.example.issuetraker.service.commentService;


import com.example.issuetraker.model.Comment;
import com.example.issuetraker.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    /**
     * Auto-create repository
     */
    @Autowired
    CommentRepository commentRepository;

    /**
     * Get all comments
     * @return - List of all comments
     */
    @Override
    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    /**
     * Save a comment
     * @return - current comment
     */
    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
