package com.nexters.neighborhood.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Dark on 2016. 8. 21..
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "가입할 수 있는 지역의 갯수는 최대 3개입니다.")
public class ExceedLimitRegionCountException extends RuntimeException {
    public ExceedLimitRegionCountException(String msg) {
        super(msg);
    }
}
