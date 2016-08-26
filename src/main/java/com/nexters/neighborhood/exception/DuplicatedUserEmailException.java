package com.nexters.neighborhood.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Dark on 2016. 8. 27..
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "같은 이름의 이메일로는 가입하실 수 없습니다.")
public class DuplicatedUserEmailException extends RuntimeException {
}
