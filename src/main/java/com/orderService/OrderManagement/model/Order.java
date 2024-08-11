package com.orderService.OrderManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @OneToMany
    private List<Product> productsList;
    private OrderStatus orderStatus;

    public Order(List<Product> orderProducts, OrderStatus orderStatus) {
        this.productsList = orderProducts;
        this.orderStatus = orderStatus;
    }
}
