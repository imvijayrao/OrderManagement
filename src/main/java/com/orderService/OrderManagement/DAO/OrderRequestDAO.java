package com.orderService.OrderManagement.DAO;

import com.orderService.OrderManagement.model.OrderStatus;
import com.orderService.OrderManagement.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequestDAO {

    private List<Product> productList;
}
