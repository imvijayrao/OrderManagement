package com.orderService.OrderManagement.DAO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDAO {

    private String message;
    private int errorCode;

    public ErrorResponseDAO(String message, int errorCode){
        this.message = message;
        this.errorCode = errorCode;
    }
}
