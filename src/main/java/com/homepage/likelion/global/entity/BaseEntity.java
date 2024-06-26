package com.homepage.likelion.global.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class BaseEntity {
	@CreatedDate
	@Column(name = "created_at")
	private LocalDateTime createdAt;


	@LastModifiedDate
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
}
