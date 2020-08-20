package com.oms.models;

import lombok.Data;

@Data
public class OrderResponse extends GenericResponse {
    String orderId;
}
