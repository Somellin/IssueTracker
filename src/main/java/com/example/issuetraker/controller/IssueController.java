package com.example.issuetraker.controller;


import com.example.issuetraker.model.Comment;
import com.example.issuetraker.model.Issue;
import com.example.issuetraker.service.commentService.CommentService;
import com.example.issuetraker.service.issueService.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Controller - data management
 */

@Controller
public class IssueController {

    /**
     * Constructor autocomplete
     */
    @Autowired
    private IssueService issueService;

    /**
     * Constructor autocomplete
     */
    @Autowired
    private CommentService commentService;

    /**
     * Getting url and displaying registration page
     * @return - registration page
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * Main page with a list of all issues
     * @param model - encapsulating application data
     * @return - main page
     */
    @GetMapping("/")
    public String getAllIssue(Model model) {
        model.addAttribute("listIssue", issueService.getAllIssue());
        return "index";
    }

    /**
     * Page for
     * creating a new problem and passing
     * it to the attributes of the model
     *
     * @param model - encapsulating application data
     * @return - new issue page
     */
    @GetMapping("/showNewIssueForm")
    public String showNewIssueForm(Model model) {
        Issue issue = new Issue();
        model.addAttribute("issue", issue);
        return "new_issue";
    }

    /**
     * Post method for creating a new problem
     * and go to the main page
     *
     * @param issue - An object has been created for later saving
     * @return - main page
     */
    @PostMapping("/saveIssue")
    public String saveIssue(@ModelAttribute("issue") Issue issue) {

        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat time = new SimpleDateFormat("HH:mm");

        issue.setDate(date.format(new Date()));
        issue.setTime(time.format(new Date()));
        issue.setStatus("Created");
        issueService.saveIssue(issue);
        return "redirect:/";
    }

    /**
     * Issue details page
     * Adding to the model attribute:
     * issue,
     * comments list,
     * comment object to create it
     * @param id - id of the current issue
     * @param comment - object of the comment
     * @param model - encapsulating application data
     * @return - page issue details
     */
    @GetMapping("/viewIssue/{id}")
    public String viewIssue(@PathVariable(value = "id") Long id,
                            @ModelAttribute("comment") Comment comment,
                            Model model) {
        Issue issue = issueService.getIssueById(id);
        model.addAttribute("issue", issue);
        model.addAttribute("comments", issue.getComments());
        model.addAttribute("comment", comment);
        return "view_issue";
    }

    /**
     *
     * @param id - id of the current issue
     * @param commentDetails - a comment object to create it
     * @return - page current issue details
     */

    @PostMapping("/saveComment/{id}")
    public String saveComment(@PathVariable(value = "id") Long id,
                              @ModelAttribute("comment") Comment commentDetails) {

        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        commentDetails.setDate(date.format(new Date()));
        Comment comment = commentService.saveComment(commentDetails);

        Issue issue = issueService.getIssueById(id);
        issue.getComments().add(comment);
        issue.setStatus(comment.getStatus());

        issueService.saveIssue(issue);
        return "redirect:/viewIssue/{id}";
    }

}
