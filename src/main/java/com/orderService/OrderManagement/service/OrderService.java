package com.orderService.OrderManagement.service;


import com.orderService.OrderManagement.DAO.OrderRequestDAO;
import com.orderService.OrderManagement.DAO.OrderResponseDAO;
import com.orderService.OrderManagement.model.OrderStatus;
import com.orderService.OrderManagement.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class OrderService {

    public OrderResponseDAO OrderProduct(OrderRequestDAO orderRequestDAO){
        int orderAmount = 0;
        List<Product> orderProducts = orderRequestDAO.getProductList();
        for(Product product: orderProducts){
            orderAmount += product.getProductAmount();
        }
        OrderResponseDAO orderResponseDAO = new OrderResponseDAO();
        orderResponseDAO.setOrderAmount(orderAmount);
        orderResponseDAO.setOrderStatus(OrderStatus.INPROGRESS);
        //payment service can be called once we confirm order and once payment is completed we can make orderstatus to completed

        return orderResponseDAO;
    }
}
