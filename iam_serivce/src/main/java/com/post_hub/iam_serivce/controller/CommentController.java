package com.post_hub.iam_serivce.controller;

import com.post_hub.iam_serivce.service.CommentService;
import com.post_hub.iam_serivce.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private CommentService commentService;

    @Autowired
    public void serCommentService(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createComment(@RequestBody Map<Object, Object> requestBody) {
        String content = (String) requestBody.get("content");
        commentService.createComment(content);

        return new ResponseEntity<>("Comment added: " + content, HttpStatus.OK);
    }
}
