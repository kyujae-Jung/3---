package com.sparta.post.domain;

import com.sparta.post.dto.PostRequestDto;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor // 기본생성자를 대신 생성해줍니다.
@Entity// 테이블임을 나타냅니다.
public class Post extends Timestamped {

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long id;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String title;

    @Column(nullable = false)
    private String post;

    @Column(nullable = false)
    private String author;

    public Post(String title, String post, String author) {
        this.title = title;
        this.post = post;
        this.author = author;
    }

    public void updatePost(String author, String title, String post){
        this.title = title;
        this.author = author;
        this.post = post;
    }
//상세 조회를 위해 PostRequestDto 추가하여 Post까지 전달 가능
    public Post(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.post = requestDto.getPost();
        this.author = requestDto.getAuthor();

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPost() {
        return this.post;
    }

    public String getAuthor() {
        return this.author;
    }
}