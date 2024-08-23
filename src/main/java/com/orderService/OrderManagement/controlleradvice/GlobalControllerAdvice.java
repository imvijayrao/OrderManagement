package com.orderService.OrderManagement.controlleradvice;

import com.orderService.OrderManagement.DAO.OrderExceptionDAO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    private String orderExceptionMessage = "Order Not Found";
    private int errorCode = 404;

    @ExceptionHandler(OrderExceptionDAO.class)
    public ResponseEntity<OrderExceptionDAO> handleOrderException(){
        OrderExceptionDAO orderExceptionDAO = new OrderExceptionDAO(orderExceptionMessage, errorCode);
        return ResponseEntity.ok(orderExceptionDAO);
    }
}
