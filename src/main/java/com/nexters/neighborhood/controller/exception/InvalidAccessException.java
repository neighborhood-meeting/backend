package com.nexters.neighborhood.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Dark on 2016. 8. 15..
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "ID 혹은 Password가 올바르지 않습니다.")
public class InvalidAccessException extends RuntimeException {
}
