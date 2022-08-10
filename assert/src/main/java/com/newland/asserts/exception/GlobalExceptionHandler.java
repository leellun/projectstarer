package com.newland.asserts.exception;

import com.newland.asserts.result.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public R handleException(Exception e){
        return R.error(e.getMessage());
    }
}
