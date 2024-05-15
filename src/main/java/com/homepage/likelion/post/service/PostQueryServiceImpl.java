package com.homepage.likelion.post.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.homepage.likelion.post.converter.PostConverter;
import com.homepage.likelion.post.domain.Post;
import com.homepage.likelion.post.exception.PostNotFoundException;
import com.homepage.likelion.post.presentation.dto.PostResponseDto;
import com.homepage.likelion.post.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostQueryServiceImpl implements PostQueryService{
	private final PostRepository postRepository;

	@Override
	public PostResponseDto.PostDetailDto getOnePost(Long postId){
		Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException());
		return PostConverter.toPostDetailDto(post);
	}

	@Override
	public List<PostResponseDto.PostDetailDto> getAllPost(){
		List<Post> postList = postRepository.findAll();
		return postList.stream().map(PostConverter::toPostDetailDto).collect(Collectors.toList());
	}

	// @Override
	// public List<PostResponseDto.PostDetailDto> getUserPost(Long userId){
		// List<Post> postList = postRepository.findByUserId(userId);
		// return postList.stream().map(PostConverter::toPostDetailDto).collect(Collectors.toList());
	// }

	
}
