package com.nexters.neighborhood.exception;

/**
 * Created by Dark on 2016. 8. 21..
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "동일한 방에 다시 가입하실 수 없습니다.")
public class DuplicatedRoomCanNotJoinException extends RuntimeException {
    public DuplicatedRoomCanNotJoinException(String msg) {
        super(msg);
    }
}
