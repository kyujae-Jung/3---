package com.sparta.post.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PostRequestDto {
    private String title;
    private String post;
    private String author;
    private String pw;

    public PostRequestDto(String title, String post, String author) {
        this.title = title;
        this.post = post;
        this.author = author;
    }
}
