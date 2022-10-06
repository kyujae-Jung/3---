package com.sparta.post;

import com.sparta.post.domain.PostRequestDto;
import com.sparta.post.service.PostService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class PostApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostApplication.class, args);
    }
    @Bean
    public CommandLineRunner demo(PostRepository postRepository, PostService postService) {
        return (args) -> {
            // 데이터 저장하기
            postRepository.save(new Post("제목", "글", "정규재"));
            // 데이터 전부 조회하기
            System.out.println("데이터 인쇄");
            List<Post> postList = postRepository.findAll();
            for (int i=0; i<postList.size(); i++) {
                Post post = postList.get(i);
                System.out.println(post.getId());
                System.out.println(post.getTitle());
                System.out.println(post.getPost());
                System.out.println(post.getAuthor());
            }

            PostRequestDto requestDto = new PostRequestDto("제목", "글","정규재");
            postService.updatePost(1L, requestDto);
            postList = postRepository.findAll();
            for (int i=0; i<postList.size(); i++) {
                Post post = postList.get(i);
                System.out.println(post.getId());
                System.out.println(post.getTitle());
                System.out.println(post.getPost());
                System.out.println(post.getAuthor());
            }
            postRepository.deleteAll();
        };
    }
}
