package com.orderService.OrderManagement.DAO;

import com.orderService.OrderManagement.model.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
public class OrderResponseDAO implements HttpStatusCode {

    private long orderId;
    private int orderAmount;
    private OrderStatus orderStatus;
}
