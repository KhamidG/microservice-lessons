package com.post_hub.iam_serivce.controller;

import com.post_hub.iam_serivce.constants.ApiErrorMessage;
import com.post_hub.iam_serivce.constants.ApiLogMessage;
import com.post_hub.iam_serivce.entity.PostEntity;
import com.post_hub.iam_serivce.repository.PostRepository;
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
    private final PostRepository postRepository;

    @GetMapping("/id/{id}")
    public ResponseEntity<PostEntity> getPostById(@PathVariable Long id) {
        log.info(ApiLogMessage.POST_INFO_BY_ID.getMessage(id));
        return postRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                    log.info(ApiErrorMessage.POST_NOT_FOUND_BY_ID.getMessage(id));
                    return ResponseEntity.notFound().build();
                });
    }
}
