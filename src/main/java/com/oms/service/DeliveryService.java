package com.oms.service;

import com.oms.models.DeliveryPerson;
import com.oms.models.DeliveryRequest;
import com.oms.models.DeliveryResponse;
import com.oms.models.Status;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class DeliveryService {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    public DeliveryResponse updateDeliveryStatus(DeliveryRequest request){
        Status status = orderService.updateOrderStatus(request.getOrderId(), request.getStatus());
        DeliveryResponse response = new DeliveryResponse();
        response.setStatus(status);
        return response;
    }

    public List<DeliveryPerson> getAllAvailableDrivers(){
        ResponseEntity<List> res =  restTemplate
                .getForEntity("http://localhost:8089/driver/list",
                List.class);
        return res.getBody();
    }




}
