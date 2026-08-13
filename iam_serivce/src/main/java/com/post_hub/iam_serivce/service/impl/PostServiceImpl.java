package com.post_hub.iam_serivce.service.impl;

import com.post_hub.iam_serivce.constants.ApiErrorMessage;
import com.post_hub.iam_serivce.dto.post.PostDTO;
import com.post_hub.iam_serivce.entity.PostEntity;
import com.post_hub.iam_serivce.excepton.NotFoundException;
import com.post_hub.iam_serivce.repository.PostRepository;
import com.post_hub.iam_serivce.response.IamResponse;
import com.post_hub.iam_serivce.service.PostSerivce;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostSerivce {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public IamResponse<PostDTO> getById(Long id) {
        PostEntity post = postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ApiErrorMessage.POST_NOT_FOUND_BY_ID.getMessage(id)));

        PostDTO postDto = PostDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .likes(post.getLikes())
                .created(
                        post.getCreated()
                )
                .build();
        return IamResponse.success(postDto);
    }
}
