package com.orderService.OrderManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Order {

    private int orderId;
    @OneToMany
    private List<Product> productsList;
    private OrderStatus orderStatus;
}
