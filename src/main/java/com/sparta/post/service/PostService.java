package com.sparta.post.service;

import com.sparta.post.domain.Post;
import com.sparta.post.repository.PostRepository;
import com.sparta.post.dto.PostRequestDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public PostRequestDto searchById(long id){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 글입니다.")
        );
        return  new PostRequestDto();
    }

    @Transactional
    public void delete(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 글입니다.")
        );
        postRepository.delete(post);
    }
    @Transactional
    public Long updatePost(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 글입니다.")
        );
        post.updatePost(requestDto.getPost(), requestDto.getPw(), requestDto.getTitle());
        return id;
    }
}