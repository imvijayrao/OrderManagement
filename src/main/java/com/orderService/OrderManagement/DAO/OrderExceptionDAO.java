package com.orderService.OrderManagement.DAO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Getter
@Setter
public class OrderExceptionDAO extends RuntimeException {

    private int errorCode;

    public OrderExceptionDAO(String message, int errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
