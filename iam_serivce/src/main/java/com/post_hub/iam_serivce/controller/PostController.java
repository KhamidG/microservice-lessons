package com.post_hub.iam_serivce.controller;

import com.post_hub.iam_serivce.constants.ApiLogMessage;
import com.post_hub.iam_serivce.dto.post.PostDTO;
import com.post_hub.iam_serivce.response.IamResponse;
import com.post_hub.iam_serivce.service.PostSerivce;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
@Slf4j
public class PostController {
    private final PostSerivce postSerivce;

    @GetMapping("/id/{id}")
    public ResponseEntity<IamResponse<PostDTO>> getPostById(@PathVariable Long id) {
        log.info(ApiLogMessage.POST_INFO_BY_ID.getMessage(id));
        IamResponse<PostDTO> iamResponse = postSerivce.getById(id);
        return ResponseEntity.ok(iamResponse);
    }
}
