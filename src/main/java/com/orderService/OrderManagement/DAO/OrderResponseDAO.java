package com.orderService.OrderManagement.DAO;

import com.orderService.OrderManagement.model.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseDAO {

    private long orderId;
    private int orderAmount;
    private OrderStatus orderStatus;
}
