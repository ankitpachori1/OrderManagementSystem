package com.oms.controller;

import com.oms.models.DeliveryInit;
import com.oms.models.DeliveryPerson;
import com.oms.models.DeliveryRequest;
import com.oms.models.DeliveryResponse;
import com.oms.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeliveryController {

    DeliveryInit delivery;

    @Autowired
    DeliveryService deliveryService;

    //Get host and port of Delivery service
    @PostMapping(value ="/delivery/init", consumes = "application/json", produces = "application/json")
    public String getDeliveryService(@RequestBody DeliveryInit deliveryInit){
        delivery = deliveryInit;
        return "done";
    }

    @GetMapping("/driver/list")
    public List<DeliveryPerson> getAllAvailableDrivers(){
        return deliveryService.getAllAvailableDrivers();
    }

    //Update Delivery status
    @PostMapping(value = "/delivery/status", consumes = "application/json", produces = "application/json")
    public DeliveryResponse updateDeliveryStatus(@RequestBody DeliveryRequest request){
        return deliveryService.updateDeliveryStatus(request);
    }
}
