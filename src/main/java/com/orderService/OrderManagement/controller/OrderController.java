package com.orderService.OrderManagement.controller;

import com.orderService.OrderManagement.DAO.OrderExceptionDAO;
import com.orderService.OrderManagement.DAO.OrderRequestDAO;
import com.orderService.OrderManagement.DAO.OrderResponseDAO;
import com.orderService.OrderManagement.controlleradvice.GlobalControllerAdvice;
import com.orderService.OrderManagement.exception.ProductNotFoundException;
import com.orderService.OrderManagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/orderproduct")
    public ResponseEntity<OrderResponseDAO> orderProducts(@RequestBody OrderRequestDAO orderRequestDAO) throws ProductNotFoundException {
       return new ResponseEntity<>(orderService.OrderProduct(orderRequestDAO));
    }

    @GetMapping("/orderproduct/{id}")
    public ResponseEntity<GlobalControllerAdvice> checkOrder(@PathVariable("id") Long id) throws OrderExceptionDAO {
        OrderResponseDAO orderResponseDAO = orderService.getOrderById(id);
        return new ResponseEntity<>(orderResponseDAO);
    }
}