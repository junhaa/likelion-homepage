package com.homepage.likelion.post.domain;

import com.homepage.likelion.global.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "posts")
public class Post extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "posts_id")
	private Long id;

	@Column(name = "posts_title", nullable = false)
	private String title;

	@Column(name = "posts_content", nullable = false)
	private String content;

	@Column(name = "posted_user_name", nullable = false)
	private String postedUserName;

	@Column(name = "posts_password")
	private String password;

	public void updatePost(String content, String title){
		this.content = content;
		this.title = title;
	}
}
