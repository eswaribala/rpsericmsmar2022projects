package com.eric.orderapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eric.orderapi.models.Order;
import com.eric.orderapi.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
	private OrderService orderService;
    
    @PostMapping({"/v1.0"})
    public ResponseEntity<String> publishOrderData(@RequestBody Order order){
    	if(this.orderService.publishData(order)) 
    		return ResponseEntity.status(HttpStatus.OK).body("Order Published.....");
    	else
    	    return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
    	        				.body("Order Not Published.....");
    	}
    
	
}
