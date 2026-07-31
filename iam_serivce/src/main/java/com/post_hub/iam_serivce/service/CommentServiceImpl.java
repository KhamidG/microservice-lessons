package com.post_hub.iam_serivce.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final List<String> comments = new ArrayList<>();


    @Override
    public void createComment(String comment) {
        comments.add(comment);

    }
}
