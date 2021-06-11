package com.example.issuetraker.service.commentService;

import com.example.issuetraker.model.Comment;

import java.util.List;

/**
 * Comment Service
 *
 * getAllComment - getting all comments
 *
 * saveComment - save comment
 */
public interface CommentService {
    List<Comment> getAllComment();
    Comment saveComment(Comment comment);
}
