package com.orderService.OrderManagement.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {

    private long productId;
    private String productName;
    private String productDescription;
    private int productAmount;
}
