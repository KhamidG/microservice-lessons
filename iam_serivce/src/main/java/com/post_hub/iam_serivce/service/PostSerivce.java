package com.post_hub.iam_serivce.service;

import com.post_hub.iam_serivce.dto.post.PostDTO;
import com.post_hub.iam_serivce.response.IamResponse;
import org.antlr.v4.runtime.misc.NotNull;

public interface PostSerivce {

    IamResponse<PostDTO> getById(@NotNull Long id);
}
