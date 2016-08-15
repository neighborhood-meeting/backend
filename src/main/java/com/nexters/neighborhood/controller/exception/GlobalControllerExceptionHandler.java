package com.nexters.neighborhood.controller.exception;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Dark on 2016. 8. 15..
 */
@Slf4j
@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Map<String, Object> handleException(Exception e) {
        log.error("{}", e.getMessage(), e);

        List<String> errors = new ArrayList<>();

        errors.add("정상적이지 않은 접근입니다.");

        Map<String, Object> result = Maps.newHashMap();
        result.put("errors", errors);
        return result;
    }
}
