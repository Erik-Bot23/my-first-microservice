package com.erikjarquin.microservice_users.service;

import java.util.List;
import com.erikjarquin.microservice_users.client.OrdersClient;
import com.erikjarquin.microservice_users.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserOrderService {
    private final OrdersClient ordersClient;

    public List<OrderDto> getOrdersForUser(Long userId){
        return ordersClient.getOrdersByUser(userId);
    }
}
