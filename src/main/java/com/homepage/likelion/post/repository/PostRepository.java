package com.homepage.likelion.post.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homepage.likelion.post.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	Optional<Post> findById(Long postId);
	// List<Post> findById(Long userId);


}
