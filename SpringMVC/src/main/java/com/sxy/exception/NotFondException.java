package com.sxy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Administrator on 2017/1/12.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFondException extends RuntimeException {
}
