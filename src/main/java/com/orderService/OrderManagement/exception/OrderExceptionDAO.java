package com.orderService.OrderManagement.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrderExceptionDAO extends RuntimeException {

    private int errorCode;

    public OrderExceptionDAO(String message, int errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
