package com.post_hub.iam_serivce.repository;

import com.post_hub.iam_serivce.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

}
