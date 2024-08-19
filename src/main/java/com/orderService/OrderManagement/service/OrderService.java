package com.orderService.OrderManagement.service;


import com.orderService.OrderManagement.DAO.OrderRequestDAO;
import com.orderService.OrderManagement.DAO.OrderResponseDAO;
import com.orderService.OrderManagement.exception.ProductNotFoundException;
import com.orderService.OrderManagement.model.Order;
import com.orderService.OrderManagement.model.OrderStatus;
import com.orderService.OrderManagement.model.Product;
import com.orderService.OrderManagement.repository.OrderRepository;
import com.orderService.OrderManagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    public OrderResponseDAO OrderProduct(OrderRequestDAO orderRequestDAO) throws ProductNotFoundException {
        int orderAmount = 0;
        List<Product> orderProducts = new ArrayList<>();
        for(List<String> product: orderRequestDAO.getProductList()) {
            Optional<Product> optionalProduct = Optional.ofNullable(productRepository.findProductByProductName(product.get(0)));
            if (optionalProduct.isEmpty()) throw new ProductNotFoundException("Product Not Found");
            int productQuantity = Integer.parseInt(product.get(1));
            orderAmount = orderAmount + (optionalProduct.get().getProductAmount() * productQuantity);
            if(orderProducts.contains(optionalProduct.get())) orderProducts.add(optionalProduct.get());
        }
        Order newOrder = new Order();
        newOrder.setProductsList(orderProducts);
        newOrder.setOrderStatus(OrderStatus.INPROGRESS);
        newOrder.setOrderAmount(orderAmount);
        orderRepository.save(newOrder);
        OrderResponseDAO orderResponseDAO = new OrderResponseDAO();
        orderResponseDAO.setOrderId(newOrder.getOrderId());
        orderResponseDAO.setOrderAmount(orderAmount);
        orderResponseDAO.setOrderStatus(OrderStatus.INPROGRESS);
        //payment service can be called once we confirm order and once payment is completed we can make orderstatus to completed

        return orderResponseDAO;
    }
}
