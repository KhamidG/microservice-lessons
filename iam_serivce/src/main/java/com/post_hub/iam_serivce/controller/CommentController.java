package com.post_hub.iam_serivce.controller;

import com.post_hub.iam_serivce.service.CommentService;
import com.post_hub.iam_serivce.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentService deffaultCommentService;
    private final CommentService advancedCommentService;

    @Autowired
    public CommentController(
            CommentService deffaultCommentService,
            @Qualifier("advantageCommentSevice") CommentService advancedCommentService) {
        this.deffaultCommentService = deffaultCommentService;
        this.advancedCommentService = advancedCommentService;
    }

    @PostMapping("/create-default")
    public ResponseEntity<String> createDefaultComment(@RequestBody Map<Object, Object> requestBody) {
        String content = (String) requestBody.get("content");
        deffaultCommentService.createComment(content);

        return new ResponseEntity<>("Default comment added: " + content, HttpStatus.OK);
    }

    @PostMapping("/create-advantage")
    public ResponseEntity<String> createAdvantageComment(@RequestBody Map<Object, Object> requestBody) {
        String content = (String) requestBody.get("content");
        advancedCommentService.createComment(content);

        return new ResponseEntity<>("Advantage comment added: " + content, HttpStatus.OK);
    }
}
