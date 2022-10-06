package com.sparta.post.controller;

import com.sparta.post.Post;
import com.sparta.post.PostRepository;
import com.sparta.post.domain.PostRequestDto;
import com.sparta.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;

    @GetMapping("/api/posts")
    public List<Post> getPost() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }

    @GetMapping("api/posts/{id}")
    public PostRequestDto searchById(@PathVariable long id){
        return postService.searchById(id);
    }

    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto) {

        Post post = new Post(requestDto);

        return postRepository.save(post);
    }
    @PutMapping("/api/posts/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return postService.updatePost(id, requestDto);
    }
    @DeleteMapping("/api/posts/{id}")
    public Long deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
        return id;
    }
}
