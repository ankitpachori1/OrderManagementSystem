package com.oms.service;

import com.oms.models.Order;
import com.oms.models.OrderRequest;
import com.oms.models.OrderResponse;
import com.oms.models.Status;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class OrderService {

    private RestTemplate restTemplate;

    private Map<String, Order> orders = new HashMap<String, Order>();

    public OrderResponse placeOrder(OrderRequest request){
        String orderId = UUID.randomUUID().toString();
        Order o = new Order();
        Status status = Status.PLACED;
        o.setItems(request.getItems());
        o.setStatus(status);
        orders.put(orderId, o);
        OrderResponse response = new OrderResponse();
        response.setOrderId(orderId);
        response.setStatus(status);
        return response;
    }

    public Status getStatus(String orderId){
        return getOrderStatus(orderId);
    }

    public Status updateOrderStatus(String orderId, Status status){
        Status s = getOrderStatus(orderId);
        if(s != Status.NOT_FOUND){
            updateOrder(orderId, status);
            return status;
        }
        else{
            return Status.NOT_FOUND;
        }
    }

    private Status getOrderStatus(String orderId){
        if(orders.containsKey(orderId)){
            Order o = orders.get(orderId);
            return o.getStatus();
        }
        else{
            return Status.NOT_FOUND;
        }
    }

    private void updateOrder(String orderId, Status status){
        Order order = orders.get(orderId);
        order.setStatus(status);
        orders.put(orderId, order);
    }

}
