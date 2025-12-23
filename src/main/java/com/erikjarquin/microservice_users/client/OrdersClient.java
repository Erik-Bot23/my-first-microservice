package com.erikjarquin.microservice_users.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import com.erikjarquin.microservice_users.dto.OrderDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Microservice-Orders") //Registrado en Eureka
public interface OrdersClient {
    @GetMapping("/api/orders/user/{userId}")
    List<OrderDto> getOrdersByUser(@PathVariable Long userId);
} 
