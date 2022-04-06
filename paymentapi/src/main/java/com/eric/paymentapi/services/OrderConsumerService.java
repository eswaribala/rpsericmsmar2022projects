package com.eric.paymentapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.eric.paymentapi.channels.PaymentChannel;
import com.eric.paymentapi.models.Order;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderConsumerService {
	private Order orderObj;
    @Autowired
	private PaymentChannel paymentChannel;
    @StreamListener(target = PaymentChannel.inChannel)
    public void consumeOrder(@Payload Order order) {
    	log.info("Order Received {}",order);
    	this.orderObj=order;
    }
	
    public Order getOrderDetails() {
    	return this.orderObj;
    }
}
