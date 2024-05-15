package com.homepage.likelion.post.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.homepage.likelion.post.converter.PostConverter;
import com.homepage.likelion.post.domain.Post;
import com.homepage.likelion.post.exception.PostForbiddenException;
import com.homepage.likelion.post.exception.PostNotFoundException;
import com.homepage.likelion.post.presentation.dto.PostRequestDto;
import com.homepage.likelion.post.presentation.dto.PostResponseDto;
import com.homepage.likelion.post.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostCommandServiceImpl implements PostCommandService{
	private final PostRepository postRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public PostResponseDto.PostCreateResponseDto createPost(PostRequestDto.PostCreateDto request){
		String encodedPassword = passwordEncoder.encode(request.getPassword());
		return PostConverter.toPostCreateResponseDto(postRepository.save(PostConverter.toPost(request,encodedPassword)));
	}

	@Override
	@Transactional
	public PostResponseDto.PostCreateResponseDto modifyPost(PostRequestDto.PostCreateDto request, Long postId){
		Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException());
		if(passwordEncoder.matches(request.getPassword(), post.getPassword())){
			post.updatePost(request.getContent(), request.getTitle());
			return PostConverter.toPostCreateResponseDto(postRepository.saveAndFlush(post));
		}
		else throw new PostForbiddenException();
	}




}
