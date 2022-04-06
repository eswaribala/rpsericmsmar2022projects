package com.eric.paymentapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eric.paymentapi.models.Order;
import com.eric.paymentapi.models.Payment;
import com.eric.paymentapi.repositories.PaymentRepository;

@Service
public class PaymentPublishService {
    @Autowired
	private PaymentRepository paymentRespository;
    @Autowired
    private OrderConsumerService orderConsumerService;
    public Payment savePayment(Payment payment) {
    	payment.setOrder(getOrderInfo());
    	return this.paymentRespository.save(payment);
    	
    }
    
    public Order getOrderInfo() {
    	return this.orderConsumerService.getOrderDetails();
    }
    
}
