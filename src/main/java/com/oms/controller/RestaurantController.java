package com.oms.controller;

import com.oms.models.OrderRequest;
import com.oms.models.OrderResponse;
import com.oms.models.Status;
import com.oms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantController {

    @Autowired
    private OrderService orderService;

    //Place Order
    @PostMapping(value = "/order", consumes = "application/json", produces = "application/json")
    public @ResponseBody OrderResponse placeOrder(@RequestBody OrderRequest request){
        return orderService.placeOrder(request);
    }

    //Order status
    @GetMapping("/order/{orderId}")
    public @ResponseBody Status orderStatus(@PathVariable("orderId") String orderId){
        return orderService.getStatus(orderId);
    }


}
