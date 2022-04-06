package com.eric.orderapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.eric.orderapi.channels.OrderChannel;
import com.eric.orderapi.models.Order;

@Service
public class OrderService {
    @Autowired
	private OrderChannel orderChannel;
    
    public boolean publishData(Order order) {
    	MessageChannel messageChannel=this.orderChannel.outChannel();
    	//publishing
    	return messageChannel.send(MessageBuilder
                .withPayload(order)
                .setHeader(MessageHeaders.CONTENT_TYPE, 
                		MimeTypeUtils.APPLICATION_JSON)
                .build());


    }
}
