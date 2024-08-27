package com.orderService.OrderManagement.controlleradvice;

import com.orderService.OrderManagement.DAO.ErrorResponseDAO;
import com.orderService.OrderManagement.exception.OrderExceptionDAO;
import com.orderService.OrderManagement.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalControllerAdvice {

    private int notFoundErrorCode = 404;

    @ExceptionHandler(OrderExceptionDAO.class)
    public ResponseEntity<Object> handleOrderException(OrderExceptionDAO ex, WebRequest request){
        ErrorResponseDAO errorResponseDAO = new ErrorResponseDAO(ex.getMessage(), notFoundErrorCode, request.getDescription(false));
        return new ResponseEntity(errorResponseDAO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductException(ProductNotFoundException ex, WebRequest request){
        ErrorResponseDAO errorResponseDAO = new ErrorResponseDAO(ex.getMessage(), notFoundErrorCode, request.getDescription(true));
        return new ResponseEntity<>(errorResponseDAO, HttpStatus.NOT_FOUND);
    }
}
