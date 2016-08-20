package com.nexters.neighborhood.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Dark on 2016. 8. 15..
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "올바르지 않은 계정 정보를 입력하셨습니다.")
public class SignUpFailException extends RuntimeException {
}
