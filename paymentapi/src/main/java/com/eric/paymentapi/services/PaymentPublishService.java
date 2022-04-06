package com.eric.paymentapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.eric.paymentapi.channels.PaymentChannel;
import com.eric.paymentapi.models.Order;
import com.eric.paymentapi.models.Payment;
import com.eric.paymentapi.repositories.PaymentRepository;

@Service
public class PaymentPublishService {
    @Autowired
	private PaymentRepository paymentRespository;
    @Autowired
    private OrderConsumerService orderConsumerService;
    @Autowired
    private PaymentChannel paymentChannel;
    public Payment savePayment(Payment payment) {
    	payment.setOrder(getOrderInfo());
    	return this.paymentRespository.save(payment);
    	
    }
    
    public Order getOrderInfo() {
    	return this.orderConsumerService.getOrderDetails();
    }
    
    
    public boolean publishPaymentDetails(long transactionId) {
    	Payment payment=this.paymentRespository.findById(transactionId)
    			.orElse(null);
    	MessageChannel messageChannel=paymentChannel.outputChannel();
    	//publishing
    	return messageChannel.send(MessageBuilder
                .withPayload(payment)
                .setHeader(MessageHeaders.CONTENT_TYPE, 
                		MimeTypeUtils.APPLICATION_JSON)
                .build());

    	
    }
}
