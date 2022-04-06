package com.eric.paymentapi.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface PaymentChannel {

	String inChannel="order-in";
	@Input(inChannel)
	MessageChannel inputChannel();
}
