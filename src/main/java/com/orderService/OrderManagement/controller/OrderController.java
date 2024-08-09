package com.orderService.OrderManagement.controller;

import com.orderService.OrderManagement.DAO.OrderRequestDAO;
import com.orderService.OrderManagement.DAO.OrderResponseDAO;
import com.orderService.OrderManagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/orderproduct")
    public ResponseEntity<OrderResponseDAO> orderProducts(@RequestBody RequestEntity<OrderRequestDAO orderRequestDAO>){
       return orderService.OrderProduct(orderRequestDAO);
    }
}
