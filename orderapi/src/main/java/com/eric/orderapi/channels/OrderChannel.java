package com.eric.orderapi.channels;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OrderChannel {

	String outChannel="order-out";
	
	@Output(outChannel)
	MessageChannel outChannel();
}
