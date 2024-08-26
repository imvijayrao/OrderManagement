package com.orderService.OrderManagement.controlleradvice;

import com.orderService.OrderManagement.DAO.ErrorResponseDAO;
import com.orderService.OrderManagement.DAO.OrderExceptionDAO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalControllerAdvice {

    private String orderExceptionMessage = "Order Not Found";
    private int errorCode = 404;

    @ExceptionHandler(OrderExceptionDAO.class)
    public ResponseEntity<Object> handleOrderException(OrderExceptionDAO ex, WebRequest request){
        ErrorResponseDAO errorResponseDAO = new ErrorResponseDAO(ex.getMessage(), errorCode, request.getDescription(false));
        return new ResponseEntity(errorResponseDAO, HttpStatus.NOT_FOUND);
    }
}
