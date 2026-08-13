package com.post_hub.iam_serivce.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@Data
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 150)
    private String content;

    @Column(nullable = false, updatable = false)
    private LocalDateTime created = LocalDateTime.now();

    @Column(nullable = false, columnDefinition = "Integer default 0")
    private Integer likes = 0;

}
