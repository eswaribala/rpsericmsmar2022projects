package com.eric.paymentapi.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface PaymentChannel {

	String inChannel="order-in";
	String outChannel="payment-out";
	@Input(inChannel)
	MessageChannel inputChannel();
	@Output(outChannel)
	MessageChannel outputChannel();
}
