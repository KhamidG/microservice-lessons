package com.post_hub.iam_serivce.service.Impl;

import com.post_hub.iam_serivce.service.CommentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service("advantageCommentSevice")
@Qualifier
public class SecondCommentServiceImpl implements CommentService {

    private List<String> comments = new ArrayList<>();

    @Override
    public void createComment(String comment) {
        String advantageComment = "[" + LocalDateTime.now() + "] " + comment.toUpperCase();
        comments.add(advantageComment);
        System.out.println(advantageComment + " Created!");
    }
}
