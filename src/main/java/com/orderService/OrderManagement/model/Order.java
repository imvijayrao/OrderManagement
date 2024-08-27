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
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @OneToMany
    private List<Product> productsList;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private int orderAmount;

}