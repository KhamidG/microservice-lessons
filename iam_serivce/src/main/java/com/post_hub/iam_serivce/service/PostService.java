package com.post_hub.iam_serivce.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private List<String> posts = new ArrayList<>();

    public void createPost(String postContent){
        posts.add(postContent);
    }
}
