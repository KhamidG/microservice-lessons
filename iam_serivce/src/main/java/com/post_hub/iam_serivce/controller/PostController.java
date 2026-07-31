package com.post_hub.iam_serivce.controller;

import com.post_hub.iam_serivce.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/posts")
public class PostController {


    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> create(@RequestBody Map<String, Object> requestBody){
        String title = (String) requestBody.get("title");
        String content = (String) requestBody.get("content");

        String postContent = "Title: " + title + "\nContent: " + content;

        postService.createPost(postContent);
        return new ResponseEntity<>(postContent, HttpStatus.OK);
    }

}
