package com.sxy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Administrator on 2017/1/11.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFindexception extends RuntimeException {
}
