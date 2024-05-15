package com.homepage.likelion.post.presentation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homepage.likelion.global.response.CustomApiResponse;
import com.homepage.likelion.post.domain.Post;
import com.homepage.likelion.post.presentation.dto.PostRequestDto;
import com.homepage.likelion.post.presentation.dto.PostResponseDto;
import com.homepage.likelion.post.service.PostCommandService;
import com.homepage.likelion.post.service.PostQueryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostRestController {
	private final PostCommandService postCommandService;
	private final PostQueryService postQueryService;


	@PostMapping()
	public CustomApiResponse<PostResponseDto.PostCreateResponseDto> createPost(@Valid @RequestBody PostRequestDto.PostCreateDto request){
		return CustomApiResponse.createSuccess(postCommandService.createPost(request), "성공적으로 게시글을 생성했습니다.");
	}

	@PutMapping("/{postId}")
	public CustomApiResponse<?> modifyPost(@PathVariable(name = "postId") Long postId, @RequestBody PostRequestDto.PostCreateDto request){
		return CustomApiResponse.createSuccess(postCommandService.modifyPost(request, postId),"성공적으로 게시글을 변경했습니다.");
	}

	@GetMapping("/{postId}")
	public CustomApiResponse<PostResponseDto.PostDetailDto> getOnePost(@PathVariable(name = "postId") Long postId){
		return CustomApiResponse.createSuccess(postQueryService.getOnePost(postId), "조회에 성공했습니다.");
	}

	@GetMapping("/posts")
	public CustomApiResponse<List<PostResponseDto.PostDetailDto>> getAllPost(){
		return CustomApiResponse.createSuccess(postQueryService.getAllPost(), "조회에 성공했습니다.");
	}

	// @GetMapping("/posts/{userId}")
	// public CustomApiResponse<List<PostResponseDto.PostDetailDto>> getUserPost(@PathVariable(name = "userId") Long userId){
	// 	return CustomApiResponse.createSuccess(postQueryService.getUserPost(userId), "조회에 성공했습니다.");
	// }
}
