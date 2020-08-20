package com.oms.models;

import lombok.Data;

@Data
public class DeliveryRequest {
    String orderId;
    Status status;
}
