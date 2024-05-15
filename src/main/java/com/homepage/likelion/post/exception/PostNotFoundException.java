package com.homepage.likelion.post.exception;

import com.homepage.likelion.global.enums.BaseCode;
import com.homepage.likelion.global.enums.ErrorStatus;
import com.homepage.likelion.global.exception.GeneralException;

public class PostNotFoundException extends GeneralException {
	public PostNotFoundException() {
		super(ErrorStatus._POST_NOT_FOUND);
	}
}
