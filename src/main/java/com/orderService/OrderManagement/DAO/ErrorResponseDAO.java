package com.orderService.OrderManagement.DAO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDAO {

    private String message;
    private int errorCode;
    private String details;

    public ErrorResponseDAO(String message, int errorCode, String details){
        super();
        this.message = message;
        this.errorCode = errorCode;
        this.details = details;
    }
}
