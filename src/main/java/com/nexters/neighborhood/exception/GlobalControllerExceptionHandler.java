package com.nexters.neighborhood.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * Created by Dark on 2016. 8. 15..
 */
@Slf4j
@ControllerAdvice
public class GlobalControllerExceptionHandler {

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//    @ResponseBody
//    public Map<String, Object> handleException(Exception e) {
//        log.error("{}", e.getMessage(), e);
//
//        List<String> errors = new ArrayList<>();
//
//        errors.add("정상적이지 않은 접근입니다.");
//
//        Map<String, Object> result = Maps.newHashMap();
//        result.put("errors", errors);
//        return result;
//    }
}
