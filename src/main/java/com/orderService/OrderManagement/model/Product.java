package com.orderService.OrderManagement.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {

    public int productId;
    public String productName;
    public String productDescription;
    public int productAmount;
}
