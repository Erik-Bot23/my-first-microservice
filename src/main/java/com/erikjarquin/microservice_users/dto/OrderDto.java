package com.erikjarquin.microservice_users.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private Long userId;
    private String status; //e.g. "CREATED","PAID"
    private BigDecimal total; //total del pedido
    private OffsetDateTime crDateTime; //fecha creación
    //agrega/ajusta campos según el JSON real
}
