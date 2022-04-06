package com.eric.paymentapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eric.paymentapi.models.Order;
import com.eric.paymentapi.models.Payment;
import com.eric.paymentapi.services.PaymentPublishService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
	private PaymentPublishService paymentPublishService;
    
    @GetMapping({"/v1.0"})
    public Order getOrderDetails() {
    	return this.paymentPublishService.getOrderInfo();
    }
    
    @PostMapping({"/v1.0"})
    public ResponseEntity<String> makePayment(@RequestBody Payment payment){
    	Payment paymentObj=this.paymentPublishService.savePayment(payment);
    	
    	if(paymentObj!=null) 
    		return ResponseEntity.status(HttpStatus.OK)
    				.body("Payment Completed");
    	else
    		return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
    				.body("Payment Failed....");
    }
    
    @GetMapping({"/v1.0/{transactionId}"})
    public ResponseEntity<String> publishPayment(@PathVariable("transactionId") long transactionId){
    	
    	
    	if(this.paymentPublishService.publishPaymentDetails(transactionId)) 
    		return ResponseEntity.status(HttpStatus.OK)
    				.body("Payment published....");
    	else
    		return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
    				.body("Payment Not published....");
    }
}
