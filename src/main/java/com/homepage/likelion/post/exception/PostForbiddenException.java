package com.homepage.likelion.post.exception;

import com.homepage.likelion.global.enums.BaseCode;
import com.homepage.likelion.global.enums.ErrorStatus;
import com.homepage.likelion.global.exception.GeneralException;

public class PostForbiddenException extends GeneralException {
	public PostForbiddenException() {
		super(ErrorStatus._POST_FORBIDDEN);
	}
}
