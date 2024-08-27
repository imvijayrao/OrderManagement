package com.orderService.OrderManagement.controller;

import com.orderService.OrderManagement.exception.OrderExceptionDAO;
import com.orderService.OrderManagement.DAO.OrderRequestDAO;
import com.orderService.OrderManagement.DAO.OrderResponseDAO;
import com.orderService.OrderManagement.exception.ProductNotFoundException;
import com.orderService.OrderManagement.service.OrderService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @NonNull
    @GetMapping("/orderproduct")
    public ResponseEntity<OrderResponseDAO> orderProducts(@RequestBody OrderRequestDAO orderRequestDAO) throws ProductNotFoundException {
       return new ResponseEntity<>(orderService.OrderProduct(orderRequestDAO), HttpStatus.CREATED);
    }

    @GetMapping("/orderproduct/{id}")
    public ResponseEntity<OrderResponseDAO> checkOrder(@PathVariable("id") Long id) throws OrderExceptionDAO {
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }
}